/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduation_p1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hapsha
 */
public class WorkeStationController implements Initializable {


    @FXML
    private Label Lable_new_btn;
    @FXML
    private Label lable_Viw_Rep;
    @FXML
    private Label Lable_admin;
    @FXML
    private Label Labe_Safety;
    @FXML
    private Label Labe_Safety1;
    @FXML
    private Label Labe_Safety11;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        }    


    @FXML
    private void Load_Splash_Screen_WorkStation(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("WorkStation_One.fxml"));     
        Scene WorkStation_One = new Scene(home_page_parent);
        
        Stage app = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        app.setScene(WorkStation_One);
       // app.setFullScreen(true);
        app.show();        
        
    }
// ================================= View Report ====================================================
    @FXML
    private void Load_Report_Screen(MouseEvent event) throws IOException {
        Parent Page_Qnatity_Materal_Report = FXMLLoader.load(getClass().getResource("Report.fxml"));     
        Scene WorkStation_One = new Scene(Page_Qnatity_Materal_Report);
        Stage app=new Stage();
       
        app.setScene(WorkStation_One);
        
        app.show();        
        
    
    
    }

    @FXML
    private void Load_Admin(MouseEvent event) throws IOException {
         Parent Page_Qnatity_Materal_Report = FXMLLoader.load(getClass().getResource("login.fxml"));     
        Scene WorkStation_One = new Scene(Page_Qnatity_Materal_Report);
        Stage app=new Stage();
       
        app.setScene(WorkStation_One);
        
        app.show();  
    }

    @FXML
    private void Load_Labe_Safety(MouseEvent event) throws IOException {
        Parent Page_Qnatity_Materal_Report = FXMLLoader.load(getClass().getResource("test.fxml"));     
        Scene WorkStation_One = new Scene(Page_Qnatity_Materal_Report);
        Stage app=new Stage();
       
        app.setScene(WorkStation_One);
        
        app.show(); 
    }

    @FXML
    private void Load_Labe_Help(MouseEvent event) throws IOException {
         Parent Page_Qnatity_Materal_Report = FXMLLoader.load(getClass().getResource("Help.fxml"));     
        Scene WorkStation_One = new Scene(Page_Qnatity_Materal_Report);
        Stage app=new Stage();
       
        app.setScene(WorkStation_One);
        
        app.show(); 
    }

    @FXML
    private void Load_Labe_About(MouseEvent event) throws IOException {
          Parent Page_Qnatity_Materal_Report = FXMLLoader.load(getClass().getResource("About.fxml"));     
        Scene WorkStation_One = new Scene(Page_Qnatity_Materal_Report);
        Stage app=new Stage();
       
        app.setScene(WorkStation_One);
        
        app.show(); 
    }

 

    


}
