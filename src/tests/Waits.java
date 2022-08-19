package tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://demoqa.com/dynamic-properties");
		
		// implicit wait
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		dynamicPropertiesImplicit();

		// explicit wait

		dynamicPropertiesExplicit();
		
		Thread.sleep(1000);
		
		driver.close();
		driver.quit();
		
	}
	
	public static void dynamicPropertiesImplicit() throws InterruptedException {
		
		// implicit wait
		
//		Thread.sleep(5000);
				
		WebElement visibleAfter5Seconds = driver.findElement(By.id("visibleAfter"));
		visibleAfter5Seconds.click();
		
	}
	
	public static void dynamicPropertiesExplicit() {
		
		// explicit wait
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement visibleAfter5Seconds = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
		
		visibleAfter5Seconds.click();
		
		WebElement enabledAfter5Seconds = wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
		
		enabledAfter5Seconds.click();
		
	}

}
