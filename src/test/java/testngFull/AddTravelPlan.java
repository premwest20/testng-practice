package testngFull;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class AddTravelPlan {
	
	@Test(priority = 1, groups = "sanity")
	public void addTravelPlan() {
		System.out.println("Travel Plan is added");
	}
	
	@Test(priority = 3, groups = "sanity")
	public void addLargePurchPlan() {
		System.out.println("Large Purchase Plan is added");
	}
	
	@Test(priority = 4, groups = "regression")
	public void editLargePurchPlan() {
		System.out.println("Large Purchase Plan is edited");
	}
	
	@Test(priority = 2)
	public void deleteTravelPlan() {
		System.out.println("Travel Plan is deleted");
	}
	
	@Test(dataProvider = "loginData", dataProviderClass = UpdatePersonalInfo.class)
	public void loginTravel(String user, String pass) {
		System.out.println(user + " and " + pass);
	}
	
	@Test
	public void editTravelPlan() {
		System.out.println("Travel Plan is edited");
	}

}
