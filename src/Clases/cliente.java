/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
 *pRUEBAAAA desde github
 */
package clases;

import javax.swing.JComboBox;

/**
 *
 * @author Juan
 */
public class cliente extends Persona {
       private String lugar_exp,pais,estado_civil,departamento,ciudad,est_civil,titulo,
                res_departamento,res_ciudad,res_dir,res_barrio,res_pais,eps,table,fecha_nac,escolaridad,res_direccion,res_tel_1,res_tel_2,arl,afp;
       private int num_hijos;
       private boolean tipo_escolaridad;
       private final String[] nombre_de_variables=new String[]{"id","nombres","apellidos","tipo_id","identificacion","estado_civil","lugar_exp","fecha_nac","pais","departamento","ciudad","sexo","num_hijos",
       "escolaridad","tipo_escolaridad","titulo","res_pais","res_departamento","res_ciudad","res_direccion","res_barrio","res_tel_1","res_tel_2","email","EPS","ARL","AFP"};

    public String[] getNombre_de_variables() {
        return nombre_de_variables;
    }

    /*public cliente(String nombres, String apellidos, int tipo_id, int identificacion,String estado_civil,
            String lugar_exp,String fecha_nac, String pais,
            String departamento,String ciudad,
             int sexo,int num_hijos,String escolaridad,String tipo_escolaridad,  String titulo,
             String res_pais,
            String res_departamento, String res_ciudad, String res_dir, String res_barrio,
            String email, String eps,  boolean est_titulo,String table,String res_direccion,String res_tel_1,String res_tel_2,String arl,String afp) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.lugar_exp = lugar_exp;
        this.pais = pais;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.estado_civil = estado_civil;
        this.titulo = titulo;
        this.res_departamento = res_departamento;
        this.res_ciudad = res_ciudad;
        this.res_dir = res_dir;
        this.res_barrio = res_barrio;
        this.email = email;
        this.eps = eps;
        this.tipo_id = tipo_id;
        this.identificacion = identificacion;
        this.estado_civil = estado_civil;
        this.sexo = sexo;
        this.num_hijos = num_hijos;
        this.est_titulo = est_titulo;
        this.table = table;
        this.escolaridad=escolaridad;
        this.tipo_escolaridad=tipo_escolaridad;
        this.res_direccion=res_direccion;
        this.res_tel_1=res_tel_1;
        this.res_tel_2=res_tel_2;
        this.arl=arl;
        this.afp=afp;
        this.res_pais=res_pais;
        this.fecha_nac=fecha_nac;
        table="clientes";
    */

    public String getLugar_exp() {
        return lugar_exp;
    }

    public void setLugar_exp(String lugar_exp) {
        this.lugar_exp = lugar_exp;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEst_civil() {
        return est_civil;
    }

    public void setEst_civil(String est_civil) {
        this.est_civil = est_civil;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getRes_departamento() {
        return res_departamento;
    }

    public void setRes_departamento(String res_departamento) {
        this.res_departamento = res_departamento;
    }

    public String getRes_ciudad() {
        return res_ciudad;
    }

    public void setRes_ciudad(String res_ciudad) {
        this.res_ciudad = res_ciudad;
    }

    public String getRes_dir() {
        return res_dir;
    }

    public void setRes_dir(String res_dir) {
        this.res_dir = res_dir;
    }

    public String getRes_barrio() {
        return res_barrio;
    }

    public void setRes_barrio(String res_barrio) {
        this.res_barrio = res_barrio;
    }

    public String getRes_pais() {
        return res_pais;
    }

    public void setRes_pais(String res_pais) {
        this.res_pais = res_pais;
    }
    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public boolean getTipo_escolaridad() {
        return tipo_escolaridad;
    }

    public void setTipo_escolaridad(boolean tipo_escolaridad) {
        this.tipo_escolaridad = tipo_escolaridad;
    }

    public String getRes_direccion() {
        return res_direccion;
    }

    public void setRes_direccion(String res_direccion) {
        this.res_direccion = res_direccion;
    }

    public String getRes_tel_1() {
        return res_tel_1;
    }

    public void setRes_tel_1(String res_tel_1) {
        this.res_tel_1 = res_tel_1;
    }

    public String getRes_tel_2() {
        return res_tel_2;
    }

    public void setRes_tel_2(String res_tel_2) {
        this.res_tel_2 = res_tel_2;
    }

    public String getArl() {
        return arl;
    }

    public void setArl(String arl) {
        this.arl = arl;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getNum_hijos() {
        return num_hijos;
    }

    public void setNum_hijos(int num_hijos) {
        this.num_hijos = num_hijos;
    }


    public void setEstado_civil(JComboBox estciv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setSexo(JComboBox sexo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
        
    

