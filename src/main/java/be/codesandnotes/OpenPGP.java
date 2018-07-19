package be.codesandnotes;

import name.neuhalfen.projects.crypto.bouncycastle.openpgp.BouncyGPG;
import name.neuhalfen.projects.crypto.bouncycastle.openpgp.keys.callbacks.KeyringConfigCallbacks;
import name.neuhalfen.projects.crypto.bouncycastle.openpgp.keys.keyrings.InMemoryKeyring;
import name.neuhalfen.projects.crypto.bouncycastle.openpgp.keys.keyrings.KeyringConfigs;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.bcpg.HashAlgorithmTags;
import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;
import org.bouncycastle.bcpg.sig.Features;
import org.bouncycastle.bcpg.sig.KeyFlags;
import org.bouncycastle.crypto.generators.RSAKeyPairGenerator;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPEncryptedData;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPKeyPair;
import org.bouncycastle.openpgp.PGPKeyRingGenerator;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.PGPSignatureSubpacketGenerator;
import org.bouncycastle.openpgp.PGPSignatureSubpacketVector;
import org.bouncycastle.openpgp.operator.PBESecretKeyEncryptor;
import org.bouncycastle.openpgp.operator.bc.BcPBESecretKeyEncryptorBuilder;
import org.bouncycastle.openpgp.operator.bc.BcPGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.bc.BcPGPDigestCalculatorProvider;
import org.bouncycastle.openpgp.operator.bc.BcPGPKeyPair;
import org.bouncycastle.util.io.Streams;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.SignatureException;
import java.util.Date;

import static java.nio.charset.StandardCharsets.*;

public class OpenPGP {

    private static final int CERTAINTY = 12;
    private static final BigInteger PUBLIC_EXPONENT = BigInteger.valueOf(0x10001);
    private static final int S2K_COUNT = 0xc0;

