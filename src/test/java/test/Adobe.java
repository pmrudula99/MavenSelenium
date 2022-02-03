package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Adobe {
	
	@Test(priority=1)
	public void register() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://account.magento.com/customer/account/create/");
		driver.findElement(By.id("firstname")).sendKeys("John");
		driver.findElement(By.id("lastname")).sendKeys("Magento");
		driver.findElement(By.id("email_address")).sendKeys("yesm@gmail.com");
		driver.findElement(By.id("self_defined_company")).sendKeys("yesm");
		
		
		Select cp=new Select(driver.findElement(By.id("company_type")));

		cp.selectByValue("development");
	
				
		Select role=new Select(driver.findElement(By.id("individual_role")));
	//	role.selectByVisibleText("business/sales/marketing/merchandising");
		role.selectByVisibleText("Technical/developer");
		
		Select c=new Select(driver.findElement(By.id("country")));
		c.selectByValue("SG");
		
			
		driver.findElement(By.id("password")).sendKeys("Newuser@123");
		driver.findElement(By.id("password-confirmation")).sendKeys("Newuser@123");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"recaptcha-f979c2ff515d921c34af9bd2aee8ef076b719d03\"]/div/div/iframe")));
		driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
		 driver.switchTo().defaultContent();
		
		if(!driver.findElement(By.id("agree_terms")).isSelected())
		{
		
		driver.findElement(By.id("agree_terms")).click();
		}
		driver.quit();
}
	@Test(priority=2)// this enabled=false will not consider as a test case to execute
	public void login() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("http://adobe.com");
		
		driver.findElement(By.xpath("//*[@id=\"gnt_754\"]/a/span")).click();
		driver.findElement(By.id("EmailPage-EmailField")).sendKeys("yesm@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"EmailForm\"]/section[2]/div[2]/button/span")).click();
		String error= driver.findElement(By.xpath("//*[@id=\"EmailForm\"]/section[1]/label")).getText();
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"EmailForm\"]/section[1]/label")).getText());
		System.out.println(error);
		driver.quit();
	}
}