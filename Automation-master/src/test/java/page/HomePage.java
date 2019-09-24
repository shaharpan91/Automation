package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public HomePage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
	}

	public void success(WebDriver driver) throws Throwable {
    	String exp_message = "You are on amazon.com. You can also shop on Amazon Germany for millions of products with fast local delivery.";
    	String actual = driver.findElement(By.cssSelector(".a-size-base.a-color-base")).getText();
    	Assert.assertEquals(exp_message, actual);
    }
}
