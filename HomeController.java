/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static javafxapplication3.NiveauxDb.updateNV;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class HomeController implements Initializable {
    public String this_email;
     @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Pane page1;
    @FXML
    private Label label;
    @FXML
    private Pane home1;
    @FXML
    private Label role;
    @FXML
    private Button suivant;
    @FXML
    private Label nom;
    @FXML
    private Label emailH;
    @FXML
    private Button Deconexion;
       @FXML
    private VBox vbox;
        @FXML
    private VBox vbox1;
         @FXML
    private Pane page22;

    @FXML
    private VBox V;
    public VBox V1(String i , int n ,int nv,int user){
       VBox pane1=new VBox();
            Label l=new Label(i);
            l.setPadding(new Insets(10, 10, 10, 10));
            Button b1=new Button("Niveau 1");
            Button b2=new Button("Niveau 2");
            Button b3=new Button("Niveau 3");
            b1.setOnAction(e -> {
            if(n==0){
                updateNV(nv,user,1);
            }
            if(n==1){
                updateNV(nv,user,0);
            }
            
                  });
            b2.setOnAction(e -> {
            if(n==2){
                updateNV(nv,user,1);
            }
            if(n<2){
                updateNV(nv,user,2);
            }
            
                  });
            b3.setOnAction(e -> {
            if(n==3){
                updateNV(nv,user,2);
            }
            if(n<3){
                updateNV(nv,user,3);
            }
            
                  });
                
            switch(n){
                 case 1 : b1.setStyle("-fx-background-color: #0D7A23; ");break;
                 case 2 : b1.setStyle("-fx-background-color: #0D7A23; ");b2.setStyle("-fx-background-color: #0D7A23; ");break;
                 case 3 : b1.setStyle("-fx-background-color: #0D7A23; ");b2.setStyle("-fx-background-color: #0D7A23; ");b3.setStyle("-fx-background-color: #0D7A23; ");break;
             }
            HBox h=new HBox();
            h.getChildren().addAll(b1,b2,b3);
            pane1.getChildren().addAll(l,h);
            return pane1;
   }

    @FXML
    void click(ActionEvent event) {
        if(event.getTarget()==btn1){
            page1.setVisible(true);
            page22.setVisible(false);
            
            
            
        }
        else if(event.getTarget()==btn2){
            page22.setVisible(true);
            page1.setVisible(false);
            
        }
        else if(event.getTarget()==suivant){
            home1.setVisible(false);
            page22.setVisible(false);
            page1.setVisible(true);
            this_email=label.getText();
            Users a = new Users();
            a=UsersDb.getUser(this_email);
            role.setText(toUpperCase(a.getRole()));
            nom.setText(a.getNom() +" "+a.getPrenom());
            emailH.setText(a.getEmail());
            
            List<Niveaux> n=NiveauxDb.getNv(String.valueOf(a.getId()));
            for (int i = 0; i < n.size(); i+=2){
                Compitance u= new Compitance();
                u=CompitanceDb.getCompaitance(String.valueOf(n.get(i).getId_competence()));
                VBox cc=V1(u.getTitle(),n.get(i).getNiveau(),n.get(i).getId_competence(),n.get(i).getId_user());
                vbox.getChildren().add(cc);
            }
            for (int i = 1; i < n.size(); i+=2){
                Compitance u= new Compitance();
                u=CompitanceDb.getCompaitance(String.valueOf(n.get(i).getId_competence()));
                VBox cc=V1(u.getTitle(),n.get(i).getNiveau(),n.get(i).getId_competence(),n.get(i).getId_user());
                vbox1.getChildren().add(cc);
            }           
        }
        else if(event.getTarget()==Deconexion){
            final Node source = (Node) event.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();

        }
        

    }
    public void setText(String Email){
        this.label.setText(Email);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    } 


    
    
}
