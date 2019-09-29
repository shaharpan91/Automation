package base;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.CucumberWebTest;
import page.HomePage;
import page.LoginPage;

public class StepDefination extends CucumberWebTest
{
	WebDriver driver = getDriver();
	LoginPage loginPage = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
		
	@Given("^user is on homepage which is \"([^\"]*)\"$")
	public void user_is_on_homepage_which_is(String url) throws Throwable {
		driver.get(url);
	}

	@When("^user navigates to Login Page$")
	public void user_navigates_to_Login_Page() throws Throwable {
		loginPage.navigate_to(driver);
	}
	
	@And("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void userEntersAnd(String username, String password) throws Throwable {
		loginPage.loginCrenditial(driver, username, password);
	}
	
	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
		Assert.assertTrue(homePage.success(driver));
	}
	
	@And("^user go to logout button$")
	public void userClickLogoutButton() throws Throwable {
		loginPage.userLogout(driver);
	}
	
	@Before()
	public void beforeScenario()
	{
		System.out.println("Scenario execution is started");
	}
	
	@After()
	public void afterScenario(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			System.out.println("Scenario status : Failed");
		}
	}

}

