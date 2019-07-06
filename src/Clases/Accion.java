/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.security.*;
import java.sql.*;

/**
 *
 * @author Juan
 */
public class Accion extends Informacion{
    public Sesion login(String user, String raw_password){
        Sesion sesion_act=null;
        String password=encriptar(raw_password);
        Conexion con=new Conexion();
        con.Conectar();
        
    return sesion_act;
    }
    
    public String[][] SacarDatos(String resDato,String nombreDelDato_parametro,String Dato_parametro, String tabla){
        String SQL="SELECT "+resDato+" FROM "+tabla+" WHERE "+nombreDelDato_parametro+" = "+Dato_parametro;
        String[][] resultado=null;
     Conexion cc=new Conexion();
      Connection con=cc.Conectar();
        try {
           Statement st =con.createStatement();
           ResultSet rs = st.executeQuery(SQL);
           ResultSetMetaData rsmd=rs.getMetaData();
           rs.last();
           int i=rs.getRow();
           int mi=i;
           rs.beforeFirst();
           int j=rsmd.getColumnCount();
           int mj=j;
           resultado=new String[i][j];
           i=0;
           while(i<mi){
               rs.next();
               j=0;
               while(j<mj){
               resultado[i][j]=rs.getString(j+1);
           j++;
               }
               i++;
           }
        cc.Desconectar();
           return resultado;
        } catch (SQLException ex) {
            System.out.println("error sacando datos "+ex);
        }
        return null;
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
