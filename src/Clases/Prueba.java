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
public class Prueba extends Accion{ 
    public static void main(String[] args) {
        
        Conexion con=new Conexion();
        Connection cc=con.Conectar();
    Conexion con1=new Conexion();
    Connection cc1=con1.Conectar();
        for(int i=98;i<=600;i++){
        
        String SQL="SELECT id10 FROM diagnostic_codes order by rand()";
        String devolver=null;
        try {
           Statement st =cc.createStatement();
           ResultSet rs = st.executeQuery(SQL);
           
           if(rs.next()){
        devolver=rs.getString(1);
        con.Desconectar();
        }
        } catch (SQLException ex) {
            System.out.println("error sacando datos "+ex);
        }
           System.out.println(devolver);     
    
    String SQL1="UPDATE `MedSystemDataBase`.`clinic_history` SET `codigo_diagnostico` = '"+devolver+"' WHERE (`id` = '"+i+"')";
    
        try {
            Statement st=cc1.createStatement();
            st.execute(SQL1);
            System.out.println("Hecho en el id "+i);
            con1.Desconectar();
            
        } catch (SQLException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        
        
        }
    
    
    }
}
