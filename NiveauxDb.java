/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class NiveauxDb {
       static Connection con=null;
    
    public static Connection getCon() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost/skills";
            String user ="root";
            String pass="";
            con=DriverManager.getConnection(url,user,pass);
            
}
        catch(ClassNotFoundException | SQLException e){
            
        }
        return con;
    
    
} 
    public static Users getUser(String em){
        Users u= new Users();
        try{
            String sql ="SELECT * FROM `users` where `email`=? ";
            Connection con =AdminsDb.getCon();
            PreparedStatement preparedstatement =(PreparedStatement) con.prepareStatement(sql);
            preparedstatement.setString(1, em);
            ResultSet result= preparedstatement.executeQuery();
            
            while(result.next()){
                
                u.setId(result.getInt(1));
                u.setEmail(result.getString(4));
                u.setNom(result.getString(2));
                u.setPrenom(result.getString(3));
                u.setPass(result.getString(5));
                u.setRole(result.getString(6));
                u.setReference(result.getString(7));
                
                
                
            }
            con.close();
            
        }
        catch(SQLException e){
            
        }
        return u;
        
    } 
}
