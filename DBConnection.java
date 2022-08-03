
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author athar
 */
public class DBConnection {
    	private static Connection connection = null;
	private static String url="jdbc:mysql://localhost:3306/helpdesk";
	private static String username="root";
	private static String password="";
		
	public static Connection createConnection() throws ClassNotFoundException, SQLException {		
		//Class.forName("com.mysql.cj.jdbc.driver");
                Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection(url, username, password);
		return connection;
	}
	
	public static void closeConnection()
	{
		try
		{
			if(connection!=null && connection.isClosed()==false)
			{
				connection.close();
				connection=null;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void closePreparedStatement(Statement ps){
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}

}
