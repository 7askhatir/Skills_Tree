/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import static javax.swing.UIManager.getInt;
import static javax.swing.UIManager.getString;
/**
 *
 * @author Admin
 */
public class AdminsDb {
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
    public static List<Admins> getAdmins(){
        List<Admins> list= new ArrayList<Admins>();
        try{
            String sql ="SELECT * FROM `users`";
            Connection con =AdminsDb.getCon();
            PreparedStatement preparedstatement =(PreparedStatement) con.prepareStatement(sql);
            ResultSet result= preparedstatement.executeQuery();
            
            while(result.next()){
                Admins adm=new Admins();
                adm.setId(result.getInt(1));
                adm.setEmail(result.getString(4));
                adm.setPassword(result.getString(5));
                
                list.add(adm);
            }
            con.close();
            
        }
        catch(SQLException e){
            
        }
        return list;
        
    }
}
