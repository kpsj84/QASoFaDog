package SoFaDog.AndroidAutomation;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Utilities {
	
	//Initiate local Android Driver for this class only
	AndroidDriver<AndroidElement> localdriver;
	
	public Utilities(AndroidDriver<AndroidElement> driver) 
	{
		this.localdriver=driver; //Assign base class driver to this class local driver
	}
	
	//Method Created for Scroll with the receive of argument as text up to which driver has to scroll 
	public void ScrollToText(String text) 
	{
		localdriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}
	
	//Method to Swipe the whole Screen
	@SuppressWarnings("rawtypes")
	public void swipeScreen(Direction dir) {		   
		System.out.println("Swipe direction input to Swipe Method is : '" + dir + "'");
		
		//Animation default time:-
		//- Android: 300 ms
		//- iOS: 200 ms
		//Final value depends on your app and could be greater
		    
		final int ANIMATION_TIME = 200; //milliseconds
		final int PRESS_TIME = 200;     //millisecods
		int edgeBorder = 10; 			//better avoid edges
		    
		PointOption pointOptionStart, pointOptionEnd;
		//init screen variables
		Dimension dims = localdriver.manage().window().getSize();

		//init start point = center of screen
		pointOptionStart = PointOption.point(dims.width - 40, dims.height / 2);
		System.out.println("The Screen Width is : "+dims.getWidth());

			switch (dir) {
		    	case DOWN:  //center of footer
		            pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
		            break;
		        case UP: 	//center of header
		            pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
		            break;
		        case LEFT:  //center of left side
		            pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
		            break;
		        case RIGHT: //center of right side
		            pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
		            break;
		        default:
		            throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
		    }
		    //execute swipe using TouchAction
		    try 
		    {
		        new TouchAction(localdriver)
		                .press(pointOptionStart)
		                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
		                .moveTo(pointOptionEnd)
		                .release().perform();
		    } 
		    catch (Exception e) 
		    {
		        System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
		        return;
		    }
		    // always allow swipe action to complete
		    try 
		    {
		        Thread.sleep(ANIMATION_TIME);
		    } 
		    catch (InterruptedException e) 
		    {
		        // ignore
		    }
		}

		//Enum created to provide direction to swipe method
		public enum Direction {
		    UP,
		    DOWN,
		    LEFT,
		    RIGHT;
		}
		
}
