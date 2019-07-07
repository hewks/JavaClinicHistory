/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class Conexion {
    //Propone los valores de conexion a la base de datos
    private static Connection con;
    private static final String DRIVER="com.mysql.jdbc.Driver";
    private static final String USER="admin";
    private static final String URL="jdbc:mysql://sl-us-south-1-portal.48.dblayer.com";
    private static final String PASS="Asdfghjkl159753";
    private static final String PORT="24186";
    private static final String ARG="?useSSL=false";
    public String database="MedSystemDataBase";
    public Connection Conectar(){
    con=null;
    //Hace el intento de conexion con la base de datos
        try {
            Class.forName(DRIVER);
            con=DriverManager.getConnection(URL+":"+PORT+"/"+database+ARG,USER,PASS);
            if(con!=null){
                System.out.println("Conexion exitosa");
            }
        } catch (ClassNotFoundException |SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return con;
    }
    public void Desconectar(){
    con=null;
    if(con==null){
        System.out.println("Se ha Desconectado exitosamente");}
    }
    }
    
    

