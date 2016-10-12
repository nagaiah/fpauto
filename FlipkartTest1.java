package seleniumauto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FlipkartTest1 extends FlipkartTest{

	private WebDriver d;
	public FlipkartTest1(WebDriver driver) {
		super();
		this.d=driver;
	}
	/*public void clickOnFlipkartLogo()
	{
		d.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebElement eleFlipkartLogo=d.findElement(By.xpath("//div[@class='_2OJxl5']//img[@title='Flipkart']"));
		eleFlipkartLogo.click();
		d.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		System.out.println("clicked on Flipkart logo");
		
	}*/
	public void listOfClothing()
	{
		Object o[]=d.findElements(By.xpath(".//*[@id='container']/div/header/div[2]/div/ul/li[3]/ul/li/ul/li[2]")).toArray();
		System.out.println("All types of clothing are ");
		System.out.println("The no of elements are : "+o.length);
		for(Object s:o)
		{
			System.out.println(s.toString());
		}
	}
	public void scrollIntoEle()
	{
		WebElement eleToScroll=d.findElement(By.xpath("//a[text()='Payments']"));
		Object []list=d.findElements(By.xpath(".//*[@id='container']/div/footer/div")).toArray();
		for(Object o:list)
		{
			if(o.toString().equals(eleToScroll.toString()))
					{
						((JavascriptExecutor)d).executeScript("arguments[0].scrollIntoView",eleToScroll);
					}
		}
		eleToScroll.click();
		System.out.println("current URL : "+d.getCurrentUrl());
		
	}
	public static void main(String args[])
	{
		 final WebDriver driver=new FirefoxDriver();
		FlipkartTest1 f1=new FlipkartTest1(driver);
		f1.openURL();
		//f1.clickOnFlipkartLogo();
		f1.listOfClothing();
		//f1.clickOnFlipkartLogo();
		f1.scrollIntoEle();
	}
}
