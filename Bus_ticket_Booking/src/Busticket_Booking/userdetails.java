package Busticket_Booking;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class userdetails {
public void deatils() throws ClassNotFoundException, SQLException {
connection4 c4=new connection4();
c4.getConnection();

Scanner s=new Scanner(System.in);
System.out.println("Choose option\n1)View Bus Details\n2)Booking Ticket\n3)Book View\n4)Cancel\n5)Logout");
int op=s.nextInt();
switch(op)
{
case 1:
Statement st1=(Statement) c4.getConnection().createStatement();
ResultSet r=st1.executeQuery("Select * from addbus");
System.out.println("##################");
while(r.next())
{
System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getString(3)+" "+r.getString(4)+" "+r.getInt(5)+" "+r.getInt(6)+" "+r.getString(7)+" "+r.getInt(8));
}
userdetails user1=new userdetails();
            user1.deatils();
break;
case 2:

System.out.println("##################");
Statement st2=(Statement) c4.getConnection().createStatement();
ResultSet r1=st2.executeQuery("select * from addbus");
System.out.println("********************");
System.out.println("Enter the booking id");
int bid=s.nextInt();
System.out.println("Enter the bus id");
int id=s.nextInt();
System.out.println("Enter Start location");
String start=s.next();
System.out.println("Enter end location");
String end=s.next();
System.out.println("Enter the bus type");
String typ=s.next();
System.out.println("Enter the date");
String date=s.next();
System.out.println("Enter the time");
int time=s.nextInt();
System.out.println("Enter number of persons");
int n=s.nextInt();
int cost=0;
int seat=0;
int seats;

while(r1.next())
{
if(id==r1.getInt(1))
{
cost=r1.getInt(5)*n;
seat=r1.getInt(6);
}
}
int avail=0;
PreparedStatement st=(PreparedStatement) c4.getConnection().prepareStatement("insert into booking(booking_id,bud_id,start,end,bus_type,date,time,no_of_persons,cost)values(?,?,?,?,?,?,?,?,?)");
st.setInt(1, bid);
st.setInt(2, id);
st.setString(3,start);
st.setString(4, end);
st.setString(5,typ);
st.setString(6,date);
st.setInt(7, time);
st.setInt(8,n);
st.setInt(9, cost);
st.executeUpdate();
System.out.println("Booking Details inserted");
//cost=cost*n;
System.out.println(" Cost ="+cost);
System.out.println("Enter 1 to confirm booking");
int a1=s.nextInt();
if(a1==1)
{
System.out.println("Your booking is confirmed");
System.out.println("Thank you");
}
seats=seat-n;
PreparedStatement st3=(PreparedStatement) c4.getConnection().prepareStatement("update addbus set seat_no=? where bus_id=?");
st3.setInt(1,seats);
st3.setInt(2,id);
st3.executeUpdate();
userdetails user2=new userdetails();
            user2.deatils();
case 3:
Statement st7=(Statement) c4.getConnection().createStatement();
ResultSet r4=st7.executeQuery("select * from booking");
System.out.println("##################");
while(r4.next())
{
System.out.println(r4.getInt(1)+" "+r4.getInt(2)+" "+r4.getString(3)+" "+r4.getString(4)+" "+r4.getString(5)+" "+r4.getString(6)+" "+r4.getInt(7)+" "+r4.getInt(8)+" "+r4.getInt(9));
}
userdetails user3=new userdetails();
            user3.deatils();
break;
case 4:
System.out.println("Enter booking id");
int id1=s.nextInt();
System.out.println("Enter the time of cancellation");
int t=s.nextInt();
int refund=0;
Statement st4=(Statement) c4.getConnection().createStatement();
ResultSet r2=st4.executeQuery("select * from booking");
Statement st5=(Statement) c4.getConnection().createStatement();
ResultSet r3=st5.executeQuery("select * from addbus");
String can=" ";
System.out.println("Enter bus id");
int bi=s.nextInt();
int t1=0;
while(r3.next())
{
if(bi==r3.getInt(1))
{
t1=r3.getInt(7);
}
}
while(r2.next())
{
if(id1==r2.getInt(1))
{
if(t1-t>=2)
{
refund=r2.getInt(9)-(r2.getInt(8)*100);
System.out.println("Refund amount ->"+refund);
}
else
{
System.out.println("Time over.. No refund");
}
}
}
PreparedStatement st6=(PreparedStatement) c4.getConnection().prepareStatement("DELETE  from  booking where booking_id=?");
st6.setInt(1,id1);
st6.executeUpdate();
System.out.println("Successfully Cancelled");
userdetails user4=new userdetails();
            user4.deatils();
case 5:
System.out.println("User Exited Successfully");
Busticket bu=new Busticket();
bu.main(null);
}
}}

