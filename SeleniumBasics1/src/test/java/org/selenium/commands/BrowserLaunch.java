package org.selenium.commands;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BrowserLaunch {
	public WebDriver driver;
	public void InitializeBrowser(String browser)
	{
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			throw new RuntimeException("invalid browser recieved");
		}
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void closeBrowser(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			takeScreenShot(result);	
		}
		
		driver.close();
		
	}
	@BeforeMethod
	public void setup()
	{
		InitializeBrowser("chrome");
	}
	public void takeScreenShot(ITestResult result) throws IOException
	{
		TakesScreenshot takesScreenshot =(TakesScreenshot)	driver;
		File screenShot=takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot,new File("./ScreenShot/"+result.getName()+".png"));
		
		
	}

}
