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
public class project {

    private int project_id;
    private String name;
    private String path;

    public void setId(int i){this.project_id=i;}
    public void setName(String i){this.name=i;}
    public void setPath(String i){this.path=i;}
    public int getId(){return this.project_id;}
    public String getName(){return this.name;}
    public String getPath(){return this.path;}

}

