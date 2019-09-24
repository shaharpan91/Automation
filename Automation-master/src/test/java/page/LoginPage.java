package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	@FindBy(xpath = "//div[@id='nav-signin-tooltip']//span[text()='Sign in']")
	WebElement signInButtton;
	
    public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
    	//super(driver);
    	//this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigate_to(WebDriver driver)  {
        //driver.findElement(By.linkText("Sign in")).click();
    	//driver.findElement(By.id("nav-link-accountList")).click();
		signInButtton.click();
    }
    
    public void loginCrenditial(WebDriver driver, String username, String password) throws Throwable {
    	driver.findElement(By.id("ap_email")).sendKeys(username);
       driver.findElement(By.id("ap_password")).sendKeys(password);
       driver.findElement(By.id("signInSubmit")).click();   
    }
    
	public void userLogout(WebDriver driver) throws Throwable {
		Actions actions = new Actions(driver);
		WebElement list = driver.findElement(By.id("nav-link-accountList"));
		actions.moveToElement(list).perform();
		WebElement signout = driver.findElement(By.id("nav-item-signout")); //xPath = "//*[@id="nav-item-signout"]"
		WebDriverWait wait = new WebDriverWait(driver, 20, 2);
		wait.until(ExpectedConditions.elementToBeClickable(signout)); 
		signout.click();
		driver.quit();
	}

}