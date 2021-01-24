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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    public static List<Niveaux> getNv(String em){
        List<Niveaux> list= new ArrayList<Niveaux>();
        
        try{
            String sql ="SELECT * FROM `niveaux` where `id_user`=?";
            Connection con =AdminsDb.getCon();
            PreparedStatement preparedstatement =(PreparedStatement) con.prepareStatement(sql);
            preparedstatement.setString(1, em);
            ResultSet result= preparedstatement.executeQuery();
            
            while(result.next()){
                Niveaux u= new Niveaux();
                u.setId_competence(result.getInt(2));
                u.setId_user(result.getInt(1));
                u.setNiveau(result.getInt(3));
                
                list.add(u);
                
                
            }
            con.close();
            
        }
        catch(SQLException e){
            
        }
        return list;
        
    } 
public static void  updateNV(int c,int u,int niveau){
    
      try{
         Connection con =AdminsDb.getCon();
         String query ="UPDATE `skills`.`niveaux` SET `niveau` = ? WHERE `niveaux`.`id_user` = ? AND `niveaux`.`id_competence` = ?;"; 
         PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
         preparedStmt.setInt(1,niveau);
         preparedStmt.setInt(2, u);
         preparedStmt.setInt(3, c);
         preparedStmt.executeUpdate();
         System.out.print(preparedStmt);
        
         con.close();
     }catch(Exception e){
         System.err.print( e.getClass().getName() + ": " + e.getMessage());
     }
}
}
