package com.revature.java.project01.Customerfunctions;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MainClass {
	private static final Logger logger = LogManager.getLogger(MainClass.class);
	public static void main(String[] args) {
		System.out.println("*************************************************************************************************************************");
		System.out.println("*-----------------------------------------------------------------------------------------------------------------------*");
		System.out.println("*-----------------------------------------------------------------------------------------------------------------------*");
		System.out.println("*-----------------------------------------------------------------------------------------------------------------------*");
		System.out.println("*************************************************************************************************************************");
	    System.out.println("*                                                                                                                       *");
	    System.out.println("*                                                                                                                       *");
	    System.out.println("*                                                  ___     ___   ___          ___                                       *");
	    System.out.println("*                                         |    | |    |   /   \\ /   \\ |\\  /| |                                          *");
	    System.out.println("*                                         | /\\ | |--- |   |     |   | | \\/ | |---                                       *");
	    System.out.println("*                                         |/  \\| |___ |___\\___/ \\___/ |    | |___                                       *");
	    System.out.println("*                                                                                                                       *");
	    System.out.println("*                                                     "+"\"BLUE  BANK  \""+"                                                    *" );
	    System.out.println("*                                                                                                                       *");
	    System.out.println("*                                                                                                                       *");
	    System.out.println("*                                                                                                                       *");
	    System.out.println("*************************************************************************************************************************");
		System.out.println("*-----------------------------------------------------------------------------------------------------------------------*");
		System.out.println("*-----------------------------------------------------------------------------------------------------------------------*");
		System.out.println("*-----------------------------------------------------------------------------------------------------------------------*");
	   	System.out.println("*************************************************************************************************************************");
	   	System.out.println("___________________________________________________________________________________");
	    System.out.println("  |                                                                             |");
	    System.out.println("  |                             WELCOME AGAIN                                   |");
	    System.out.println("  |                           CHOOSE AN OPTION.....                             |");
	    System.out.println("  |                                                                             |");
	    System.out.println("  |                   1- SIGN IN                                                |");
	    System.out.println("  |                                                                             |");
	    System.out.println("  |                   2- DON'T YOU HAVE AN ACCOUNT..? SIGN UP                   |");
	    System.out.println("  |                                                                             |");
	    System.out.println("  |                                                                             |");
	    System.out.println("  |                                                                             |");
	    System.out.println("  |                                                                             |");
	    System.out.println("__|_____________________________________________________________________________|__");
	    int i=1;
	    //logger.info("BANKING STARTED "+d);
	    int option1=0,option2=0;
	    while(i==1) {
	    @SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
	    option1=in.nextInt();
	    if(option1==1) {
	    	System.out.println("____________________________________________________");
		    System.out.println("  |                                              |");
		    System.out.println("  |                 YOU ARE AN.......            |");
		    System.out.println("  |              CHOOSE AN OPTION.....           |");
		    System.out.println("  |                                              |");
		    System.out.println("  |                  1- EMPLOYEE                 |");
		    System.out.println("  |                                              |");
		    System.out.println("  |                  2- CUSTOMER                 |");
		    System.out.println("  |                                              |");
		    System.out.println("  |                                              |");
		    System.out.println("__|______________________________________________|__");
		    option2=in.nextInt();
		    if(option2==1) {
		    	EmployeeClass.Employeeclass();  
		    }
		    else if(option2==2) {
		    	CustomerClass.Customerclass();
		    }
	    }
	    else if(option1==2) {
	    	CreateNewCustomerAccount.Createnewcustomeraccount();
	    	CustomerClass.Customerclass();
	    	
	    }
	    else if(option1==3) {
	    	i=0;
	    	System.out.println("THANK YOU FOR YOUR VISIT...HAPPY BANKING...!!!!");
			System.exit(0);
	    }
	    else {
	    	System.out.println("SORRY.....INVALID OPTION....CHOOSE 1..2..OR..3...");
	    }
	    
	
	    }
	}
	public static Logger getLogger() {
		return logger;
	}
}


