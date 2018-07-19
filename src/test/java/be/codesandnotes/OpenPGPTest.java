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
}
