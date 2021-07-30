package com.revature.java.project01.Customerfunctions;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Accept_Reject_CustomerAccount {
	private static Scanner sc;

	public static void Accept_Reject_Customeraccount() {
		try {
		sc = new Scanner(System.in);
		System.out.println("NAME OF THE ACCOUNT HOLDER...:");
		String name=sc.next();
		System.out.println("USER ID OF THE ACCOUNT HOLDER...:");
		long uid=sc.nextLong();
		System.out.println("ACCEPT(1) OR REJECT(2)....?");
		int a=sc.nextInt();
		if(a==1) {
			System.out.println("YOU HAVE ACCEPTED "+name+"'S ACCOUNT ");
		}
		else if(a==2) {
	    Connection con5=SetConnection.getConnection();
	    Statement st = con5.createStatement();     
        String sql1 = "DELETE FROM CUSTOMER WHERE userid="+uid;
        st.executeUpdate(sql1);
        Statement stmt = con5.createStatement(); 
        String sql = "DROP TABLE "+name.charAt(0)+"_"+uid;
        stmt.executeUpdate(sql);
        System.out.println("YOU HAVE REJECTED "+name+"'S ACCOUNT ");
		}
		else {
			System.out.println("INVALID CHOICE...TRY AGAIN");
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
			System.out.println("SERVER ERROR...");
}
}
}
