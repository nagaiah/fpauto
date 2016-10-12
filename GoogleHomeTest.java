package seleniumauto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class GoogleHomeTest {

	private WebDriver d;
	private String appURL="http://google.com";
	
	@BeforeClass
	public void driverSetUp()
	{
		d=new FirefoxDriver();
		
	}
	@Test
	public void verifyGoogleTitle()
	{
		/* purpose to open the google page 
		*/
		//d.get(appURL);
		d.navigate().to(appURL);
		String title=d.getTitle();
		Assert.assertEquals(title,"Google");
		System.out.println("Google title is copied to console");
		
	}
	
	@AfterClass(enabled=false)
	public void quitDriver()
	{
		if(d!=null)
		d.close();
	}
}
