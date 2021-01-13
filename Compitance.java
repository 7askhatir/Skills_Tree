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
public class Compitance {
    private int id;
    private String title,reference;
    
     public Compitance(){
        super();
    }
    public Compitance(int id, String title, String reference) {
        
        this.id = id;
        this.title = title;
        this.reference = reference;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getReference() {
        return reference;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
    
    
    
    
    
}
