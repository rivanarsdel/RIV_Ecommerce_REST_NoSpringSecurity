package dev.riv.REST_TurboBasic.utilities;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class HashGenerator {

    public String createMD5Hash() throws NoSuchAlgorithmException {

        //Generate random string for hash function
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        //Instantiate instance of methodDigest with "MD5" algorhythm
        String hashText = null;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        // Compute message digest of the generated String
        byte[] mdByte = messageDigest.digest(generatedString.getBytes());
        hashText = convertToHex(mdByte);
        return hashText;
    }

    private String convertToHex(final byte[] messageDigest) {
        BigInteger bigint = new BigInteger(1, messageDigest);
        String hexText = bigint.toString(16);
        while (hexText.length() < 32) {
            hexText = "0".concat(hexText);
        }
        return hexText;
    }
}
