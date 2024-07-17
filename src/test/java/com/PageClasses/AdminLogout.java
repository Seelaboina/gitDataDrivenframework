package com.PageClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogout {
@FindBy(xpath = "//a[starts-with(text(), 'Logout')]")
WebElement ObjLogout;
public void adminLogout()
{
	ObjLogout.click();
}
}
