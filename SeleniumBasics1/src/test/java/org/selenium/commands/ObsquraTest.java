package org.selenium.commands;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ObsquraTest extends BrowserLaunch
{
private Object select;

@Test
public void verifySingleInputField() {
driver.get("https://selenium.qabible.in/simple-form-demo.php");	
String a="Hai obsqura";
WebElement simpleformdemo=driver.findElement(By.xpath("//a[text()='Simple Form Demo']"));
simpleformdemo.click();
WebElement enterMessage=driver.findElement(By.xpath("//input[@id='single-input-field']"));
enterMessage.sendKeys(a);
WebElement showMessage=driver.findElement(By.xpath("//button[@id='button-one']"));
showMessage.click();
WebElement yourmessage=driver.findElement(By.xpath("//div[@id='message-one']"));
Assert.assertEquals(yourmessage.getText(),"Your Message :" +a,"Message not match");
System.out.println(yourmessage.getText());
	
}



@Test

public void verifyTwoInputField()
{
	driver.get("https://selenium.qabible.in/simple-form-demo.php");
	WebElement EnterValueA=driver.findElement(By.xpath("//input[@id='value-a']"));
	EnterValueA.sendKeys("10");
	WebElement EnterValueB=driver.findElement(By.xpath("//input[@id='value-b']"));
	EnterValueB.sendKeys("20");	
	WebElement GetTotal=driver.findElement(By.xpath("//button[@id='button-two']"));
	GetTotal.click();
	//	Assert
}
@Test

public void verifyCheckboxDemo()
{
	driver.get("https://selenium.qabible.in/simple-form-demo.php");
	WebElement CheckboxDemo=driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/div/ul/li[2]/a"));
	CheckboxDemo.click();
	WebElement clickonCheckbox=driver.findElement(By.xpath("//input[@id='gridCheck']"));
	clickonCheckbox.click();
	boolean isselected= clickonCheckbox.isSelected();
	Assert.assertTrue(isselected, "checkbox is not selected");
	System.out.println("Checkbox is selected: "+isselected);
	
			
}
@Test

public void verifyRadioButton()
{
	driver.get("https://selenium.qabible.in/simple-form-demo.php");
	WebElement RadioButtonsDemo=driver.findElement(By.xpath("//a[text()='Radio Buttons Demo']"));
	RadioButtonsDemo.click();
	WebElement FemaleButton=driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
	FemaleButton.click();
	boolean isselected=FemaleButton.isSelected();
	
	Assert.assertTrue(isselected,"radio button is selected");
	System.out.println("IsSelected"+isselected);

}
@Test

public void verifyFormWithValidation()
{
	driver.get("https://selenium.qabible.in/simple-form-demo.php");
	WebElement FormSubmit=driver.findElement(By.xpath("//a[text()='Form Submit']"));
	FormSubmit.click();
	WebElement FirstName=driver.findElement(By.xpath("//input[@id='validationCustom01']"));
	FirstName.sendKeys("Neo");
	WebElement LastName=driver.findElement(By.xpath("//input[@id='validationCustom02']"));
	LastName.sendKeys("jose");
	WebElement Username=driver.findElement(By.xpath("//input[@id='validationCustomUsername']"));
	Username.sendKeys("neojose");	
	WebElement city=driver.findElement(By.xpath("//input[@id='validationCustom03']"));
	city.sendKeys("Thrissur");	
	WebElement state=driver.findElement(By.xpath("//input[@id='validationCustom04']"));
	state.sendKeys("kerala");	
	
	WebElement zip=driver.findElement(By.xpath("//input[@id='validationCustom05']"));
	zip.sendKeys("680613");	
	WebElement agree=driver.findElement(By.xpath("//input[@id='invalidCheck']"));
	agree.click();
	WebElement submitButton=driver.findElement(By.xpath("//input[@class='form-check-input']"));
	boolean isselected=submitButton.isSelected();
	Assert.assertTrue(isselected, "Message not found");
	System.out.println("submitButton is selected is" +isselected);
}
@Test

public void verifyRedColorSelectFromDropdown()
{
	driver.get("https://selenium.qabible.in/simple-form-demo.php");
	WebElement selectInput=driver.findElement(By.xpath("//a[text()='Select Input']"));
	selectInput.click();
	WebElement colorselection =driver.findElement(By.xpath("//select[@id='single-input-field']"));
	Select select=new Select(colorselection);
	select.selectByVisibleText("Red");
	//select.selectByIndex("0")
	String actual="Red";
	Assert.assertEquals(actual,"Red","invalid color");
	System.out.println(" Red color is selected");
			
}
@Test
public void verifyYellowColorSelectFromDropdown()
{
	driver.get("https://selenium.qabible.in/simple-form-demo.php");
	WebElement selectInput=driver.findElement(By.xpath("//a[text()='Select Input']"));
	selectInput.click();
	WebElement colorselection =driver.findElement(By.xpath("//select[@id='single-input-field']"));
	Select select=new Select(colorselection);
	select.selectByVisibleText("Yellow");
	//select.selectByIndex("1");
	String actual="Yellow";
	Assert.assertEquals(actual,"Yellow","invalid color");
	System.out.println(" Yellow color is selected");
		
}
@Test

public void verifyGreenColorSelectFromDropdown()
{
	driver.get("https://selenium.qabible.in/simple-form-demo.php");
	WebElement selectInput=driver.findElement(By.xpath("//a[text()='Select Input']"));
	selectInput.click();
	WebElement colorselection =driver.findElement(By.xpath("//select[@id='single-input-field']"));
	Select select=new Select(colorselection);
	select.selectByVisibleText("Green");
	//select.selectByIndex("2");
	String actual="Green";
	Assert.assertEquals(actual,"Green","invalid color");
	System.out.println(" Green color is selected");

		}
@Test

public void verifyTotalNumberofDropdownValues()
{
	driver.get("https://selenium.qabible.in/simple-form-demo.php");
	WebElement selectInput=driver.findElement(By.xpath("//a[text()='Select Input']"));
	selectInput.click();
	WebElement selectcolor =driver.findElement(By.xpath("//select[@id='single-input-field']"));
	Select select=new Select(selectcolor);
	List<WebElement>listofdropdownelements=select.getOptions();
	System.out.println(listofdropdownelements.size());
	
}
}
