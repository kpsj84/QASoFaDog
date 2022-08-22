package Memberse.AndroidAutomation;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.ProfileMenuPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import SoFaDog.AndroidAutomation.Utilities.Direction;

public class aLogoutTest extends Base {
	
	@Test
	public void aLogoutTestCase() throws InterruptedException {
				Utilities u = new Utilities(driver);
				u.DirectToLoginOptionPage();
				
				String userNumber = "aA40";
				String userName = "AutoUser"+userNumber;
				String emailId = "autouser"+userNumber;
				String emailDomain = "@yopmail.com";
				String email = emailId+emailDomain;
				String password = emailId;
				
				LoginOptionPage lop = new LoginOptionPage(driver);
				lop.signinWithEmail().sendKeys(email);
				lop.EmailPassword().sendKeys(password);
				lop.LoginButton().click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				AppMenus am = new AppMenus(driver);
				am.ProfileMenu().click();
				Thread.sleep(3000);
				
				u.swipeScreen(Direction.UP);
				
				ProfileMenuPage pmp = new ProfileMenuPage(driver);
				pmp.Logout().click();
				
				driver.findElementByXPath("//android.widget.Button[@text='YES']").click();
				Thread.sleep(5000);
				System.out.println(userName + "Logout Test Case Pass");		
	}

}