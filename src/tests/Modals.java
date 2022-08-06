package tests;
//  tests.Modals

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class Modals {
    static WebDriver driver;
    public static void main(String[] args) throws AWTException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/browser-windows");

        Robot robot = new Robot();

        for (int i = 0; i < 5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        modals();

        Thread.sleep(2000);

        driver.close();
        driver.quit();


    }

    public static void modals() throws InterruptedException {

        // modals are windows over windows

        // click on the left side to open the modals dialog page
        WebElement modalsElement = driver.findElement(By.xpath("//div[@class=\"accordion\"]/div[3]/div/descendant::li[@id=\"item-4\"]/*"));
        modalsElement.click();

        WebElement smallModal = driver.findElement(By.id("showSmallModal"));
        System.out.println(smallModal.getText());
        smallModal.click();

        Thread.sleep(1000);

        WebElement modalHeader = driver.findElement(By.id("example-modal-sizes-title-sm"));
        WebElement modalText = driver.findElement(By.xpath("//div[@class=\"modal-body\"]"));
        WebElement modalClose = driver.findElement(By.id("closeSmallModal"));

        Assert.assertEquals("Small Modal", modalHeader.getText());
        Assert.assertEquals("This is a small modal. It has very less content", modalText.getText());
        modalClose.click();

    }

}
