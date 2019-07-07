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
public class Informacion {
    protected static final String DATABASE="MedSystemDataBase";
    protected static final String DRIVER="com.mysql.jdbc.Driver";
    protected static final String USER="admin";
    protected static final String URL="jdbc:mysql://sl-us-south-1-portal.48.dblayer.com";
    protected static final String PASS="Asdfghjkl159753";
    protected static final String PORT="24186";
    protected static final String ARG="?useSSL=false";
    protected String user_table="users";
    protected String client_table="clients";
    protected String user_table_username="username";
    protected String user_table_password="password";
    protected String history_table="clinic_history";

    public void setUser_table(String user_table) {
        this.user_table = user_table;
    }

    public void setClient_table(String client_table) {
        this.client_table = client_table;
    }

    public void setUser_table_username(String user_table_username) {
        this.user_table_username = user_table_username;
    }
    
    

    
    
}