    static {
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
            Security.addProvider(new BouncyCastleProvider());
        }
    }

    private final SecureRandom secureRandom;

    public OpenPGP(SecureRandom secureRandom) {
        this.secureRandom = secureRandom;
    }

    public ArmoredKeyPair generateKeys(int keySize, String userIdName, String userIdEmail, String passphrase) throws PGPException {

        Date now = new Date();

        RSAKeyPairGenerator keyPairGenerator = keyPairGenerator(keySize);

        PGPKeyPair encryptionKeyPair = encryptionKeyPair(now, keyPairGenerator);
        PGPSignatureSubpacketVector encryptionKeySignature = encryptionKeySignature();

        PGPKeyPair signingKeyPair = signingKeyPair(keyPairGenerator, now);
        PGPSignatureSubpacketVector signingKeySignature = signingKeySignature();

        PGPKeyRingGenerator keyRingGenerator = new PGPKeyRingGenerator(
                PGPSignature.POSITIVE_CERTIFICATION,
                signingKeyPair,
                userIdName + " <" + userIdEmail + ">",
                new BcPGPDigestCalculatorProvider().get(HashAlgorithmTags.SHA1),
                signingKeySignature,
                null,
                new BcPGPContentSignerBuilder(signingKeyPair.getPublicKey().getAlgorithm(), HashAlgorithmTags.SHA1),
                secretKeyEncryptor(passphrase)
        );
        keyRingGenerator.addSubKey(encryptionKeyPair, encryptionKeySignature, null);

        try {
            return ArmoredKeyPair.of(
                    generateArmoredSecretKeyRing(keyRingGenerator),
                    generateArmoredPublicKeyRing(keyRingGenerator));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private RSAKeyPairGenerator keyPairGenerator(int keySize) {
        RSAKeyPairGenerator keyPairGenerator = new RSAKeyPairGenerator();
        keyPairGenerator.init(new RSAKeyGenerationParameters(PUBLIC_EXPONENT, secureRandom, keySize, CERTAINTY));
        return keyPairGenerator;
    }

    private PGPKeyPair encryptionKeyPair(Date now, RSAKeyPairGenerator rsaKeyPairGenerator) throws PGPException {
        return new BcPGPKeyPair(PGPPublicKey.RSA_GENERAL, rsaKeyPairGenerator.generateKeyPair(), now);
    }

    private PGPKeyPair signingKeyPair(RSAKeyPairGenerator rsaKeyPairGenerator, Date date) throws PGPException {
        return new BcPGPKeyPair(PGPPublicKey.RSA_SIGN, rsaKeyPairGenerator.generateKeyPair(), date);
    }

    private PGPSignatureSubpacketVector encryptionKeySignature() {
        PGPSignatureSubpacketGenerator encryptionKeySignatureGenerator = new PGPSignatureSubpacketGenerator();
        encryptionKeySignatureGenerator.setKeyFlags(false, KeyFlags.ENCRYPT_COMMS | KeyFlags.ENCRYPT_STORAGE);
        return encryptionKeySignatureGenerator.generate();
    }

    private PGPSignatureSubpacketVector signingKeySignature() {
        PGPSignatureSubpacketGenerator signingKeySignatureGenerator = new PGPSignatureSubpacketGenerator();
        signingKeySignatureGenerator.setKeyFlags(false, KeyFlags.SIGN_DATA | KeyFlags.CERTIFY_OTHER); // GPG seems to generate keys with ENCRYPT_COMMS and ENCRYPT_STORAGE flags. However this is the signing key, so I'd avoid setting those flags. Omitting them does not seem to have an impact on the functioning of BouncyGPG...
        signingKeySignatureGenerator.setPreferredSymmetricAlgorithms(false, new int[]{SymmetricKeyAlgorithmTags.AES_256});
        signingKeySignatureGenerator.setPreferredHashAlgorithms(false, new int[]{HashAlgorithmTags.SHA512});
        signingKeySignatureGenerator.setFeature(false, Features.FEATURE_MODIFICATION_DETECTION);
        return signingKeySignatureGenerator.generate();
    }

    private PBESecretKeyEncryptor secretKeyEncryptor(String passphrase) throws PGPException {
        return new BcPBESecretKeyEncryptorBuilder(
                PGPEncryptedData.AES_256,
                new BcPGPDigestCalculatorProvider().get(HashAlgorithmTags.SHA256),
                S2K_COUNT)
                .build(passphrase.toCharArray());
    }

    private String generateArmoredSecretKeyRing(PGPKeyRingGenerator keyRingGenerator) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (
                ArmoredOutputStream armoredOutputStream = new ArmoredOutputStream(outputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(armoredOutputStream)
        ) {
            keyRingGenerator.generateSecretKeyRing().encode(bufferedOutputStream);
        }
        return outputStream.toString(UTF_8.name());
    }

    private String generateArmoredPublicKeyRing(PGPKeyRingGenerator keyRingGenerator) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (
                ArmoredOutputStream armoredOutputStream = new ArmoredOutputStream(outputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(armoredOutputStream)
        ) {
            keyRingGenerator.generatePublicKeyRing().encode(bufferedOutputStream, true);
        }
        return outputStream.toString(UTF_8.name());
    }

    public String encryptAndSign(String unencryptedMessage,
                                 String senderUserIdEmail,
                                 String senderPassphrase,
                                 ArmoredKeyPair senderArmoredKeyPair,
                                 String receiverUserId,
                                 String receiverArmoredPublicKey)
            throws IOException, PGPException, NoSuchAlgorithmException, SignatureException, NoSuchProviderException {

        InMemoryKeyring keyring = keyring(senderPassphrase, senderArmoredKeyPair, receiverArmoredPublicKey);

        ByteArrayOutputStream encryptedOutputStream = new ByteArrayOutputStream();
        try (
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(encryptedOutputStream);
                OutputStream bouncyGPGOutputStream = BouncyGPG.encryptToStream()
                        .withConfig(keyring)
                        .withStrongAlgorithms()
                        .toRecipient(receiverUserId)
                        .andSignWith(senderUserIdEmail)
                        .armorAsciiOutput()
                        .andWriteTo(bufferedOutputStream)
        ) {
            Streams.pipeAll(new ByteArrayInputStream(unencryptedMessage.getBytes()), bouncyGPGOutputStream);
        }

        return encryptedOutputStream.toString(UTF_8.name());
    }

    public String decryptAndVerify(String encryptedMessage,
                                   String receiverPassphrase,
                                   ArmoredKeyPair receiverArmoredKeyPair,
                                   String senderUserIdEmail,
                                   String senderArmoredPublicKey)
            throws IOException, PGPException, NoSuchProviderException {

        InMemoryKeyring keyring = keyring(receiverPassphrase, receiverArmoredKeyPair, senderArmoredPublicKey);

        ByteArrayOutputStream unencryptedOutputStream = new ByteArrayOutputStream();
        try (
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(unencryptedOutputStream);
                InputStream bouncyGPGInputStream = BouncyGPG
                        .decryptAndVerifyStream()
                        .withConfig(keyring)
                        .andRequireSignatureFromAllKeys(senderUserIdEmail)
                        .fromEncryptedInputStream(new ByteArrayInputStream(encryptedMessage.getBytes(UTF_8)))
        ) {
            Streams.pipeAll(bouncyGPGInputStream, bufferedOutputStream);
        }

        return unencryptedOutputStream.toString(UTF_8.name());
    }

    /**
     * @param passphrase The passphrase of the user that will encrypt / decrypt
     * @param armoredKeyPair The armored key pair of the user that will encrypt / decrypt
     * @param recipientsArmoredPublicKey The armored public keys of all recipients whose key needs to be in the keyring,
     *                                  either to encrypt a message to him/her or to verify the signature of a message
     *                                  coming from him/her
     * @return An in-memory keyring
     */
    private InMemoryKeyring keyring(String passphrase,
                                    ArmoredKeyPair armoredKeyPair,
                                    String... recipientsArmoredPublicKey)
            throws IOException, PGPException {
        InMemoryKeyring keyring = KeyringConfigs.forGpgExportedKeys(KeyringConfigCallbacks.withPassword(passphrase));
        keyring.addSecretKey(armoredKeyPair.privateKey().getBytes(UTF_8));
        keyring.addPublicKey(armoredKeyPair.publicKey().getBytes(UTF_8));
        for (String recipientArmoredPublicKey : recipientsArmoredPublicKey) {
            keyring.addPublicKey(recipientArmoredPublicKey.getBytes(UTF_8));
        }
        return keyring;
    }

    public static class ArmoredKeyPair {

        private final String privateKey;
        private final String publicKey;

        private ArmoredKeyPair(String privateKey, String publicKey) {
            this.privateKey = privateKey;
            this.publicKey = publicKey;
        }

        public String privateKey() {
            return privateKey;
        }

        public String publicKey() {
            return publicKey;
        }

        public static ArmoredKeyPair of(String privateKey, String publicKey) {
            return new ArmoredKeyPair(privateKey, publicKey);
        }
    }
}
