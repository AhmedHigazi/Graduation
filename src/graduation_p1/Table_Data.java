/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduation_p1;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Hapsha
 */
public class Table_Data {
    
    private SimpleStringProperty State;
    private SimpleStringProperty Quantity;
    private SimpleStringProperty Color;
    
    public Table_Data(String State,String Quantity,String Color){
        
        this.State = new SimpleStringProperty(State);
        this.Quantity = new SimpleStringProperty(Quantity);
        this.Color = new SimpleStringProperty(Color);
    
    }
    
    //  ------------------------------------ Setter Class --------------------------------------- 
    public void setState(String State){       
    this.State.set(State);
    }
    public void setQuantity(String Quantity){
    this.Quantity.set(Quantity);
    }
    public void setColor(String Color){
    this.Color.set(Color);
    }
   //  ------------------------------------ Getter Class --------------------------------------- 
    
    public String getState(){
    
       return State.get();
    }
    public String getQuantity(){
    
       return Quantity.get();
    }    
    public String getColor(){
    
       return Color.get();
    }
    
    
    
    
}
