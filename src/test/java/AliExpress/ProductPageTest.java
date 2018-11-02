package AliExpress;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.ConfirmPagePO;
import PageObjects.HomePagePO;
import PageObjects.productPagePO;
import resources.base;

public class ProductPageTest extends base{

public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
	driver=initializblicedriver();
	driver.get(pro.getProperty("url"));
	log.info("successfully initialized");
	int cct=driver.findElements(By.cssSelector(".newuser-container")).size();
	if(cct>0) {
		driver.findElement(By.cssSelector(".close-layer")).click();
	}
	}
	
	@Parameters({"email","name","address","mobile","zip"})
	@Test
	public void productselection(String emails, String names, String addresses, String mobiles, String zips) throws InterruptedException {
		//choose item from categories
		HomePagePO hp=new HomePagePO(driver);
		hp.catag().click();
		Actions a=new Actions(driver);
		a.moveToElement(hp.mencloth()).build().perform();
		hp.parkas().click();
		log.info("go to product info page");
		
		productPagePO pdc=new productPagePO(driver);
		WebDriverWait d=new WebDriverWait(driver,20);
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'HANQIU Winter Jacket Men 2018 Stand Collar Male So')]")));
		pdc.choice().click();
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		it.next();
		driver.switchTo().window(it.next());
		log.info("go to detailed page");
		
		pdc.color().click();
		pdc.size().click();
		pdc.add().click();
		pdc.goon().click();
		pdc.buy().click();
		log.info("go to conformation page");
		
		ConfirmPagePO cp=new ConfirmPagePO(driver);
		cp.email().sendKeys(emails);
		cp.CName().sendKeys(names);
		Select sc=new Select(cp.country());
		sc.selectByIndex(2);
		cp.address().sendKeys(addresses);
		Select ss=new Select(cp.state());
		ss.selectByIndex(6);
		Thread.sleep(5000L);
		Select sct=new Select(cp.city());
		sct.selectByIndex(7);
		cp.zip().sendKeys(zips);;
		cp.mobile().sendKeys(mobiles);
		cp.save().click();
		log.info("go to conform and pay");
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
		driver=null;
	}
	
}
