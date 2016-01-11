package garage.PageObjectFramework.Pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import garage.SeleniumFramework.TestPageObject;
import garage.utility.SeleniumConstants;

public class HomePageEvaluation extends TestPageObject{

	public SeleniumConstants seleniumConstants = new SeleniumConstants();
	public String URL = seleniumConstants.getUrl();
	public String generateString = SeleniumConstants.generateString();

	@Test
	public void testBasicNavigationOnLoadToHomePage(){
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
        String URL = driver.getCurrentUrl();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        Assert.assertEquals(("http://localhost:8080/#/home"), URL );
	}
}
