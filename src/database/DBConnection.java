/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Diego
 */
public class DBConnection {
    private static DBConnection instance;
    private static String server;
    private static String port;
    private static String dbName;
    private static String username;
    private static String password;
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private Connection connection;

    private DBConnection(String sv, String prt, String db, String user, String pwd) {
        server = sv;
        port = prt;
        dbName = db;
        username = user;
        password = pwd;
    }
    
    public static DBConnection configureConnection(String server, String port, String dbName, String username, String password){
        if(instance == null){
            instance = new DBConnection(server, port, dbName, username, password);
        }
        return instance;
    }
    
    public String getConnectionAddress(){
        return "jdbc:mysql://" + server + ":" + port + "/" + dbName;
    }
    
    public Connection connect(){  
        try {
            Class.forName(this.DRIVER);
            connection = DriverManager.getConnection(this.getConnectionAddress(), username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERROR");
            //Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return connection;
    }
    
    public void disconnect() {
        if(connection!=null){
            try{
                connection.close();
            }
            catch(SQLException e){
                System.out.println("ERROR");            
                //Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    public static DBConnection getCreatedConnection(){
        return instance;
    }
}
