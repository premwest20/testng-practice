package fullPracticeMay;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePageFour {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePageFour(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	By suggestTextBoxElement = By.xpath("//input[@type='text' and @id='autocomplete']");
	By webTable = By.id("product");
	By rows = By.xpath("//table[@id='product']/tr");
	By cols = By.xpath("//table[@id='product']/tr/td");
	
	
	public void homepagefour() throws IOException {
		
		//TextBox using Keys
		WebElement suggestTextBox = wait.until(ExpectedConditions.elementToBeClickable(suggestTextBoxElement));
		suggestTextBox.sendKeys(Keys.BACK_SPACE);
		Actions action = new Actions(driver);
		action.keyDown(Keys.SHIFT).sendKeys("rafa").keyUp(Keys.SHIFT).sendKeys(" - Vamos").perform();
		String actualText = suggestTextBox.getDomProperty("value");
		System.out.println(actualText);
		
		//WebTableRevision
		//WebElement rows = driver.findElement(By.xpath("//input[@id='product']/tr)"));
		List<WebElement> rowsData = driver.findElements(rows); 
		for(WebElement row : rowsData) {
			List<WebElement> colsData = row.findElements(cols);
			for(WebElement col : colsData) {
				System.out.print(col.getText() + " ");
			}
			System.out.println(row.getText());
		}
		
		//screenshot
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("/Users/premw/eclipse-workspace/testng-framework//src/test.png");
		FileUtils.copyFile(source, destination);
		System.out.println(destination.getAbsolutePath());
		
	}

}
