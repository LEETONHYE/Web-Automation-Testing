package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPagePO {

	
	public WebDriver driver;
	public LoginPagePO(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}

	By frame=By.xpath("//iframe[@id='alibaba-login-box']");
	By username=By.cssSelector("#fm-login-id");
	By password=By.cssSelector("#fm-login-password");
	By submit=By.cssSelector("#fm-login-submit");
	
	public WebElement frame() {
		return (WebElement) driver.switchTo().frame(driver.findElement(frame));
	}
	
	public WebElement username() {
		return driver.findElement(username);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement submit() {
		return driver.findElement(submit);
	}
	
	
}
