/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduation_p1;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Hapsha
 */
public class Materials_PaneController implements Initializable {

    @FXML
    private AnchorPane Mater_Pan;
    @FXML
    private Button btn_back;
    @FXML
    private Button btn_H;
    @FXML
    private Button btn_Be;
    @FXML
    private Button btn_Sc;
    @FXML
    private Button btn_AI;
    @FXML
    private Button btn_B;
    @FXML
    private Button btn_HCL;
    @FXML
    private Button btn_NaOH;
    @FXML
    private TextField text_Equation;
    @FXML
    private TextField text_Equation_Result;
    @FXML
    private Button btn_PLUS;
    @FXML
    private TextField EquationName;
    @FXML
    private CheckBox REqu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Work_Station_One_Call(ActionEvent event) throws IOException, SQLException {
       if(REqu.isSelected()==true){
        addM(EquationName.getText(), text_Equation.getText(), text_Equation_Result.getText(), 1);
                new JFXPanel();
        notifier("Done!", "Add Equation Is working Right.");
       }else{
       addM(EquationName.getText(), text_Equation.getText(), text_Equation_Result.getText(), 0);
       new JFXPanel();
        notifier("Done!", "Add Equation Is working Right.");
       }
        
    }
   
    String All_Equation;
    
    @FXML
    private void add_H(ActionEvent event) {
       All_Equation = text_Equation.getText();
       text_Equation.setText(All_Equation+"H");
    }

    @FXML
    private void add_Be(ActionEvent event) {
       All_Equation = text_Equation.getText();
       text_Equation.setText(All_Equation+"Be");
    }

    @FXML
    private void add_Sc(ActionEvent event) {
       All_Equation = text_Equation.getText();
       text_Equation.setText(All_Equation+"Sc");
    }

    @FXML
    private void Add_AI(ActionEvent event) {
       All_Equation = text_Equation.getText();
       text_Equation.setText(All_Equation+"AI");      
    }

    @FXML
    private void add_B(ActionEvent event) {
       All_Equation = text_Equation.getText();
       text_Equation.setText(All_Equation+"B");
    }

    @FXML
    private void Add_HCL(ActionEvent event) {
       All_Equation = text_Equation.getText();
       text_Equation.setText(All_Equation+"HCL");        
    }

    @FXML
    private void Add_NaOH(ActionEvent event) {
       All_Equation = text_Equation.getText();
       text_Equation.setText(All_Equation+"NaOH");
    }

    @FXML
    private void METHOD_PLUS(ActionEvent event) {
       All_Equation = text_Equation.getText();
       text_Equation.setText(All_Equation+"+");       
    }
    ///////////////////////////////////////////////////////////
    private Connection conn;

	void connectToDB() throws ClassNotFoundException, SQLException
	{
		// Instantiate the driver for MySQL
     try {
       //  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
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
        ////////////////////////////////////////////////////////////////////////////
        public void addM(String name ,String input,String result,int Reveserse_Equation) throws SQLException
	{

	// connect to data base
	try {
		connectToDB();
	} catch (ClassNotFoundException e1) {

		e1.printStackTrace();
	}

	// add a user to the DB
	Statement s = null;

	try {
		s = conn.createStatement();
                //INSERT INTO `equation` (`equation_id`, `name`, `input`, `result`, `Reverse_Equation`) VALUES (NULL, 'jhj', 'bUJK', 'nkh', '0');
		String query = "INSERT INTO 'equation' ('name', 'input', 'result','Reveserse_Equation')"+
		"VALUES ( '"+name+"', '"+input+"', '"+result+"', '"+Reveserse_Equation+"'";
		  s.execute(query);

	} catch (SQLException e) {

		e.printStackTrace();
	       }
	finally {
		 // close both the SQL statement and the DB connection
	      if (s != null) {s.close();}
	      if (conn != null){conn.close();}
	     }
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
