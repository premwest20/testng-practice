package fullPracticeMay;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestRunner extends BaseClass{
	
	@Test
	public void urlLaunch() throws IOException {
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
	//	HomePage homepage = new HomePage(driver, wait);
	//	homepage.practicePage();
		
//		HomePageTwo homepagetwo = new HomePageTwo(driver, wait);
//		homepagetwo.practicePageTwo();
		
//		HomePageThree homepagethree = new HomePageThree(driver, wait);
//		homepagethree.homepagethree();
		
//		HomePageFour homepagefour = new HomePageFour(driver, wait);
//		homepagefour.homepagefour();
//		
		HomePageFive homepagefive = new HomePageFive(driver, wait);
		homepagefive.homepagefive();
		}
	
	
		
		
	

}
