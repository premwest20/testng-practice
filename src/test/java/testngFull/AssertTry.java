package testngFull;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test
public class AssertTry {
	
	public void updateCli() {
		int actualCli = 100;
		int expectedCli = 100;
		
		Assert.assertEquals(actualCli, expectedCli);
		
		System.out.println("CLI updated successfully");
		
		SoftAssert soft = new SoftAssert();
		
		soft.assertEquals(500, 500);
		soft.assertEquals(1, 0);
		
		System.out.println("This would still print");
		
		soft.assertAll();
	}

}
