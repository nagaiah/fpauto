package seleniumauto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartTest implements FKLocators {

	private WebDriver d;
	private String appURL;
	private Actions action;
	private WebDriverWait wait;
	FlipkartData fkData;

	FlipkartTest()
	{
		d=new FirefoxDriver();
		appURL="http://flipkart.com";
		action=new Actions(d);
		fkData=new FlipkartData();
		System.out.println("class : "+d.getClass().getName());
	}
	
	public void openURL()
	{
		
		d.get(appURL);
		d.manage().window().maximize();
		try{
		Thread.sleep(2000L);
		}catch(InterruptedException e)
		{
			e.getMessage();
		}
	}
	public void loginFlipkart()
	{
		WebDriverWait wait=new WebDriverWait(d, 20);
		wait.until(ExpectedConditions.elementToBeClickable(d.findElement(By.linkText("Log In"))));
		WebElement eleLoginBtn=d.findElement(By.linkText("Log In"));
		eleLoginBtn.click();
		try{
		Thread.sleep(3000L);
		}catch(Exception e)
		{
			e.getMessage();
		}
		WebElement eleMobileNo=d.findElement(LOGINMAIL);
		eleMobileNo.sendKeys(fkData.mobileNo);
		WebElement elePwd=d.findElement(LOGINPWD);
		elePwd.sendKeys(fkData.password);
		WebElement eleSignIn=d.findElement(LOGINBTN);
		eleSignIn.click();
		
	}
	/*public void verifyElectronicsAndsearch()
	{
		WebElement eleElectronics=d.findElement(By.xpath("//span[text()='Electronics']"));
		action.moveToElement(eleElectronics).build().perform();
		WebElement eleSamsung=d.findElement(By.xpath("//a[@class='_3ZgIXy']//span[text()='Samsung']"));
		eleSamsung.click();
		System.out.println("Current URL : "+d.getCurrentUrl());
		d.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Select select=new Select(d.findElement(By.xpath("//select[@class='a_eCSK']")));
		select.selectByValue("2000");
		d.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		List<WebElement> listOfItems=d.findElements(By.xpath("//div[@class='_2xw3j-']//div[@class='col zZCdz4']"));
		Object o[]=listOfItems.toArray();
		int noOfItems=o.length;
		System.out.println("Number of items displayed : "+noOfItems);
		String itemToSearch="SAMSUNG Galaxy J2 (Black, 8 GB)";
		WebElement eleItem=d.findElement(By.xpath("//div[text()='SAMSUNG Galaxy J2 (Black, 8 GB)']"));
		if(o.equals(itemToSearch))
		{
			eleItem.click();
		}
		else
		{
			System.out.println("ele not displayed");
		}
		
		for(WebElement ele:listOfItems)
		{
			System.out.println(ele.getAttribute("href")+"   "+ele.getText());
			if(ele.toString().equals(itemToSearch))
			{
				ele.click();
				d.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			}
		}
	}*/
	
	public static void main(String args[])
	{
		FlipkartTest f1=new FlipkartTest();
		f1.openURL();
		f1.loginFlipkart();
		//f1.verifyElectronicsAndsearch();
	}
}
