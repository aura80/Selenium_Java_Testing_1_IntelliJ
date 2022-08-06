
//  Select

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Selecturi {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, AWTException {

        System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/select-menu");

        Robot robot = new Robot();

        for (int i = 0; i < 5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        select();


        Thread.sleep(2000);		// opreste executia sistemului pentru 4 secunde

        driver.close();
        driver.quit();
    }

    public static void select() throws InterruptedException {

        // metoda 1

        Select classicSelect = new Select(driver.findElement(By.id("oldSelectMenu")));

        classicSelect.selectByIndex(0);
        Thread.sleep(1000);
        classicSelect.selectByIndex(1);
        Thread.sleep(1000);
        classicSelect.selectByValue("2");
        Thread.sleep(1000);
        classicSelect.selectByVisibleText("Purple");

        // metoda 2  -  pornind de la parinte

        WebElement classicSelect2 = driver.findElement(By.id("oldSelectMenu"));
        classicSelect2.click();

        List<WebElement> optiuni = classicSelect2.findElements(By.tagName("option"));
        for (WebElement optiune:optiuni) {
            System.out.println(optiune.getText());
        }

        System.out.println(optiuni.get(0).getText());
        System.out.println(optiuni.size());
        optiuni.get(4).click();

        // metoda 3 cu dropdown care dispare la click

        WebElement selectOne = driver.findElement(By.id("selectOne"));
        selectOne.click();

        Thread.sleep(1000);

        WebElement dissapearSelect = driver.findElement(By.xpath("//div[@class=\" css-26l3qy-menu\"]"));
        List<WebElement> elemente = dissapearSelect.findElements(By.tagName("div"));

        Thread.sleep(1000);

        elemente.get(6).click();

        Thread.sleep(1000);

    }

}
