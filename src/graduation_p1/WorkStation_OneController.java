/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduation_p1;

import DBC.matraleDbc;
import eu.mihosoft.vrl.ext.com.bric.qt.JPEGMovieAnimation;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.security.auth.callback.Callback;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Hapsha
 */
public class WorkStation_OneController implements Callback, Initializable {

    //@FXML
   // private AnchorPane AP;
    @FXML
    private ImageView empty_flask;
    @FXML
    private Label MeasuringCylinde;
    @FXML
    private ImageView burette1;
    @FXML
    private TableView Info_table;
    @FXML
    private Button btn_Sarch_materials;
    private ProgressIndicator Prograss_Indecator;
    @FXML
    private ImageView Liquid_Bottel;
    @FXML
    private ImageView Measuring_Cylinde;
    @FXML
    private ImageView burette;
    @FXML
    private ImageView beaker;
    @FXML
    private ImageView IMV_ONE;
    @FXML
    private ImageView IMV_TWO;
    @FXML
    private ImageView IMV_THREE;
    @FXML
    private ImageView IMV_FOR;
    @FXML
    private ImageView IMV_FIVE;
    @FXML
    private ImageView IMV_SIX;
    @FXML
    private ImageView IMV_SEVEN;
    @FXML
    private ImageView IMV_EIGHT;
    @FXML
    private ImageView IMV_NINE;
    @FXML
    private ImageView IMV_TEN;
    @FXML
    private ImageView IMV_ELIVEN;
    @FXML
    private ImageView IMV_TWILLIVE;
    @FXML
    private Button record;
    @FXML
    private Button stop;
    @FXML
    private AnchorPane viedoPANE2;
    @FXML
    private AnchorPane AP;
    @FXML
    private AnchorPane videoPan;
    @FXML
    private Button addNote;
    @FXML
    private Label Status_bar;
    private Stage stage;
    public static ImageView ahmedimage;
    @FXML
    private ImageView imageadd;
    @FXML
    private Label imageLabel;
    @FXML
    private TextField imageTextF;
    @FXML
    private TextField search_Mater;
    @FXML
    private MenuBar MenuBar;
    @FXML
    private TextField Material_Name;
    @FXML
    private TextField text_Fir_mat;


    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }//------------------------------------------ End of The initialize ------------------------------------------     

    @FXML
    private void Show_Materials_Pane(ActionEvent event) throws IOException {
      
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Materials_Pane.fxml"));     
        Scene Materials_Pane = new Scene(home_page_parent);    
        Stage app = new Stage();     
        app.setScene(Materials_Pane);        
        app.show();        
    }
    
    //===================================== Tools Drag Detection Methods   ===========================================
    
    @FXML
    private void Flask_OnDragDetected(MouseEvent event) {        
        Dragboard DB = empty_flask.startDragAndDrop(TransferMode.COPY);
        ClipboardContent cb = new ClipboardContent();
        Image SI = empty_flask.getImage();
        cb.putImage(SI);
        DB.setContent(cb);
        event.consume();         

    } 
    @FXML
    private void Liquid_BottleOnDragDetected(MouseEvent event) {
        Dragboard DB = Liquid_Bottel.startDragAndDrop(TransferMode.COPY);
        ClipboardContent cb = new ClipboardContent();
        Image SI = Liquid_Bottel.getImage();
        cb.putImage(SI);
        DB.setContent(cb);
        event.consume();          
    }
    @FXML
    private void Measuring_CylindeOnDragDetection(MouseEvent event) {
        Dragboard DB = Measuring_Cylinde.startDragAndDrop(TransferMode.COPY);
        ClipboardContent cb = new ClipboardContent();
        Image SI = Measuring_Cylinde.getImage();
        cb.putImage(SI);
        DB.setContent(cb);
        event.consume();         
    }
    @FXML
    private void buretteOnDragDetection(MouseEvent event) {
        Dragboard DB = burette.startDragAndDrop(TransferMode.COPY);
        ClipboardContent cb = new ClipboardContent();
        Image SI = burette.getImage();
        cb.putImage(SI);
        DB.setContent(cb);
        event.consume();        
 }
    @FXML
    private void beakerOnDragDetection(MouseEvent event) {
        Dragboard DB = beaker.startDragAndDrop(TransferMode.COPY);
        ClipboardContent cb = new ClipboardContent();
        Image SI = beaker.getImage();
        cb.putImage(SI);
        DB.setContent(cb);
        event.consume();         
    }
   //-------------------------------------------------------------------------------------------------------------
    

//================================================================================ Image_View Dropped ===============
    @FXML
    private void IMV_ONE_Dropped(DragEvent event) {
        Image im = event.getDragboard().getImage();
        IMV_ONE.setImage(im);        
    }
    @FXML
    private void IMV_TWO_Dropped(DragEvent event) {
        Image im = event.getDragboard().getImage();
        IMV_TWO.setImage(im);
    }
    @FXML
    private void IMV_THREE_Dropped(DragEvent event) {
        Image im = event.getDragboard().getImage();
        IMV_THREE.setImage(im);    
    } 
    @FXML
    private void IMV_FOR_Dropped(DragEvent event) {
        Image im = event.getDragboard().getImage();
        IMV_FOR.setImage(im);        
    }
    @FXML
    private void IMV_FIVE_Dropped(DragEvent event) {
        Image im = event.getDragboard().getImage();
        IMV_FIVE.setImage(im);        
    }
    @FXML
    private void IMV_SIX_Dropped(DragEvent event) {
        Image im = event.getDragboard().getImage();
        IMV_SIX.setImage(im);        
        
    }
    @FXML
    private void IMV_SEVEN_Dropped(DragEvent event) {
        Image im = event.getDragboard().getImage();
        IMV_SEVEN.setImage(im);        
    } 
    @FXML
    private void IMV_EIGHT_Dropped(DragEvent event) {
        Image im = event.getDragboard().getImage();
        IMV_EIGHT.setImage(im);        
    }
    @FXML
    private void IMV_NINE_Dropped(DragEvent event) {
        Image im = event.getDragboard().getImage();
        IMV_NINE.setImage(im);        
    }    
    @FXML
    private void IMV_TEN_Dropped(DragEvent event) {
        Image im = event.getDragboard().getImage();
        IMV_TEN.setImage(im);        
    }    
    @FXML
    private void IMV_ELIVEN_Dropped(DragEvent event) {
        Image im = event.getDragboard().getImage();
        IMV_ELIVEN.setImage(im);        
    } 
    @FXML
    private void IMV_TWILLIVE_Dropped(DragEvent event) {
        Image im = event.getDragboard().getImage();
        IMV_TWILLIVE.setImage(im);        
    }
    
