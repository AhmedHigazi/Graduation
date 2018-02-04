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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed Higazi
 */
public class ReportController implements Initializable {

    @FXML
    private Label Lable_new_btn;
    @FXML
    private Label lable_Viw_Rep;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Load_Splash_Screen_WorkStation(MouseEvent event) throws IOException {
     
         Parent Page_Qnatity_Materal_Report = FXMLLoader.load(getClass().getResource("Procurement_Report.fxml"));     
        Scene WorkStation_One = new Scene(Page_Qnatity_Materal_Report);
        Stage app=new Stage();
       
        app.setScene(WorkStation_One);
        
        app.show(); 
    }

    @FXML
    private void Load_Report_Screen(MouseEvent event) throws IOException {
     
        Parent Page_Qnatity_Materal_Report = FXMLLoader.load(getClass().getResource("Quantity_Materal_Report.fxml"));     
        Scene WorkStation_One = new Scene(Page_Qnatity_Materal_Report);
        Stage app=new Stage();
       
        app.setScene(WorkStation_One);
        
        app.show(); 
        
    }
    
}
