package org.selenium.commands;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Commands extends BrowserLaunch {
	//@Test
	public void verifyCommunityPool()
	{
		driver.get("https://demowebshop.tricentis.com/");
		List<WebElement> communitypollelements=driver.findElements(By.xpath("//label[starts-with(@for,'pollanswe')]//parent::li"));
		for(int i=0;i<communitypollelements.size();i++)
		{
			//System.out.println(communitypollelements.get(i).getText());
			String polloptiontext=communitypollelements.get(i).getText();
			if(polloptiontext.equals("Poor"))
			{
				communitypollelements.get(i).click();
			}
		}
	}
	@Test
	public void verifyCurrentUrl()
	{
		driver.get("https://demowebshop.tricentis.com/");
		String actualpageurl=driver.getCurrentUrl();
		String expectedCurrentUrl="https://demowebshop.tricentis.com/register/";
		Assert.assertEquals(actualpageurl,expectedCurrentUrl,"Invalid current url" );
		//System.out.println(pageurl);
	}
//	@Test
	public void verifyPageTitle()
	{
		driver.get("https://demowebshop.tricentis.com/");
		String actualpagetitle=driver.getTitle(); 
		String expectedpagetitle="DEmo Web Shop";
		Assert.assertEquals(actualpagetitle,expectedpagetitle,"invalid page title" );
		//System.out.println(pagetitle);
		
	}
	//@Test
	public void verifyIsSelected()
	{
		boolean isFemaleSelected;
		driver.get("https://demowebshop.tricentis.com/register");
		driver.manage().window().maximize();
		WebElement radioButtonFemale =	driver.findElement(By.xpath("//input[@id='gender-female']"));
		isFemaleSelected= radioButtonFemale.isSelected();//actual result
		Assert.assertFalse( isFemaleSelected,"radio button is selected");
		radioButtonFemale.click();
	    isFemaleSelected= radioButtonFemale.isSelected();
	    Assert.assertFalse( isFemaleSelected,"radio button is not selected");
		System.out.println("female element after click: "+isFemaleSelected);
		
		driver.close();
	}
	//@Test
	public void verifyIsEnabled()
		{
		boolean isSubscribeEnabled;
			driver.get("https://demowebshop.tricentis.com/");
			driver.manage().window().maximize();
			WebElement subscribeButton =	driver.findElement(By.xpath("//input[@id='newsletter-subscribe-button']"));
		    isSubscribeEnabled= subscribeButton.isEnabled();
		    Assert.assertFalse( isSubscribeEnabled,"Subscibe button is enabled");
			System.out.println("Subscribe element before click: "+isSubscribeEnabled);
			subscribeButton.click();
			 
			boolean isSubscribeEnabledAfterClick= subscribeButton.isEnabled();
			Assert.assertTrue( isSubscribeEnabled,"Subscibe button is not enabled");
			System.out.println("female element after click: "+isSubscribeEnabledAfterClick);
			driver.close();
		}
	//@Test
	public void verifyIsDisplayed()
	{
		boolean isVoteDisplayed;
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		WebElement voteButton =	driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
		isVoteDisplayed= voteButton.isDisplayed();
		Assert.assertFalse(isVoteDisplayed,"Subscibe button is enabled");
		System.out.println("Vote element before click: "+isVoteDisplayed);
		voteButton.click();
	    boolean isVoteDisplayedAfterClick= voteButton.isDisplayed();
	    Assert.assertFalse(isVoteDisplayed,"Subscibe button is not enabled");
	    System.out.println("Vote element after click: "+isVoteDisplayedAfterClick);
		driver.close();

	
	}
	@Test
	
	
	public void verifyUserLogin()
	{
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		WebElement userlogin=driver.findElement(By.xpath("//a[@class='ico-login']"));
		userlogin.click();
		WebElement emailField=driver.findElement(By.xpath("//input[@id='Email']"));
		emailField.sendKeys("neomjose@gmail.com");
		WebElement passwordField=driver.findElement(By.xpath("//input[@id='Password']"));
	    passwordField.sendKeys("neojose@1234");
	    WebElement lastlogin=driver.findElement(By.xpath("//input[@id='button-1 login-button']"));
	    lastlogin.click();
	    WebElement afterLoginMailId=driver.findElement(By.xpath("//a[text()=neomjose@gmail.com]"));
	    afterLoginMailId.click();
	    String  actualLoginMailId= "neomjose@gmail.com";
	    Assert.assertEquals( afterLoginMailId.getText(),actualLoginMailId,"Mail id is wrong");
	    System.out.println("afterLoginMailId.getText()");
		 
	}
	@Test
	
	public void verifyValuesFromDropDown()
	{
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		
		WebElement country =driver.findElement(By.xpath("//select[@name='country']"));
		 Select select=new Select(country); 	
		//select.selectByVisibleText("INDIA");
		//select.selectByIndex(5);
		select.selectByValue("AMERICAN SAMOA");
		WebElement getCountryName =select.getFirstSelectedOption();
		System.out.println(getCountryName.getText());
		
	}
	@Test
	
	public void verifyTotalNumberofDropdownValues()
	{
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement country =driver.findElement(By.xpath("//select[@name='country']"));
		Select select=new Select(country);
		List<WebElement>listofdropdownelements=select.getOptions();
		System.out.println(listofdropdownelements.size());
		
	}
	@Test
	
	public void verifymultiSelectDropdown()
	{
		driver.get("https://selenium.qabible.in/select-input.php");
		WebElement muliselect=driver.findElement(By.xpath("//select[@id='multi-select-field']"));
    	Select select=new Select(muliselect);
    	boolean selectedvalue=select.isMultiple();
    	System.out.println(selectedvalue);
	    select.selectByVisibleText("Red");
	    select.selectByVisibleText("Yellow");
	    List<WebElement>listofselectedvalues=select.getAllSelectedOptions();
	    for(WebElement e:listofselectedvalues) {
	    	System.out.println(e.getText());
	    	
	    }
	    select.deselectByValue("Red");
	}

	@Test
	public void verifyfileUpload()
	{

		driver.get("https://demo.guru99.com/test/upload/");
		WebElement chooseFilefield= driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		chooseFilefield.sendKeys("C:\\Users\\USER\\git\\SeleniumBasics\\SeleniumBasics1\\src");
		WebElement acceptkey=driver.findElement(By.xpath("//input[@id='terms']"));
		acceptkey.click();
		WebElement submit=driver.findElement(By.xpath("//button[@id='submitbutton']"));
		submit.click();
	}
	@Test
	
	public void verifyMultipleWindowHandling()
	{
		driver.get("https://demo.guru99.com/popup.php");
		String parentwindowhandleid=driver.getWindowHandle();
		System.out.println(parentwindowhandleid);
		WebElement clickhere= driver.findElement(By.xpath("//a[text()='Click Here']"));
		clickhere.click();
		Set<String> windowhandlesid=driver.getWindowHandles();
		Iterator<String>value=windowhandlesid.iterator();
		while(value.hasNext())
		{
			String handleid=value.next();
			if(!handleid.equals(parentwindowhandleid))
			{
				driver.switchTo().window(handleid);
				WebElement emailid=driver.findElement(By.xpath("//input[@name='emailid']"));
				emailid.sendKeys("neomjose@gmail.com");
				WebElement submit=driver.findElement(By.xpath("//input[@name='btnLogin']"));
				submit.click();
				driver.close();
			}
			
		}
		driver.switchTo().window(parentwindowhandleid);
	}
	
			
	
@Test
public void validateSimpleAlert()
{
	driver.get("https://demoqa.com/alerts");
	WebElement clickmebutton=driver.findElement(By.id("alertButton"));
	clickmebutton.click();
	Alert alert=driver.switchTo().alert();
	String clicktext=alert.getText();
	System.out.println( clicktext);
	alert.accept();
				
}
@Test
public void validateConfirmationAlert()
{

	driver.get("https://demoqa.com/alerts");
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");
	WebElement clickme=driver.findElement(By.id("confirmButton"));
	clickme.click();
	Alert alert=driver.switchTo().alert();
	alert.dismiss();
	WebElement canclemessage=driver.findElement(By.xpath("//span[@id='confirmResult']"));
	String actualmessage=canclemessage.getText();
	String expectedmessage="You selected Cancel";
	Assert.assertEquals(actualmessage, expectedmessage,"You selected ok");
			
}
@Test
public void validatePromptAlert()
{
	driver.get("https://demoqa.com/alerts");
	JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0,document.body.scrollHeight) ");
	WebElement clickme=driver.findElement(By.id("promtButton"));
	clickme.click();
	Alert alert=driver.switchTo().alert();
	alert.sendKeys("Neo");
	alert.accept();
	WebElement aftermessage=driver.findElement(By.xpath("//span[@id='promptResult']"));
	String actual=aftermessage.getText();
	String expected="You entered Neo";
	Assert.assertEquals(actual, expected, "invalid message");
	
}
	
}
