package Flipkart_Assesment;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;


public class Flipkart_Assignment {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("(//span[@role=\"button\"])[1]")).click();Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("Bluetooth Speakers"+Keys.ENTER);
		driver.findElement(By.xpath(("//div[text()='Brand']"))).click();
		driver.findElement(By.xpath("//div[text()='boAt']")).click();Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'4★')]")).click();Thread.sleep(2000);
		driver.findElement(By.xpath("//option[text()='800']")).click();Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@rel,\"noopener noreferrer\")]")).click();
		String parentwindow = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		for(String win:allwindow)
		{
			if(!win.equals(parentwindow))
			{
				driver.switchTo().window(win);
			}
		}
		List<WebElement> allprice = driver.findElements(By.xpath("//div[text()='Best value for you']/ancestor::div[17]"));
		for(WebElement e:allprice)
		{
			System.out.println(e.getText());
		}
		
		driver.findElement(By.xpath("//div[text()='Add to cart']")).click();
		driver.findElement(By.xpath("//div[text()='Go to cart']")).click();Thread.sleep(2000);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File create=new File("./cart_result/result.png");
		FileHandler.copy(scr, create);
		driver.quit();
	    
	}
}
	




