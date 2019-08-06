package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.MainPage;
import pages.UserInfoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import java.util.HashMap;
import java.util.Map;

public class MySteps {

	public static WebDriver driver;
	public Map<String, String> map = new HashMap<String, String>();

	@Given("^I open my DevOps practice web page$")
	public void openWebPage() throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("disable-gpu");
        chromeOptions.addArguments("window-size=1200x600");
		driver = new ChromeDriver(chromeOptions);
		driver.get("http://192.168.229.138:8787/wru_gradle/index.jsp");
		System.out.println(driver.getTitle());
		System.out.println("driver=" + driver);
	}

	@When("^I enter my name \"([^\"]*)\"$")
	public void enterName(String arg1) throws Throwable {
		System.out.println("driver=" + this.driver);
		map.put("user_name", arg1);
		MainPage main = new MainPage(this.driver);
		WebElement element = main.nameInput();
		element.sendKeys(arg1);
	}

	@When("^I enter my password \"([^\"]*)\"$")
	public void enterPasword(String arg1) throws Throwable {
		map.put("user_password", arg1);
		MainPage main = new MainPage(this.driver);
		WebElement element = main.passworsInput();
		element.sendKeys(arg1);
	}

	@When("^I enter my age \"([^\"]*)\"$")
	public void enterAge(String arg1) throws Throwable {
		map.put("user_age", arg1);
		MainPage main = new MainPage(this.driver);
		WebElement element = main.ageInput();
		element.sendKeys(arg1);
	}

	@When("^I click on Register button$")
	public void clickOnRegister() throws Throwable {
		MainPage main = new MainPage(this.driver);
		WebElement element = main.registerButton();
		element.click();
	}

	@Then("^I see all my info registered$")
	public void seeInfoRegistered() throws Throwable {
		UserInfoPage user = new UserInfoPage(this.driver);
		boolean element = user.userInfoText(map);
		Assert.assertEquals(element, true);
		driver.quit();
	}
	
	@Then("^I see my name registered$")
	public void seeNameRegistered() throws Throwable {
		UserInfoPage user = new UserInfoPage(this.driver);
		String findName = map.get("user_name");
		boolean element = user.userNameText(findName);
		Assert.assertEquals(element, true);
		driver.quit();
	}
	
	@Then("^I see my password registered$")
	public void seePasswordRegistered() throws Throwable {
		UserInfoPage user = new UserInfoPage(this.driver);
		String findName = map.get("user_password");
		boolean element = user.userPasswordText(findName);
		Assert.assertEquals(element, true);
		driver.quit();
	}
	
	@Then("^I see my age registered$")
	public void iseeAgeRegistered() throws Throwable {
		UserInfoPage user = new UserInfoPage(this.driver);
		String findName = map.get("user_age");
		boolean element = user.userAgeText(findName);
		Assert.assertEquals(element, false);
		driver.quit();
	}	  
}
