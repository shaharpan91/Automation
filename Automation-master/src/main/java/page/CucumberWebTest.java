package page;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CucumberWebTest {

	public static WebDriver driver;
	
	public WebDriver getDriver()
	{
		String browserName = getPropertiesValue("browser");
		
		if (browserName.equalsIgnoreCase("firefox"))
		{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//test//java//resources//driver//geckodriver.exe");
				driver = new FirefoxDriver();
				return driver;
		}
		else if(browserName.equalsIgnoreCase("internetExplorer"))
			{
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "//src//test//java//resources//driver//IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				return driver;
			}
		else
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//java//resources//driver//chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options);
				return driver;
			}
		}
	
	/**
	 * This method is used to load all properties file
	 * 
	 * @return properties
	 * @throws Exception
	 */
	public Properties loadProperties() throws Exception
	{
		File folder = new File("src\\test\\java\\config");
		File[] listOfFiles = folder.listFiles();
		FileReader reader;
		Properties p = new Properties();
		for (File file : listOfFiles)
		{
			if (file.isFile())
			{
				reader = new FileReader(file);
				p.load(reader);
			}
		}
		return p;
	}
	
	/**
	 * This method is used to get property value based on key
	 * 
	 * @param key
	 * @return String value
	 */
	public String getPropertiesValue(String key)
	{
		String value = "";
		try
		{
			Properties p = loadProperties();
			value = p.getProperty(key);
		} catch (Exception e)
		{
			System.out.println("Unable to get Properties Value for key : " + key + " " + e);
		}
		return value;
	}
}
