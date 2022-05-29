package SoFaDog.AndroidAutomation;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class EndToEndTest extends Base {
	
		@SuppressWarnings("rawtypes")
		@Test
		public void EndToEndTestCase() throws IOException, InterruptedException {
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

/* 			
//Step1 Checks for UI is Responsive
			SmokeTest st = new SmokeTest();
			st.SmokeTestCase();
			Thread.sleep(3000);		//This lands on Login Options Screen
*/

/* 			
//Step2 Register a User
			RegisterTest rt = new RegisterTest();
			rt.registerUser();
			Thread.sleep(10000);	//This lands on Home Page Screen	
*/			

/* */			
//Step Login User directly with Bypass Register Process
			LoginTest lt = new LoginTest();
			lt.LoginTestCase();
			Thread.sleep(10000);		//This lands on Home Page Screen	

/*			
//Step3 Subscribe a Free Channel
			//Click on Explore Channels Button
			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			driver.findElementByXPath("//*[@content-desc=', tab, 2 out of 4']").click();
			
			//Click in Search at some tag
			Thread.sleep(10000);
			driver.findElementByXPath("//*[@text='tag1']").click();
			driver.findElementByXPath("//android.widget.TextView[@text='Channels']").click();
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.EditText[@text='Search...']").sendKeys("kqacd2");
			Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.TextView[@text='kqacd2 Test Channel']").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//android.widget.TextView[@text='Subscribe for FREE                                  }']").click();
			driver.findElementById("android:id/button2").click();
			Thread.sleep(20000);
			
//Step4 Watch a Video			
			driver.findElementByXPath("//android.widget.TextView[@text='VR Glasses']").click();
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.TextView[@text='Play']").click();
			Thread.sleep(30000);
			TouchAction t = new TouchAction(driver);
			t.tap(PointOption.point(1280,2000)).perform();
			Thread.sleep(2000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			Thread.sleep(6000);
			t.tap(PointOption.point(98,196)).perform();
			Thread.sleep(6000);
			t.tap(PointOption.point(1307,231)).perform();
			Thread.sleep(3000);
			
			//Back to Search Page
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
*/

/* no end tag for this, just remove this			
//Step5 Search for Other Creator Channel & Subscribe a Paid Channel			
			//Click on View All Button for New Channels on Explore Page
			Thread.sleep(5000);
			driver.findElementByXPath("//*[@content-desc=', tab, 2 out of 4']").click();
			driver.findElementByXPath("(//android.widget.TextView[@text='View All'])[2]").click();
			
			//Scroll List
			Thread.sleep(5000);
			Utilities u = new Utilities(driver);
			u.swipeScreen(Utilities.Direction.UP);
			u.swipeScreen(Utilities.Direction.UP);
			u.swipeScreen(Utilities.Direction.UP);
			//TouchAction t = new TouchAction(driver);
			//t.longPress(PointOption.point(1200, 2000)).waitAction(waitOptiopns(Duration.ofMillis(800))).moveTo(PointOption.point(1200, 400)).release().perform();
			Thread.sleep(5000);
			driver.findElementByXPath("//android.widget.TextView[@text='kqacd Test Channel']").click();
			Thread.sleep(10000);
			
			//Subscribe Button
			driver.findElementByXPath("//android.widget.TextView[@text='Subscribe for € 9 p/m']").click();
			Thread.sleep(25000);
			
/*			//Stripe Form
			Thread.sleep(15000);
			driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
			System.out.println("wait for context");
			
			Set<String> contexts = driver.getContextHandles();
			for(String contextName : contexts)
            {
                    System.out.println(contextName);
            }   
			System.out.println("Printed context Name");
			Thread.sleep(15000);
			
			driver.context("WEBVIEW_dog.fa.so.app"); //this let the code know which view it has to consider by taking the detail from package attribute, add WEBVIEW_ before the package name
			Thread.sleep(12000);
			System.out.println(driver.getContext());
			
			// Some Issue Here
			driver.findElement(By.name("email")).sendKeys("autouser2@yopmail.com");
			driver.findElementByAccessibilityId("cardNumber']").sendKeys("4242424242424242");
			driver.findElementByXPath("//android.widget.EditText[@resource-id='cardExpiry']").sendKeys("12/26");
			driver.findElementByXPath("//android.widget.EditText[@resource-id='cardCvc']").sendKeys("123");
			driver.findElementByXPath("//android.widget.EditText[@resource-id='billingName']").sendKeys("autouser2@yopmail.com");
			//Utilities u = new Utilities(driver);
			u.ScrollToText("Subscribe");
			
			//click subscribe
			Thread.sleep(2000);
			driver.findElementByXPath("//android.widget.Button[@text=Subscribe]");
			driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
			driver.context("NATIVE_APP");
			System.out.println("Shifting context from WEBVIEW to NATIVE APP");
*/
//			driver.pressKey(new KeyEvent(AndroidKey.BACK));
//			Thread.sleep(2000);
//			driver.pressKey(new KeyEvent(AndroidKey.BACK));
//			Thread.sleep(5000);

Utilities u = new Utilities(driver);			
driver.findElementByXPath("//*[@content-desc=', tab, 2 out of 4']").click();
driver.findElementByXPath("(//android.widget.TextView[@text='View All'])[2]").click();						
//Step6 Search for some audio / video content in New Channels List and in Popular section on Explore Page respectively
			Thread.sleep(3000);
			u.swipeScreen(Utilities.Direction.DOWN);
			u.swipeScreen(Utilities.Direction.DOWN);
			driver.findElementByXPath("//android.widget.TextView[@text='MakFreeChannel']").click();
			Thread.sleep(6000);
			driver.findElementByXPath("//android.widget.TextView[@text='test']").click();
			driver.findElementByXPath("//android.widget.TextView[@text='Play']").click();
			Thread.sleep(21000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			
			//Watching content in Popular Section of Explore Page
			Thread.sleep(3000);
			u.swipeScreen(Utilities.Direction.UP);
			Thread.sleep(3000);
			TouchAction t2 = new TouchAction(driver);
			t2.press(PointOption.point(1400, 2203)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(10, 2203)).release().perform();	
			t2.press(PointOption.point(1400, 2203)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(10, 2203)).release().perform();	
			t2.press(PointOption.point(1400, 2203)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(10, 2203)).release().perform();	
			driver.findElementByXPath("//android.widget.TextView[@text='Party time']").click();
			Thread.sleep(28000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));			
			
//Step7 Become a Creator
			driver.findElementByXPath("(//android.widget.TextView[@text='View All'])[4]").click();
			Thread.sleep(5000);
			driver.findElementByXPath("(//android.widget.Switch[1]").click();
			Thread.sleep(2000);
			driver.findElementById("(//android:id/button2").click();
			Thread.sleep(2000);
			driver.findElementById("android:id/button1").click();
			driver.findElementByXPath("(//android.widget.EditText[@text='A description of my channel, this is a new channel and hasn't yet been created.']").click();
			driver.hideKeyboard();
			driver.findElementByXPath("(//android.widget.EditText[@text='Pricing']").click();
			driver.findElementByXPath("(//android.widget.TextView[@text='|']").sendKeys("100");
			driver.hideKeyboard();
			driver.findElementByXPath("(//android.widget.TextView[@text='Set']").click();
			Thread.sleep(2000);
			driver.findElementByXPath("(//android.widget.TextView[@text='SAVE']").click();
			driver.findElementById("android:id/button1").click();
						
//Step8 Upload a Video
			driver.findElementByXPath("//android.widget.TextView[@text='My Posts']").click();
			driver.findElementByXPath("//android.widget.TextView[@text='UPLOAD']").click();
			driver.findElementByXPath("//android.widget.TextView[@text='Select a file to upload']").click();
			driver.findElementByXPath("//android.widget.TextView[@text='Upload Audio']").click();
			driver.findElementByXPath("//android.widget.ImageButton").click();
			driver.findElementByXPath("//android.widget.ImageButton[@text='Downloads']").click();
			driver.findElementByXPath("//android.widget.ImageButton[@text='file_example_MP3_700KB.mp3']").click();
			driver.findElementByXPath("//android.widget.TextView[@text='Select a thumbnail image']").click();
			driver.findElementById("com.android.camera2:id/shutter_button").click();
			Thread.sleep(1000);
			driver.findElementById("com.android.camera2:id/done_button").click();
			Thread.sleep(1000);
			driver.findElementByXPath("//android.widget.EditText").sendKeys("Auto Test Audio");
			driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("Auto Test Description");
			u.swipeScreen(Utilities.Direction.UP);
			driver.findElementByXPath("//android.widget.Switch").click();
			driver.findElementByXPath("//android.widget.TextView[@text='SAVE']").click();
			Thread.sleep(5000);
			driver.findElementById("android:id/button1").click();
			
//Step9 Checks the uploaded content on Own Channel	
			driver.findElementByXPath("//*[@content-desc=', tab, 1 out of 5']").click();
			driver.findElementByXPath("//android.widget.TextView[@text='AutoUser2']").click();
			driver.findElementByXPath("//android.widget.TextView[@text='Auto Test Audio']").click();
			driver.findElementByXPath("//android.widget.TextView[@text='Play']").click();
			Thread.sleep(25000);
			System.out.println("Yeppee uploaded content availabe for public");
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));			
			
//Step10 Signout from App
			LogoutTest lgt = new LogoutTest();
			lgt.LogoutTestCase();
		}

}