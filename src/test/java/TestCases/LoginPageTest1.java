package TestCases;

import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Page.LoginPage;
import Utility.CaptureScreeshot;
import Utility.ReadData;

public class LoginPageTest1 extends TestBase {
	LoginPage login;
	//It is prerequisite to run the test case open the browser + enter URL
	//This will execute multiple times depend on number of test cases
	
	@BeforeMethod
	public void setup() throws Exception
	{
		Initialization();
		login = new LoginPage();
	}
	
	//Test case to verify visibility of login logo
	@Test (enabled = false)
	public void verifyLoginLogoTest()
	{
		boolean result = login.verifyLoginLogo();
//		Assert.assertEquals(result, true);
	}
	
	//Test case to verify visibility of login logo
	@Test (enabled = false)
	public void verifyBotLogoTest()
	{
		boolean result = login.verifyBotLogo();
		Assert.assertEquals(result, true);
	}
	
	//Test case to login to application and verify label
	@Test
	public void loginToApp1Test() throws Exception
	{
		String label = login.loginToApp1();
		Assert.assertEquals(label, "1PRODUCTS");
		// Assert.assertEquals(label, ReadData.readExcelFile(1, 0));
	}
	
	//Test case to login to application and verify URL
	@Test (enabled = false)
	public void loginToApp2Test() throws Exception  //Inventory Page Login
	{
		// Assert.assertEquals(login.loginToApp2(),"https://www.saucedemo.com/inventory.html");
		Assert.assertEquals(login.loginToApp2(), ReadData.readExcelFile(1, 1));
	}
	
	//Test case to verify title
	@Test (enabled = false)
	public void verifyTitleTest() throws Exception
	{
		String title = login.verifyTitle();
		// Assert.assertEquals(title, "Swag Labs");
		Assert.assertEquals(title, ReadData.readExcelFile(1, 2));
	}
	
	//Test case to verify current URL
	@Test (enabled = false)
	public void verifyUrlTest() throws Exception
	{
		String url = login.verifyUrl();
		// Assert.assertEquals(url, "https://www.saucedemo.com/");
		Assert.assertEquals(url, ReadData.readExcelFile(1, 3));
	}
	
	//This is post action after running the test case and will close the browser
	//This will execute multiple times depend on number of test cases
	@AfterMethod
	public void closeBrowser(ITestResult it) throws Exception
	{
		if(ITestResult.FAILURE == it.getStatus())
		{
			CaptureScreeshot.screenshot(it.getName());
		}
		
	driver.close();
	}

}
