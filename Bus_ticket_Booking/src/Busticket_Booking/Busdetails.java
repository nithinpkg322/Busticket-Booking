package Busticket_Booking;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Busdetails {
	
	
	
	
	public void details() throws ClassNotFoundException, SQLException {
		connection4 c4=new connection4();
		c4.getConnection();

		Scanner s=new Scanner(System.in);
		System.out.println("Choose option\n1)Add Bus details\n2)View\n3)Update\n4)Logout");
		int op=s.nextInt();
		switch(op)
		{
		case 1:
		System.out.println("Enter the bus id");
		int id=s.nextInt();
		System.out.println("Enter the bus type");
		String type=s.next();
		System.out.println("Enter the start location");
		String start=s.next();
		System.out.println("Enter the end location");
		String end=s.next();
		System.out.println("Enter the cost");
		int fare=s.nextInt();
		System.out.println("Enter number of seats");
		int seats=s.nextInt();
		System.out.println("Enter the date");
		String date=s.next();
		System.out.println("Enter Time");
		int time=s.nextInt();

		PreparedStatement st=(PreparedStatement) c4.getConnection().prepareStatement("insert into addbus(bus_id,bus_type,start,end,cost,seat_no,name,time)values(?,?,?,?,?,?,?,?)");
		st.setInt(1, id);
		st.setString(2, type);
		st.setString(3,start);
		st.setString(4, end);
		st.setInt(5,fare);
		st.setInt(6,seats);
		st.setString(7, date);
		st.setInt(8,time);
		st.executeUpdate();
		System.out.println("Successfully Inserted");
		Busdetails bus=new Busdetails();
		        bus.details();
		case 2:
		Statement st1=(Statement) c4.getConnection().createStatement();
		ResultSet r=st1.executeQuery("Select * from addbus");
		System.out.println("##################");
		while(r.next())
		{
		System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getString(3)+" "+r.getString(4)+" "+r.getInt(5)+" "+r.getInt(6)+" "+r.getInt(8));
		}
		Busdetails bus1=new Busdetails();
		       bus1.details();
		case 3:
		Statement st2=(Statement) c4.getConnection().createStatement();
		ResultSet r1=st2.executeQuery("Select * from addbus");
		while(r1.next())
		{
		System.out.println(r1.getInt(1)+" "+r1.getString(2));
		}
		Statement st3=(Statement) c4.getConnection().createStatement();
		ResultSet r2=st3.executeQuery("select * from addbus");


		String upfrom=null,upto=null,date1=null;
		int price=0;
		System.out.println("Enter the id do you want update");
		int a=s.nextInt();

		System.out.println("Enter the start location");
		String from=s.next();
		System.out.println("Enter the destination");
		String dest=s.next();
		System.out.println("Enter the cost");
		int cost=s.nextInt();
		System.out.println("Enter the date");
		String da=s.next();
		while(r2.next())
		{
		if(a==r2.getInt(1))
		{
		upfrom=r2.getString(3);
		upto=r2.getString(4);
		cost=r2.getInt(5);
		date1=r2.getString(7);
		}

		}
		PreparedStatement ps=(PreparedStatement) c4.getConnection().prepareStatement("update addbus set start=?,end=?,cost=?,name=? where bus_id=?");
		ps.setString(1,from);
		ps.setString(2, dest);
		ps.setInt(3,cost);
		ps.setString(4, da);
		ps.setInt(5, a);
		ps.executeUpdate();
		System.out.println("Updated Successfully");
		Busdetails bus2=new Busdetails();
		       bus2.details();
		case 4:
		System.out.println("Admin Exited Successfully");
		Busticket bu=new Busticket();
		bu.main(null);


		}


		}

		}
