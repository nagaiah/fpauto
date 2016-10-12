package seleniumauto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParallelTest1 {

	private WebDriver d;
	private String appURL="http://flipkart.com";
	
	@BeforeClass
	public void initDriver()
	{
		d=new FirefoxDriver();
		d.get(appURL);
		d.manage().window().maximize();
	}
	@Test
	public void testMethod1()
	{
		System.out.println("in test method 1");
	}
	@Test
	public void testMethod2()
	{
		System.out.println("in test method2");
	}
	@Test
	public void testMethod3()
	{
		System.out.println("in test Method3");
	}
	@AfterClass
	public void closeDriver()
	{
		System.out.println("closing the driver");
		System.out.println();
	}
}
