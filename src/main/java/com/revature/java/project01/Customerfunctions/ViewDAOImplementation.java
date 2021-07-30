package com.revature.java.project01.Customerfunctions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewDAOImplementation implements ViewDAO {
	public static void DisplayDetails(String pwd) {
        PreparedStatement st;
		try {
			Connection con1=SetConnection.getConnection();
           String queryActor ="SELECT * FROM customer WHERE password ="+"'"+pwd+"'";
           st = con1.prepareStatement(queryActor);
           ResultSet rs=st.executeQuery();
           while(rs.next())
           {
           System.out.println("**********************************************************************");
       	System.out.println("*                          YOUR ACCOUNT DETAILS                      *");
       	System.out.println("**********************************************************************");
    		System.out.println("|             ACCOUNT NUMBER : "+rs.getString(1)+"                    ");
    		System.out.print("|             ACCOUNT HOLDER NAME : "+rs.getString(2));
    		System.out.print("|             ADDRESS : "+rs.getString(4));
    		System.out.println("|             DOB : "+rs.getString(5));
    		System.out.println("|             AGE : "+rs.getInt(6));
    		System.out.println("|             EMAIL : "+rs.getString(11));
    		System.out.println("|             CONTACT NUMBER : "+rs.getString(12));
    		System.out.println("|             USER ID : "+rs.getInt(7));
    		System.out.println("|             DATE OF CREATION: "+rs.getString(9));
    		System.out.println("|             CURRENT BALANCE: "+rs.getDouble(8));
    		System.out.println("**********************************************************************");
         }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("CHECK FOR CORRECT DETAILS...DOESNT MATCH THE INFO PROVIDED..");
}
}
public static void DisplayDetails(long uid) {
            PreparedStatement st;
			try {
				Connection con1=SetConnection.getConnection();
               String queryActor ="SELECT * FROM customer WHERE userid ="+uid;
               st = con1.prepareStatement(queryActor);
               ResultSet rs=st.executeQuery();
               while(rs.next())
               {
               	System.out.println("**********************************************************************");
                	System.out.println("*                          YOUR ACCOUNT DETAILS                      *");
                	System.out.println("**********************************************************************");
             		System.out.println("|             ACCOUNT NUMBER : "+rs.getString(1)+"                    ");
             		System.out.print("|             ACCOUNT HOLDER NAME : "+rs.getString(2));
             		System.out.print("|             ADDRESS : "+rs.getString(4));
             		System.out.println("|             DOB : "+rs.getString(5));
             		System.out.println("|             AGE : "+rs.getInt(6));
             		System.out.println("|             EMAIL : "+rs.getString(11));
             		System.out.println("|             CONTACT NUMBER : "+rs.getString(12));
             		System.out.println("|             USER ID : "+rs.getInt(7));
             		System.out.println("|             DATE OF CREATION: "+rs.getString(9));
             		System.out.println("|             CURRENT BALANCE: "+rs.getDouble(8));
             		System.out.println("**********************************************************************");
              
             }
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getLocalizedMessage());
				System.out.println("CHECK FOR CORRECT DETAILS...DOESNT MATCH THE INFO PROVIDED..");
}
}
private static Scanner sc,scanner;
public static void Viewtransactiondetails() {
	   PreparedStatement st;
		try{
			sc = new Scanner(System.in);
			scanner = new Scanner(System.in).useDelimiter("\n");
			Connection con1=SetConnection.getConnection();
			System.out.print("NAME:");
		    String name= scanner.next();
			System.out.println("---------------------------------------------------------------------");
			System.out.print("USER ID:");
			long uid=sc.nextLong(); 
			System.out.println("---------------------------------------------------------------------");
           String queryActor ="SELECT * FROM "+name.charAt(0)+"_"+uid;
           st = con1.prepareStatement(queryActor);
           ResultSet rs=st.executeQuery();
           System.out.println("**********************************************************************");
      	   System.out.println("*                          YOUR ACCOUNT DETAILS                      *");
      	   System.out.println("**********************************************************************");
      	   System.out.println("DATE                | MESSAGE     | DEPOSIT   | WITHDRAWAL  | BALANCE ");
           while(rs.next())
           {
           System.out.println(rs.getString(1)+" | "+rs.getString(2)+"   | "+rs.getDouble(3)+" | "+ rs.getDouble(4) +" | "+rs.getDouble(5));
           }
           System.out.println("**********************************************************************");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
}
}
public static void Viewtransactiondetails(long uid) {
	   PreparedStatement st,st1;
		try {
			Connection con5=SetConnection.getConnection();
        String queryActor ="SELECT first_name FROM customer WHERE userid="+uid;
        st = con5.prepareStatement(queryActor);
        ResultSet rs=st.executeQuery();
        String name = null;
        while(rs.next())
        {
        name=rs.getString(1);
        }
        System.out.println("ACCOUNT HOLDER :"+name);
		String queryActor1 ="SELECT * FROM "+name.charAt(0)+"_"+uid;
        st1 = con5.prepareStatement(queryActor1);
        ResultSet rs1=st1.executeQuery();
        System.out.println("**********************************************************************");
   	    System.out.println("*                    ACCOUNT TRANSACTION DETAILS                     *");
   	    System.out.println("**********************************************************************");
   	    System.out.println("DATE                | MESSAGE     | WITHDRAWAL | DEPOSIT   |  BALANCE ");
   	    System.out.println("**********************************************************************");
        while(rs1.next())
        {
        System.out.println(rs1.getString(1)+" | "+rs1.getString(2)+"   | "+rs1.getDouble(3)+" | "+ rs1.getDouble(4) +" | "+rs1.getDouble(5));
        }
        System.out.println("**********************************************************************");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
			System.out.println("SERVER ERROR...");
}
}
public static void Viewtransactionlogs() {
	  File file = new File("C:\\mylogs\\TransactionLog.log");
	  BufferedReader br;
	try {
		br = new BufferedReader(new FileReader(file));
		String st;
		System.out.println("THE TRANSACTIONS PERFORMED TILL NOW: ");
		while ((st = br.readLine()) != null)
		    System.out.println(st);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
