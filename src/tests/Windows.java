package tests;
//	Tabs  ,  tests.Windows


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, AWTException {

        System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/alertsWindows");

        Robot robot = new Robot();

        for (int i = 0; i < 5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        tabs();
        windows();


        Thread.sleep(3000);		// opreste executia sistemului pentru 4 secunde

        driver.close();
        driver.quit();
    }

    public static void windows() throws InterruptedException {
//		driver.navigate().to("https://demoqa.com/browser-windows");

        WebElement browserWinClick = driver.findElement(By.xpath("//div[@class=\"accordion\"]/div[3]/div/descendant::li[@id=\"item-0\"]/*"));
        browserWinClick.click();

        // windows

        // initial window	/	driver.getWindowHandle()  -  it returns the current - initial window

        String initialWindow = driver.getWindowHandle();

        // click on New Window

        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        System.out.println(newWindowButton.getText());
        newWindowButton.click();

        Thread.sleep(1000);

        // after click we will have more than one window
        // 	 driver.getWindowHandles()  -  it returns all the windows
        // we go to all windows so that we can take elements from those pages

        for (String wind : driver.getWindowHandles()) {
            driver.switchTo().window(wind);
        }

        WebElement secondWindowText = driver.findElement(By.id("sampleHeading"));
        System.out.println(secondWindowText.getText());

        Assert.assertEquals("This is a sample page", secondWindowText.getText());


        // we close the second window

        driver.close();

        // we go back to the first window

        driver.switchTo().window(initialWindow);

        Thread.sleep(1000);

        // click on New Window Message

        WebElement thirdWindowClick = driver.findElement(By.id("messageWindowButton"));
        System.out.println(thirdWindowClick.getText());
        thirdWindowClick.click();

        Thread.sleep(1000);

        // switch from initial window to the new one so that we can close the second one

        for (String windo : driver.getWindowHandles()) {
            System.out.println(windo);
            driver.switchTo().window(windo);
        }

        // close the New Window Message

        driver.close();

        // we go back to the first window

        driver.switchTo().window(initialWindow);

        Thread.sleep(1000);

        // how to open a new tab

        ((JavascriptExecutor) driver).executeScript("window.open('https://www.geeksforgeeks.org/static-methods-vs-instance-methods-java/')");

        Thread.sleep(2000);

        driver.switchTo().window(initialWindow);
    }

    public static void tabs() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/browser-windows");

        // tabs

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        System.out.println(newTabButton.getText());
        newTabButton.click();

        Thread.sleep(1000);

        // navigate to second tab

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));	// al doilea tab

        WebElement secondWinText = driver.findElement(By.id("sampleHeading"));
        Assert.assertEquals("This is a sample page", secondWinText.getText());

        System.out.println(secondWinText.getText());

        // closing second tab

        driver.close();

        // navigate back to first tab

        driver.switchTo().window(tabs.get(0));	// primul tab

    }

}
