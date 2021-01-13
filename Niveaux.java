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
public class Niveaux {
    private int id_user,id_competence,niveau;

    public Niveaux(int id_user, int id_competence, int niveau) {
        this.id_user = id_user;
        this.id_competence = id_competence;
        this.niveau = niveau;
    }
    public Niveaux(){
        super();
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_competence() {
        return id_competence;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_competence(int id_competence) {
        this.id_competence = id_competence;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    
    
    
}
