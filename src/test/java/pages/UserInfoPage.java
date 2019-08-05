package pages;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserInfoPage extends BasePage {

	private WebElement element = null;

	public UserInfoPage(WebDriver driver) {
		super(driver);
	}

	public boolean userInfoText(Map<String, String> map) {
		boolean exist = true;
		try {
			exist = userNameText(map.get("user_name"));
			exist = userPasswordText(map.get("user_password"));
			exist = userAgeText(map.get("user_age"));
		} catch (NoSuchElementException e) {
			exist = false;
		}
		return exist;
	}

	public boolean userAgeText(String toReplace) {
		boolean exist = true;
		try {
			String selector = "//h2[contains(text()[3], \"$(user_info)\")]";
			String replaceSelector = selector.replace("$(user_info)", toReplace);
			this.element = this.driver.findElement(By.xpath(replaceSelector));		
		} catch (NoSuchElementException e) {
			exist = false;
		}
		return exist;
	}
	
	public boolean userNameText(String toReplace) {
		boolean exist = true;
		try {
			String selector = "//h2[contains(text() , \"$(user_info)\")]";
			String replaceSelector = selector.replace("$(user_info)", toReplace);
			this.element = this.driver.findElement(By.xpath(replaceSelector));		
		} catch (NoSuchElementException e) {
			exist = false;
		}
		return exist;
	}
	
	public boolean userPasswordText(String toReplace) {
		boolean exist = true;
		try {
			String selector = "//h2[contains(text()[2], \"$(user_info)\")]";
			String replaceSelector = selector.replace("$(user_info)", toReplace);
			this.element = this.driver.findElement(By.xpath(replaceSelector));		
		} catch (NoSuchElementException e) {
			exist = false;
		}
		return exist;
	}	
}
