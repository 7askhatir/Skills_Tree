/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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
    private Pane pane_comp;
    @FXML
    private Button btn2;
    @FXML
    private Pane page1;
    @FXML
    private Label label;
    @FXML
    private Pane page2;
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
    

    void click(ActionEvent event) {
        if(event.getTarget()==btn1){
            page1.setVisible(true);
            page2.setVisible(false);
            
            
            
        }
        else if(event.getTarget()==btn2){
            page2.setVisible(true);
            page1.setVisible(false);
            
        }
        else if(event.getTarget()==suivant){
            home1.setVisible(false);
            this_email=label.getText();
            Users a = new Users();
            a=UsersDb.getUser(this_email);
            role.setText(toUpperCase(a.getRole()));
            nom.setText(a.getNom() +" "+a.getPrenom());
            emailH.setText(a.getEmail());
            
            
            
            
           
            
        }
        else if(event.getTarget()==Deconexion){
            final Node source = (Node) event.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();

        }
        

    }
    @FXML
    private Label email;
    
    public void setText(String Email){
        this.label.setText(Email);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
     
     
      
      
      
      
        
        
    }    

    
    
}
