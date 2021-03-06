package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppMenus {
	
	public AppMenus(AppiumDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//*[@content-desc=', tab, 2 out of 5']")
	private WebElement ExploreMenu;
	
	public WebElement ExploreMenu() {
		return ExploreMenu;
	}
	
	@AndroidFindBy(xpath="//*[@content-desc=', tab, 3 out of 5']")
	private WebElement CreatorMenu;
	
	public WebElement CreatorMenu() {
		return CreatorMenu;
	}
	
	@AndroidFindBy(xpath="//*[@content-desc=', tab, 5 out of 5']")
	private WebElement ProfileMenu;
	
	public WebElement ProfileMenu() {
		return ProfileMenu;
	}

}
