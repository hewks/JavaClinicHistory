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
public class Conexion extends Informacion{
    //Propone los valores de conexion a la base de datos
    private static Connection con;
    public Connection Conectar(){
    con=null;
    //Hace el intento de conexion con la base de datos
        try {
            Class.forName(DRIVER);
            con=DriverManager.getConnection(URL+":"+PORT+"/"+DATABASE+ARG,USER,PASS);
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
    
    

