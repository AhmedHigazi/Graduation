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
public class equation {
     private int equation_id;
    private String name;
    private String input;
    private String result;
   private boolean Reveerse_Equation ;

    public void setId(int i){this.equation_id=i;}
    public void setName(String i){this.name=i;}
    public void setinput(String i){this.input=i;}
    public void setresult(String i){this.result=i;}
    public void setReveerse_Equation(boolean i){this.Reveerse_Equation=i;}
    public int getId(){return this.equation_id;}
    public String getName(){return this.name;}
    public String getinput(){return this.input;}
    public String getresult(){return this.result;}
    public boolean getReveerse_Equation(){return this.Reveerse_Equation;}

}