//================================================================================ Image_View Over ==================
    @FXML
    private void IMV_ONE_Over(DragEvent event) {
        if(event.getDragboard().hasImage()){
        event.acceptTransferModes(TransferMode.ANY);
        }        
    }   
    @FXML
    private void IMV_TWO_Over(DragEvent event) {
        if(event.getDragboard().hasImage()){
        event.acceptTransferModes(TransferMode.ANY);
        }        
    }
    @FXML
    private void IMV_THREE_Over(DragEvent event) {
        if(event.getDragboard().hasImage()){
        event.acceptTransferModes(TransferMode.ANY);
        }        
    } 
    @FXML
    private void IMV_FOR_Over(DragEvent event) {
        if(event.getDragboard().hasImage()){
        event.acceptTransferModes(TransferMode.ANY);
        }        
    }    
    @FXML
    private void IMV_FIVE_Over(DragEvent event) {
        if(event.getDragboard().hasImage()){
        event.acceptTransferModes(TransferMode.ANY);
        }        
    }
    @FXML
    private void IMV_SIX_Over(DragEvent event) {
        if(event.getDragboard().hasImage()){
        event.acceptTransferModes(TransferMode.ANY);
        }        
    }
    @FXML
    private void IMV_SEVEN_Over(DragEvent event) {
        if(event.getDragboard().hasImage()){
        event.acceptTransferModes(TransferMode.ANY);
        }        
    }    
    @FXML
    private void IMV_EIGHT_Over(DragEvent event) {
        if(event.getDragboard().hasImage()){
        event.acceptTransferModes(TransferMode.ANY);
        }        
    }
    @FXML
    private void IMV_NINE_Over(DragEvent event) {
        if(event.getDragboard().hasImage()){
        event.acceptTransferModes(TransferMode.ANY);
        }        
    }
    @FXML
    private void IMV_TEN_Over(DragEvent event) {
        if(event.getDragboard().hasImage()){
        event.acceptTransferModes(TransferMode.ANY);
        }        
    }
    @FXML
    private void IMV_ELIVEN_Over(DragEvent event) {
        if(event.getDragboard().hasImage()){
        event.acceptTransferModes(TransferMode.ANY);
        }        
    }
    @FXML
    private void IMV_TWILLIVE_Over(DragEvent event) {
        if(event.getDragboard().hasImage()){
        event.acceptTransferModes(TransferMode.ANY);
        }        
    }
 
//================================================================================ Image_View Dragged ===============
    @FXML
    private void IMV_ONE_Dragged(MouseEvent event) {
        IMV_ONE.setX(event.getX());
        IMV_ONE.setY(event.getY());
    } 
    @FXML
    private void IMV_TWO_Dragged(MouseEvent event) {
        IMV_TWO.setX(event.getX());
        IMV_TWO.setY(event.getY());        
    }
    @FXML
    private void IMV_THREE_Dragged(MouseEvent event) {
        IMV_THREE.setX(event.getX());
        IMV_THREE.setY(event.getY());        
    }    
    @FXML
    private void IMV_FOR_Dragged(MouseEvent event) {
        IMV_FOR.setX(event.getX());
        IMV_FOR.setY(event.getY());        
    }  
    @FXML
    private void IMV_FIVE_Dragged(MouseEvent event) {
        IMV_FIVE.setX(event.getX());
        IMV_FIVE.setY(event.getY());
    }
    @FXML
    private void IMV_SIX_Dragged(MouseEvent event) {
        IMV_SIX.setX(event.getX());
        IMV_SIX.setY(event.getY());        
    }
    @FXML
    private void IMV_SEVEN_Dragged(MouseEvent event) {
        IMV_SEVEN.setX(event.getX());
        IMV_SEVEN.setY(event.getY());          
    }
    @FXML
    private void IMV_EIGHT_Dragged(MouseEvent event) {
        IMV_EIGHT.setX(event.getX());
        IMV_EIGHT.setY(event.getY());          
    }
    @FXML
    private void IMV_NINE_Dragged(MouseEvent event) {
        IMV_NINE.setX(event.getX());
        IMV_NINE.setY(event.getY());           
    }
    @FXML
    private void IMV_TEN_Dragged(MouseEvent event) {
        IMV_TEN.setX(event.getX());
        IMV_TEN.setY(event.getY());         
    }       
    @FXML
    private void IMV_ELIVEN_Dragged(MouseEvent event) {
        IMV_ELIVEN.setX(event.getX());
        IMV_ELIVEN.setY(event.getY());        
    }
    @FXML
    private void IMV_TWILLIVE_Dragged(MouseEvent event) {
        IMV_TWILLIVE.setX(event.getX());
        IMV_TWILLIVE.setY(event.getY());        
    }
