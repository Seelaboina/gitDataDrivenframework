package com.PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin {
// define repository loigin
	@FindBy(id="btnreset")
	WebElement objReset;
	@FindBy(xpath = "//input[@id='username']")
	WebElement objUser;
	@FindBy(name = "password")
	WebElement objPass;
	@FindBy(id="btnsubmit")
	WebElement objLogin;
	public void verify_login(String user, String pass) throws Throwable
	{
		objReset.click();
		objUser.sendKeys(user);
		objPass.sendKeys(pass);
		objLogin.click();
	}
}
