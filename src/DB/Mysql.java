/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author 3RO
 */
public class Mysql {
    private static String user="root";
    private static String pass="";
    private static String url="jdbc:mysql://localhost:3306/biblioteca";
    private static Connection Conn;
    
    public static Connection getConnection(){
        try{
            Conn=DriverManager.getConnection(url, user, pass);
            if(Conn!=null){
                //JOptionPane.showMessageDialog(null, "Conexión estalecida con éxito");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
        return Conn;
    }
}