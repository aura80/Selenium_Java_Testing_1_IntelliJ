package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://demoqa.com/text-box");
		
		// implicit wait

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		keyboardBasic();
		keyboardActions();
		
		Thread.sleep(1000);
		
		driver.close();
		driver.quit();		
		
	}
	
	public static void keyboardBasic() {
		
		WebElement name = driver.findElement(By.id("userName"));
		WebElement address = driver.findElement(By.id("currentAddress"));
		
		name.sendKeys("introducem text");
		
		// basic , without Action class
		
		// copy the text from user name
		
		name.sendKeys(Keys.CONTROL + "A");
		name.sendKeys(Keys.CONTROL + "C");
		
		name.sendKeys(Keys.TAB);
		name.sendKeys(Keys.TAB);
		
		// paste the text to address

		address.sendKeys(Keys.CONTROL + "V");
		
	}
	
	public static void keyboardActions() {
		
		// with Action class
		
		Actions actions = new Actions(driver);
		
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("a");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();
		
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("c");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();

		actions.sendKeys(Keys.TAB);
		actions.build().perform();
		actions.sendKeys(Keys.TAB);
		actions.build().perform();
		
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("v");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();
	}
}
