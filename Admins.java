/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

/**
 *
 * @author Admin
 */
public class Admins {
    private int id;
    private String email;
    private String password;
    
    
    public Admins(){
        super();
    }

    public Admins(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    
    
    
}