//================================= CONTEXT MENU  Methods =====================================================
    @FXML
    private void ContextMenuReq(ContextMenuEvent event) {
    
        ContextMenu contextMenu = new ContextMenu();

     //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ITEM_ONE

        MenuItem ITEM_ONE = new MenuItem("set mteral");
        ITEM_ONE.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {     
  

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        
           int Vale = Integer.parseInt(text_Fir_mat.getText());         
            FileInputStream INPUT = null;
              /* try {  
                   
   if((Vale > 0)&&(Vale < 45) ){
   INPUT = new FileInputStream("C:\\Users\\Ahmed Higazi\\Desktop\\New folder\\Graduation_p1\\src\\graduation_p1\\Colored_TOOLS\\LESS_FLASK.png");
   Image IMG = new Image(INPUT);
   IMV_ONE.setImage(IMG);
    }
   else
   if((Vale > 46 )&&(Vale < 70)){
   INPUT = new FileInputStream("C:\\Users\\Ahmed Higazi\\Desktop\\New folder\\Graduation_p1\\src\\graduation_p1\\Colored_TOOLS\\HELF_FLASK.png");
   Image IMG = new Image(INPUT);
   IMV_ONE.setImage(IMG);                                      
   }else
   if((Vale >70 )&&(Vale < 100)){
   INPUT = new FileInputStream("C:\\Users\\Ahmed Higazi\\Desktop\\New folder\\Graduation_p1\\src\\graduation_p1\\Colored_TOOLS\\Full_Flask.png");
   Image IMG = new Image(INPUT);
   IMV_ONE.setImage(IMG);                           
    }   
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
               }   */             
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

                try {
                    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                    matraleDbc.updateM2(Material_Name.getText(),Integer.parseInt(text_Fir_mat.getText()));
                } catch (SQLException ex) {
                    Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
                }
        // new JFXPanel();
        notifier("Done!", "Add matrale Is working Right.");

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            }// ============================ handle Method End Close =======================================
        });//--------------------------- SetOnAction Methods End Close ---------------------------   
 //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>ITEM THERE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
         MenuItem ITEM_THREE = new MenuItem("Orentation");
        ITEM_THREE.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
             
            IMV_ONE.setRotate(80);
                
            }
        });
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ITEM FOR >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
         MenuItem ITEM_FOR = new MenuItem("Orentation Undo");
        ITEM_FOR.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
             
            IMV_ONE.setRotate(0);
                
            }
        });
// |||||||||||||||||||||||||||||||||||||||  Add MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
        contextMenu.getItems().addAll(ITEM_ONE,ITEM_THREE,ITEM_FOR);
// |||||||||||||||||||||||||||||||||||||||  END OF MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
 
        // When user right-click on Circle
        IMV_ONE.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
 
            @Override
            public void handle(ContextMenuEvent event) {
 
                contextMenu.show(IMV_ONE, event.getScreenX(), event.getScreenY());
            }
        });       
    }
   
     @FXML
    private void ContextMenuReq_TWO(ContextMenuEvent event) {
    
        ContextMenu contextMenu = new ContextMenu();

     //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ITEM_ONE

        MenuItem ITEM_ONE = new MenuItem("Pink Color");
        ITEM_ONE.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {     
  

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        
           int Vale = Integer.parseInt(text_Fir_mat.getText());         
            FileInputStream INPUT = null;
               try {  
                   
                   if((Vale > 0)&&(Vale < 45) ){
                   INPUT = new FileInputStream("C:\\Users\\scorpion\\Desktop\\PROJECT_SESONS\\Graduation_p1\\src\\graduation_p1\\Colored_TOOLS\\llong1.png");
                   Image IMG = new Image(INPUT);
                   IMV_TWO.setImage(IMG);
                    }
                   else
                   if((Vale > 46 )&&(Vale < 70)){
                   INPUT = new FileInputStream("C:\\Users\\scorpion\\Desktop\\PROJECT_SESONS\\Graduation_p1\\src\\graduation_p1\\Colored_TOOLS\\llong2.png");
                   Image IMG = new Image(INPUT);
                   IMV_TWO.setImage(IMG);                                      
                   }else
                   if((Vale >70 )&&(Vale < 100)){
                   INPUT = new FileInputStream("C:\\Users\\scorpion\\Desktop\\PROJECT_SESONS\\Graduation_p1\\src\\graduation_p1\\Colored_TOOLS\\llong1.png");
                   Image IMG = new Image(INPUT);
                   IMV_TWO.setImage(IMG);                           
                    }    
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
               }                



            }// ============================ handle Method End Close =======================================
        });//--------------------------- SetOnAction Methods End Close ---------------------------
 //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>ITEM THERE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
         MenuItem ITEM_THREE = new MenuItem("Orentation");
        ITEM_THREE.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
             
            IMV_TWO.setRotate(80);
                
            }
        });
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ITEM FOR >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
         MenuItem ITEM_FOR = new MenuItem("Orentation Undo");
        ITEM_FOR.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
             
            IMV_TWO.setRotate(0);
                
            }
        });
// |||||||||||||||||||||||||||||||||||||||  Add MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
        contextMenu.getItems().addAll(ITEM_ONE,ITEM_THREE,ITEM_FOR);
