/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduation_p1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author Hapsha
 */
public class FXMLDocumentController implements Initializable {

    @FXML
     AnchorPane Root_panel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            Load_Splash_Screen_Forth();
            //Load_Splash_Screen();
            //Load_Splash_Screen_WorkStation();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    


   private void Load_Splash_Screen_Forth() throws IOException{
    
    StackPane pane = FXMLLoader.load(getClass().getResource("Sp_One.fxml"));
    Root_panel.getChildren().setAll(pane);
    FadeTransition fadein = new  FadeTransition(Duration.seconds(1),pane);
    fadein.setFromValue(0);
    fadein.setToValue(1);
    fadein.setCycleCount(1);
    
    fadein.play();
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    FadeTransition fadeOut = new  FadeTransition(Duration.seconds(11),pane);
    
    fadeOut.setFromValue(1);
    fadeOut.setToValue(0);
    fadeOut.setCycleCount(1);
    
    fadein.setOnFinished((e)->{
    fadeOut.play();
    });
    
    
    fadeOut.setOnFinished((e)->{
    
        try {    
            Load_Splash_Screen_WorkStation();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    });
    
    } 
  
// ========================================= Thered Fade implementtation ========================================
  
     
   private void Load_Splash_Screen_WorkStation() throws IOException{
    
    StackPane pane = FXMLLoader.load(getClass().getResource("WorkeStation.fxml"));
    Root_panel.getChildren().setAll(pane);

   }
  
}
 