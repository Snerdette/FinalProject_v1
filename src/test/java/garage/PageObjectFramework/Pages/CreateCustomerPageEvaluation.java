package garage.PageObjectFramework.Pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import garage.SeleniumFramework.TestPageObject;
import garage.SeleniumFramework.Pages.CreateCustomerPage;
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
		CreateCustomerPage customer = new CreateCustomerPage(driver);
		customer.sendKeys(By.id("firstName"), "Scotty");
		customer.sendKeys(By.id("lastName"), "Magoo");
		customer.sendKeys(By.id("email"), "dummy@gmail.com");
		customer.click(By.id("submit"));
		 
		String aURL = driver.getCurrentUrl();

	    Assert.assertEquals(aURL, (URL  + "/#/home"));
	}*/
}
