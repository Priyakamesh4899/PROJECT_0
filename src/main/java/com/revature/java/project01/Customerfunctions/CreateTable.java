package com.revature.java.project01.Customerfunctions;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class CreateTable {
public static void Createtable(String fname,long ui) {
	               try {
	                   Connection con2=SetConnection.getConnection();
	                   Statement stmt = con2.createStatement();
	                   String query = "CREATE TABLE " +fname.charAt(0)+"_"+ui+"(date timestamp ,"+"message varchar,"+"withdrawal bigint,"+"deposit bigint,"+"balance bigint)";
	           			stmt.execute(query);
	           		} catch (SQLException e) {
	           			// TODO Auto-generated catch block
	           			System.out.println(e.getLocalizedMessage());
	           			System.out.println("SERVER ERROR....");
	           		}
	                   
	           }
	           }

