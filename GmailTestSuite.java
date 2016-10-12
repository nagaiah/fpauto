package seleniumauto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GmailTestSuite {

	private WebDriver d;
	private GmailTests gt;
	private String url="http://gmail.com";
	@BeforeClass
	public void intitDriver()
	{
		d=new FirefoxDriver();
		gt=new GmailTests(d, url);
		System.out.println("Beginning of the test suite");
	}
	
	@Test
	public void TC01_Gmail_OpenAPP()
	{
		gt.openGmail();
	}
	@Test
	public void TC02_Gmail_GmailLogin()
	{
		try{
		gt.gmailLogin();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void TC03_Gmail_GmailCompose()
	{
		try{
		gt.gmailCompose();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public void TC04_Gmail_InboxSearch()
	{
		try{
		gt.searchForInbox();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void TC05_Gmail_GmailLogOut()
	{
		try{
		gt.gmailLogOut();
		}catch(Exception e)
		{
			e.getMessage();
		}
	}
	@AfterClass
	public void terminateDriver()
	{
		if(d != null)
			d.close();
		System.out.println("End of the suite");
	}
}
