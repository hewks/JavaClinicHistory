/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.security.*;

/**
 *
 * @author Juan
 */
public class Accion {
    public Sesion login(String user, String raw_password){
        Sesion sesion_act=null;
        String password=encriptar(raw_password);
        Conexion con=new Conexion();
        con.Conectar();
        
    return sesion_act;
    }
    
    
    //Sistema de encryptacion de Datos
    
    public String encriptar(String password){
            final byte[] defaultBytes = password.getBytes();
        try {
            final MessageDigest md5MsgDigest = MessageDigest.getInstance("MD5");
            md5MsgDigest.reset();
            md5MsgDigest.update(defaultBytes);
            final byte messageDigest[] = md5MsgDigest.digest();
            final StringBuffer hexString = new StringBuffer();
            for (final byte element : messageDigest) {
                final String hex = Integer.toHexString(0xFF & element);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            password = hexString + "";
        } catch (final NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        return password;
    }
    
}
