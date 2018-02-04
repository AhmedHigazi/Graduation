/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduation_p1;

import static graduation_p1.Quantity_Materal_ReportController.conn;
import static graduation_p1.Quantity_Materal_ReportController.connectToDB;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Hapsha
 */
public class Procurement_ReportController implements Initializable {

    @FXML
    private Button PrintOut;
    @FXML
    private Button Back_btn;
     public static Connection conn;
    @FXML
    private TableView tableview;
    private ObservableList<ObservableList> data;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       buildData();
    }    
       

	public static void connectToDB() throws ClassNotFoundException, SQLException
	{
		// Instantiate the driver for MySQL
     try {
        
         Class.forName("com.mysql.jdbc.Driver").newInstance();
     }
     catch (Exception e) {
      e.printStackTrace();
    }

// Create the connection to the db
    try {
       conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vlab","root","");
	}
    catch (SQLException e) {
      e.printStackTrace();
    }
        }
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        
          public void buildData(){
          
          data = FXCollections.observableArrayList();
          Statement s = null;
          try{
             connectToDB();
             String query = "select * from matrale";
	     s = conn.createStatement();
	     ResultSet rs= s.executeQuery(query);

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                String x=rs.getMetaData().getColumnName(i+1);
                if("matrale_id".equals(x)||"name".equals(x)||"consuming_quantity".equals(x)){
                final int j = i;                
                TableColumn col = new TableColumn(x);
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tableview.getColumns().addAll(col); 
                System.out.println("Column ["+i+"] ");
            }}

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                  
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tableview.setItems(data);
          }catch(ClassNotFoundException | SQLException e){
              System.out.println("Error on Building Data");             
          }
      }
        
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////       
    @FXML
    private void PrintOut_Event(ActionEvent event) {
    }

    @FXML
    private void Lode_home_page(ActionEvent event) throws IOException {
        
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("WorkeStation.fxml"));     
        Scene WorkStation_One = new Scene(home_page_parent);
        
        Stage app = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        app.setScene(WorkStation_One);
        app.setFullScreen(true);
        app.show();        
        
        
        
        
    }
    
}
