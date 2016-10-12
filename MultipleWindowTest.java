package seleniumauto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MultipleWindowTest {

	private WebDriver d=null;
	private String appURL="http://flipkart.com";
	private Actions action=null;
	
	MultipleWindowTest()
	{
		d=new FirefoxDriver();
		action=new Actions(d);
		System.out.println("Driver class : "+d.getClass().getName());
	}
	public void windowTest()
	{
		d.get(appURL);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/*public void flipkartWindowTest() throws Exception
	{
		//WebElement eleElectronics=d.findElement(By.xpath("//span[text()='Electronics']"));
		WebElement eleElectronics=d.findElement(By.xpath("//a[@class='_1QZ6fC']"));
		WebElement eleSamsung=d.findElement(By.xpath("//span[text()='Samsung']"));
		action.moveToElement(eleElectronics).moveToElement(eleSamsung).build().perform();
		System.out.println("Current URL : "+d.getCurrentUrl());
		
		
	}
	*/
	public void switchWindowTest()
	{
		String mainWindow=d.getWindowHandle();
		WebElement eleLogin=d.findElement(By.xpath("//a[text()='Log In']"));
		action.contextClick(eleLogin).build().perform();
		
		Set<String> mulWindows=d.getWindowHandles();
		for(String wins:mulWindows)
		{
			if(!mainWindow.equals(wins))
			{
			d.switchTo().window(wins);
			System.out.println("current URl : "+d.getCurrentUrl());
			}else
			{
				return;
			}
		}
		d.switchTo().defaultContent();
		WebElement eleElectronics=d.findElement(By.xpath("//span[text()='Electronics']"));
		WebElement eleSamsung=d.findElement(By.xpath("//span[text()='Samsung']"));
		action.moveToElement(eleElectronics).moveToElement(eleSamsung).click().build().perform();
		System.out.println("current URL : "+d.getCurrentUrl());
	}
	public static void main(String args[])
	{
		MultipleWindowTest m1=new MultipleWindowTest();
		m1.windowTest();
		m1.switchWindowTest();
	}
}
