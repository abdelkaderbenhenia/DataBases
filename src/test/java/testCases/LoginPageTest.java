package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;

import page.DatabasePage;
import page.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpageObj;
	SoftAssert softAssert =new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		initializeDriver();
		loginpageObj = PageFactory.initElements(driver, LoginPage.class);
		
	}
	@Test 
	public void loginTest() throws Throwable {
		loginpageObj.enterUserName(DatabasePage.getData("userName"));
		Thread.sleep(2000);
		
		loginpageObj.enterPassword(DatabasePage.getData("password"));
		Thread.sleep(2000);
		
		loginpageObj.clickSigninButton();
		
		takeScreenshotAtEndOfTest(driver);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
