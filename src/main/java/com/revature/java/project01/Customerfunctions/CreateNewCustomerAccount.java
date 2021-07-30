package com.revature.java.project01.Customerfunctions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class CreateNewCustomerAccount {
	private static Scanner scanner;
	public static void Createnewcustomeraccount() {
	    Connection con=null;
	    @SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
	    con=SetConnection.getConnection();
		try {
			PreparedStatement stmt;
			Statement stmt1;
			System.out.println("**********************************************************************");
			System.out.println("*                      CREATING NEW ACCOUNT                          *");
			System.out.println("**********************************************************************");
			System.out.print("NAME:");
			scanner = new Scanner(System.in).useDelimiter("\n");
		    String fname= scanner.next();
			System.out.println("---------------------------------------------------------------------");
			System.out.print("INITIAL:");
			scanner = new Scanner(System.in).useDelimiter("\n");
			String lname=scanner.next();
			System.out.println("---------------------------------------------------------------------");
			System.out.print("ADDRESS:");
			scanner = new Scanner(System.in).useDelimiter("\n");
		    String add = scanner.next();
		    System.out.println("---------------------------------------------------------------------");
		   //	String add=in.next();
			System.out.print("EMAIL ID:");
			String email=in.next();
			boolean e=ValidateDAOImplementation.Validatemail(email);
		    while(e==false) {
		    	System.out.println("INVALID EMAIL...TRY AGAIN");
				System.out.print("EMAIL:");
				email=in.next();
				e=ValidateDAOImplementation.Validatemail(email);
		    }
		    System.out.println("---------------------------------------------------------------------");
			System.out.println("Note:Your pswd should contain one uppercase,one lowercase ,numerals and a special case of minimum 8 and maximum 10 characters");
			System.out.print("CREATE A PASSWORD FOR YOUR ACCOUNT:");
			String pswd=in.next();
			boolean c=ValidateDAOImplementation.ValidatePassword(pswd);
		    while(c==false) {
		    	System.out.println("PLEASE CHECK FOR PASSWORD CONSTRAINTS");
		    	System.out.println("Note:Your pswd should contain one uppercase,one lowercase ,numerals and a special case of minimum 8 and maximum 10 characters");
				System.out.print("CREATE A PASSWORD FOR YOUR ACCOUNT:");
		    	pswd=in.next();
		    	c=ValidateDAOImplementation.ValidatePassword(pswd);
		    }
			System.out.print("CONFIRM YOUR PASSWORD OF YOUR ACCOUNT:");
			String cpswd=in.next();
			while(!(pswd.equals(cpswd))) {
				System.out.println("PASSWORDS DONT MATCH,TRY AGAIN");
				System.out.println("Note:Your pswd should contain one uppercase,one lowercase ,numerals and a special case of minimum 8 and maximum 10 characters");
				System.out.print("CREATE A PASSWORD FOR YOUR ACCOUNT:");
				pswd=in.next();
			    c=ValidateDAOImplementation.ValidatePassword(pswd);
			    while(c==false) {
			    	System.out.println("INVALID PASSWORD TYPE...PLEASE CHECK FOR PASSWORD CONSTRAINTS");
			    	System.out.println("---------------------------------------------------------------------");
			    	System.out.println("Note:Your pswd should contain one uppercase,one lowercase ,numerals and a special case of minimum 8 and maximum 10 characters");
					System.out.print("CREATE A PASSWORD FOR YOUR ACCOUNT:");
			    	pswd=in.next();
			    	c=ValidateDAOImplementation.ValidatePassword(pswd);
			    }
				System.out.print("CONFIRM PASSWORD FOR YOUR ACCOUNT:");
				cpswd=in.next();
			}
			System.out.println("---------------------------------------------------------------------");
			System.out.print("DATE OF BIRTH:(note:MM/dd/yyyy):");
			String input = in.next() ;
			System.out.println("---------------------------------------------------------------------");
			System.out.print("AGE:");
			int age=in.nextInt();
			while(ValidateDAOImplementation.Validateage(input, age)==false) {
				System.out.println("YOUR DATE OF BIRTH AND AGE DOESNT MATCH...GIVE CORRECT DETAILS");
				System.out.print("DATE OF BIRTH:(note:MM/dd/yyyy):");
				input = in.next() ;
				System.out.print("AGE:");
				age=in.nextInt();
			}
			System.out.println("---------------------------------------------------------------------");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "MM/dd/yyyy" ) ;
			LocalDate localDate = LocalDate.parse( input, formatter ) ;
			System.out.print("CONTACT NUMBER:");
	        String phn=in.next();
	        while(ValidateDAOImplementation.ValidatePhoneNumber(phn)==false)
	        {
	        	System.out.println("THE CONTACT NUMBER GIVEN IS INAPPROPRIATE....CHECK FOR NUMBER IN IT");
	        	System.out.print("CONTACT NUMBER:");
		        phn=in.next();
	        }
	        System.out.println("---------------------------------------------------------------------");
			System.out.print("INITIAL AMOUNT (Note:Initial amount must be greater than 1000) :");
		    double amnt=in.nextDouble();
		    while(amnt<=1000) {
		    	System.out.println("INITIAL AMOUNT CANNOT BE LESS THAN 1000");
		    	System.out.print("INITIAL AMOUNT:");
			    amnt=in.nextDouble();
		    }
		    System.out.println("---------------------------------------------------------------------");
			String query="INSERT INTO customer(acntno, first_name,last_name, address, date_of_birth, age,userid, balance, date_of_creation, password,emailid,contactno) VALUES(nextval('acntNo'),?,?,?,?,?,nextval('use'),?,CURRENT_DATE,?,?,?)";
			stmt=con.prepareStatement(query);
			stmt.setString(1, fname);
			stmt.setString(2, lname);
			stmt.setString(3, add);
			stmt.setObject(4,localDate );
			stmt.setInt(5, age);
			stmt.setDouble(6, amnt);
			stmt.setString(7, pswd);
			stmt.setString(8, email);
			stmt.setString(9, phn);
			int r=stmt.executeUpdate();
			if(r>0) {
				System.out.println("**********************************************************************");
				System.out.println("*                  ACCOUNT CREATED SUCCESSFULLY                      *");
				System.out.println("**********************************************************************");
				ViewDAOImplementation.DisplayDetails(pswd);
			}
			else {
				System.out.println("SOME ERROR OCCURED,TRY AGAIN LATER...!!");
			}
			String query1="SELECT acntno,userid FROM customer WHERE password="+"'"+pswd+"'";
			stmt1=con.createStatement();
			ResultSet rs=stmt1.executeQuery(query1);
            long ui = 0;
			while(rs.next()) {
            	 rs.getLong(1);
                 ui=rs.getLong(2);
            }
            CreateTable.Createtable(fname, ui);
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println("SERVER ERROR...");
		}
		
		
	}
}
