package fullPracticeJune;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageParaBank {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public LoginPageParaBank(WebDriver driver, WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
	}
	
	By customerLoginHeader = By.xpath("//h2[contains(text(), 'Customer Login')]");
	By usernameTextBox = By.xpath("//input[@name='username']");
	By passwordTextBox = By.xpath("//input[@name='password']");
	By loginButton = By.xpath("//input[@value='Log In']");
	
	public void loginPara(String uname, String pword) {
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTextBox));
		username.sendKeys(uname);
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBox));
		password.sendKeys(pword);
		driver.findElement(loginButton).click();
		
	}
	
	

}
