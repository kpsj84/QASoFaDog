package Memberse.AndroidAutomation;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import MembersePageObjects.AppMenus;
import MembersePageObjects.LoginOptionPage;
import MembersePageObjects.PlaylistPage;
import MembersePageObjects.ProfileMenuPage;
import SoFaDog.AndroidAutomation.Base;
import SoFaDog.AndroidAutomation.Utilities;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class aCreatePlaylistTest extends Base {
	
	@Test
	public void aCreatePlaylistTestCase() throws InterruptedException, IOException {
		Utilities u = new Utilities(driver);
		u.DirectToLoginOptionPage();
		
		String userNumber = "c3";
		String emailId = "kqatest"+userNumber;
		String emailDomain = "@yopmail.com";
		String email = emailId+emailDomain;
		String password = emailId;
		
		LoginOptionPage lop = new LoginOptionPage(driver);
		Thread.sleep(15000);
		lop.signinWithEmail().sendKeys(email);
		lop.EmailPassword().sendKeys(password);
		lop.RevealPassword().click();
		lop.LoginButton().click();
		Thread.sleep(15000);
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Next']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='Close']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		AppMenus am = new AppMenus(driver);
		am.ProfileMenu().click();
		
		ProfileMenuPage pmp = new ProfileMenuPage(driver);
		pmp.playlistSubMenu().click();
		Thread.sleep(5000);
		
		PlaylistPage plp = new PlaylistPage(driver);
        plp.createPlayList().click();
        Thread.sleep(3000);
        String autotext = getSaltString();
		System.out.println(autotext);
		String title = "Autolist-" + autotext;
        plp.PlayListTitleTextbox().sendKeys(title);
        plp.DescriptionTextbox().sendKeys("This is an Automated QA Description");
        plp.UploadImageButton().click();
        Thread.sleep(5000);
        
        driver.findElementByXPath("//android.widget.TextView[@text='Pick from Library']").click(); 
        driver.pushFile("/sdcard/Download/Pic22.jpg", new File(System.getProperty("user.dir") + "/src/Pic22.jpg"));
        Thread.sleep(3000);
        //byte[] fileBase64 = driver.pullFile("/sdcard/Download/Pic22.jpg");
        //File fl = new File(System.getProperty("user.dir") + "/src/Pic22.jpg");
        //StringSelection str = new StringSelection(fl.getAbsolutePath());
        //Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        Thread.sleep(5000);
        driver.findElementByXPath("//android.view.ViewGroup[@index='1']").click(); 
        Thread.sleep(2000);
        driver.findElementByXPath("//android.view.ViewGroup[@text='Save']").click();
        Thread.sleep(6000);
        driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
        Thread.sleep(3000);
        u.ScrollToText(title);
        Thread.sleep(3000);
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