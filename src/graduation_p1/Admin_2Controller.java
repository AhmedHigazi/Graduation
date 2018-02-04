/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduation_p1;

import DBC.assistantfactorDbc;
import DBC.effectiveDbc;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Ahmed Higazi
 */
public class Admin_2Controller implements Initializable {

    @FXML
    private VBox root;
    @FXML
    private Button button;
    @FXML
    private Label tool11;
    @FXML
    private Label tool21;
    @FXML
    private Label tool31;
    @FXML
    private TextField toolName1;
    @FXML
    private TextField toolSize1;
    @FXML
    private Button ASSBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  
    @FXML
    private void DisplayAss(ActionEvent event) throws IOException {
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("Admin_2.fxml"));     
        Scene WorkStation_One = new Scene(home_page_parent);
        
        Stage app = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        app.setScene(WorkStation_One);
      
        app.show();  
    }

    @FXML
    private void insertTool(ActionEvent event) throws ClassNotFoundException, SQLException {
         assistantfactorDbc d =new assistantfactorDbc();
       
        d.addProject(toolName1.getText(),toolSize1.getText());
         new JFXPanel();
        notifier("Done!", "Add AsstineFactor Is working Right.");
       
    }

    @FXML
    private void DisplayTool(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Admin_1.fxml"));     
        Scene WorkStation_One = new Scene(home_page_parent);
        
        Stage app = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        app.setScene(WorkStation_One);
      
        app.show(); 
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////
    private static void notifier(String pTitle, String pMessage) {
        Platform.runLater(() -> {
                    Stage owner = new Stage(StageStyle.TRANSPARENT);
                    StackPane root = new StackPane();
                    root.setStyle("-fx-background-color: TRANSPARENT");
                    Scene scene = new Scene(root, 1, 1);
                    scene.setFill(Color.TRANSPARENT);
                    owner.setScene(scene);
                    owner.setWidth(1);
                    owner.setHeight(1);
                    owner.toBack();
                    owner.show();
                    Notifications.create().title(pTitle).text(pMessage).showInformation();
                }
        );
    } 
}
