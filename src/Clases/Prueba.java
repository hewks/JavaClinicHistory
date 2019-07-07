/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Juan
 */
public class Prueba { 
    public static void main(String[] args) {
        Sesion sesion_act=new Sesion();
        sesion_act.setCliente_act(new Cliente());
    String client_table="hola";
    String SQL="INSERT INTO "+client_table+" (nombres,apellidos,identificacion,tipo_identificacion,sexo,estado_civil,"
                + "hijos,fecha_nacimiento,pais,departamento,ocupacion,escolaridad,pais_residencia,ciudad_residencia)values"
                + "("+sesion_act.getCliente_act().getNombres()+","
                + sesion_act.getCliente_act().getApellidos()+","
                + sesion_act.getCliente_act().getIdentificacion()+","
                + sesion_act.getCliente_act().getTipo_id()+","
                + sesion_act.getCliente_act().getSexo()+","
                + sesion_act.getCliente_act().getEstado_civil()+","
                + sesion_act.getCliente_act().getHijos()+","
                + sesion_act.getCliente_act().getFecha_nac()+","
                + sesion_act.getCliente_act().getPais()+","
                + sesion_act.getCliente_act().getDep()+","
                + sesion_act.getCliente_act().getOcupacion()+","
                + sesion_act.getCliente_act().getEscolaridad()+","
                + sesion_act.getCliente_act().getPais_res()+","
                + sesion_act.getCliente_act().getCiudad_res()+")";
    System.out.println(SQL);
    }
    
}
