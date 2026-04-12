package testngFull;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;

public class UpdateContactInfo {
	
	@Test(groups = "sanity")
	public void addMailingAddress(){		
		System.out.println("Mailing Address added");
	}
	
	@BeforeClass(alwaysRun = true)
	public void runFirst() {
		System.out.println("Run First");
	}
	
	@AfterClass
	public void runLast() {
		System.out.println("Run Last");
	}
	

	@Test(groups = "sanity")
	@Parameters("addMailingAddressTwo")
	public void addMailingAddressTwo(@Optional("abc@gmail.com") String addMailingAddressSecond){		
		System.out.println("Mailing Address two added" + addMailingAddressSecond);
	}
	
	
	@BeforeMethod()
	public void selectPrimary() {
		System.out.println("Primary is selected");
	}
	
	@AfterMethod
	public void activityCompleted() {
		System.out.println("Activity Completed");
	}
	
	@Test(priority = 1, groups = "")
	public void loginCheck() {
		System.out.println("Logged in successfully");
	}
	
	@Test(priority = 5, groups = "")
	public void logoutCheck() {
		System.out.println("Logged out successfully");
	}
	
	@Test(groups = "sanity", dependsOnMethods = {"addMailingAddress"})
	public void addAlternateEmail() {
		System.out.println("Alternate Email is added");
	}
	
	@Test(dependsOnMethods = "addMailingAddress")
	public void editALternateEmail() {
		System.out.println("Alternate Email is edited");
	
	}
	
	@Test(dependsOnMethods = {"loginCheck", "logoutCheck"})
	public void addEmail() {
		System.out.println("Email is added");
	}
	
	@Test(dependsOnMethods = {"loginCheck", "logoutCheck"})
	public void editEmail() {
		System.out.println("Email is edited");
	}
	
	@Test
	public void deletedEmail() {
		System.out.println("Email is deleted");
	}
	

}
