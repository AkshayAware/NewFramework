package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

public class LoginPage extends TestBase {
	//TC1 - Verify application title
	//TC2 - Verify application URL
	//TC3 - Verify visibility of login logo
	//TC4 - Verify visibility bot logo
	//TC5 - Login to application
	//TC6 - Verify the URL of second page (inventory page)
	
	//Object Repository
	@FindBy(xpath = "//div[@class='login_logo']") private WebElement loginLogo;
	@FindBy(xpath = "//div[@class='bot_column']") private WebElement botLogo;
	@FindBy(xpath = "//input[@id='user-name']") private WebElement usernameTextbox;
	@FindBy(xpath = "//input[@id='password']") private WebElement passwordTextbox;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement loginBtn;
	@FindBy(xpath = "//span[@class='title']") private WebElement productLabel;
	
	//Constructor to initialize the elements of page/current class using this
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Method to login to application and verify the label
	public String loginToApp1() throws Exception
	{
		usernameTextbox.sendKeys(ReadData.readPropertyFile("username"));
		passwordTextbox.sendKeys(ReadData.readPropertyFile("password"));
		loginBtn.click();
		return productLabel.getText();
	}
	
	
	//Methods
	//Method to verify the current URL
	public String loginToApp2() throws Exception
	{
		loginToApp1();
		return driver.getCurrentUrl();
	}
	
	//Method to verify the title
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	//Method to verify visibility of login logo
	public boolean verifyLoginLogo()
	{
		return loginLogo.isDisplayed();
	}
	
	//Method to verify visibility of bot logo
	public boolean verifyBotLogo()
	{
		return botLogo.isDisplayed();
	}
	

	
	//Method to verify the URL
	public String verifyUrl()
	{
		return driver.getCurrentUrl();
	}
	
}
