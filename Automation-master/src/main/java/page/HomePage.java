package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
	
    public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean success(WebDriver driver) throws Throwable {
    	String exp_message = "You are on amazon.com. You can also shop on Amazon Germany for millions of products with fast local delivery.";
    	String actual = driver.findElement(By.cssSelector(".a-size-base.a-color-base")).getText();
    	if(exp_message.equalsIgnoreCase(actual))
    	{
    		return true;
    	}
    	return false;
//    	Assert.assertEquals(exp_message, actual);
    }
}
