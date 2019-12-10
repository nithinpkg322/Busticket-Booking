package Busticket_Booking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin {

	public void adminlogin() throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		connection4 c4=new connection4();
		c4.getConnection();
		int op1;

		System.out.println("enter username");
		String user=s.next();
		   System.out.println("enter password");
		String pass=s.next();
		     
		       boolean cu = false;
		       String query = "SELECT * FROM admin WHERE username =?";
		           PreparedStatement    ps = (PreparedStatement) c4.getConnection().prepareStatement(query);
		           ps.setString(1,user);
		           
		           ResultSet   rs = ps.executeQuery();
		           
		           if(rs.next())
		           {
		               cu = true;
		           }
		       
		        if(cu==true) {
		        System.out.println("Successfully logged in");
		             Busdetails bus=new Busdetails();
		             bus.details();}
		        else
		        System.out.println("User name or password does't exist");
		        Busticket b=new Busticket();
		        b.choice();
		}

		}

