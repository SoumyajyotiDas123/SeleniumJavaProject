package day1;




import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public final class Login {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/loginpagePractise");
		Thread.sleep(2000);
		driver.findElement(By.className("blinkingText")).click();
		Thread.sleep(2000);
		Set<String>windows= driver.getWindowHandles();
		Iterator<String>it=windows.iterator();
		String parrentid=it.next();
		String childid=it.next();
		driver.switchTo().window(childid);
		System.out.println(driver.findElement(By.className("im-para")).getText());
		driver.switchTo().window(parrentid);
		System.out.println(driver.findElement(By.xpath("//p[@class='text-center text-white']")).getText());
		String s1=driver.findElement(By.xpath("//p[@class='text-center text-white']")).getText();
		String[]sa1= s1.split(" ");
		String[]chars = sa1[6].split("g");
		driver.findElement(By.id("username")).sendKeys(sa1[2]);
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(chars[0]+"g");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.className("btn-success")).click();
		Select drpdn=new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		drpdn.selectByValue("teach");
		driver.findElement(By.id("signInBtn")).click();
		Thread.sleep(4000);
		System.out.println(driver.getCurrentUrl());
		List<WebElement>adcart=driver.findElements(By.xpath("//button[@class='btn btn-info']"));
		for(WebElement crt:adcart) {
			crt.click();
			Thread.sleep(2000);
		}
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("btn-success")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("country")).sendKeys("India");
		Thread.sleep(2000);
		driver.findElement(By.className("btn-lg")).click();
		System.out.println(driver.findElement(By.className("alert-success")).getText());
		Thread.sleep(2000);
		driver.quit();
	}

}
