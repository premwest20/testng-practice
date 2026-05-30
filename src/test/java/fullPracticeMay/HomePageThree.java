package fullPracticeMay;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageThree {

	WebDriver driver;
	WebDriverWait wait;
	
	public HomePageThree(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	
	String showTextBoxExpectedText = "Rafa"; 
	String showTextBoxActualText = "";
	
	By showButton = By.id("show-textbox");
	By showExampleTextBox = By.cssSelector("#displayed-text");
	
	
	
	
	public void homepagethree() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//scroll
		js.executeScript("window.scrollBy(0, 500)");
		Long scrollPosition = (long) js.executeScript("return window.pageYOffset;");
		System.out.println(scrollPosition);
		
		//ShowButton click to enable textbox using JS
		WebElement showButtonElement = wait.until(ExpectedConditions.elementToBeClickable(showButton));
		WebElement fTable = driver.findElement(By.id("product"));
		js.executeScript("arguments[0].click();", showButtonElement);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(showExampleTextBox)).sendKeys(showTextBoxExpectedText);
		WebElement showTextBox = driver.findElement(showExampleTextBox);
		js.executeScript("arguments[0].value='Rafa';", showTextBox);
		showTextBoxActualText = driver.findElement(showExampleTextBox).getDomProperty("value");
		if(showTextBoxActualText.equals(showTextBoxExpectedText)) {
			System.out.println("Success");
		}else {
			System.out.println("Failure");
		}
		
		//scroll to section
		js.executeScript("arguments[0].scrollIntoView()", fTable);
		
		//Page refresh
		js.executeScript("history.go(0)");
		
		//scroll to bottom
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		//scroll to top
		js.executeScript("window.scrollTo(0,0)");
		
	}

}
