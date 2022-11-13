package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Page.InventoryPage;
import Page.LoginPage;
import Utility.ReadData;

public class InventoryPageTest1 extends TestBase {
	LoginPage login;
	InventoryPage invent;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		Initialization();
		invent = new InventoryPage();
		login = new LoginPage();
	}
	
	@Test (enabled = true, priority=0) 
	public void verifySmallLogoTest() throws Exception
	{
		login.loginToApp1();
		boolean result = invent.verifySmallLogo();
		Assert.assertEquals(result, true);
		System.out.println("verify Small Logo Test");
	}
	@Test (enabled = true, priority=0)
	public void verifyBigLogoTest() throws Exception
	{
		login.loginToApp1();
		boolean result = invent.verifyBigLogo();
		Assert.assertEquals(result, true);
		System.out.println("verify Big Logo Test");
	}
	
	@Test (enabled = true, priority=0)
	public void add6ProductTest() throws Exception
	{
		login.loginToApp1();
		String result = invent.add6Product();
		Assert.assertEquals(result, ReadData.readExcelFile(1, 4));
		System.out.println("add 6 Product Test");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
}
