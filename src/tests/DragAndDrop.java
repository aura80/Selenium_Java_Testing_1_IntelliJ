package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://demoqa.com/droppable");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		dragAndDrop();
		dragAndDropByOffset();
		clickAndHold();
		
		Thread.sleep(1000);
		
		driver.close();
		driver.quit();
		
	}
	
	public static void dragAndDrop() throws InterruptedException {
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		System.out.println(drag.getCssValue("color"));
		System.out.println(drop.getCssValue("color"));
		System.out.println("Background color -  " + drop.getCssValue("background-color"));
		
		System.out.println("X:  " + drag.getLocation().getX());
		System.out.println("Y:  " + drag.getLocation().getY());
		
		// drag and drop
		
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();
		
		System.out.println(drag.getCssValue("color"));
		System.out.println(drop.getCssValue("color"));
		System.out.println("Background color -  " + drop.getCssValue("background-color"));
		
		System.out.println("X:  " + drop.getLocation().getX());
		System.out.println("Y:  " + drop.getLocation().getY());
		
		Thread.sleep(1000);
	}
	
	public static void dragAndDropByOffset() {
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		int x = drag.getLocation().getX();
		int y = drag.getLocation().getY();
		int xx = drop.getLocation().getX();
		int yy = drop.getLocation().getY();
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(drag, xx - x, yy - y).build().perform();
		
	}
	
	public static void clickAndHold() {
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		// pause is not mandatory
		action.clickAndHold(drag).pause(1000).moveToElement(drop).pause(1000).release().build().perform();
		
	}
}
