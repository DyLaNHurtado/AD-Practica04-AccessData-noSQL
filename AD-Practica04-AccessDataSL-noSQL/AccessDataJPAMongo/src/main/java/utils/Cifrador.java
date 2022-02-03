package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Cifrador de SHA256
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public class Cifrador {
    /**
     * Cifrador SHA256
     * @param password
     * @return String password cifrada
     */
    public String toSHA256(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

        byte[] hash = md.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();

        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

}
