package Memberse.AndroidAutomation;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import MembersePageObjects.CreatePostPage;
import MembersePageObjects.HomePage;
import MembersePageObjects.LoginOptionPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class aCreatePhotoPostTest extends Base {
	
	@Test
	public void aCreatePhotoPostTestCase() throws InterruptedException, IOException {
		Utilities u = new Utilities(driver);
		u.DirectToLoginOptionPage();
		
		String userNumber = "c6";
		String emailId = "kqatest"+userNumber;
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		lop.signinWithEmail().sendKeys(email);
		lop.EmailPassword().sendKeys(password);
		lop.RevealPassword().click();
		lop.LoginButton().click();
		Thread.sleep(10000);
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//android.widget.TextView[@text='Close']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(1000);
		
		HomePage hp = new HomePage(driver);
		hp.createPost().click();
		Thread.sleep(2000);
		
    	String autotext=getSaltString();
  		System.out.println(autotext);
  		
  		CreatePostPage cpp = new CreatePostPage(driver);
  		cpp.postTitle().sendKeys("Auto Generated Text Post - " +autotext);
        cpp.postDescription().sendKeys("This is an Auto-QA Post Description");
        Thread.sleep(2000);
        cpp.membersOnlyToggle().click();
        Thread.sleep(2000);
        
        cpp.photoButton().click();
        Thread.sleep(2000);
        driver.findElementByXPath("//android.widget.TextView[@text='Pick from Library']").click(); 
        driver.pushFile("/sdcard/Download/Pic22.jpg", new File(System.getProperty("user.dir") + "/src/Pic22.jpg"));
        Thread.sleep(45000);														//Wait for download folder appear on screen
        driver.pressKey(new KeyEvent(AndroidKey.ENTER)); 							//Focus comes to the current UI, Browserstack have default folders and files in it
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER)); 							//Enters into first folder visible on screen
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.ViewGroup[@index='1']").click(); //Selects the first picture from that folder
        Thread.sleep(3000);
        
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.TextView").click();
        Thread.sleep(10000);
        
        WebDriverWait w = new WebDriverWait(driver,90);
        w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button")));
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button").click();
		
		String Text = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[1]").getText();
        System.out.println(Text);
		Assert.assertEquals(Text,"Auto Generated Text Post - " +autotext);
    }
	
	    public String getSaltString() {
		String SALTCHARS="369852147";
		StringBuilder salt= new StringBuilder();
		   Random rnd =new Random();
		   while(salt.length() < 4) {//length of the random string.
			   int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			   salt.append(SALTCHARS.charAt(index));
		   }
		   String saltStr= salt.toString();
		   return saltStr;    
	}

}
