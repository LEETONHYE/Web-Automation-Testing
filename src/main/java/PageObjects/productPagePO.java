package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class productPagePO {

	public WebDriver driver;
	public productPagePO(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}
	
	By choice=By.xpath("//a[contains(text(),'HANQIU Winter Jacket Men 2018 Stand Collar Male So')]");
	By color=By.xpath("//img[@title='Blue']");
	By size=By.xpath("//a[@id='sku-2-361385']");
	By add=By.cssSelector("#j-add-cart-btn");
	By goon=By.xpath("//a[@data-role='undefined']");
	By buy=By.xpath("//input[@title='Buy All']");
	
	public WebElement choice() {
		return driver.findElement(choice);
	}
	public WebElement color() {
		return driver.findElement(color);
	}
	public WebElement size() {
		return driver.findElement(size);
	}
	public WebElement add() {
		return driver.findElement(add);
	}
	public WebElement goon() {
		return driver.findElement(goon);
	}
	public WebElement buy() {
		return driver.findElement(buy);
	}
}
