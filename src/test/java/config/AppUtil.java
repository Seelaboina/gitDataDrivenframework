package config;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.PageClasses.AdminLogin;
import com.PageClasses.AdminLogout;

public class AppUtil {
public static WebDriver driver;
@BeforeTest
public static void setUp() throws Throwable
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://webapp.qedgetech.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	AdminLogin login = PageFactory.initElements(driver, AdminLogin.class);
	login.verify_login("admin", "master");
	
}
@AfterTest
public static void tearDown()
{
	AdminLogout logout = PageFactory.initElements(driver, AdminLogout.class);
	logout.adminLogout();
	driver.quit();
}
}
