package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

	private WebElement element = null;

	public MainPage(WebDriver driver) {
		super(driver);
	}

	public WebElement nameInput() {

		this.element = this.driver.findElement(By.cssSelector("input[name='name']"));

		return this.element;

	}

	public WebElement passworsInput() {

		this.element = this.driver.findElement(By.cssSelector("input[name=\"password\"]"));

		return this.element;

	}

	public WebElement ageInput() {

		this.element = this.driver.findElement(By.cssSelector("input[name=\"age\"]"));

		return this.element;

	}

	public WebElement registerButton() {

		this.element = this.driver.findElement(By.cssSelector("input[type=\"submit\"]"));

		return this.element;

	}

}
