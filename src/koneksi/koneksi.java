/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {

    private Connection koneksi;
    public Connection connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Database Terhubung");
        }   catch (ClassNotFoundException ex){
            System.err.println ("Driver Database Terputus"+ex);
        }
        
        String url;
        url = "jdbc:mysql://localhost:3306/db_monitoring";
        try {
            koneksi = DriverManager.getConnection(url,"root","");
            System.out.println("Database Terhubung");
        }   catch (SQLException ex){
            System.err.println("Database Terputus"+ex);
        }
        return koneksi;
    }
}