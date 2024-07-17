package com.PageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage {
WebDriver driver;
public CustomerPage(WebDriver driver)
{
	this.driver=driver;
}
//define repository
@FindBy(xpath = "(//a[contains(text(),'Customers')])[2]")
WebElement objCustomerLink;
@FindBy(xpath = "(//span[@data-caption='Add'])[2]")
WebElement objClickAddIcon;
@FindBy(name = "x_Customer_Number")
WebElement objCustomerNumber;
@FindBy(name = "x_Customer_Name")
WebElement objCustomerName;
@FindBy(name = "x_Address")
WebElement objAddress;
@FindBy(name = "x_City")
WebElement objCity ;
@FindBy(name = "x_Country")
WebElement objCountry;
@FindBy(name = "x_Contact_Person")
WebElement objContactPerson;
@FindBy(name = "x_Phone_Number")
WebElement objPhoneNumber;
@FindBy(name = "x__Email")
WebElement objEmail;
@FindBy(name = "x_Mobile_Number")
WebElement objMobileNumber;
@FindBy(name = "x_Notes")
WebElement objNotes; 
@FindBy(id= "btnAction")
WebElement objAddbtn;
@FindBy(xpath = "//button[normalize-space()='OK!']")
WebElement objConfirmOk;
@FindBy(xpath="(//button[starts-with(text(), 'OK')])[6]")
WebElement objAlertOk;
@FindBy(xpath="//span[@data-caption=\"Search\"]")
WebElement objSearchPanel;
@FindBy(xpath="//input[@name='psearch']")
WebElement objSearchTextbox;
@FindBy(xpath="//button[@id=\"btnsubmit\"]")
WebElement objSearchbtn;
@FindBy(xpath="//table[@class ='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
WebElement webtable;
public boolean add_Customer(String cname,String Address,String city,String Country, String cperson,String PhnNo, String Email,String mobileNo, String Notes ) throws Throwable
{
	Actions ac = new Actions(driver);
	Thread.sleep(2000);
	ac.moveToElement(this.objCustomerLink).click().build().perform();
	Thread.sleep(2000);
	ac.moveToElement(this.objClickAddIcon).click().build().perform();
	Thread.sleep(2000);
	String Exp_Data = this.objCustomerNumber.getAttribute("Value");	
	this.objCustomerName.sendKeys(cname);
	this.objAddress.sendKeys(Address);
	this.objCity.sendKeys(city);
	this.objCountry.sendKeys(Country);
	this.objContactPerson.sendKeys(cperson);
	this.objPhoneNumber.sendKeys(PhnNo);
	this.objEmail.sendKeys(Email);
	this.objMobileNumber.sendKeys(mobileNo);
	this.objNotes.sendKeys(Notes);
	ac.sendKeys(Keys.ENTER);
	Thread.sleep(3000);
	ac.moveToElement(this.objAddbtn).click().build().perform();
	ac.pause(4000);
	ac.moveToElement(this.objAlertOk).click().perform();
	Thread.sleep(3000);
	if(!this.objSearchTextbox.isDisplayed())
		this.objSearchPanel.click();
	this.objSearchTextbox.clear();
	this.objSearchTextbox.sendKeys(Exp_Data);
	this.objSearchbtn.click();
	Thread.sleep(3000);
	String Act_data = this.webtable.getText();
	if(Act_data.equals(Exp_Data))
	{
		Reporter.log(Act_data+ " "+Exp_Data, true);
		return true;
	} else
	{
		Reporter.log(Act_data+ " "+Exp_Data, false);
		return false;
	}
	
}

}
