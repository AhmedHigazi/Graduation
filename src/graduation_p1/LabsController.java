package graduation_p1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Hima
 */
public class LabsController implements Initializable {
    
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void agree(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("WorkeStation.fxml"));     
        Scene WorkStation_One = new Scene(home_page_parent);
        
        Stage app = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        app.setScene(WorkStation_One);
       // app.setFullScreen(true);
        app.show();  
        
    }
    
}
