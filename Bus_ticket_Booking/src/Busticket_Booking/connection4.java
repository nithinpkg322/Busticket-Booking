package Busticket_Booking;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class connection4 {

	private static Connection NULL;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection  c=null;
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ticket_booking","root","");
		if(c!=null)
		{
		return (Connection) c;
		}
		else
		{
		return null;
		}

	}

}
