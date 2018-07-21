/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
//import org.apache.commons.net.util.Base64;

/**
 *
 * @author desarrollo
 */
public class ENCRIPTAR {

    public static String salt_pass() { //es en el hach 16? ono ?
        byte[] salt = new byte[16];
        double r = Math.random();

        String aux = toMD5(toMD5(toMD5("" + r)));

        int a = aux.length();

        aux = aux.substring(0, a / 2);
        return aux;

    }

    public static String toMD5(String text) {
        String md5 = null;
        try {
            MessageDigest md;

            md = MessageDigest.getInstance("MD5");

            md.update(text.getBytes());

            byte byteData[] = md.digest();

            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            md5 = sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ENCRIPTAR.class.getName()).log(Level.SEVERE, null, ex);
        }
        return md5;
    }
}