// |||||||||||||||||||||||||||||||||||||||  END OF MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
 
        // When user right-click on Circle
        IMV_TWO.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
 
            @Override
            public void handle(ContextMenuEvent event) {
 
                contextMenu.show(IMV_TWO, event.getScreenX(), event.getScreenY());
            }
        });     
            
    }  
    
    @FXML
    private void ContextMenuReq_Three(ContextMenuEvent event) {
        
        ContextMenu contextMenu = new ContextMenu();

     //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ITEM_ONE

        MenuItem ITEM_ONE = new MenuItem("Select Color");
        ITEM_ONE.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {     
  

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         FileInputStream INPUT = null;
                try {
                    Status_bar.setText("Color has been changed");
                    IMV_THREE.setPreserveRatio(true);
                    INPUT = new FileInputStream("C:\\Users\\Hapsha\\Documents\\NetBeansProjects\\Graduation_p1\\src\\graduation_p1\\Chemical_equipment_image\\empty_flask.png");
                    Image image = new Image(INPUT);                 
                    Lighting lighting = new Lighting();
                    lighting.setLight(new Light.Distant(100, 100, Color.RED));       
                    IMV_THREE.setEffect(lighting);                   
                  /*  
                    Lighting lighting = new Lighting();
                    lighting.setLight(new Light.Distant(80, 100, Color.RED));
                    IMV_ONE.setEffect(lighting); 
                    IMV_ONE.setClip(new ImageView(image));                    
                  */
         
                } //--------------------------- handle Acttion End Close !! ---------------------------
                catch (FileNotFoundException ex) {
                    Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        INPUT.close();
                    } catch (IOException ex) {
                        Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

            }// ============================ handle Method End Close =======================================
        });//--------------------------- SetOnAction Methods End Close ---------------------------
    //>>>>>>>>>>>>>>>>>>>> ITEM_TWO >>>    
       
        MenuItem ITEM_TWO = new MenuItem("Menu Item 2");
        ITEM_TWO.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
              
              Status_bar.setText("Method 2 implemented");    
                Lighting lighting = new Lighting();
                lighting.setLight(new Light.Distant(45, 45, Color.CADETBLUE));

              IMV_THREE.setEffect(lighting);

            }
        });    
 
// |||||||||||||||||||||||||||||||||||||||  Add MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
        contextMenu.getItems().addAll(ITEM_ONE,ITEM_TWO);
// |||||||||||||||||||||||||||||||||||||||  END OF MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
 
        // When user right-click on Circle
        IMV_THREE.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
 
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(IMV_THREE, event.getScreenX(), event.getScreenY());
            }
        });        
    }

    @FXML
    private void ContextMenuReq_FOR(ContextMenuEvent event) {
        ContextMenu contextMenu = new ContextMenu();

     //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ITEM_ONE

        MenuItem ITEM_ONE = new MenuItem("Select Color");
        ITEM_ONE.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {     
  
      
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
           /* FileInputStream INPUT = null;
                try {
                    Status_bar.setText("Color has been changed");
                    IMV_FOR.setPreserveRatio(true);
                    INPUT = new FileInputStream("C:\\Users\\Hapsha\\Documents\\NetBeansProjects\\Graduation_p1\\src\\graduation_p1\\Chemical_equipment_image\\empty_flask.png");
                    Image image1 = new Image(INPUT);                 
                    Lighting lighting = new Lighting();
                    lighting.setLight(new Light.Distant(100, 100, Color.RED));       
                    IMV_FOR.setEffect(lighting);                   
                  /*  
                    Lighting lighting = new Lighting();
                    lighting.setLight(new Light.Distant(80, 100, Color.RED));
                    IMV_ONE.setEffect(lighting); 
                    IMV_ONE.setClip(new ImageView(image));                    
                  */
         
               /* } //--------------------------- handle Acttion End Close !! ---------------------------
                catch (FileNotFoundException ex) {
                    Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        INPUT.close();
                    } catch (IOException ex) {
                        Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }*/
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

            }// ============================ handle Method End Close =======================================
        });//--------------------------- SetOnAction Methods End Close ---------------------------
    //>>>>>>>>>>>>>>>>>>>> ITEM_TWO >>>    
       
        MenuItem ITEM_TWO = new MenuItem("Menu Item 2");
        ITEM_TWO.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
              
              Status_bar.setText("Method 2 implemented");    
                Lighting lighting = new Lighting();
                lighting.setLight(new Light.Distant(45, 45, Color.CADETBLUE));

              IMV_FOR.setEffect(lighting);

            }
        });    
 
// |||||||||||||||||||||||||||||||||||||||  Add MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
        contextMenu.getItems().addAll(ITEM_ONE,ITEM_TWO);
// |||||||||||||||||||||||||||||||||||||||  END OF MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
 
        // When user right-click on Circle
        IMV_FOR.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
 
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(IMV_FOR, event.getScreenX(), event.getScreenY());
            }
        });         
    }
  
    @FXML
    private void ContextMenuReq_FIVE(ContextMenuEvent event) {
        ContextMenu contextMenu = new ContextMenu();

     //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ITEM_ONE

        MenuItem IMV_FIVE1 = new MenuItem("Select matrel");
        IMV_FIVE1.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {     
  

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                        
           int Vale = Integer.parseInt(text_Fir_mat.getText());         
            FileInputStream INPUT = null;
               try {  
                   
   if((Vale > 0)&&(Vale < 45) ){
   INPUT = new FileInputStream("C:\\Users\\Ahmed Higazi\\Desktop\\New folder\\Graduation_p1\\src\\graduation_p1\\Colored_TOOLS\\LESS_FLASK.png");
   Image IMG = new Image(INPUT);
   IMV_FIVE.setImage(IMG);
    }
   else
   if((Vale > 46 )&&(Vale < 70)){
   INPUT = new FileInputStream("C:\\Users\\Ahmed Higazi\\Desktop\\New folder\\Graduation_p1\\src\\graduation_p1\\Colored_TOOLS\\HELF_FLASK.png");
   Image IMG = new Image(INPUT);
   IMV_FIVE.setImage(IMG);                                      
   }else
   if((Vale >70 )&&(Vale < 100)){
   INPUT = new FileInputStream("C:\\Users\\Ahmed Higazi\\Desktop\\New folder\\Graduation_p1\\src\\graduation_p1\\Colored_TOOLS\\Full_Flask.png");
   Image IMG = new Image(INPUT);
   IMV_FIVE.setImage(IMG);                           
    }   
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
               }                
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

                try {
                    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                    matraleDbc.updateM2(Material_Name.getText(),Integer.parseInt(text_Fir_mat.getText()));
                } catch (SQLException ex) {
                    Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
                }
        // new JFXPanel();
        notifier("Done!", "Add matrale Is working Right.");

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            }// ============================ handle Method End Close =======================================
        });//--------------------------- SetOnAction Methods End Close ---------------------------   
 //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>ITEM THERE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
         MenuItem ITEM_THREE = new MenuItem("Orentation");
        ITEM_THREE.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
             
            IMV_FIVE.setRotate(80);
                
            }
        });
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ITEM FOR >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
         MenuItem ITEM_FOR = new MenuItem("Orentation Undo");
        ITEM_FOR.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
             
            IMV_FIVE.setRotate(0);
                
            }
        });
