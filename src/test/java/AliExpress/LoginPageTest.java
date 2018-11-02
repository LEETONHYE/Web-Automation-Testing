package AliExpress;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePagePO;
import PageObjects.LoginPagePO;
import resources.base;


public class LoginPageTest extends base {
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
	driver=initializblicedriver();
	log.info("driver successfully invoked");
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String password,String text) throws IOException {
		
		driver.get(pro.getProperty("url"));
		log.info("url is reached");
		int cct=driver.findElements(By.cssSelector(".newuser-container")).size();
		if(cct>0) {
			driver.findElement(By.cssSelector(".close-layer")).click();
		}
		//create to that class and invoke methods of it
		HomePagePO lp=new HomePagePO(driver);
		lp.signIn().click();
		LoginPagePO lgp=new LoginPagePO(driver);
		lgp.driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='alibaba-login-box']")));
		lgp.username().sendKeys(username);
		lgp.password().sendKeys(password);
		//System.out.println(text);
		log.info(text);
		lgp.submit().click();
		lgp.driver.switchTo().defaultContent();
		log.info("finish login twice");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
	
	
	
	@DataProvider
	public Object[][] getData(){
		//rows stand for how many times you gonna run
		//columns stand for how many values are you passing
		Object[][] data=new Object[2][3];
		
		data[0][0]="123@gmail.com";
		data[0][1]="123456";
		data[0][2]="limited user";
		
		data[1][0]="456@yahoo.com";
		data[1][1]="789000";
		data[1][2]="full user";
		return data;
		
	}
	
	
	
	
}
