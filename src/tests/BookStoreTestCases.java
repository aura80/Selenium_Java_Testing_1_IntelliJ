package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class BookStoreTestCases {

    static WebDriver driver;

    @BeforeClass
    public static void beforeAll() throws AWTException {

        System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        Robot robot = new Robot();

        for (int i = 0; i < 5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }

    @AfterClass
    public static void afterAll() {
        driver.close();
        driver.quit();
    }

    @Before
    public void before() {
        driver.navigate().to("https://demoqa.com/login");
    }

    @After
    public void after() {

    }

    @Test
    public void test() throws InterruptedException {

        System.out.println();
        System.out.println("TEXT POZITIVE !");

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

        Thread.sleep(1000);

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

        // logging out

        WebElement logOut = driver.findElement(By.xpath("//div[@id=\"books-wrapper\"]/descendant::button[contains(.,\"Log out\")]"));
        System.out.println(" *** " + logOut.getText());
        logOut.click();

    }

    @Test
    public  void testeNegative() throws InterruptedException {

        System.out.println();
        System.out.println("NEGATIVE !");
        // login with negative inputs

        WebElement userNameKey2 = driver.findElement(By.id("userName"));
        userNameKey2.sendKeys(" ");
        System.out.println("getCssValue css border-color:  " + userNameKey2.getCssValue("border-color"));


        WebElement passwordKey2 = driver.findElement(By.id("password"));
        passwordKey2.sendKeys("!");

        // click and check login

        WebElement login2 = driver.findElement(By.id("login"));
        System.out.println(login2.getText() + " -> " + login2.isDisplayed());
        Assert.assertTrue(login2.getText().contains("Login"));
        System.out.println("Assert true!");

        login2.click();

        WebElement userNameKey3 = driver.findElement(By.xpath("//div[@class=\"login-wrapper\"]//div[@id=\"output\"]//p[@id=\"name\"]"));
        System.out.println("Error text:   " + userNameKey3.getText());
        System.out.println("Value of attribute style:   " + userNameKey3.getAttribute("style"));
        System.out.println("Text color:   " + userNameKey3.getCssValue("color"));
        Assert.assertTrue(userNameKey3.getAttribute("class").contains("mb-1"));

    }

    @Test
    public  void searchBook() throws InterruptedException {

        System.out.println();
        System.out.println("SEARCH BOOK !");

        // login with positive inputs

        WebElement userNameKey2 = driver.findElement(By.id("userName"));
        userNameKey2.sendKeys("aura");

        WebElement passwordKey2 = driver.findElement(By.id("password"));
        passwordKey2.sendKeys("Aura1!!!");

        // click login

        WebElement login2 = driver.findElement(By.id("login"));
        System.out.println(login2.getText());
        login2.click();

        driver.navigate().to("https://demoqa.com/books");

        // searching for an element

        WebElement searchBook = driver.findElement(By.id("searchBox"));
        searchBook.sendKeys("Speaking JavaScript");
//		searchBook.click();


        WebElement searchBook2 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div/descendant::div/span/a"));
        System.out.println(searchBook2.getAttribute("href"));
        System.out.println("Name of the book:  " + searchBook2.getText());
        Assert.assertTrue(searchBook2.getAttribute("href").contains("9781449365035"));
        System.out.println("Assert true!");



    }


    @Test
    public  void bookDetails() throws InterruptedException, AWTException {

        System.out.println();
        System.out.println("BOOK DETAILS !");

        WebElement userNameKey = driver.findElement(By.id("userName"));
        userNameKey.sendKeys("aura");
        System.out.println(" " + userNameKey.getAttribute("value"));

        WebElement passwordKey = driver.findElement(By.id("password"));
        passwordKey.sendKeys("Aura1!!!");
        System.out.println(" " + passwordKey.getAttribute("value"));

        // click and check login

        WebElement login = driver.findElement(By.id("login"));
        System.out.print(login.getText());
        System.out.println(" -> " + login.isDisplayed());
        login.click();

        // click on Go To Book Store

        Robot robot = new Robot();

        for (int i = 0; i < 5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }


        WebElement goToBookStore = driver.findElement(By.xpath("//div[@class=\"profile-wrapper\"]/div[@class=\"mt-2 buttonWrap row\"]/div[1]/button"));
        System.out.print(goToBookStore.getText());
        System.out.println(" -> " + goToBookStore.isDisplayed());

        goToBookStore.click();

        // book details

        System.out.println();

        WebElement headerBook = driver.findElement(By.xpath("//div[@class=\"rt-table\"]/div/div[@class=\"rt-tr\"]"));
        System.out.println(headerBook.getText());
        List<WebElement> headerBook2 = headerBook.findElements(By.tagName("div"));

        List<String> headerBookText = new ArrayList<String>();

        for (int i = 0; i < headerBook2.size(); i++) {
            headerBookText.add(headerBook2.get(i).getText());
            System.out.println(" * " + headerBookText.get(i));
        }

        for(WebElement w:headerBook2) {
            System.out.println(" -> " + w.getText());
        }


        WebElement infoBook = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[4]/div[@class=\"rt-tr -even\"]"));
        System.out.println(infoBook.getText());
        List<WebElement> infoBook2 = infoBook.findElements(By.tagName("div"));

        List<String> infoBookText = new ArrayList<String>();

        for (int i = 0; i < infoBook2.size(); i++) {
            infoBookText.add(infoBook2.get(i).getText());
            System.out.println(" * " + infoBookText.get(i));
        }

        for(WebElement we:infoBook2) {
            System.out.println(" -> " + we.getText());
        }
        System.out.println();
        System.out.println("Header size:	" + headerBook2.size());
        System.out.println("Line size:	" + infoBook2.size());
        System.out.println();

        System.out.println(headerBook2.get(0).getText() + " - " + infoBook2.get(0).getText());
//		System.out.println(headerBook2.get(1).getText());
//		System.out.println(headerBook2.get(2).getText());
        System.out.println(headerBook2.get(3).getText() + " - " + infoBook2.get(1).getText());
//		System.out.println(headerBook2.get(4).getText() + " - " + infoBook2.get(2).getText());
//		System.out.println(headerBook2.get(5).getText());
        System.out.println(headerBook2.get(6).getText() + " - " + infoBook2.get(3).getText());
//		System.out.println(headerBook2.get(7).getText());
//		System.out.println(headerBook2.get(8).getText());
        System.out.println(headerBook2.get(9).getText() + " - " + infoBook2.get(4).getText());
//		System.out.println(headerBook2.get(10).getText());
//		System.out.println(headerBook2.get(11).getText());

        System.out.println();

        String name = "Speaking JavaScript";
        //get line data
        WebElement author = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[contains(.,\""+name+"\")]/div/div[3]"));
        WebElement publisher = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[contains(.,\""+name+"\")]/div/div[4]"));
        WebElement picture = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[contains(.,\""+name+"\")]/div/div[1]/img"));

        System.out.println(author.getText());
        System.out.println(publisher.getText());
        System.out.println(picture.getAttribute("src"));
        System.out.println(picture.getCssValue("color"));
        System.out.println(picture.isDisplayed());
        System.out.println(picture.getLocation());
        System.out.println(picture.getSize());
        System.out.println(picture.getCssValue("position"));

        System.out.println();

        // click on the book

        // JavascriptExecutor not needed in this case because I used Robot class
        // JavascriptExecutor was not useful in my case for the next click, only Robot worked

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(2200,800)");

        WebElement goToBookLink = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[contains(.,\"Speaking JavaScript\")]//div[2]/div[@class=\"action-buttons\"]/span/a"));
        System.out.println(goToBookLink.getAttribute("href"));

        WebElement goToBook = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[contains(.,\"Speaking \")]/div/div[2]/div/span"));
        System.out.println(goToBook.getText());

        goToBook.click();

        System.out.println();

        // book characteristics
        // it gives only the first line

        WebElement bookInfos = driver.findElement(By.xpath("//div[@class=\"profile-wrapper\"]/div"));
        System.out.println(bookInfos.getText());
        List<WebElement> bookInfos2 = bookInfos.findElements(By.tagName("label"));

        for (WebElement bookElem : bookInfos2) {
            System.out.println(" *** " + bookElem.getText());
        }

        System.out.println();

        // it gives all the elements from the first 8 lines

        WebElement bookInfos1 = driver.findElement(By.xpath("//div[@class=\"profile-wrapper\"]"));
        System.out.println(bookInfos1.getText());
        List<WebElement> bookInfos3 = bookInfos1.findElements(By.tagName("label"));

        for (WebElement bookElem2 : bookInfos3) {
            System.out.println(" ** " + bookElem2.getText());
        }

        // other method

        WebElement date1 = driver.findElement(By.id("ISBN-wrapper"));
        WebElement date2 = driver.findElement(By.id("title-wrapper"));
        WebElement date3 = driver.findElement(By.id("subtitle-wrapper"));
        WebElement date4 = driver.findElement(By.id("author-wrapper"));
        WebElement date5 = driver.findElement(By.xpath("//div[@class=\"profile-wrapper\"]/div[contains(.,\"Publisher : \")]"));
        WebElement date6 = driver.findElement(By.xpath("//div[@class=\"profile-wrapper\"]/div[contains(.,\"Total Pages : \")]"));
        WebElement date7 = driver.findElement(By.id("description-wrapper"));
        WebElement date8 = driver.findElement(By.id("website-wrapper"));
        List<WebElement> listdate1 = date1.findElements(By.tagName("div"));
        List<WebElement> listdate2 = date2.findElements(By.tagName("div"));
        List<WebElement> listdate3 = date3.findElements(By.tagName("div"));
        List<WebElement> listdate4 = date4.findElements(By.tagName("div"));
        List<WebElement> listdate5 = date5.findElements(By.tagName("div"));
        List<WebElement> listdate6 = date6.findElements(By.tagName("div"));
        List<WebElement> listdate7 = date7.findElements(By.tagName("div"));
        List<WebElement> listdate8 = date8.findElements(By.tagName("div"));

        System.out.println(listdate1.size());

        System.out.println("************************" + listdate1.get(0).getText() + "***");
        System.out.println("************************" + listdate1.get(1).getText() + "***");

        System.out.println("************************" + listdate2.get(0).getText() + "***");
        System.out.println("************************" + listdate2.get(1).getText() + "***");

        Assert.assertEquals("ISBN :", listdate1.get(0).getText());
        Assert.assertEquals("9781449365035", listdate1.get(1).getText());


        System.out.println();

        for (WebElement d1 : listdate1) {
            System.out.print(" " + d1.getText());
        }

        Assert.assertEquals("Title :", listdate2.get(0).getText());
        Assert.assertEquals("Speaking JavaScript", listdate2.get(1).getText());

        System.out.println();

        for (WebElement d2 : listdate2) {
            System.out.print(" " + d2.getText());
        }

        Assert.assertEquals("Sub Title :", listdate3.get(0).getText());
        Assert.assertTrue(listdate3.get(1).getText().contains("Programmers"));

        System.out.println();

        for (WebElement d3 : listdate3) {
            System.out.print(" " + d3.getText());
        }

        Assert.assertEquals("Author :", listdate4.get(0).getText());
        Assert.assertTrue(listdate4.get(1).getText().contains("Axel"));

        System.out.println();

        for (WebElement d4 : listdate4) {
            System.out.print(" " + d4.getText());
        }

        Assert.assertEquals("Publisher :", listdate5.get(0).getText());
        Assert.assertTrue(listdate5.get(1).getText().contains("O'Reilly"));

        System.out.println();

        for (WebElement d5 : listdate5) {
            System.out.print(" " + d5.getText());
        }

        Assert.assertTrue(listdate6.get(0).getText().contains("Total Pag"));
        Assert.assertEquals("460", listdate6.get(1).getText());

        System.out.println();

        for (WebElement d6 : listdate6) {
            System.out.print(" " + d6.getText());
        }

        Assert.assertEquals("Description :", listdate7.get(0).getText());
        Assert.assertTrue(listdate7.get(1).getText().contains("language"));

        System.out.println();

        for (WebElement d7 : listdate7) {
            System.out.print(" " + d7.getText());
        }

        Assert.assertTrue(listdate8.get(0).getText().contains("Web"));
        Assert.assertEquals("http://speakingjs.com/", listdate8.get(1).getText());

        System.out.println();

        for (WebElement d8 : listdate8) {
            System.out.print(" " + d8.getText());
        }

        System.out.println();

        String isbn = "ISBN : ";
        WebElement isbnNo = driver.findElement(By.xpath("//div[@class=\"profile-wrapper\"]/div[contains(.,\""+isbn+"\")]/div[2]/label"));
        System.out.print("\nAssert ISBN no.: 		" + isbnNo.getText());
        Assert.assertEquals("9781449365035", isbnNo.getText());

        String title = "Title : ";
        WebElement titleName = driver.findElement(By.xpath("//div[@class=\"profile-wrapper\"]/div[contains(.,\""+title+"\")]/div[2]/label[contains(.,\"Speaking JavaScript\")]"));
        System.out.print("\nAssert title: 			" + titleName.getText());
        Assert.assertEquals("Speaking JavaScript", titleName.getText());

        String subTitle = "Sub Title : ";
        WebElement subTitleName = driver.findElement(By.xpath("//div[@class=\"profile-wrapper\"]/div[contains(.,\""+subTitle+"\")]/div[2]/label[contains(.,\"An In-Depth Guide for Programmers\")]"));
        System.out.print("\nAssert subtitle: 		" + subTitleName.getText());
        Assert.assertEquals("An In-Depth Guide for Programmers", subTitleName.getText());

        String authName = "Author : ";
        WebElement authorName = driver.findElement(By.xpath("//div[@class=\"profile-wrapper\"]/div[contains(.,\""+authName+"\")]/div[2]/label"));
        System.out.print("\nAssert author's name: 		" + authorName.getText());
        Assert.assertEquals("Axel Rauschmayer", authorName.getText());

        String publishername = "Publisher : ";
        WebElement publisherName = driver.findElement(By.xpath("//div[@class=\"profile-wrapper\"]/div[contains(.,\""+publishername+"\")]/div[2]/label"));
        System.out.print("\nAssert publisher name: 		" + publisherName.getText());
        Assert.assertEquals("O'Reilly Media", publisherName.getText());

        String totalPages = "Total Pages : ";
        WebElement totalPagesNo = driver.findElement(By.xpath("//div[@class=\"profile-wrapper\"]/div[contains(.,\""+totalPages+"\")]/div[2]/label"));
        System.out.print("\nAssert total no. of pages: 	" + totalPagesNo.getText());
        Assert.assertEquals("460", totalPagesNo.getText());

        String description = "Description : ";
        WebElement descr = driver.findElement(By.xpath("//div[@class=\"profile-wrapper\"]/div[contains(.,\""+description+"\")]/div[2]/label"));
        System.out.print("\nAssert description: 		" + descr.getText());
        Assert.assertTrue(descr.getText().contains("JavaScript is everywhere"));

        String website = "Website : ";
        WebElement web = driver.findElement(By.xpath("//div[@class=\"profile-wrapper\"]/div[contains(.,\""+website+"\")]/div[2]/label"));
        System.out.println("\nAssert author's name: 		" + web.getText());
        Assert.assertEquals("http://speakingjs.com/", web.getText());


        // click on Add To Your Collection

        WebElement addToBooks = driver.findElement(By.xpath("//div[@class=\"mt-2 fullButtonWrap row\"]/div[2]/button"));
        System.out.println(addToBooks.getText());
        addToBooks.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals("Book already present in the your collection!", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        Thread.sleep(1000);

        // logging out

        WebElement logOut = driver.findElement(By.xpath("//div[@class=\"books-wrapper\"]//button[@id=\"submit\"][contains(text(),\"Log out\")]"));
        System.out.println(" *** " + logOut.getText());
        logOut.click();

    }
}
