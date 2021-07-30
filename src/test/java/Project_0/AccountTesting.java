package Project_0;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.revature.java.project01.Customerfunctions.FunctionsDAOImplementation;
import com.revature.java.project01.Customerfunctions.ValidateDAOImplementation;
	public class AccountTesting {
	/*@BeforeAll
	static void BeforeAll() {
		System.out.println("Testing of the bank functions");
	}
	@AfterAll
	static void AfterAll() {
		System.out.println("Testing Completed");
	}*/
	@Test
	void AgeTest() {
		System.out.println("Testing Age Function....");
		Assertions.assertEquals(true,ValidateDAOImplementation.Validateage("02/08/1999",22));
	}
	@Test
	void PasswordTest() {
		System.out.println("Testing Password Function....");
		Assertions.assertEquals(true,ValidateDAOImplementation.Validatemail("hema@gmail.com"));
	}
	@Test
	void EmailTest() {
		System.out.println("Testing Email Function....");
		Assertions.assertEquals(true,ValidateDAOImplementation.ValidatePassword("Priy@143*"));
	}
	@Test
	void ContactNumberTest() {
		System.out.println("Testing Contact number Function....");
		Assertions.assertEquals(true,ValidateDAOImplementation.ValidatePhoneNumber("9956774655"));
	}
	@Test
	void depositTest() {
		System.out.println("Testing Deposit Function....");
		   Assertions.assertEquals(6000,FunctionsDAOImplementation.Depositamount());
		 }
	@Test
    void WithdrawTest() {
		System.out.println("Testing Withdraw Function....");
      Assertions.assertEquals(11498,FunctionsDAOImplementation.Withdrawamount());
    }
}