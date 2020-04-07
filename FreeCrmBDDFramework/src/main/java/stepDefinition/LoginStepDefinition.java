package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition {
	WebDriver driver;

	@Given("^User is already on login Page$")
	public void user_is_already_on_login_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"E:/TMS OPEN SOURCE PROJECT/FreeCrmBDDFramework/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://freecrm.co.in/");

	}

	@When("^Title of the login page is Free CRM$")
	public void title_of_the_login_page_is_Free_CRM() throws Throwable {
		String title = driver.getTitle();
		System.out.println("Login page title is" + " :" + title);
		Assert.assertEquals("Free CRM #1 cloud software for any business large or small", title);

	}
	//============================================================================================================
/*//username and password hardcoded
	@Then("^User enters Username and Password$")
	public void user_enters_Username_and_Password() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement login = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'Log In')]"))));
		// driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
		login.click();
		driver.findElement(By.xpath("//input[@placeholder='E-mail address']")).sendKeys("rakeshit0913@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Qualix2019");
		Thread.sleep(1000);
	}
	*/
	//============================================================================================================
	
	//============================================================================================================
	//Data driven testing with and without using Examples keywords
	@Then("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_Username_and_Password(String userName,String password) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement login = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'Log In')]"))));
		// driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
		login.click();
		driver.findElement(By.xpath("//input[@placeholder='E-mail address']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		Thread.sleep(1000);
	}
	
	//============================================================================================================
	@Then("^User clicks on Login Button$")
	public void user_clicks_on_Login_Button() throws Throwable {
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
	}

	@And("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		String homePageTitle = driver.getTitle();
		System.out.println("Home page title is" + " :" + homePageTitle);
		Assert.assertEquals("Cogmento CRM", homePageTitle);

	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}

}
