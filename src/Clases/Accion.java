/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.security.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class Accion extends Informacion{
    public Sesion login(String user, String raw_password){
        Sesion sesion_act=null;
        String password=encriptar(raw_password);
        Conexion con=new Conexion();
        Connection cc=con.Conectar();
        con.Conectar();
        String SQL="SELECT * FROM "+user_table+" WHERE "+user_table_username+"= '"+user+"' AND "+user_table_password+" = '"+password+"'";
        try {
            Statement st=cc.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs.next()){
            sesion_act=new Sesion();
            }else{
            return sesion_act=null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Accion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return sesion_act;
    }
    
    public void paciente(Sesion sesion_act){
        Conexion con=new Conexion();
        Connection cc=con.Conectar();
        String SQL="INSERT INTO clients (nombres,apellidos,identificacion,tipo_identificacion,"
                + "sexo,estado_civil,hijos,fecha_nacimiento,pais,departamento,ocupacion,escolaridad,pais_residencia,ciudad_residencia)values"
                + "('"+sesion_act.getCliente_act().getNombres()+"',"
                + "'"+sesion_act.getCliente_act().getApellidos()+"',"
                + "'"+sesion_act.getCliente_act().getIdentificacion()+"',"
                + "'"+sesion_act.getCliente_act().getTipo_id()+"',"
                + "'"+sesion_act.getCliente_act().getSexo()+"',"
                + "'"+sesion_act.getCliente_act().getEstado_civil()+"',"
                + "'"+sesion_act.getCliente_act().getHijos()+"',"
                + "'"+sesion_act.getCliente_act().getFecha_nac()+"',"
                + "'"+sesion_act.getCliente_act().getPais()+"',"
                + "'"+sesion_act.getCliente_act().getDep()+"',"
                + "'"+sesion_act.getCliente_act().getOcupacion()+"',"
                + "'"+sesion_act.getCliente_act().getEscolaridad()+"',"
                + "'"+sesion_act.getCliente_act().getPais_res()+"',"
                + "'"+sesion_act.getCliente_act().getCiudad_res()+"')";
        System.out.println(SQL);
        try {
            PreparedStatement pst=cc.prepareStatement(SQL);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Registro exitoso");
        } catch (SQLException ex) {
            Logger.getLogger(Accion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
    
    
    
    public void historia(Sesion sesion_act){
    Conexion con=new Conexion();
        Connection cc=con.Conectar();
        String SQL="INSERT INTO "+history_table+" (user_id,motivo_consulta,antecedentes_familiares,revision_general,codigo_diagnostico,"
                + "antecedentes_personales,pais,ciudad,localidad,fecha,sintomas,peso,talla,imc,estado_imc,tension,frecuencia_cardiaca,"
                + "frecuencia_respiratoria)values("
                + sesion_act.getHistorial_act().getUser_id()+","
                + sesion_act.getHistorial_act().getMotivo_consulta()+","
                + sesion_act.getHistorial_act().getAntecedentes_familiares()+","
                + sesion_act.getHistorial_act().getRevision_general()+","
                + sesion_act.getHistorial_act().getCodigo()+","
                + sesion_act.getHistorial_act().getAntecedentes_personales()+","
                + sesion_act.getHistorial_act().getPais()+","
                + sesion_act.getHistorial_act().getCiudad()+","
                + sesion_act.getHistorial_act().getLocalidad()+","
                + sesion_act.getHistorial_act().getFecha()+","
                + sesion_act.getHistorial_act().getSintomas()+","
                + sesion_act.getHistorial_act().getPeso()+","
                + sesion_act.getHistorial_act().getTalla()+","
                + sesion_act.getHistorial_act().getImc()+","
                + sesion_act.getHistorial_act().getEstado_imc()+","
                + sesion_act.getHistorial_act().getTension()+","
                + sesion_act.getHistorial_act().getFrec_cardiaca()+","
                + sesion_act.getHistorial_act().getFrec_respiratoria()+")";
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
