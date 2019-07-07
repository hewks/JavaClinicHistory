/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Interfaces.formulario;
import java.sql.*;
import javax.swing.JFrame;
import Interfaces.menu;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.*;
import javax.swing.JOptionPane;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Juan
 */
public class Accion {
    //Hace la accion del login usando la conexion a SQL
    public void login(String user,String raw_password,JFrame act_window_name){
    String info;
    String password=this.encrypted(raw_password);
        Conexion cc=new Conexion();
        Connection con=cc.Conectar();
        String SQL="select * from user_table where username='"+user+"' and password='"+password+"'";
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            Sesion sesion=new Sesion();
            if(rs.next()){
                sesion.setVentana_ant(act_window_name);
                info="se ha conectado exitosamente el usuario "+rs;
            System.out.println(info);
            act_window_name.dispose();
            
                sesion.setVentana_act(new menu(sesion));
                sesion.getVentana_act().setVisible(true);
                
            }else{
                info="Datos incorrectos";
            System.out.println(info);
            }
        } catch (SQLException e) {
            System.out.println("Error de ingreso "+e);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //sube la informacion de un nuevo cliente
    public void formulario(cliente cliente_formulario,String database){
        String[] nombre_datos=new cliente().getNombre_de_variables();
        String SQL="insert into clientes(";
/*      String SQL="insert into "+database+" (nombres,apellidos,tipo_id,identificacion,"+
              "estado_civil,lugar_exp,fecha_nac,pais,departamento,ciudad,sexo,"+
              "num_hijos,escolaridad,tipo_escolaridad,titulo,res_pais,res_departamento,"+
              "res_ciudad,res_direccion,res_barrio,res_tel_1,res_tel_2,email,EPS,"+
              "ARL,AFP)"+
              " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        */
        for(int i=0; i<nombre_datos.length-1;i=i+1){
            SQL=SQL+nombre_datos[i+1];
            if(i<nombre_datos.length-2){
                SQL=SQL+",";
            }
        };
         SQL=SQL+") values(";
    
            for(int i=0;i<nombre_datos.length-1;i=i+1){
        SQL=SQL+"?";
            if(i<nombre_datos.length-2){
                SQL=SQL+",";
            }
             }
                 SQL=SQL+")";
        
        Conexion cc=new Conexion();
        Connection con=cc.Conectar();
      
//      String SQL="insert into clientes (nombres,apellidos,tipo_id,identificacion) values(?,?,?,?)";
        try {
            PreparedStatement pst=con.prepareStatement(SQL);
            pst.setString(1, cliente_formulario.getNombres());
            pst.setString(2, cliente_formulario.getApellidos());
            pst.setInt(3, cliente_formulario.getTipo_id());
            pst.setInt(4, cliente_formulario.getIdentificacion());
            pst.setString(5, cliente_formulario.getEstado_civil());
            pst.setString(6, cliente_formulario.getLugar_exp());
            pst.setString(7, cliente_formulario.getFecha_nac());
            pst.setString(8, cliente_formulario.getPais());
            pst.setString(9, cliente_formulario.getDepartamento());
            pst.setString(10, cliente_formulario.getCiudad());
            pst.setInt(11, cliente_formulario.getSexo());
            pst.setInt(12, cliente_formulario.getNum_hijos());
            pst.setString(13, cliente_formulario.getEscolaridad());
            pst.setBoolean(14, cliente_formulario.getTipo_escolaridad());
            pst.setString(15, cliente_formulario.getTitulo());
            pst.setString(16, cliente_formulario.getRes_pais());
            pst.setString(17, cliente_formulario.getRes_departamento());
            pst.setString(18, cliente_formulario.getRes_ciudad());
            pst.setString(19, cliente_formulario.getRes_direccion());
            pst.setString(20, cliente_formulario.getRes_barrio());
            pst.setString(21, cliente_formulario.getRes_tel_1());
            pst.setString(22, cliente_formulario.getRes_tel_2());
            pst.setString(23, cliente_formulario.getEmail());
            pst.setString(24, cliente_formulario.getEps());
            pst.setString(25, cliente_formulario.getArl());
            pst.setString(26, cliente_formulario.getAfp());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro exitoso");
            
        cc.salir();
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(formulario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } 
    }
    
    
    
    
    
    
    //saca una lista de datos, puede ser 1 o una tabla
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
        cc.desconectar();
           return resultado;
        } catch (SQLException ex) {
            System.out.println("error sacando datos "+ex);
        }
        cc.salir();
        return null;
    }
    
