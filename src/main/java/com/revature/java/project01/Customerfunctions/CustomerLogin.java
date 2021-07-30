package com.revature.java.project01.Customerfunctions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerLogin {
private static Scanner sc;

public static int Customerlogin() {
		    try  {
		    	sc = new Scanner(System.in);
				Connection con3=SetConnection.getConnection();
				System.out.print("ENTER YOUR USER ID:");
				long uid=sc.nextLong(); 
				System.out.println("---------------------------------------------------------------------");
				System.out.print("ENTER YOUR PASSWORD:");
				String pwd=sc.next();
				System.out.println("---------------------------------------------------------------------");
				String sql= "SELECT password FROM customer WHERE userid="+uid;
				Statement statement = con3.createStatement(); 
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) 
				{
				//System.out.println(resultSet.getString(1));
				if(resultSet.getString(1).equals(pwd)) {
					return 1;
				}
				else {
					return 0;
				}
				}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
			System.out.println("SERVER ERROR...");
		}
	return 0;
}
}
