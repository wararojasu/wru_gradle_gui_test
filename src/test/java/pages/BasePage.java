package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	public WebDriver driver;
	public boolean bResult;

	public BasePage(WebDriver driver){
		this.driver = driver;
		this.bResult = true;
	 }
}
