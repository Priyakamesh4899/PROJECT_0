package com.revature.java.project01.Customerfunctions;

import java.util.Scanner;

public class CustomerClass {
	@SuppressWarnings("resource")
	public static void Customerclass() {
    int b=CustomerLogin.Customerlogin();
    Scanner c = new Scanner(System.in);
    	try {
			while(b==0) {
				System.out.println("INVALID USED ID OR PASSWORD.....TRY AGAIN");
				System.out.println("---------------------------------------------------------------------");
				b=CustomerLogin.Customerlogin();
			}
			System.out.println("*******************************************");
			System.out.println();
			System.out.println("*        WELCOME TO CUSTOMER PORTAL       *");
			System.out.println();
			System.out.println("*******************************************");
			while(b==1) {
				int choice=0;
			System.out.println("_________________________________________________");
			System.out.println("  |                                           |");
			System.out.println("  |          OPTIONS FOR CUSTOMER....         |");
			System.out.println("  |                                           |");			    
			System.out.println("  |        1. VIEW ACCOUNT BALANCE            |");
			System.out.println("  |        2. DEPOSIT                         |");
			System.out.println("  |        3. WITHDRAWAL                      |");
			System.out.println("  |        4. MONEY TRANSFER                  |");
			System.out.println("  |        5. VIEW TRANSACTION DETAILS        |");
			System.out.println("  |        6. EXIT                            |");
			System.out.println("__|___________________________________________|__");
			choice=c.nextInt();
			switch(choice) {
			case 1:
				System.out.print("ENTER YOUR USER ID:");
				long uid=c.nextLong();
				System.out.println("---------------------------------------------------------------------");
				ViewDAOImplementation.DisplayDetails(uid);
			break;
			case 2:
				FunctionsDAOImplementation.Depositamount();
			break;
			case 3:
				FunctionsDAOImplementation.Withdrawamount();
			break;
			case 4:
				FunctionsDAOImplementation.Transferamount();
			break;
			case 5:
				ViewDAOImplementation.Viewtransactiondetails();
			break;
			case 6:
			{
				System.out.println("THANK YOU FOR YOUR VISIT...HAPPY BANKING...!!!!");
				System.out.println("---------------------------------------------------------------------");
				System.exit(0);
			}
			break;
			default:
				System.out.println("INVALID OPTIONS....TRY FROM THE MENU...");
				System.out.println("---------------------------------------------------------------------");
			break;
			}
			System.out.println("FOR FURTHER PROCESSING...PRESS 1 or PRESS ANY KEY TO LOGOUT");
			int i=0;
			i=c.nextInt();
			    System.out.println("---------------------------------------------------------------------");
			if(i!=1) {
				System.out.println("             THANK YOU FOR YOUR VISIT...HAPPY BANKING...!!!!");
				System.out.println("---------------------------------------------------------------------");
				System.exit(0);
			}
			
}
}
    	finally {
    		System.out.println();
    	}
}
}

