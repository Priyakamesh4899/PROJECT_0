package com.revature.java.project01.Customerfunctions;

import java.util.Scanner;

public class EmployeeClass {
	private static Scanner sc;

	public static void Employeeclass() {
	sc = new Scanner(System.in);
	int i=EmployeeLogin.Employeelogin();
	while(i==0) {
		System.out.println("ENTER PROPER DETAILS TO LOGIN...");
		i=EmployeeLogin.Employeelogin();
	}
	while(i==1) {
	System.out.println("________________________________________________________");
    System.out.println("  |                                                  |");
    System.out.println("  |          OPTIONS FOR EMPLOYEE....                |");
    System.out.println("  |                                                  |");			    
    System.out.println("  |        1.VIEW CUSTOMER BANK ACCOUNT              |");
    System.out.println("  |        2.VIEW RECORD OF ALL TRANSACTIONS         |");
    System.out.println("  |        3.ACCEPT/DELETE CUSTOMER BANK ACCOUNT     |");
    System.out.println("  |        4.VIEW ALL TRANSACTIONS                   |");
    System.out.println("  |        5.EXIT                                    |");
    System.out.println("__|__________________________________________________|__");
	int choice=sc.nextInt();
	switch(choice) {
	case 1:
		System.out.print("ENTER USER ID OF THE ACCOUNT:");
		long uid=sc.nextLong();
		System.out.println("---------------------------------------------------------------------");
		ViewDAOImplementation.DisplayDetails(uid);
	break;
	case 2:
		System.out.print("ENTER USER ID OF THE ACCOUNT:");
		long uid1=sc.nextLong();
		System.out.println("---------------------------------------------------------------------");
		ViewDAOImplementation.Viewtransactiondetails(uid1);
	break;
	case 3:
		Accept_Reject_CustomerAccount.Accept_Reject_Customeraccount();
	break;
	case 4:
		ViewDAOImplementation.Viewtransactionlogs();
		break;
	case 5:
	{
		System.out.println("!!!!...HAPPY BANKING...!!!!");
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
	i=sc.nextInt();
	    System.out.println("---------------------------------------------------------------------");
	if(i!=1) {
		System.out.println("             THANK YOU FOR YOUR VISIT...HAPPY BANKING...!!!!");
		System.out.println("---------------------------------------------------------------------");
		System.exit(0);
	}
}
}
}