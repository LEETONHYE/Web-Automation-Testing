package AliExpress;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePagePO;

import resources.base;

public class HomePageTest extends base{

public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
	driver=initializblicedriver();
		driver.get(pro.getProperty("url"));
		log.info("driver successfully initialized");
		int cct=driver.findElements(By.cssSelector(".newuser-container")).size();
		if(cct>0) {
			driver.findElement(By.cssSelector(".close-layer")).click();
		}
	}
	
	@Test
	public void validate() throws IOException {
		
	
		//validate Nav bar
		HomePagePO lp=new HomePagePO(driver);
		Assert.assertTrue(lp.NavigationBar().isDisplayed());
		log.info("NavigationBar is successfully displayed");
		//validate search bar
		lp.searchBar().sendKeys(Keys.ENTER);
		lp.	driver.navigate().back();
		log.info("search bar is accessible");
	}
	
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
	
}
