package fullPracticeMay;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class HomePage {	
	
	private WebDriver driver;
	private WebDriverWait wait;

	public HomePage(WebDriver driver, WebDriverWait wait) {		
		this.driver = driver;
		this.wait = wait;
	}
	
	String name = "VyPrem";
	String expectedTextTab = "qaclickacademy.com";
	String actualTextTab = " ";
	String expectedWindow = "https://www.qaclickacademy.com/lander";
	String actualWindow = " ";
	
	By practicePageWebElement = By.xpath("//h1[text()='Practice Page']");
	By radioTwo = By.xpath("//input[@value='radio2']");	
	By dropdown = By.id("dropdown-class-example");
	By mouseHover = By.cssSelector("#mousehover");
	By hoverTopLink = By.xpath("//a[text() ='Top']");
	By suggestionTextBox = By.id("autocomplete");
	By argentinaSuggestion = By.xpath("//div[text() = 'Argentina']");
	By textAlertTextBox = By.xpath("//input[@id='name']");
	By alertButton = By.cssSelector("#alertbtn");
	By openTabButton = By.cssSelector("#opentab");
	//By newTabText = By.xpath("//div[contains(text(), 'ParkwebGetDomain')]");
	By openWindowButton = By.cssSelector("#openwindow");
	
	
	
	public void practicePage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(practicePageWebElement));
		wait.until(ExpectedConditions.elementToBeClickable(radioTwo)).click();
		
		WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown));
		Select select = new Select(dropdownElement);
		select.selectByValue("option1");
		
		Actions action = new Actions(driver);
		WebElement mouseHoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mouseHover));
		action.moveToElement(mouseHoverElement).perform();
		WebElement hoverTop = wait.until(ExpectedConditions.visibilityOfElementLocated(hoverTopLink));
		action.click(hoverTop).perform();
		
		//SuggestionTextBox
		wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionTextBox)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionTextBox)).sendKeys("Ar");
		wait.until(ExpectedConditions.visibilityOfElementLocated(argentinaSuggestion)).click();
		
		//Alert
		wait.until(ExpectedConditions.visibilityOfElementLocated(textAlertTextBox)).sendKeys(name);
		wait.until(ExpectedConditions.elementToBeClickable(alertButton)).click();
		Alert a = driver.switchTo().alert();
		String alertName = a.getText();
		if(alertName.contains(name)) {
			System.out.println("Alert is good");
			a.accept();
		}else {
			System.out.println("Alert is not as expected");
			a.dismiss();
		}
		
		String parentWindow = driver.getWindowHandle();	
		
		//Tab
		wait.until(ExpectedConditions.elementToBeClickable(openTabButton)).click();
		Set<String> tabs = driver.getWindowHandles();
		for(String tab : tabs) {
			driver.switchTo().window(tab);
		//actualTextTab = wait.until(ExpectedConditions.visibilityOfElementLocated(newTabText)).getText();
			actualTextTab = driver.getCurrentUrl();
		}
		if(actualTextTab.contains(expectedTextTab)) {
			System.out.println("Passed Tab");
		}else {
			System.out.println("Failed Tab");
		}		
		driver.switchTo().window(parentWindow);
		
		//Window
		wait.until(ExpectedConditions.elementToBeClickable(openWindowButton)).click();
		Set<String> windows = driver.getWindowHandles();
		for(String window : windows) {
			if(!window.equals(parentWindow)) {
			driver.switchTo().window(window);
			actualWindow = driver.getCurrentUrl();
			System.out.println(actualWindow);
			}
		}
		if(actualWindow.contains(expectedWindow)) {
			System.out.println("Passed Window");
		}else {
			System.out.println("Failed Window");
			
		}
		
		
		
	}

}
