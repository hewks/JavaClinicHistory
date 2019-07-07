/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.JFrame;

/**
 *
 * @author Juan
 */
public class Sesion extends Persona {
    cliente cliente_act=null;
    Consulta consulta_act=null;
    JFrame ventana_ant=null;
    JFrame ventana_act=null;
    public Sesion() {
    };

    public Consulta getConsulta_act() {
        return consulta_act;
    }

    public void setConsulta_act(Consulta consulta_act) {
        this.consulta_act = consulta_act;
    }

    public cliente getCliente_act() {
        return cliente_act;
    }

    public void setCliente_act(cliente cliente_act) {
        this.cliente_act = cliente_act;
    }

    public JFrame getVentana_ant() {
        return ventana_ant;
    }

    public void setVentana_ant(JFrame ventana_ant) {
        this.ventana_ant = ventana_ant;
    }

    public JFrame getVentana_act() {
        return ventana_act;
    }

    public void setVentana_act(JFrame ventana_act) {
        this.ventana_act = ventana_act;
    }
    
}
