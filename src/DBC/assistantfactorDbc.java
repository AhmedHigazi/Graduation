/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ahmed Higazi
 */
public class assistantfactorDbc {
           //Database connection
	private Connection conn;

	public void connectToDB() throws ClassNotFoundException, SQLException
	{
		// Instantiate the driver for MySQL
     try {
         //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
         Class.forName("com.mysql.jdbc.Driver").newInstance();
     }
     catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
    }

// Create the connection to the db
    try {
       conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vlab","root","");
	}
    catch (SQLException e) {
    }

	}
	public effective retrievematrale(String name) throws SQLException
	{
		
		effective book=new effective();
		// connect to data base
		try {
			connectToDB();
		} catch (ClassNotFoundException e1) {
		}
		// retrieve users based on the last name
		Statement s = null;
	try {
              
	     String query = "select * from assistantfactor where name like '%"+name+"%'";
	     s = conn.createStatement();
	     ResultSet rs= s.executeQuery(query);
	     while (rs.next()) {
	    	
	    	book.setId(rs.getInt("assFa_id"));
	    	book.setName(rs.getString("name"));
	    
	     }
		} catch (SQLException e) {
                    // TODO Auto-generated catch block

		}
		finally {
			// close both the SQL statement and the DB connection
		      if (s != null) {s.close();}
		      if (conn != null){conn.close();}
		     }
		return book;
	}
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void addProject(String name,String AssistantFactor ) throws SQLException
	{

	// connect to data base
	try {
		connectToDB();
	} catch (ClassNotFoundException e1) {
	}

	try ( // add a user to the DB
                Statement s = conn.createStatement()) {
		String query = "INSERT INTO assistantfactor ( name , AssistantFactor)"+
		"VALUES ( '"+name+"','"+AssistantFactor+"')";
		  s.execute(query);

	} catch (SQLException e) {
	       }
	finally {
// close both the SQL statement and the DB connection
                	      if (conn != null){conn.close();}
	     }
	}
}
