package seleniumauto;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailTests {

	private WebDriver d;
	private String appURL=null;
	
	public GmailTests(WebDriver driver, String url)
	{
		this.d=driver;
		this.appURL=url;
	}
	/*purpose to open gmail application
	 * and maximizing the window and getting page title
	*/
	public void openGmail()
	{
		if(appURL==null)
		{
			System.out.println("Please enter valid app URL");
			//return;
		}
		d.get(appURL);
		d.manage().window().maximize();
		System.out.println("Application is successfully launched");
		String titlePage=d.getTitle();
		System.out.println("page Title is : "+titlePage);
	}
	/*purpose to get login into gmail with the mentioned data
	*/
	public void gmailLogin() throws Exception
	{
		WebElement eleEmail=d.findElement(By.id("Email"));
		eleEmail.sendKeys("nagaiahburugala419@gmail.com");
		WebElement eleNext=d.findElement(By.id("next"));
		eleNext.click();
		Thread.sleep(2000);
		WebElement elePwd=d.findElement(By.id("Passwd"));
		elePwd.sendKeys("9550954081");
		WebElement eleSignIn=d.findElement(By.id("signIn"));
		eleSignIn.click();
		//Thread.sleep(3000);
		d.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	/* purpose to compose mail and send to mail id
	*/
	public void gmailCompose() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(d, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='COMPOSE']")));
		WebElement eleCompose=d.findElement(By.xpath("//div[text()='COMPOSE']"));
		eleCompose.click();
		Thread.sleep(2000L);
		WebElement eleTo=d.findElement(By.xpath("//textarea[@name='to']"));
		eleTo.sendKeys("nagaiahburugala419@gmail.com");
		WebElement eleSub=d.findElement(By.xpath("//input[@name='subjectbox']"));
		eleSub.sendKeys("On Board Mail");
		WebElement eleBody=d.findElement(By.xpath("//div[@aria-label='Message Body']"));
		eleBody.sendKeys("Welcome to Software technologies field Nagaiah Burgula");
		WebElement eleSendBtn=d.findElement(By.xpath("//div[text()='Send']"));
		eleSendBtn.click();
		Thread.sleep(3000L);
		WebElement eleRefresh=d.findElement(By.xpath("//div[@class='asf T-I-J3 J-J5-Ji']"));
		eleRefresh.click();
	}
	/*purpose to check for a particular mail inbox
	*/
	public void searchForInbox() throws Exception
	{
		Thread.sleep(2000L);
		WebElement eleSearch=d.findElement(By.id("gs_taif50"));
		eleSearch.sendKeys("exploremyjobs.com@gmail.com");
		WebElement eleSearchBtn=d.findElement(By.xpath("//button[@aria-label='Search Gmail']"));
		eleSearchBtn.click();
		WebDriverWait wait=new WebDriverWait(d, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id=':4']")));
		List<WebElement> list=d.findElements(By.xpath(".//*[@id=':4']"));
		for(WebElement ele:list)
		{
			System.out.println("Email is : "+ele.getAttribute("name"));
			System.out.println("\n");
		}
	}
	/*purpose to logout from gmail
	*/
	public void gmailLogOut() throws Exception
	{
		// identifying xpath using contains method instead of text() method
		WebElement eleLogOut=d.findElement(By.xpath("//span[contains(@class,'gb_7a gbii')]"));
		eleLogOut.click();
		//identifying logout button with the help of id attribute
		WebElement eleLogOut1=d.findElement(By.id("gb_71"));
		eleLogOut1.click();
		Thread.sleep(3000L);
		System.out.println("End of the test case");
	}
}
