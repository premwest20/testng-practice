package testngFull;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;


public class UpdatePersonalInfo {
	
	@Test(groups = "sanity")
	public void editFirstName() {
		System.out.println("First Name is edited");
	}
	
	@DataProvider(name="loginData")
	public static Object[][] getData(){
		return new Object[][] {
							{"user1", "pass1"},
							{"user2", "pass2"},
							{"user3", "pass3"}
							};
							}
	
	@Test(dataProvider = "loginData", alwaysRun = true)
	public void loginTest(String user, String pass) {
		System.out.println(user + " " + pass);
	}
	
	
	
	@DataProvider(name = "editLastNameData")
	public Object[][] getEditLastName(){
		return new Object[][] {
								{"Diaz"},
								{"Max"},
								{"Maximus"}
								};
								}
	
	
	
	@Test(dataProvider = "editLastNameData", alwaysRun = true)
	public void editLastName(String lastName) {
		System.out.println("Last Name is edited with " + lastName);
	}
	
	@Test
	public void mainBranchAdd(){
	System.out.println("Updated from MAIN branch");
	}
	
	@Test
	public void featureBranchAdd(){
	System.out.println("Updated from FEATURE branch");
	}
	
	
	
	@Test
	public void editPrefix() {
		System.out.println("Prefix is edited");
	}

}
