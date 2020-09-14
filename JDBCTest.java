package dbmsA2;

import java.util.Scanner;
import java.sql.*;

class JDBCTest{

	public void Display(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A2?characterEncoding=latin1","root","Kshitija@19");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from customer");
			System.out.println("----------------------------");
			System.out.println("Cust_ID |  Name  |   Company");
			while(rs.next())	{
			System.out.println("----------------------------");
			System.out.println(" "+rs.getInt(1)+"	|"+rs.getString(2)+"	 | "+rs.getString(3));
			}
			System.out.println("");
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void Insert(int i1,String nm,String i2){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A2?characterEncoding=latin1","root","Kshitija@19");
			String query = "insert into customer (cust_id,name,company)" + " values("+i1+",'"+nm+"','"+i2+"')";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.execute();
			//Statement stmt=con.createStatement();
			//stmt.executeUpdate("insert into Student_Data values(21,'Apurva',4,'Pune');");
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void UpdatenameCompany(){
		Scanner sca = new Scanner(System.in);
		String sql = "update customer set company=? where name = ?";
		String company, name;
		System.out.println("Enter the Name where you wnat to change company name");
		name =sca.nextLine();
		System.out.println("Enter the updated company name");
		company =sca.nextLine();
	    try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A2?characterEncoding=latin1","root","Kshitija@19");
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, company);
            pstmt.setString(2, name);
			pstmt.execute();
			//Statement stmt=con.createStatement();
			//stmt.executeUpdate("insert into Student_Data values(21,'Apurva',4,'Pune');");
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void UpdateCompanyname(){
		Scanner sca = new Scanner(System.in);
		String sql = "update customer set name=? where company = ?";
		String company, name;
		System.out.println("Enter the company name where you want to change name");
		company =sca.nextLine();
		System.out.println("Enter the updated customer name");
		name =sca.nextLine();
	    try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A2?characterEncoding=latin1","root","Kshitija@19");
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
            pstmt.setString(2, company);
			pstmt.execute();
			//Statement stmt=con.createStatement();
			//stmt.executeUpdate("insert into Student_Data values(21,'Apurva',4,'Pune');");
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void UpdateIDCompany(){
		Scanner scan = new Scanner(System.in);
		String sql = "update customer set company=? where  cust_id= ?";
		String company; 
		int id;
		System.out.println("Enter the Customer ID where you wnat to change company name");
		id =scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the updated company name");
		company =scan.nextLine();
	    try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A2?characterEncoding=latin1","root","Kshitija@19");
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, company);
            pstmt.setInt(2, id);
			pstmt.execute();
			//Statement stmt=con.createStatement();
			//stmt.executeUpdate("insert into Student_Data values(21,'Apurva',4,'Pune');");
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void UpdateIDname(){
		Scanner scan = new Scanner(System.in);
		String sql = "update customer set name=? where  cust_id= ?";
		String name; 
		int id;
		System.out.println("Enter the Customer ID where you wnat to change customer name");
		id =scan.nextInt();
		scan.nextLine();
		System.out.println("Enter the updated name");
		name =scan.nextLine();
	    try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A2?characterEncoding=latin1","root","Kshitija@19");
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
            pstmt.setInt(2, id);
			pstmt.execute();
			//Statement stmt=con.createStatement();
			//stmt.executeUpdate("insert into Student_Data values(21,'Apurva',4,'Pune');");
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	
	public void DeletebyID(){
		Scanner sc = new Scanner(System.in);
		String sql = "delete from customer where cust_id=?";
		int id;
		System.out.println("Enter the Customer ID which record has to be deleted");
		id =sc.nextInt();
	    try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A2?characterEncoding=latin1","root","Kshitija@19");
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.execute();
			//Statement stmt=con.createStatement();
			//stmt.executeUpdate("insert into Student_Data values(21,'Apurva',4,'Pune');");
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void DeletebyName(){
		Scanner sc = new Scanner(System.in);
		String sql = "delete from customer where name=?";
		String name;
		System.out.println("Enter the Customer Name which record has to be deleted");
		name =sc.nextLine();
	    try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A2?characterEncoding=latin1","root","Kshitija@19");
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.execute();
			//Statement stmt=con.createStatement();
			//stmt.executeUpdate("insert into Student_Data values(21,'Apurva',4,'Pune');");
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void DeletebyCompany(){
		Scanner sc = new Scanner(System.in);
		String sql = "delete from customer where company=?";
		String company;
		System.out.println("Enter the Company which record has to be deleted");
		company =sc.nextLine();
	    try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/A2?characterEncoding=latin1","root","Kshitija@19");
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, company);
			pstmt.execute();
			//Statement stmt=con.createStatement();
			//stmt.executeUpdate("insert into Student_Data values(21,'Apurva',4,'Pune');");
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		JDBCTest obj1=new JDBCTest();
		int ch;
		String n1, id2;
		int id1;
		do
		{
			System.out.println("----------------Database Connected Sucessfully----------------");
			System.out.println("--------------------------------------------");
			System.out.println("	1.Display all Records");
			System.out.println("	2.Insert new Record");
			System.out.println("	3.Update a Record");
			//System.out.println("	4.Update a Company using ID");
			System.out.println("	4.Delete a Record");
			System.out.println("	5.Exit");
			System.out.println("--------------------------------------------");
			System.out.println("	Enter your Choice");
			ch=sc.nextInt();
			switch(ch){
				case 1: obj1.Display();
					break;
				case 2: System.out.println("Enter Customer Id: ");
					id1=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Customer Name: ");
					n1=sc.nextLine();
					//sc.nextLine();
					System.out.println("Enter Company: ");
					id2=sc.nextLine();
					
					obj1.Insert(id1,n1,id2);
					break;
				case 3: 
					int choice;
					System.out.println("Enter Choice:\n1.Update a comapny by name\n2.Update a company by ID\n3.Update a Name by ID\n4.Update a Name by Comapny\n5.Exit ");
					choice=sc.nextInt();
					switch(choice) {
					case 1:obj1.UpdatenameCompany();
						break;
					case 2:obj1.UpdateIDCompany();
						break;
					case 3:obj1.UpdateIDname();
						break;
					case 4:obj1.UpdateCompanyname();
						break;
					case 5:
						break;
					}
					break;
				case 4: 
					int ans;
					System.out.println("Enter Choice:\n1.Delete by name\n2.Delete by company\n3.Delete by ID\n4.Exit ");
					ans=sc.nextInt();
					switch(ans) {
					case 1:obj1.DeletebyName();
						break;
					case 2:obj1.DeletebyCompany();
						break;
					case 3:obj1.DeletebyID();
						break;
					case 4:
						break;
					}
					break;
				
				
				case 0:
					break;
			}
		}while(ch!=5);
		
	}
}