// |||||||||||||||||||||||||||||||||||||||  Add MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
        contextMenu.getItems().addAll(IMV_FIVE1,ITEM_THREE,ITEM_FOR);
// |||||||||||||||||||||||||||||||||||||||  END OF MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
 
        // When user right-click on Circle
        IMV_FIVE.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
 
            @Override
            public void handle(ContextMenuEvent event) {
 
                contextMenu.show(IMV_FIVE, event.getScreenX(), event.getScreenY());
            }
        }); 
    }
   
    @FXML
    private void ContextMenuReq_SIX(ContextMenuEvent event) {
       ContextMenu contextMenu = new ContextMenu();

     //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ITEM_ONE

        MenuItem ITEM_ONE = new MenuItem("Select Color");
        ITEM_ONE.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {     
  

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         FileInputStream INPUT = null;
                try {
                    Status_bar.setText("Color has been changed");
                    IMV_SIX.setPreserveRatio(true);
                    INPUT = new FileInputStream("C:\\Users\\Hapsha\\Documents\\NetBeansProjects\\Graduation_p1\\src\\graduation_p1\\Chemical_equipment_image\\empty_flask.png");
                    Image image = new Image(INPUT);                 
                    Lighting lighting = new Lighting();
                    lighting.setLight(new Light.Distant(100, 100, Color.RED));       
                    IMV_SIX.setEffect(lighting);                   
                  /*  
                    Lighting lighting = new Lighting();
                    lighting.setLight(new Light.Distant(80, 100, Color.RED));
                    IMV_ONE.setEffect(lighting); 
                    IMV_ONE.setClip(new ImageView(image));                    
                  */
         
                } //--------------------------- handle Acttion End Close !! ---------------------------
                catch (FileNotFoundException ex) {
                    Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        INPUT.close();
                    } catch (IOException ex) {
                        Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

            }// ============================ handle Method End Close =======================================
        });//--------------------------- SetOnAction Methods End Close ---------------------------
    //>>>>>>>>>>>>>>>>>>>> ITEM_TWO >>>    
       
        MenuItem ITEM_TWO = new MenuItem("Menu Item 2");
        ITEM_TWO.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
              
              Status_bar.setText("Method 2 implemented");    
                Lighting lighting = new Lighting();
                lighting.setLight(new Light.Distant(45, 45, Color.CADETBLUE));

              IMV_SIX.setEffect(lighting);

            }
        });    
 
// |||||||||||||||||||||||||||||||||||||||  Add MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
        contextMenu.getItems().addAll(ITEM_ONE,ITEM_TWO);
// |||||||||||||||||||||||||||||||||||||||  END OF MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
 
        // When user right-click on Circle
        IMV_SIX.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
 
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(IMV_SIX, event.getScreenX(), event.getScreenY());
            }
        });        
    }

    @FXML
    private void ContextMenuReq_SEVEN(ContextMenuEvent event) {
       ContextMenu contextMenu = new ContextMenu();

     //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ITEM_ONE

        MenuItem ITEM_ONE = new MenuItem("Select Color");
        ITEM_ONE.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {     
  

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         FileInputStream INPUT = null;
                try {
                    Status_bar.setText("Color has been changed");
                    IMV_SEVEN.setPreserveRatio(true);
                    INPUT = new FileInputStream("C:\\Users\\Hapsha\\Documents\\NetBeansProjects\\Graduation_p1\\src\\graduation_p1\\Chemical_equipment_image\\empty_flask.png");
                    Image image = new Image(INPUT);                 
                    Lighting lighting = new Lighting();
                    lighting.setLight(new Light.Distant(100, 100, Color.RED));       
                    IMV_SEVEN.setEffect(lighting);                   
                  /*  
                    Lighting lighting = new Lighting();
                    lighting.setLight(new Light.Distant(80, 100, Color.RED));
                    IMV_ONE.setEffect(lighting); 
                    IMV_ONE.setClip(new ImageView(image));                    
                  */
         
                } //--------------------------- handle Acttion End Close !! ---------------------------
                catch (FileNotFoundException ex) {
                    Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        INPUT.close();
                    } catch (IOException ex) {
                        Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

            }// ============================ handle Method End Close =======================================
        });//--------------------------- SetOnAction Methods End Close ---------------------------
    //>>>>>>>>>>>>>>>>>>>> ITEM_TWO >>>    
       
        MenuItem ITEM_TWO = new MenuItem("Menu Item 2");
        ITEM_TWO.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
              
              Status_bar.setText("Method 2 implemented");    
                Lighting lighting = new Lighting();
                lighting.setLight(new Light.Distant(45, 45, Color.CADETBLUE));

              IMV_SEVEN.setEffect(lighting);

            }
        });    
 
// |||||||||||||||||||||||||||||||||||||||  Add MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
        contextMenu.getItems().addAll(ITEM_ONE,ITEM_TWO);
