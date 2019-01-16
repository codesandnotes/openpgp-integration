package be.codesandnotes;

import org.bouncycastle.openpgp.PGPException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.SignatureException;

import static be.codesandnotes.Identities.*;
import static org.assertj.core.api.Assertions.*;

public class OpenPGPTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenPGPTest.class);
    private static final SecureRandom SECURE_RANDOM;
    static {
        try {
            SECURE_RANDOM = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Could not initialize a strong secure random instance", e);
        }
    }

    private OpenPGP openPgp;

    @Before
    public void setUp() {
        openPgp = new OpenPGP(SECURE_RANDOM);
    }

    @Test
    public void generateJavaKeys() throws PGPException {

        OpenPGP.ArmoredKeyPair armoredKeyPair = openPgp
                .generateKeys(KEY_SIZE, JAVA_USER_ID_NAME, JAVA_USER_ID_EMAIL, JAVA_PASSPHRASE);

        assertThat(armoredKeyPair).hasNoNullFieldsOrProperties();

        LOGGER.info("java's private key ring:\n" + armoredKeyPair.privateKey());
        LOGGER.info("java's public key ring:\n" + armoredKeyPair.publicKey());
    }

    @Test
    public void generateAvajKeys() throws PGPException {

        OpenPGP.ArmoredKeyPair armoredKeyPair = openPgp
                .generateKeys(KEY_SIZE, AVAJ_USER_ID_NAME, AVAJ_USER_ID_EMAIL, AVAJ_PASSPHRASE);

        assertThat(armoredKeyPair).hasNoNullFieldsOrProperties();

        LOGGER.info("avaj's private key ring:\n" + armoredKeyPair.privateKey());
        LOGGER.info("avaj's public key ring:\n" + armoredKeyPair.publicKey());
    }

    @Test
    public void encryptSignedMessageAsJavaAndDecryptItAsAvaj() throws IOException, PGPException, NoSuchAlgorithmException, SignatureException, NoSuchProviderException {

        String unencryptedMessage = "Message from java to avaj: you're all backwards!";

        String encryptedMessage = openPgp.encryptAndSign(
                unencryptedMessage,
                JAVA_USER_ID_EMAIL,
                JAVA_PASSPHRASE,
                OpenPGP.ArmoredKeyPair.of(JAVA_PRIVATE_KEYS, JAVA_PUBLIC_KEYS),
                AVAJ_USER_ID_EMAIL,
                AVAJ_PUBLIC_KEYS);

        assertThat(encryptedMessage).isNotEmpty();

        LOGGER.info("java's encrypted message to avaj:\n" + encryptedMessage);

        String messageDecryptedByAvaj = openPgp.decryptAndVerify(
                encryptedMessage,
                AVAJ_PASSPHRASE,
                OpenPGP.ArmoredKeyPair.of(AVAJ_PRIVATE_KEYS, AVAJ_PUBLIC_KEYS),
                JAVA_USER_ID_EMAIL,
                JAVA_PUBLIC_KEYS);

        assertThat(messageDecryptedByAvaj).isEqualTo(unencryptedMessage);
    }

    @Test
    public void encryptMessageAsJavascriptAndDecryptItAsJava() throws PGPException, SignatureException, NoSuchAlgorithmException, NoSuchProviderException, IOException {

        String unencryptedMessage = "Message from javascript to java: how's life in the back end?";

        String encryptedMessage = openPgp.encryptAndSign(
                unencryptedMessage,
                JAVASCRIPT_USER_ID_EMAIL,
                JAVASCRIPT_PASSPHRASE,
                OpenPGP.ArmoredKeyPair.of(JAVASCRIPT_PRIVATE_KEYS, JAVASCRIPT_PUBLIC_KEYS),
                JAVA_USER_ID_EMAIL,
                JAVA_PUBLIC_KEYS);

        assertThat(encryptedMessage).isNotEmpty();

        LOGGER.info("javascript's encrypted message to java:\n" + encryptedMessage);

        String messageDecryptedByJava = openPgp.decryptAndVerify(
                encryptedMessage,
                JAVA_PASSPHRASE,
                OpenPGP.ArmoredKeyPair.of(JAVA_PRIVATE_KEYS, JAVA_PUBLIC_KEYS),
                JAVASCRIPT_USER_ID_EMAIL,
                JAVASCRIPT_PUBLIC_KEYS);

        assertThat(messageDecryptedByJava).isEqualTo(unencryptedMessage);
    }

    @Test
    public void encryptMessageAsJavaAndDecryptItAsJavascript() throws PGPException, SignatureException, NoSuchAlgorithmException, NoSuchProviderException, IOException {

        String unencryptedMessage = "Message from java to javascript: how's life in the front end?";

        String encryptedMessage = openPgp.encryptAndSign(
                unencryptedMessage,
                JAVA_USER_ID_EMAIL,
                JAVA_PASSPHRASE,
                OpenPGP.ArmoredKeyPair.of(JAVA_PRIVATE_KEYS, JAVA_PUBLIC_KEYS),
                JAVASCRIPT_USER_ID_EMAIL,
                JAVASCRIPT_PUBLIC_KEYS);

        assertThat(encryptedMessage).isNotEmpty();

        LOGGER.info("java's encrypted message to javascript:\n" + encryptedMessage);

        String messageDecryptedByJavascript = openPgp.decryptAndVerify(
                encryptedMessage,
                JAVASCRIPT_PASSPHRASE,
                OpenPGP.ArmoredKeyPair.of(JAVASCRIPT_PRIVATE_KEYS, JAVASCRIPT_PUBLIC_KEYS),
                JAVA_USER_ID_EMAIL,
                JAVA_PUBLIC_KEYS);

        assertThat(messageDecryptedByJavascript).isEqualTo(unencryptedMessage);
    }

    @Test
    public void decryptJavascriptMessageToJava() throws IOException, PGPException, NoSuchProviderException {

        String decryptedMessage = openPgp.decryptAndVerify(
                JAVASCRIPT_ENCRYPTED_MESSAGE_TO_JAVA,
                JAVA_PASSPHRASE,
                OpenPGP.ArmoredKeyPair.of(JAVA_PRIVATE_KEYS, JAVA_PUBLIC_KEYS),
                JAVASCRIPT_USER_ID_EMAIL,
                JAVASCRIPT_PUBLIC_KEYS
        );

        assertThat(decryptedMessage).isEqualTo(JAVASCRIPT_UNENCRYPTED_MESSAGE_TO_JAVA);
    }

    @Test
    public void generateKeysAndEncryptAndDecryptMessage() throws PGPException, SignatureException, NoSuchAlgorithmException, NoSuchProviderException, IOException {

        OpenPGP.ArmoredKeyPair javaArmoredKeyPair = openPgp
                .generateKeys(KEY_SIZE, JAVA_USER_ID_NAME, JAVA_USER_ID_EMAIL, JAVA_PASSPHRASE);

        assertThat(javaArmoredKeyPair).hasNoNullFieldsOrProperties();

        OpenPGP.ArmoredKeyPair avajArmoredKeyPair = openPgp
                .generateKeys(KEY_SIZE, AVAJ_USER_ID_NAME, AVAJ_USER_ID_EMAIL, AVAJ_PASSPHRASE);

        assertThat(avajArmoredKeyPair).hasNoNullFieldsOrProperties();

        String unencryptedMessage = "Message from java to avaj: you're all backwards!";

        String encryptedMessage = openPgp.encryptAndSign(
                unencryptedMessage,
                JAVA_USER_ID_EMAIL,
                JAVA_PASSPHRASE,
                javaArmoredKeyPair,
                AVAJ_USER_ID_EMAIL,
                avajArmoredKeyPair.publicKey());

        assertThat(encryptedMessage).isNotEmpty();

        LOGGER.info("java's encrypted message to avaj:\n" + encryptedMessage);

        String messageDecryptedByAvaj = openPgp.decryptAndVerify(
                encryptedMessage,
                AVAJ_PASSPHRASE,
                avajArmoredKeyPair,
                JAVA_USER_ID_EMAIL,
                javaArmoredKeyPair.publicKey());

        assertThat(messageDecryptedByAvaj).isEqualTo(unencryptedMessage);
    }

    private static final String JAVASCRIPT_ENCRYPTED_MESSAGE_TO_JAVA = "-----BEGIN PGP MESSAGE-----\n" +
            "Version: OpenPGP.js v3.0.11\n" +
            "Comment: https://openpgpjs.org\n" +
            "\n" +
            "wcBMAw2t7NW0cb1oAQgAmSFw5kjMOoaWutOIDyE7i7T8NeZPV8Q3yAh+vqCP\n" +
            "FGSSLlEArsmAGacCdcYV1Cxanp7lgs775bjarEX8HIHrh8LuAM6cg9Tby4e7\n" +
            "NdCgJxTGQbdY9HErYYzCDJ0TOpVYAXn47SWTd2Dvdf3CdlOQkeJkgn61LekG\n" +
            "uI76y9LkrBDZhJYPL3HmG2+lK8+NKnQPt3Vg1dBks/j+9XrWXKuiYb4gWgP7\n" +
            "EtFwazpUJaRFqMFFUa9G1qPeZ6nlyMK19vL+sW5vaLRcl2iVv1WZdNU1aXBm\n" +
            "1E8pZ3b4C38QMbFq/iFrSsLxlSyBOXcmRiiddTgov1jwgq39tyGB6xbyXAE+\n" +
            "7dLA1gFr4PDnVn/Txhm11UfWy+bGWNsKBFCa5ifyBdgH7WdMVMQJuZ12HXNc\n" +
            "v14eUdc8cYSfRBUuRfnZjzkJZOBLuExbdJJIp2tGs0qTPzErGoVHi7u2hGNJ\n" +
            "NZpwD9EfguS8wzZ7xXmzD+LtoMjiRGB3EwJz46IZhXpUPOm+wydcht82p6aA\n" +
            "sBCqAK22YLltcTcOsXf9mND7GDe1tNd4N3oGV6kA1EyCJYg8T9eMOKtCg1Zp\n" +
            "joVnRq9tNV2HvhAzgDB90TJD8J97LmGZ425Ytn3QjvGS5dCUtFFjUC2KqcYv\n" +
            "+M5rxyD74V+9VbceFzVqaWIUywoRHqQfPFtgPAHfS7AqsiaabTq+KEocbwsK\n" +
            "EX5gFiPnnXBIU9xZe9AXHWty6z4srN/irAQMd+fLAXEis7ULidjnPE4u1A9L\n" +
            "jzK/q4MDXq3dbZ+KP3kbXGbfms8fErLT1UgcRvQv5tjvT25bSNlNVOSIV1LX\n" +
            "Tw5YIIyoYIo77XVqq+sORpEvy0ojcSu2HMt64403CLGVW2zEgcacITaiQu4u\n" +
            "GoCDncI=\n" +
            "=O0yP\n" +
            "-----END PGP MESSAGE-----\n";
    private static final String JAVASCRIPT_UNENCRYPTED_MESSAGE_TO_JAVA = "A message encrypted by javascript";
}
