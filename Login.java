package javafxapplication3;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login {
    @FXML
    private TextField l_email;
    @FXML
    private Label chek;
    @FXML
    private PasswordField l_pass;
    @FXML
    private Button btn;

    @FXML
    void click(ActionEvent event) throws SQLException, IOException {
        
            if(event.getTarget()==btn){
                if(!AdminsDb.getCon().isClosed()){
                    System.out.print("DB Connect");
                    List<Admins> list=AdminsDb.getAdmins();
                    Map<String,String> map=new HashMap<String,String>();
                    for(Admins a:list){
                        map.put(a.getEmail(),a.getPassword());
                    }
                    if(map.containsKey(l_email.getText())){
                        String Val=map.get(l_email.getText());
                        if(Val.equals(l_pass.getText())){
                    
                            FXMLLoader loader =new FXMLLoader();
                            loader.setLocation(getClass().getResource("Home.fxml"));
                            try{
                                loader.load();
                            }
                            catch(IOException e){
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE,null,e);  
                            }
                            HomeController display =loader.getController();
                            
                            display.setText(l_email.getText());
                            Parent p = loader.getRoot();
                            Stage stage =new Stage();
                            stage.setScene(new Scene(p));
                            stage.showAndWait();
                            
                            
                            
                            
                        }
                        else{
                            chek.setText("Votre Email ou Password Incorrect !!");
                        }
                    }
                    else{
                        chek.setText("Votre Email ou Password Incorrect !!");
                    }
                }
                else{
                    System.out.print("DB Not Connected !!!");
                    
                }
            }
        

    }

}