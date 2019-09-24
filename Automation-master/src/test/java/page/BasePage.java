package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	
	public static WebDriver driver;
	
	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver",  
				System.getProperty("user.dir") + "//src//test//java//resources//driver//chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				return driver;
	}
	

}
