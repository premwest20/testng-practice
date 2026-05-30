package fullPracticeMay;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	WebDriver driver;	
	WebDriverWait wait;
	
		@BeforeClass
		public void startUp() {		
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		}
		
		@AfterClass
		public void tearDown() {
			driver.close();			
		}
		
		
	//}

}
