package fullPracticeMay;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePageFive {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePageFive(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	String expectedText = "Rafa";
	
	By dropdownId = By.cssSelector("#dropdown-class-example");
	By alertButton = By.xpath("//input[@id='alertbtn']");
	By alertTextBox = By.id("name");
	By windowButton = By.cssSelector("#openwindow");	
	By frame = By.xpath("//iframe[@id='courses-iframe']");
	By frameImage = By.xpath("//div[@class='pull-left logo-outer']//img[@src='assets/images/rs_logo.png']");
	
	public void homepagefive() {
		
		//DropDown
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownId));
		Select select = new Select(dropdown);
		select.selectByValue("option2");
		
		//Alerts
		WebElement alertText = wait.until(ExpectedConditions.visibilityOfElementLocated(alertTextBox));
		alertText.sendKeys(expectedText);		
		Actions action = new Actions(driver);
		action.click(driver.findElement(alertButton)).perform();		
		Alert alert = driver.switchTo().alert();
		String actualText = alert.getText();
		System.out.println(actualText);
		if(actualText.contains(expectedText)) {
			System.out.println("Passed");
			alert.accept();
		}else {
		System.out.println("Failed");
		alert.dismiss();
		}
		
		
		//Window
		String parentWindow = driver.getWindowHandle();
		WebElement openWindowButton = wait.until(ExpectedConditions.elementToBeClickable(windowButton));
		openWindowButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Set<String> windows = driver.getWindowHandles();
		for(String window : windows) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
	//For Switching to specific window
//				String title = driver.getTitle();
//				if(title.contains("Dravidam")) {
//					break;
//				}
//	//For Switching to specific window using List
//				List<String> windowsList = new ArrayList<>(windows);
//				driver.switchTo().window(windowsList.get(0));
				String currentUrl = driver.getCurrentUrl();
				System.out.println(currentUrl);
				Assert.assertTrue(driver.getCurrentUrl().contains("academy"));
			}
		}
		driver.close();
		driver.switchTo().window(parentWindow);		
		
		//frames
		
		WebElement frameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(frame));
		driver.switchTo().frame(frameElement);
		Assert.assertTrue(driver.findElement(frameImage).isDisplayed());
		driver.switchTo().parentFrame();//switches to previous frame
		wait.until(ExpectedConditions.visibilityOfElementLocated(alertButton));
		
		//Git Revert Practice
		
		//Git Reset Practice
		
		//Git Reset Practice Proper one
		
	}
}
