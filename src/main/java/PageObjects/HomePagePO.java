package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePagePO {

	
	public WebDriver driver;
	public HomePagePO(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}

	
	By signIn=By.linkText("Sign in");
	By NavBar=By.cssSelector("#nav-global");
	By searchBar=By.cssSelector("#search-key");
	By catag=By.xpath("//span[contains(text(),'CATEGORIES')]");
	By mencloth=By.xpath("//dl[@class='cl-item cl-item-men']/dt/span");
	By parkas=By.xpath("//dd[@data-path=\"c-men-content\"]/div/div/div[2]/dl/dd/a[text()='Parkas']");
	public WebElement signIn() {
		return driver.findElement(signIn);
	}
	
	public WebElement NavigationBar() {
		return driver.findElement(NavBar);
	}
	
	public WebElement searchBar() {
		return driver.findElement(searchBar);
	}
	
	public WebElement catag() {
		return driver.findElement(catag);
	}
	
	public WebElement mencloth() {
		return driver.findElement(mencloth);
	}
	
	public WebElement parkas() {
		return driver.findElement(parkas);
	}
}