// |||||||||||||||||||||||||||||||||||||||  END OF MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
 
        // When user right-click on Circle
        IMV_SEVEN.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
 
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(IMV_SEVEN, event.getScreenX(), event.getScreenY());
            }
        });        
        
        
        
    }

    @FXML
    private void ContextMenuReq_EIGHT(ContextMenuEvent event) {
        
        ContextMenu contextMenu = new ContextMenu();

     //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ITEM_ONE

        MenuItem ITEM_ONE = new MenuItem("Select Color");
        ITEM_ONE.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {     
  

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         FileInputStream INPUT = null;
                try {
                    Status_bar.setText("Color has been changed");
                    IMV_EIGHT.setPreserveRatio(true);
                    INPUT = new FileInputStream("C:\\Users\\Hapsha\\Documents\\NetBeansProjects\\Graduation_p1\\src\\graduation_p1\\Chemical_equipment_image\\empty_flask.png");
                    Image image = new Image(INPUT);                 
                    Lighting lighting = new Lighting();
                    lighting.setLight(new Light.Distant(100, 100, Color.RED));       
                    IMV_EIGHT.setEffect(lighting);                   
                  /*  
                    Lighting lighting = new Lighting();
                    lighting.setLight(new Light.Distant(80, 100, Color.RED));
                    IMV_ONE.setEffect(lighting); 
                    IMV_ONE.setClip(new ImageView(image));                    
                  */
         
                } //--------------------------- handle Acttion End Close !! ---------------------------
                catch (FileNotFoundException ex) {
                    Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        INPUT.close();
                    } catch (IOException ex) {
                        Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

            }// ============================ handle Method End Close =======================================
        });//--------------------------- SetOnAction Methods End Close ---------------------------
    //>>>>>>>>>>>>>>>>>>>> ITEM_TWO >>>    
       
        MenuItem ITEM_TWO = new MenuItem("Menu Item 2");
        ITEM_TWO.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
              
              Status_bar.setText("Method 2 implemented");    
                Lighting lighting = new Lighting();
                lighting.setLight(new Light.Distant(45, 45, Color.CADETBLUE));

              IMV_EIGHT.setEffect(lighting);

            }
        });    
 
// |||||||||||||||||||||||||||||||||||||||  Add MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
        contextMenu.getItems().addAll(ITEM_ONE,ITEM_TWO);
// |||||||||||||||||||||||||||||||||||||||  END OF MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
 
        // When user right-click on Circle
        IMV_EIGHT.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
 
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(IMV_EIGHT, event.getScreenX(), event.getScreenY());
            }
        });       
        
        
        
    }

    @FXML
    private void ContextMenuReq_NINE(ContextMenuEvent event) {
       ContextMenu contextMenu = new ContextMenu();

     //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ITEM_ONE

        MenuItem ITEM_ONE = new MenuItem("Select Color");
        ITEM_ONE.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {     
  

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         FileInputStream INPUT = null;
                try {
                    Status_bar.setText("Color has been changed");
                    IMV_NINE.setPreserveRatio(true);
                    INPUT = new FileInputStream("C:\\Users\\Hapsha\\Documents\\NetBeansProjects\\Graduation_p1\\src\\graduation_p1\\Chemical_equipment_image\\empty_flask.png");
                    Image image = new Image(INPUT);                 
                    Lighting lighting = new Lighting();
                    lighting.setLight(new Light.Distant(100, 100, Color.RED));       
                    IMV_NINE.setEffect(lighting);                   
                  /*  
                    Lighting lighting = new Lighting();
                    lighting.setLight(new Light.Distant(80, 100, Color.RED));
                    IMV_ONE.setEffect(lighting); 
                    IMV_ONE.setClip(new ImageView(image));                    
                  */
         
                } //--------------------------- handle Acttion End Close !! ---------------------------
                catch (FileNotFoundException ex) {
                    Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        INPUT.close();
                    } catch (IOException ex) {
                        Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

            }// ============================ handle Method End Close =======================================
        });//--------------------------- SetOnAction Methods End Close ---------------------------
    //>>>>>>>>>>>>>>>>>>>> ITEM_TWO >>>    
       
        MenuItem ITEM_TWO = new MenuItem("Menu Item 2");
        ITEM_TWO.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
              
              Status_bar.setText("Method 2 implemented");    
                Lighting lighting = new Lighting();
                lighting.setLight(new Light.Distant(45, 45, Color.CADETBLUE));

              IMV_NINE.setEffect(lighting);

            }
        });    
 
// |||||||||||||||||||||||||||||||||||||||  Add MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
        contextMenu.getItems().addAll(ITEM_ONE,ITEM_TWO);
// |||||||||||||||||||||||||||||||||||||||  END OF MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
 
        // When user right-click on Circle
        IMV_NINE.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
 
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(IMV_NINE, event.getScreenX(), event.getScreenY());
            }
        });      
        
    }

    @FXML
    private void ContextMenuReq_TEN(ContextMenuEvent event) {
        
       ContextMenu contextMenu = new ContextMenu();

     //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ITEM_ONE

        MenuItem ITEM_ONE = new MenuItem("Select Color");
        ITEM_ONE.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {     
  

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         FileInputStream INPUT = null;
                try {
                    Status_bar.setText("Color has been changed");
                    IMV_TEN.setPreserveRatio(true);
                    INPUT = new FileInputStream("C:\\Users\\Hapsha\\Documents\\NetBeansProjects\\Graduation_p1\\src\\graduation_p1\\Chemical_equipment_image\\empty_flask.png");
                    Image image = new Image(INPUT);                 
                    Lighting lighting = new Lighting();
                    lighting.setLight(new Light.Distant(100, 100, Color.RED));       
                    IMV_TEN.setEffect(lighting);                   
                  /*  
                    Lighting lighting = new Lighting();
                    lighting.setLight(new Light.Distant(80, 100, Color.RED));
                    IMV_ONE.setEffect(lighting); 
                    IMV_ONE.setClip(new ImageView(image));                    
                  */
         
                } //--------------------------- handle Acttion End Close !! ---------------------------
                catch (FileNotFoundException ex) {
                    Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        INPUT.close();
                    } catch (IOException ex) {
                        Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

            }// ============================ handle Method End Close =======================================
        });//--------------------------- SetOnAction Methods End Close ---------------------------
    //>>>>>>>>>>>>>>>>>>>> ITEM_TWO >>>    
       
        MenuItem ITEM_TWO = new MenuItem("Menu Item 2");
        ITEM_TWO.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
              
              Status_bar.setText("Method 2 implemented");    
                Lighting lighting = new Lighting();
                lighting.setLight(new Light.Distant(45, 45, Color.CADETBLUE));

              IMV_TEN.setEffect(lighting);

            }
        });    
 
