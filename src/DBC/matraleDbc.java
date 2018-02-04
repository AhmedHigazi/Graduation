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
public class matraleDbc {
          //Database connection
	public static Connection conn;

	public static void connectToDB() throws ClassNotFoundException, SQLException
	{
		// Instantiate the driver for MySQL
     try {
         //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
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
	public static String retrievematrale(String name) throws SQLException
	{
		String x = null;
		//matrale book=new matrale();
		// connect to data base
		try {
			connectToDB();
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		// retrieve users based on the last name
		Statement s = null;
	try {
              
	     String query = "select * from matrale where name like '%"+name+"%'";
	     s = conn.createStatement();
	     ResultSet rs= s.executeQuery(query);
	     while (rs.next()) {
	    	
	    	
	    	x=rs.getString("name");
	    	
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
		return x;
	}
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void addProject(String name ,String color,String state,int quantity,int consuming_quantity) throws SQLException
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
		String query = "INSERT INTO matrale ( name, color,state,quantity,consuming_quantity)"+
		"VALUES ('"+name+"', '"+color+"', '"+state+"', '"+quantity+"', '"+consuming_quantity+"')";
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

    public static void updateM  (String name ,int quantity) throws SQLException
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
		String query = "UPDATE matrale SET quantity='"+quantity+"' where name like '%"+name+"%'";
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
    //////////////////////////////////////////////////////////////////////////////
     public static void updateM2  (String name ,int quantity) throws SQLException
	{
            int x2=retrieve_consuming_quantity(name);
            int x1 = retrievematrale1(name);
	// connect to data base
	try {
		connectToDB(); 
	} catch (ClassNotFoundException e1) {

		e1.printStackTrace();
	}
        
        Statement s = null;
///////////////////////////////////////////////////////////////////////////////////

            // consuming_quantity
////////////////////////////////////////////////////////////////////////////////////
            // add a user to the DB
	
int a=x1-quantity;
	try {
		s = conn.createStatement();
		String query = "UPDATE matrale SET quantity='"+a+"' where name like '%"+name+"%'";
		  s.execute(query);

	} catch (SQLException e) {

		e.printStackTrace();
	       }
        
   int a1=x2+quantity;
   try {
		s = conn.createStatement();
		String query = "UPDATE matrale SET consuming_quantity='"+a1+"' where name like '%"+name+"%'";
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
     ////////////////////////////////////////////////////////
      public static int  retrievematrale1(String name) throws SQLException
	{
		int x = 0 ;
		//matrale book=new matrale();
		// connect to data base
		try {
			connectToDB();
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		// retrieve users based on the last name
		Statement s = null;
	try {
              
	   String query = "select quantity from matrale where name like '%"+name+"%'";
	     s = conn.createStatement();
	     ResultSet rs= s.executeQuery(query);
	     while (rs.next()) {
	    	
	    	
	    	x=rs.getInt("quantity");
	    	
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
		return x;
	}
	     
     ////////////////////////////////////////////////////////
       public static int  retrieve_consuming_quantity(String name) throws SQLException
	{
		int x = 0 ;
		//matrale book=new matrale();
		// connect to data base
		try {
			connectToDB();
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}
		// retrieve users based on the last name
		Statement s = null;
	try {
              
	   String query = "select consuming_quantity from matrale where name like '%"+name+"%'";
	     s = conn.createStatement();
	     ResultSet rs= s.executeQuery(query);
	     while (rs.next()) {
	    	
	    	
	    	x=rs.getInt("consuming_quantity");
	    	
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
		return x;
	}
}
