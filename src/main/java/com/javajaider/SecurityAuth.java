package com.javajaider;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityAuth {

    public static String generateHash(String rawText) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] hashBytes = computeHash(rawText);
        return bytesToHex(hashBytes);
    }

    private static byte[] computeHash(String rawText) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(rawText.getBytes("utf-8"));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
