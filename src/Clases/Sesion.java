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
    Cliente actual=null;

    public Cliente getActual() {
        return actual;
    }

    public void setActual(Cliente actual) {
        this.actual = actual;
    }
    
    
}
