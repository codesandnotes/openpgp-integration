package be.codesandnotes;

import org.bouncycastle.openpgp.PGPException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

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
}
