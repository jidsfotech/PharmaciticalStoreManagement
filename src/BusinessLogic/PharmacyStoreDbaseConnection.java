/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MAJEED SHUAIB
 * 
 */
public class PharmacyStoreDbaseConnection {
    private static Connection connection = null;
    private static final String Url = "jdbc:mysql://localhost:3306/pharmaciticalstoredb";
    private static final String username = "root";
    private static final String password = "devadmin";
    
    public static Connection getDbaseConnection(){
        try{
            try {
                connection =  DriverManager.getConnection(Url, username, password);
            } catch (SQLException ex) {
                Logger.getLogger(medicine.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Connection to database not sucessfull");
            }
            System.out.println("Connection to database sucessfull");
            
        }catch(Exception e){
            System.out.println("Connection to database not sucessfull");
        }
        
        return connection;
        
    }
}