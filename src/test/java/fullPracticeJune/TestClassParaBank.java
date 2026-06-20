package fullPracticeJune;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestClassParaBank extends BaseTest{
	
	@Test
	public void urlLaunch() {
	
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
	
	
	LoginPageParaBank loginpage = new LoginPageParaBank(driver, wait);
	loginpage.loginPara("user12", "pass12");
	System.out.println("Friday Jenkins practice");
	System.out.println("Second Jenkins practice");
	System.out.println("WebHook practice using ngrok");
	
	}

}
