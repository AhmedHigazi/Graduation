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
public class toolDbc {
      //Database connection
	private Connection conn;

	public void connectToDB() throws ClassNotFoundException, SQLException
	{
		// Instantiate the driver for MySQL
     try {
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
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
	public tool retrievetool(String name) throws SQLException
	{
		
		tool book=new tool();
		// connect to data base
		try {
			connectToDB();
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		// retrieve users based on the last name
		Statement s = null;
	try {
              
	     String query = "select * from tool where name like '%"+name+"%'";
	     s = conn.createStatement();
	     ResultSet rs= s.executeQuery(query);
	     while (rs.next()) {
	    	
	    	book.setId(rs.getInt("tool_id"));
	    	book.setName(rs.getString("name"));
	    	book.setPath(rs.getString("path"));
                book.setsize(rs.getInt("size"));
	     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			// close both the SQL statement and the DB connection
		      if (s != null) {s.close();}
		      if (conn != null){conn.close();}
		     }
		return book;
	}
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void addProject(String name ,String path,int size) throws SQLException
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
		String query = "INSERT INTO tool ( name, path,size)"+
		"VALUES ('"+name+"', '"+path+"', '"+size+"')";
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
}
