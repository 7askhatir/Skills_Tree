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
public class Users {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String pass;
    private String role;
    private String reference;

    public Users(int id, String nom, String prenom, String email, String pass, String role, String reference) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pass = pass;
        this.role = role;
        this.reference = reference;
    }

    public Users(){
        super();
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getRole() {
        return role;
    }

    public String getReference() {
        return reference;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
    
    
    
    
}
