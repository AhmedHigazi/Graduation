/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBC;

/**
 *
 * @author Ahmed Higazi
 */
public class matrale {
      private int matrale_id;
    private String name;
    private String color;
    private String state;
    private int quantity;
    private int consuming_quantity;
    public void setId(int i){this.matrale_id=i;}
    public void setName(String i){this.name=i;}
    public void setcolor(String i){this.color=i;}
    public void setstate(String i){this.state=i;}
    public void setquantity(int i){this.quantity=i;}
    public void setconsuming_quantity(int i){this.consuming_quantity=i;}
    public int getId(){return this.matrale_id;}
    public String getName(){return this.name;}
    public String getcolor(){return this.color;}
    public String getstate(){return this.state;}
    public int getquantity(){return this.quantity;}
    public int getconsuming_quantity(){return this.consuming_quantity;}

}
