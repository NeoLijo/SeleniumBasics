package org.selenium.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementCommand {
public void verifySwagLabsUserName() {
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
    driver.manage().window().maximize();
    
    WebElement userNamefield=driver.findElement(By.id("user-name"));
    userNamefield .sendKeys("standard_user");
    
    WebElement passwordField=driver.findElement(By.id("password"));
    passwordField.sendKeys("secret_sauce");
    
    WebElement loginButton=driver.findElement(By.id("login-button"));
    loginButton.click();
    
// String button=loginButton.getTagName();
  //  System.out.println(button);
  
    driver.close();    
}


	public static void main(String[] args) {
		
		WebElementCommand obj=new WebElementCommand();
		obj.verifySwagLabsUserName();
		
	}

}
