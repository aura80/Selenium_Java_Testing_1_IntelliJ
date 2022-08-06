package tests;//	tests.Frames

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

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

        frames1();
        frames2();


        Thread.sleep(4000);		// opreste executia sistemului pentru 4 secunde

        driver.close();
        driver.quit();
    }


    public static void frames2() {
        // page in page or html in html

        driver.navigate().to("https://demoqa.com/frames");

        // first we switch to the frame, after that we search elements inside

        // we take frames with name and id

        driver.switchTo().frame("frame2");

        WebElement frameul2 = driver.findElement(By.id("sampleHeading"));
        System.out.println(" ** Frame 2  " + frameul2.getText());


    }

    public static void frames1() {
        // page in page or html in html

        driver.navigate().to("https://demoqa.com/frames");

        // first we switch to the frame, after that we search elements inside

        // we take frames with name and id

        driver.switchTo().frame("frame1");

        WebElement frame1 = driver.findElement(By.id("sampleHeading"));
        System.out.println(" * Frame 1  " + frame1.getText());

        WebElement frame1Background = driver.findElement(By.xpath("//html/body"));
        System.out.println(frame1Background.getCssValue("color"));
        System.out.println(frame1Background.getCssValue("background-color"));
        System.out.println(frame1Background.getCssValue("background-position"));
        System.out.println(frame1Background.getCssValue("background-repeat"));
        System.out.println(frame1Background.getCssValue("background-attachment"));

    }

}