    //crea una clase cliente desde SQL
    public cliente sacarCliente(String identificacion){
        cliente cliente_act=new cliente();
        String[][] tabla=this.SacarDatos("*", "identificacion", identificacion, "clientes");
        if(tabla.length>0){
        int mi=tabla.length;
        int mj=tabla[0].length;
        cliente_act.setId(Integer.parseInt(tabla[0][0]));
        cliente_act.setNombres(tabla[0][1]);
        cliente_act.setApellidos(tabla[0][2]);
        cliente_act.setTipo_id(Integer.parseInt(tabla[0][3]));
        cliente_act.setIdentificacion(Integer.parseInt(tabla[0][4]));
        cliente_act.setEstado_civil(tabla[0][5]);
        cliente_act.setLugar_exp(tabla[0][6]);
        cliente_act.setFecha_nac(tabla[0][7]);
        
        cliente_act.setPais(tabla[0][8]);
        cliente_act.setDepartamento(tabla[0][9]);
        cliente_act.setCiudad(tabla[0][10]);
        cliente_act.setSexo(Integer.parseInt(tabla[0][11]));
        cliente_act.setNum_hijos(Integer.parseInt(tabla[0][12]));
        cliente_act.setEscolaridad(tabla[0][13]);
        cliente_act.setTipo_escolaridad(Boolean.getBoolean(tabla[0][14]));
        cliente_act.setTitulo(tabla[0][15]);
        cliente_act.setRes_pais(tabla[0][16]);
        cliente_act.setRes_departamento(tabla[0][17]);
        cliente_act.setRes_ciudad(tabla[0][18]);
        cliente_act.setRes_direccion(tabla[0][19]);
        cliente_act.setRes_barrio(tabla[0][20]);
        cliente_act.setRes_tel_1(tabla[0][21]);
        cliente_act.setRes_tel_2(tabla[0][22]);
        cliente_act.setEmail(tabla[0][23]);
        cliente_act.setEps(tabla[0][24]);
        cliente_act.setArl(tabla[0][25]);
        cliente_act.setAfp(tabla[0][26]);}
        else {
            cliente_act=null;
        }
        /*    try {
            for(int i=0;i<mi;i++){
                for(int j=0;j<mi;j++){
            Method c=cliente_act.getClass().getMethod("set"+capitalizar(datos[j]));
            c.invoke(cliente_act);
            
                }
            }
            Method c=cliente_act.getClass().getMethod("getNombres");
            System.out.println("el metodo es "+c);
            System.out.println(c.invoke(cliente_act,3));
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Accion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Accion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Accion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Accion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Accion.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    return cliente_act;
    }
    
    
    
    
    
    
    
    //encripta la contraseña para enviar
    public String encrypted(String password){
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
    
    
    private String capitalizar(String line) {
   return Character.toUpperCase(line.charAt(0)) + line.substring(1);
}
    
    
    
    
    public int indexSexo(String sexo){
        int iSexo=0;
        switch(sexo) {
  case "Masculino":
    iSexo=0;
    break;
  case "Femenino":
    iSexo=1;
    break;
  case "Otros":
    iSexo=2;
    break;
  default:
    // code block
}return iSexo;
}
    
    public String indexSexo(int sexo){
       String Ssexo=null;
    switch(sexo){
        case 0:
            Ssexo="Masculino";
            break;
        case 1:
            Ssexo="Femenino";
            
            break;
        case 2:
            Ssexo="Otros";
    
    
    }
    return Ssexo;
    }
    
    
    public void consulta_1(Consulta consulta_formulario,String database){
      String SQL="insert into "+database+" (user_id,motivo_consulta,descripcion_sintomas,antecedentes_quirurjicos,antecedentes_hospitalizaciones,"+
              "antecedentes_traumatismo,antecedentes_inmunizaciones,antecedentes_alergicos,antecedentes_medicamentos,antecedentes_familiares,revision_general,revision_piel,"+
              "revision_neurosensorial_ojos,revision_neurosensorial_nariz,revision_neurosensorial_oidos,revision_neurosensorial_boca,revision_cardiovascular,revision_respiratorio,revision_gastrointestinal,"+
              "revision_urinario,revision_reproductor,revision_endocrino,revision_nervioso)"+
              " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        
        Conexion cc=new Conexion();
        Connection con=cc.Conectar();
      
//      String SQL="insert into clientes (nombres,apellidos,tipo_id,identificacion) values(?,?,?,?)";
        try {
            PreparedStatement pst=con.prepareStatement(SQL);
            pst.setInt(1, consulta_formulario.getUser_id());
            pst.setString(2, consulta_formulario.getMotivo_consulta());
            pst.setString(3, consulta_formulario.getDescripcion_sintomas());
            pst.setString(4, consulta_formulario.getAntecedentes_quirurjicos());
            pst.setString(5, consulta_formulario.getAntecedentes_hospitalizaciones());
            pst.setString(6, consulta_formulario.getAntecedentes_traumatismo());
            pst.setString(7, consulta_formulario.getAntecedentes_inmunizaciones());
            pst.setString(8, consulta_formulario.getAntecedentes_alergicos());
            pst.setString(9, consulta_formulario.getAntecedentes_medicamentos());
            pst.setString(10, consulta_formulario.getAntecedentes_familiares());
            pst.setString(11, consulta_formulario.getRevision_general());
            pst.setString(12, consulta_formulario.getRevision_piel());
            pst.setString(13, consulta_formulario.getRevision_neurosensorial_ojos());
            pst.setString(14, consulta_formulario.getRevision_neurosensorial_nariz());
            pst.setString(15, consulta_formulario.getRevision_neurosensorial_oidos());
            pst.setString(16, consulta_formulario.getRevision_neurosensorial_boca());
            pst.setString(17, consulta_formulario.getRevision_cardiovascular());
            pst.setString(18, consulta_formulario.getRevision_respiratorio());
            pst.setString(19, consulta_formulario.getRevision_gastrointestinal());
            pst.setString(20, consulta_formulario.getRevision_urinario());
            pst.setString(21, consulta_formulario.getRevision_reproductor());
            pst.setString(22, consulta_formulario.getRevision_endocrino());
            pst.setString(23, consulta_formulario.getRevision_nervioso());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro exitoso");
            
        cc.salir();
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(formulario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } 
    }
    
    
    }
    
    

