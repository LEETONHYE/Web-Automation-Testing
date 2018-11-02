package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmPagePO {
	public WebDriver driver;
	public ConfirmPagePO(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}

	By email=By.xpath("//div[@class='email-control email-field']//input[@name='email']");
	By CName=By.xpath("//input[@name='contactPerson']");
	By country=By.xpath("//select[@name='country']");
	By address=By.xpath("//input[@placeholder='Street address']");
	By state=By.xpath("//div[contains(@class,'sa-province-wrapper')]/select");
	By city=By.xpath("//div[contains(@class,'sa-city-wrapper')]/select");
	By zip=By.xpath("//input[@name='zip']");
	By mobile=By.xpath("//input[@name='mobileNo']");
	By save=By.xpath("//a[@class='ui-button ui-button-primary ui-button-medium sa-confirm']");
	

	public WebElement email() {
		return driver.findElement(email);
	}
	public WebElement CName() {
		return driver.findElement(CName);
	}
	public WebElement country() {
		return driver.findElement(country);
	}

	public WebElement address() {
		return driver.findElement(address);
	}
	public WebElement state() {
		return driver.findElement(state);
	}
	public WebElement city() {
		return driver.findElement(city);
	}
	public WebElement zip() {
		return driver.findElement(zip);
	}
	public WebElement mobile() {
		return driver.findElement(mobile);
	}
	public WebElement save() {
		return driver.findElement(save);
	}
	
}
