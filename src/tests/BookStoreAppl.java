package tests;
//    Book Store

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class BookStoreAppl {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, AWTException {

        System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/login");

        Robot robot = new Robot();

        for (int i = 0; i < 5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        loginCheck();

//		Thread.sleep(2000);		// opreste executia sistemului pentru 4 secunde

        driver.close();
        driver.quit();
    }

    public static void loginCheck() throws InterruptedException {
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        WebElement text1 = driver.findElement(By.tagName("h2"));
        System.out.println(text1.getText());
        WebElement text2 = driver.findElement(By.tagName("h5"));
        System.out.println(text2.getText());

        WebElement userName = driver.findElement(By.id("userName-label"));
        System.out.print(userName.getText());
        WebElement userNameKey = driver.findElement(By.id("userName"));
        userNameKey.sendKeys("aura");
        System.out.println(" " + userNameKey.getAttribute("value"));

        WebElement password = driver.findElement(By.id("password-label"));
        System.out.print(password.getText());
        WebElement passwordKey = driver.findElement(By.id("password"));
        passwordKey.sendKeys("Aura1!!!");
        System.out.println(" " + passwordKey.getAttribute("value"));

        // click and check login

        WebElement login = driver.findElement(By.id("login"));
        System.out.print(login.getText());
        System.out.println(" -> " + login.isDisplayed());
        login.click();

//		Thread.sleep(1000);

        // checking the visibility of the user name on the new page after login

        WebElement userNameCheckVisible = driver.findElement(By.xpath("//div[@id=\"books-wrapper\"]/descendant::label[contains(.,\"User Name : \")]"));
        System.out.println(userNameCheckVisible.isDisplayed());
        System.out.print(userNameCheckVisible.getText());
        System.out.println(userNameCheckVisible.isDisplayed());

        Assert.assertEquals("User Name :", userNameCheckVisible.getText());

        // getting and checking the name given by the user

        WebElement userNameCheck = driver.findElement(By.id("userName-value"));
        System.out.println("           " + userNameCheck.getText());

        Assert.assertEquals("aura", userNameCheck.getText());

        // click on Go To Book Store

        WebElement goToBookStore = driver.findElement(By.id("gotoStore"));
        System.out.println(goToBookStore.getText());
        goToBookStore.click();

        // after click we are on a new page - getting the page

        driver.navigate().to(driver.getCurrentUrl());

        // click on the book

        WebElement goToBookLink = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[contains(.,\"Speaking JavaScript\")]//div[2]/div[@class=\"action-buttons\"]/span/a"));
        System.out.println(goToBookLink.getAttribute("href"));

        WebElement goToBook = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[contains(.,\"Speaking \")]/div/div[2]/div/span"));
        System.out.println(goToBook.getText());

        Thread.sleep(1000);

        goToBook.click();

//		Thread.sleep(1000);

        Assert.assertEquals("https://demoqa.com/books?book=9781449365035", driver.getCurrentUrl());

        // click on Add To Your Collection

        WebElement addToBooks = driver.findElement(By.xpath("//div[@class=\"mt-2 fullButtonWrap row\"]/div[2]/button"));
        System.out.println(addToBooks.getText());
        addToBooks.click();

        Thread.sleep(2000);

//		driver.switchTo().alert();
        Assert.assertEquals("Book already present in the your collection!", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        Thread.sleep(1000);

        // back to books store

        WebElement backToBooks = driver.findElement(By.xpath("//div[@class=\"mt-2 fullButtonWrap row\"]/div[1]/button"));
        System.out.println(backToBooks.getText());
        backToBooks.click();

        System.out.println(driver.getCurrentUrl());


        WebElement searchBook = driver.findElement(By.id("searchBox"));
        searchBook.sendKeys("You Don't Know JS");
        searchBook.click();

        WebElement logOut = driver.findElement(By.xpath("//div[@id=\"searchBox-wrapper\"]/div[2]/button[@id=\"submit\"]"));
        System.out.println(logOut.getText());
        logOut.click();
    }
}

