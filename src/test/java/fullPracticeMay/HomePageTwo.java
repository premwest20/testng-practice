package fullPracticeMay;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageTwo {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public HomePageTwo(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		}
	
	String expectedPriceAppium = "30";
	String actualPriceAppium = " ";
	By appiumPrice = By.xpath("//table[@id = 'product']//tr[td[contains(text(), 'Appium')]]/td[3]");
	By webTable = By.xpath("//table[@id = 'product']/tbody/tr");
	By iframeElement = By.id("courses-iframe");
	By iframeRegisterLink = By.xpath("//a[contains(text(), 'Register')]");
	By fixedWebTable = By.cssSelector("#product");
	By fixedWebTableRows = By.xpath("//div[@class = 'tableFixHead']//tr");
	
	public void practicePageTwo() {
		
		//WebTable
		actualPriceAppium = wait.until(ExpectedConditions.visibilityOfElementLocated(appiumPrice)).getText();
		System.out.println(actualPriceAppium);
		if(actualPriceAppium.equals(expectedPriceAppium)) {
			System.out.println("Correct Price for Appium");
		}else {
			System.out.println("Incorrect Price for Appium");
		}
		
		//printTable
		//We are going with rows first cause in DOM it is rows followed by columns
		List<WebElement> rows = driver.findElements(webTable);		
		for(WebElement row : rows) {			
			List<WebElement> cols = row.findElements(By.tagName("td"));			
				for(WebElement col : cols) {
					System.out.print(col.getText() +  " ");
			}
		System.out.println();
		}
		
		//count rows and columns
		rows.size();
		System.out.println("Rows count is " + rows.size());		
		List<WebElement> columns = rows.get(0).findElements(By.tagName("td"));
		System.out.println("Columns count is " + columns.size());
		
		//iframe
		WebElement iframeWebElement = driver.findElement(iframeElement);
		driver.switchTo().frame(iframeWebElement);
		wait.until(ExpectedConditions.elementToBeClickable(iframeRegisterLink)).click();
		driver.switchTo().defaultContent();
		
		//fixedWebTable
		//WebElement fixedTable = wait.until(ExpectedConditions.visibilityOfElementLocated(fixedWebTable));
		List<WebElement> rowsFixedTable = driver.findElements(fixedWebTableRows);
		for(WebElement r : rowsFixedTable) {
			List<WebElement> colsFixedTable = r.findElements(By.tagName("td"));
			for(WebElement c : colsFixedTable) {
				System.out.print(c.getText() + " ");
			}
			System.out.println(r.getText());
		}
		
		//counting FixedWebTable
		rowsFixedTable.size();
		System.out.println("Fixed table row count is " + rowsFixedTable.size());
		List<WebElement> columnsFixedTable = rowsFixedTable.get(1).findElements(By.tagName("td"));
		System.out.println("Fixed table column count is " + columnsFixedTable.size());
		
	}

}