// |||||||||||||||||||||||||||||||||||||||  Add MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
        contextMenu.getItems().addAll(ITEM_ONE,ITEM_TWO);
// |||||||||||||||||||||||||||||||||||||||  END OF MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
 
        // When user right-click on Circle
        IMV_TEN.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
 
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(IMV_TEN, event.getScreenX(), event.getScreenY());
            }
        });        
    }

    @FXML
    private void ContextMenuReq_ELIVEN(ContextMenuEvent event) {
        
       ContextMenu contextMenu = new ContextMenu();

     //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ITEM_ONE

        MenuItem ITEM_ONE = new MenuItem("Select Color");
        ITEM_ONE.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {     
  

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
         FileInputStream INPUT = null;
                try {
                    Status_bar.setText("Color has been changed");
                    IMV_ELIVEN.setPreserveRatio(true);
                    INPUT = new FileInputStream("C:\\Users\\Hapsha\\Documents\\NetBeansProjects\\Graduation_p1\\src\\graduation_p1\\Chemical_equipment_image\\empty_flask.png");
                    Image image = new Image(INPUT);                 
                    Lighting lighting = new Lighting();
                    lighting.setLight(new Light.Distant(100, 100, Color.RED));       
                    IMV_ELIVEN.setEffect(lighting);                   
                  /*  
                    Lighting lighting = new Lighting();
                    lighting.setLight(new Light.Distant(80, 100, Color.RED));
                    IMV_ONE.setEffect(lighting); 
                    IMV_ONE.setClip(new ImageView(image));                    
                  */
         
                } //--------------------------- handle Acttion End Close !! ---------------------------
                catch (FileNotFoundException ex) {
                    Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        INPUT.close();
                    } catch (IOException ex) {
                        Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

            }// ============================ handle Method End Close =======================================
        });//--------------------------- SetOnAction Methods End Close ---------------------------
    //>>>>>>>>>>>>>>>>>>>> ITEM_TWO >>>    
       
        MenuItem ITEM_TWO = new MenuItem("Menu Item 2");
        ITEM_TWO.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
              
              Status_bar.setText("Method 2 implemented");    
                Lighting lighting = new Lighting();
                lighting.setLight(new Light.Distant(45, 45, Color.CADETBLUE));

              IMV_ELIVEN.setEffect(lighting);

            }
        });    
 
// |||||||||||||||||||||||||||||||||||||||  Add MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
        contextMenu.getItems().addAll(ITEM_ONE,ITEM_TWO);
// |||||||||||||||||||||||||||||||||||||||  END OF MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
 
        // When user right-click on Circle
        IMV_ELIVEN.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
 
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(IMV_ELIVEN, event.getScreenX(), event.getScreenY());
            }
        });
        
    }

    @FXML
    private void ContextMenuReq_TWILLIVE(ContextMenuEvent event) {
        
       ContextMenu contextMenu = new ContextMenu();

     //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ITEM_ONE

        MenuItem ITEM_ONE = new MenuItem("Select Color");
        ITEM_ONE.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {     
  

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                    Status_bar.setText("Color has been changed");
// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                    IMV_TWILLIVE.setPreserveRatio(true);
                    Lighting lighting = new Lighting();
                    lighting.setLight(new Light.Distant(100, 100, Color.RED));
                    IMV_TWILLIVE.setEffect(lighting);
 /*
                    Lighting lighting = new Lighting();
                    lighting.setLight(new Light.Distant(80, 100, Color.RED));
                    IMV_ONE.setEffect(lighting);
                    IMV_ONE.setClip(new ImageView(image));
*/

            }// ============================ handle Method End Close =======================================
        });//--------------------------- SetOnAction Methods End Close ---------------------------
    //>>>>>>>>>>>>>>>>>>>> ITEM_TWO >>>    
       
        MenuItem ITEM_TWO = new MenuItem("Menu Item 2");
        ITEM_TWO.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
              
              Status_bar.setText("Method 2 implemented");    

                       Lighting lighting = new Lighting();
                       lighting.setLight(new Light.Distant(100, 100, Color.RED));
                       IMV_TWILLIVE.setEffect(lighting);                
            }
        });    
 
// |||||||||||||||||||||||||||||||||||||||  Add MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
        contextMenu.getItems().addAll(ITEM_ONE,ITEM_TWO);
