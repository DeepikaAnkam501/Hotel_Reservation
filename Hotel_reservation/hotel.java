package Hotel_reservation;
import java.sql.*;
import java.util.*;
public class hotel {

	public static void main(String[] args)throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(Exception e) {
			System.out.println(e);
		}
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hotel_db","root","Deepika@501");
       while(true) {
    	   System.out.println("HOTEL RESERVATION SYSTEM");
    	   Scanner sc=new Scanner(System.in);
    	   System.out.println("\n 1.NEW RESERVATION \n 2.CHECK RESERVATIONS \n 3.GET RESERVATION \n 4.UPDATE RESEVATION \n 5.DELETE RESERVATION \n 6.EXIT");
    	   int choice =sc.nextInt();
    	   switch(choice) {
    	   case 1: newreservation(con,sc);
    	   break;
    	   case 2: checkreservation(con);
    	   break;
    	   case 3: getreservation(con,sc);
    	   break;
    	   case 4: updatereservation(con,sc);
    	   break;
    	   case 5:deletereservation(con,sc);
    	   break;
    	   case 6:exit();
    	   return;
    	   
    	   default:System.out.println("Invalid choice enter correct choice");
    	   }
       }
      
	}
	 public static void newreservation(Connection con,Scanner sc) throws SQLException {
  	   System.out.println("enter guest name:");
  	   String name=sc.next();
  	   sc.nextLine();
  	   System.out.println("enter room number:");
  	   int room_no=sc.nextInt();
  	   sc.nextLine();
  	   System.out.println("enter contact number:");
  	   String contact=sc.next();
  	   String query="insert into reservation(name,room_no,contact) values('"+name+"',"+room_no+",'"+contact+"')";
  	  
		Statement st=con.createStatement();
		int count=st.executeUpdate(query);
		if(count>0) {
			System.out.println("room reserved successfully");
		}else {
			System.out.println("reservation failed");
		}
	
		
	
  	   
     }
	 public static void checkreservation(Connection con) throws SQLException {
		 Statement st=con.createStatement();
		 String query="select * from reservation";
		 ResultSet rs=st.executeQuery(query);
		 while(rs.next()) {
			 System.out.println("id: "+rs.getInt("id")+"name: "+rs.getString("name")+"room_no: "+rs.getInt("room_no")+"contact: "+rs.getString("contact")+"date: "+rs.getTimestamp("date"));
		 }
	 }
     public static void getreservation(Connection con,Scanner sc) throws SQLException {
    	 
    	 Statement st=con.createStatement();
    	 
    	 System.out.println("enter the name:");
    	 String name=sc.next();
    	 
    	 
    	 String query="select name,room_no from reservation where name='"+name+"'";
    	 ResultSet rs=st.executeQuery(query);
    	while(rs.next()) {
    		 System.out.println("name: "+rs.getString("name")+"   room_no: "+rs.getInt("room_no"));
    	}
     }
     public static void  updatereservation(Connection con,Scanner sc) throws SQLException {
    	 Statement st=con.createStatement();
    	 System.out.println("enter id to update:");
    	 int id=sc.nextInt();
    	 sc.nextLine();
    	 System.out.println("enter name to update:");
    	 String name=sc.next();
    	 sc.nextLine();
    	 System.out.println("enter room number to update: ");
    	 int room_no=sc.nextInt();
    	 sc.nextLine();
    	 System.out.println("enter the contact to update");
    	 String contact=sc.next();
    	 String query="update reservation set id="+id+",name='"+name+"',room_no="+room_no+",contact='"+contact+"'";
    	 int count=st.executeUpdate(query);
    	 if(count>0) {
    		 System.out.println("data updated successfully");	 
    	 }else {
    		 System.out.println("data updation failed");
    	 }
     }
     public static void deletereservation(Connection con,Scanner sc) throws SQLException {
    	 Statement st=con.createStatement();
    	 System.out.println("enter id to delete:");
    	 int id=sc.nextInt();
    	 String query="delete from reservation where id="+id+"";
    	 int count=st.executeUpdate(query);
    	 if(count>0) {
    		 System.out.println("data deleted success fully");
    	 }else {
    		 System.out.println("data deletion failed");
    	 }
    	
     }
     public static void exit() {
    	 System.out.println("thank you visit again !!!!!");
     }
}
