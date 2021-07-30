package com.revature.java.project01.Customerfunctions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FunctionsDAOImplementation implements FunctionsDAO{
	private static final Logger logger = LogManager.getLogger(FunctionsDAOImplementation.class);
	private static Scanner sc,scanner,sc1;
@SuppressWarnings("deprecation")
public static double Depositamount() {
	     double amnt,dep = 0;
	     int i=0;
	try  {
		sc = new Scanner(System.in);
		scanner = new Scanner(System.in).useDelimiter("\n");
		Connection con4=SetConnection.getConnection();
		PreparedStatement stmt;
		double at=0;
		System.out.print("NAME:");
	    String name= scanner.next();
		System.out.println("---------------------------------------------------------------------");
		do {
			if(i>0) {
				System.out.println("CANNOT DEPOSIT NEGATIVE AMOUNT");
				System.out.println("---------------------------------------------------------------------");
			}
		System.out.print("AMOUNT TO BE DEPOSITED:");
		amnt=sc.nextDouble();
		i++;
		}while(amnt<0);
		System.out.println("---------------------------------------------------------------------");
		System.out.print("ACCOUNT NO:");
		long acnt=sc.nextLong();
		System.out.println("---------------------------------------------------------------------");
		System.out.print("USER ID:");
		long uid=sc.nextLong(); 
		System.out.println("---------------------------------------------------------------------");
		String sql= "SELECT balance FROM customer WHERE acntno="+acnt;
		Statement statement = con4.createStatement(); 
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) 
		{
		at=resultSet.getDouble(1)+amnt;
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String sql1= "INSERT INTO "+name.charAt(0)+"_"+uid+"(date,message,deposit,balance) values(?,?,?,?)";
		stmt=con4.prepareStatement(sql1);
		stmt.setObject(1,dtf.format(now));
		stmt.setString(2,"Deposit");
		stmt.setDouble(3,amnt);
		stmt.setDouble(4, at);
		int r=stmt.executeUpdate();
		if(r>0) {
			logger.info(dtf.format(now)+ " "+name+" "+"Deposited"+" "+amnt+" "+":"+"Total available balance: "+at);
			System.out.println("AMOUNT SUCCESSFULLY DEPOSITED");
			System.out.println("---------------------------------------------------------------------");
		}
		else {
			System.out.println("SOME ERROR OCCURED,TRY AGAIN LATER...!!");
			System.out.println("---------------------------------------------------------------------");
		}
		statement.close();
		dep=at;
		String sql2= "update customer set balance="+at+" where userid="+uid;
		Statement stmt3 = con4.createStatement();
		stmt3.executeUpdate(sql2);
		logger.entry();
		ViewDAOImplementation.Viewtransactiondetails(uid);
		stmt3.close();
		con4.close();
	}
	catch (SQLException e) {
		System.out.println(e.getLocalizedMessage());
		System.out.println("SERVER ERROR...");
	}
	logger.exit();
	return dep;
}
public static Logger getLogger() {
	return logger;
}
@SuppressWarnings("deprecation")
public static double Withdrawamount() {
double wam=0;
try{
sc1 = new Scanner(System.in);
sc = new Scanner(System.in).useDelimiter("\n");
Connection con4=SetConnection.getConnection();
PreparedStatement stmt;
double at=0,amnt=0;
int i=0;
System.out.print("NAME:");
String name= sc.next();
System.out.println("---------------------------------------------------------------------");
System.out.print("ACCOUNT NO:");
long acnt=sc1.nextLong(); 
System.out.println("---------------------------------------------------------------------");
System.out.print("USER ID:");
long uid=sc1.nextLong(); 
System.out.println("---------------------------------------------------------------------");
do {
	if(i>0) {
		System.out.println("CANNOT WITHDRAW NEGATIVE AMOUNT");
		System.out.println("---------------------------------------------------------------------");
	}
	System.out.print("AMOUNT TO BE WITHDRAWN:");
	amnt=sc1.nextDouble();
	i++;
	}while(amnt<0);
System.out.println("---------------------------------------------------------------------");
String sql= "SELECT balance FROM customer WHERE acntno="+acnt;
Statement statement = con4.createStatement(); 
ResultSet resultSet = statement.executeQuery(sql);
while (resultSet.next()) 
{
double bal=resultSet.getDouble(1);
bal=bal-1000;
if(bal<amnt) {
	System.out.println("INSUFFICICNET BALANCE...CHECK YOUR BALANCE AND TRY AGAIN ...");
	System.out.println("---------------------------------------------------------------------");
	statement.close();
}
at=resultSet.getDouble(1)-amnt;
//System.out.println(resultSet.getDouble(1));
}
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
LocalDateTime now = LocalDateTime.now();  
String sql1= "INSERT INTO "+name.charAt(0)+"_"+uid+"(date,message,withdrawal,balance) values(?,?,?,?)";
stmt=con4.prepareStatement(sql1);
stmt.setObject(1,dtf.format(now));
stmt.setString(2,"Withdraw");
stmt.setDouble(3,amnt);
stmt.setDouble(4, at);
int r=stmt.executeUpdate();
if(r>0) {
	logger.info(dtf.format(now)+ " "+name+" "+"Withdrawn"+" "+amnt+" "+":"+"Total available balance: "+at);
	System.out.println("AMOUNT WITHDRAWN SUCCESSFULLY....");
	System.out.println("---------------------------------------------------------------------");
}
else {
	System.out.println("SOME ERROR OCCURED,TRY AGAIN LATER...!!");
	System.out.println("---------------------------------------------------------------------");
}
statement.close();
String sql2= "update customer set balance="+at+" where userid="+uid;
Statement stmt3 = con4.createStatement();
stmt3.executeUpdate(sql2);
logger.entry();
wam=at;
ViewDAOImplementation.Viewtransactiondetails(uid);
stmt3.close();
con4.close();
}
catch (SQLException e) {
//System.out.println(e.getLocalizedMessage());
System.out.println("SERVER ERROR...");
}
logger.exit();
return wam;
}
@SuppressWarnings({ "deprecation", "unused" })
public static void Transferamount() {
try{
sc = new Scanner(System.in);
sc1 = new Scanner(System.in).useDelimiter("\n");
Connection con=SetConnection.getConnection();
PreparedStatement stmt2,stmt4;
double at=0,amnt=0;
int i=0;
System.out.println("*********************************************************************");
System.out.println();
System.out.println("                     ACCOUNT HOLDERS DETAILS:");
System.out.println();
System.out.println("*********************************************************************");
System.out.print("NAME:");
String name= sc1.next();
System.out.println("---------------------------------------------------------------------");
System.out.print("INITIAL:");
String name2=sc1.next();
System.out.println("---------------------------------------------------------------------");
System.out.print("ACCOUNT NO:");
long acnt=sc.nextLong();
System.out.println("---------------------------------------------------------------------");
System.out.print("USER ID:");
long uid=sc.nextLong(); 
System.out.println("---------------------------------------------------------------------");
do {
	if(i>0) {
		System.out.println("CANNOT BE NEGATIVE AMOUNT");
		System.out.println("---------------------------------------------------------------------");
	}
	System.out.print("AMOUNT TO BE TRANSFERED:");
	amnt=sc.nextDouble();
	i++;
	}while(amnt<0);
System.out.println("---------------------------------------------------------------------");
String sql1= "SELECT balance FROM customer WHERE acntno="+acnt;
Statement stmt1 = con.createStatement(); 
ResultSet resultSet1 = stmt1.executeQuery(sql1);
while (resultSet1.next()) 
{
double bal=resultSet1.getDouble(1);
bal=bal-1000;
if(bal<amnt) {
	System.out.println("INSUFFICICNET BALANCE...CHECK YOUR BALANCE AND TRY AGAIN ...");
	System.out.println("---------------------------------------------------------------------");
	return;
}
at=resultSet1.getDouble(1)-amnt;
}
System.out.println("*********************************************************************");
System.out.println();
System.out.println("                        PAYEE DETAILS:");
System.out.println();
System.out.println("*********************************************************************");
System.out.print("NAME :");
String name3= sc1.next();
System.out.println("---------------------------------------------------------------------");
System.out.print("INITIAL:");
String name5=sc1.next();
System.out.println("---------------------------------------------------------------------");
System.out.print("ACCOUNT NO :");
long acnt1=sc.nextLong();
System.out.println("---------------------------------------------------------------------");
System.out.print("USER ID :");
long uid1=sc.nextLong(); 
System.out.println("---------------------------------------------------------------------");
String sql4= "SELECT balance FROM customer WHERE acntno="+acnt1;
Statement statement1 = con.createStatement(); 
ResultSet resultSet2 = statement1.executeQuery(sql4);
while (resultSet2.next()) 
{
at=resultSet2.getDouble(1)+amnt;
}
DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
LocalDateTime now1 = LocalDateTime.now();  
String sql3= "update customer set balance="+at+" where userid="+uid;
Statement stmt3 = con.createStatement();
stmt3.executeUpdate(sql3);
String sql5= "INSERT INTO "+name3.charAt(0)+"_"+uid1+"(date,message,deposit,balance) values(?,?,?,?)";
stmt4=con.prepareStatement(sql5);
stmt4.setObject(1,dtf1.format(now1));
stmt4.setString(2,"Deposit");
stmt4.setDouble(3,amnt);
stmt4.setDouble(4, at);
int r2=stmt4.executeUpdate();
String sql2= "INSERT INTO "+name.charAt(0)+"_"+uid+"(date,message,withdrawal,balance) values(?,?,?,?)";
stmt2=con.prepareStatement(sql2);
stmt2.setObject(1,dtf1.format(now1));
stmt2.setString(2,"Withdraw");
stmt2.setDouble(3,amnt);
stmt2.setDouble(4, at);
int r1=stmt2.executeUpdate();
stmt2.close();
String sql6= "update customer set balance="+at+" where userid="+uid1;
Statement stmt5 = con.createStatement();
stmt5.executeUpdate(sql6);
if(r2>0) {
	logger.info(dtf1.format(now1)+" "+name+" "+"Transfered"+" "+amnt+" to "+name3);
	System.out.println("AMOUNT SUCCESSFULLY TRANSFERED");
	System.out.println("---------------------------------------------------------------------");
}
else {
	System.out.println("SOME ERROR OCCURED,TRY AGAIN LATER...!!");
	System.out.println("---------------------------------------------------------------------");
}
logger.entry();
ViewDAOImplementation.Viewtransactiondetails(uid);
con.close();
}catch (SQLException e) {
System.out.println(e.getLocalizedMessage());
System.out.println("SERVER ERROR...");
}
logger.exit();
}
}