// |||||||||||||||||||||||||||||||||||||||  END OF MenuItem to ContextMenu ||||||||||||||||||||||||||||||||||||||||||||||||||
 
        // When user right-click on Circle
        IMV_TWILLIVE.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
 
            @Override
            public void handle(ContextMenuEvent event) {
                contextMenu.show(IMV_TWILLIVE, event.getScreenX(), event.getScreenY());
            }
        });        
    }    
    
 
    
 //======================================Start Of VIDEO Part =================================================   

    
  long runtime = 0;
  JPEGMovieAnimation anim ;
   AnimationTimer timer;
    @FXML
    private void recordA(ActionEvent event) throws IOException, AWTException {
        
               FileChooser fileChooser = new FileChooser();
 
              //Set extension filter
              FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("video files (*.m4v)", "*.m4v");
              fileChooser.getExtensionFilters().add(extFilter);
             
              //Show save file dialog
              File file = fileChooser.showSaveDialog(stage);
        
         anim = VideoCreator.create(file); 
        record.setText("recording...");
        record.setDisable(true);
           
      
         timer = new AnimationTimer() {
            
            long prev = 0;
           
            
            WritableImage img = new WritableImage(
                    (int) viedoPANE2.getWidth(),
                    (int) viedoPANE2.getHeight());
            
            @Override
            public void handle(long now) {
                long dist;
                
                if (prev > 0) {
                    dist = now - prev;
                } else {
                    dist = 0;
                    prev = now;
                }
                
                if (dist > 0.1 * 1e9) {
                    prev = now;
                    runtime += dist;
                    
                    SnapshotParameters params = new SnapshotParameters();
                    params.setCamera(new PerspectiveCamera());
                    img = viedoPANE2.snapshot(params, img);
                    
                    VideoCreator.addFrame(anim, img, 0.1f);
                    
                  //  node.setTitle("Recording: remaining " + (int)(10-runtime*1e-9));
                }
                
          
            }
        };
        timer.start();
        
    }

    @FXML
    private void stopA(ActionEvent event) {
          try {
                        anim.close();
                    } catch (IOException ex) {
                        Logger.getLogger(WorkStation_OneController.class.getName()).
                                log(Level.SEVERE, null, ex);
                    }
                    timer.stop();
                    System.out.println(">> recording done at: " + runtime * 1e-9 + " sec");
                    record.setText("Record");
                    record.setDisable(false);
                    
                //    node.setTitle(originalTitle);
            
        
    }//====================================== STOP VIDEO RECORDING =================================================

    
//====================================== Add Note =============================================
    @FXML
    private void addNoteAction(ActionEvent event) throws IOException {
        
       
           Parent Page_Qnatity_Materal_Report = FXMLLoader.load(getClass().getResource("Note.fxml"));     
        Scene WorkStation_One = new Scene(Page_Qnatity_Materal_Report);
        Stage app=new Stage();
       
        app.setScene(WorkStation_One);
        
        app.show();  
        
        
    }
//===================================== End Note ==============================================

   
    @FXML
    private void add_image(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
 
              //Set extension filter
              FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("image files (*.png)", "*.png");
             fileChooser.getExtensionFilters().add(extFilter);
             
              //Show save file dialog
              File file = fileChooser.showOpenDialog(stage);
   
             FileInputStream input = null;
        try {
            input = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WorkStation_OneController.class.getName()).log(Level.SEVERE, null, ex);
        }
               
        Image image = new Image(input);
       imageadd.setImage(image);
      ///////////////////
        imageLabel.setText(imageTextF.getText());
    }

/////////////////////////////////////////////////////////////////////////////////////////////
//////=========================================== search ===============================================
    private ObservableList<ObservableList> data;
    public static Connection conn;
    @FXML
    private void SearchAction(ActionEvent event) {
        buildData(search_Mater.getText());
        
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
    /////////////
     public void buildData(String name){
          
          data = FXCollections.observableArrayList();
          Statement s = null;
          try{
             connectToDB();
             
             String query = "select * from matrale where name like '%"+name+"%'";
	     s = conn.createStatement();
	     ResultSet rs= s.executeQuery(query);

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                String x=rs.getMetaData().getColumnName(i+1);
                if( "name".equals(x)||"color".equals(x)||"state".equals(x)){
                final int j = i;                
                TableColumn col = new TableColumn(x);
                col.setCellValueFactory(new javafx.util.Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                Info_table.getColumns().addAll(col); 
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
            Info_table.setItems(data);
          }catch(ClassNotFoundException | SQLException e){
              System.out.println("Error on Building Data");             
          }
      }
//////=========================================== End search ===============================================  

    @FXML
    private void imageaddDetectedAction(MouseEvent event) {
                Dragboard DB = imageadd.startDragAndDrop(TransferMode.COPY);
        ClipboardContent cb = new ClipboardContent();
        Image SI = imageadd.getImage();
        cb.putImage(SI);
        DB.setContent(cb);
        event.consume();  
    }

    @FXML
    private void imageaddOverAction(DragEvent event) {
         if(event.getDragboard().hasImage()){
        event.acceptTransferModes(TransferMode.ANY);
        }  
    }

    @FXML
    private void imageaddDroppedAction(DragEvent event) {
         Image im = event.getDragboard().getImage();
        IMV_ONE.setImage(im);
    }
    
///////////////////////////// notfi ////////////////////////////////////////////////////////////////////////
    
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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    private void Menuw_New_Action(ActionEvent event) throws IOException {
        Parent Page_Qnatity_Materal_Report = FXMLLoader.load(getClass().getResource("WorkStation_One.fxml"));     
        Scene WorkStation_One = new Scene(Page_Qnatity_Materal_Report);
        Stage app=new Stage();
       
        app.setScene(WorkStation_One);
        
        app.show();  
    }
 
    @FXML
    private void Menuw_Close_Action(ActionEvent event) {
         System.exit(0);
    }

    @FXML
    private void AboutAction(ActionEvent event) throws IOException {
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("About.fxml"));     
        Scene WorkStation_One = new Scene(home_page_parent);
        
        Stage app = (Stage)((Node) event.getSource()).getScene().getWindow();
        
        app.setScene(WorkStation_One);
       // app.setFullScreen(true);
        app.show();        
    }


   
  

    
 
    
    
} //------------------------------------------ End of The Class ------------------------------------------------                                        