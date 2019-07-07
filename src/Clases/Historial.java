/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author romer
 */
public class Historial {
    String pais,ciudad,localidad,fecha,motivo_consulta,sintomas,revision_general,antecedentes_personales,antecedentes_familiares,diagnostico,codigo,estado_imc;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivo_consulta() {
        return motivo_consulta;
    }

    public void setMotivo_consulta(String motivo_consulta) {
        this.motivo_consulta = motivo_consulta;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getRevision_general() {
        return revision_general;
    }

    public void setRevision_general(String revision_general) {
        this.revision_general = revision_general;
    }

    public String getAntecedentes_personales() {
        return antecedentes_personales;
    }

    public void setAntecedentes_personales(String antecedentes_personales) {
        this.antecedentes_personales = antecedentes_personales;
    }

    public String getAntecedentes_familiares() {
        return antecedentes_familiares;
    }

    public void setAntecedentes_familiares(String antecedentes_familiares) {
        this.antecedentes_familiares = antecedentes_familiares;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado_imc() {
        return estado_imc;
    }

    public void setEstado_imc(String estado_imc) {
        this.estado_imc = estado_imc;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getTension() {
        return tension;
    }

    public void setTension(double tension) {
        this.tension = tension;
    }

    public double getFrec_cardiaca() {
        return frec_cardiaca;
    }

    public void setFrec_cardiaca(double frec_cardiaca) {
        this.frec_cardiaca = frec_cardiaca;
    }

    public double getFrec_respiratoria() {
        return frec_respiratoria;
    }

    public void setFrec_respiratoria(double frec_respiratoria) {
        this.frec_respiratoria = frec_respiratoria;
    }
    double peso, talla, imc, tension,frec_cardiaca,frec_respiratoria;
}
