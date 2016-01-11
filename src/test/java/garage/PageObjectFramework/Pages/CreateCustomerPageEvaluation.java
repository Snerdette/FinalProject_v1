package garage.PageObjectFramework.Pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import garage.SeleniumFramework.TestPageObject;
import garage.utility.SeleniumConstants;

public class CreateCustomerPageEvaluation extends TestPageObject{

	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	public String generateString = SeleniumConstants.generateString();
	
	@Test
	public void navigateToCreateNewCustomerPage(){
		driver.get(URL + "/");	
	
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.id("createCustomer"))).click();
		/*driver.findElement(By.id("createCustomer")).click();*/

		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(("http://localhost:8080/#/createCustomer"), URL );
	}
	
	/*@Test
	public void addNewCustomerWithValidInformation(){
		driver.get(URL + "/#/createCustomer");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		new WebDriverWait(driver, 180).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button")));
		 
		String aURL = driver.getCurrentUrl();

	    Assert.assertEquals(aURL, (URL  + "/#/home"));
	}*/
}
