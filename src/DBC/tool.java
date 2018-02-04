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
public class tool {
     private int tool_id;
    private String name;
    private String path;
    private int size;

    public void setId(int i){this.tool_id=i;}
    public void setName(String i){this.name=i;}
    public void setPath(String i){this.path=i;}
    public void setsize(int i){this.size=i;}
    public int getId(){return this.tool_id;}
    public String getName(){return this.name;}
    public String getPath(){return this.path;}
    public int getsize(){return this.size;}
}
