package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ExplorePage {
	
		public ExplorePage(AppiumDriver<AndroidElement> driver) 
		{
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		
		//Search tag with name tag1
		@AndroidFindBy(xpath="//*[@text='tag1']") 
		private WebElement Searchtag1;
		
		public WebElement Searchtag1(){    
			return Searchtag1;
		}
		
		@AndroidFindBy(xpath="//android.widget.TextView[@text='Suggested Channels']") 
		private WebElement SuggestedChannels;
		
		public WebElement SuggestedChannels(){    
			return SuggestedChannels;
		}
		
		//Viewall Button of New Channels
		@AndroidFindBy(xpath="(//*[@text='View All'])[2]")
		private WebElement NewChannelsViewall;
		
		public WebElement NewChannelsViewall(){    
			return NewChannelsViewall;
		}
		
		@AndroidFindBy(xpath="(//android.view.ViewGroup[17]") 
		private WebElement PopularSection;
		
		public WebElement PopularSection(){    
			return PopularSection;
		}


}
