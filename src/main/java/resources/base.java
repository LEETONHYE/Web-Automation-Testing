package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class base {
	public static WebDriver driver;
	public Properties pro;
	public WebDriver initializblicedriver() throws IOException {
		pro= new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\52456\\WebTesting\\src\\main\\java\\resources\\data.properties");
		pro.load(fis);
		String browserName=pro.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Study\\selenium\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Study\\selenium\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Study\\selenium\\MicrosoftWebDriver.exe");
			driver= new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void screenshots(String result ) throws IOException {
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:\\Study\\selenium\\"+result+"screenshot.png"));
	}
	
}
