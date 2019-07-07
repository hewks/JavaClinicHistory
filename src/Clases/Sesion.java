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
public class Sesion extends Persona{
    Cliente cliente_act=null;
    Historial historial_act=null;

    public Historial getHistorial_act() {
        return historial_act;
    }

    public void setHistorial_act(Historial historial_act) {
        this.historial_act = historial_act;
    }

    public Cliente getCliente_act() {
        return cliente_act;
    }

    public void setCliente_act(Cliente cliente_act) {
        this.cliente_act = cliente_act;
    }

    
    
}
