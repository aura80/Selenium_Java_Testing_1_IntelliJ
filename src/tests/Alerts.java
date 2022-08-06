package tests;

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


//   tests.Alerts


public class Alerts {

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

        alerts();

        Thread.sleep(4000);		// opreste executia sistemului pentru 4 secunde

        driver.close();
        driver.quit();
    }


    public static void alerts() throws InterruptedException {

        // click on tests.Alerts on the left side

        WebElement alertsClick = driver.findElement(By.xpath("//div[@class=\"element-list collapse show\"]/ul[@class=\"menu-list\"]//following-sibling::li/span[contains(.,\"tests.Alerts\")]"));
        System.out.println(alertsClick.getText());

        WebElement alertsClick2 = driver.findElement(By.xpath("//div[@class=\"accordion\"]/div[3]/div/descendant::li[@id=\"item-1\"]/*"));
        alertsClick2.click();

        // click on first alert button

        WebElement alert1Click = driver.findElement(By.id("alertButton"));
        alert1Click.click();

        Thread.sleep(2000);

        driver.switchTo().alert().accept();

        // click on second alert button - it appears after 5 sec

        WebElement alert2Click = driver.findElement(By.id("timerAlertButton"));
        alert2Click.click();

        Thread.sleep(6000);

        driver.switchTo().alert().accept();


        // click on third alert button - it appears a confirm box with text

        WebElement alert3Click = driver.findElement(By.id("confirmButton"));
        alert3Click.click();

        Thread.sleep(1000);

        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();

        WebElement alert3ClickMessage = driver.findElement(By.id("confirmResult"));
        System.out.println(alert3ClickMessage.getText());

        // click on fourth alert button - it appears promt box

        WebElement alert4Click = driver.findElement(By.id("promtButton"));
        System.out.println(alert4Click.getText());
        alert4Click.click();

        Thread.sleep(1000);

        driver.switchTo().alert().sendKeys("Hello world!");
        driver.switchTo().alert().accept();

        WebElement alert4ClickMessage = driver.findElement(By.id("promptResult"));
        System.out.println(alert4ClickMessage.getText());

        Assert.assertTrue(alert4ClickMessage.getText().contains("Hello "));
        Assert.assertEquals("You entered Hello world!" , alert4ClickMessage.getText());

    }
}

