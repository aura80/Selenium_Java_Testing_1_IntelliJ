package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class DemoQAForm {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, AWTException {

        System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/automation-practice-form");

        //	https://www.softwaretestingmaterial.com/zoom-in-and-zoom-out-in-selenium/

        //  Method 1: Using Robot Class

        Robot robot = new Robot();

        for (int i = 0; i < 5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //	Method 2: Using SendKeys Method

//		for(int i=0; i<10; i++){
//			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
//		}

        Form();

        Thread.sleep(2000);

        driver.close();
        driver.quit();

    }

    public static void Form() throws InterruptedException {
        System.out.println("Title of the page:  " + driver.getTitle());
        System.out.println("Current URL:        " + driver.getCurrentUrl());
        System.out.println("Page source:        " + driver.getPageSource());


        WebElement firstName = driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]"));
        firstName.sendKeys("Izabela");
        WebElement lastName = driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]"));
        lastName.sendKeys("Adjani");
        WebElement email = driver.findElement(By.xpath("//input[@placeholder=\"name@example.com\"]"));
        email.sendKeys("izabela@yahoo.com");

        WebElement radioButton = driver.findElement(By.xpath("//label[@for=\"gender-radio-2\"]"));
        radioButton.click();

        WebElement mobileNo = driver.findElement(By.xpath("//input[@placeholder=\"Mobile Number\"]"));
        mobileNo.sendKeys("0123456789");

        WebElement date = driver.findElement(By.xpath("//input[@id=\"dateOfBirthInput\"]"));
        date.click();
        WebElement month = driver.findElement(By.xpath("//select[@class=\"react-datepicker__month-select\"]/option[@value=\"3\"]"));
        month.click();
        WebElement year = driver.findElement(By.xpath("//select[@class=\"react-datepicker__year-select\"]/option[@value=\"1995\"]"));
        year.click();
        WebElement day = driver.findElement(By.xpath("//div[@class=\"react-datepicker__day react-datepicker__day--016 react-datepicker__day--weekend\"]"));
        day.click();

        System.out.println();

        WebElement subj0 = driver.findElement(By.xpath("//div[@class=\"css-1g6gooi\"]//input[@id=\"subjectsInput\"]"));
        subj0.sendKeys("m");

        List<WebElement> subj = driver.findElements(By.xpath("//div[@class=\"subjects-auto-complete__menu css-26l3qy-menu\"]"));
        System.out.println("Size subjects: " + subj.size());

        for(int i = 0; i <= subj.size()-1; i++) {
            System.out.println(subj.get(i).getText());
            subj.get(i).click();
        }


//		WebElement subject0 = driver.findElement(By.xpath("//div[@class=\" css-2b097c-container\"]//div[contains(text(),\"Maths\")]"));
//		System.out.println(subject0.getText());
//		subject0.click();

//		WebElement subj1 = driver.findElement(By.xpath("//div[@class=\"css-1g6gooi\"]//input[@id=\"subjectsInput\"]"));
//		subj1.sendKeys("m");
//
//		WebElement subject1 = driver.findElement(By.xpath("//div[@class=\" css-2b097c-container\"]//div[contains(text(),\"Chemistry\")]"));
//		System.out.println(subject1.getText());
//		subject1.click();
//
//		WebElement subj2 = driver.findElement(By.xpath("//div[@class=\"css-1g6gooi\"]//input[@id=\"subjectsInput\"]"));
//		subj2.sendKeys("m");
//
//		WebElement subject2 = driver.findElement(By.xpath("//div[@class=\" css-2b097c-container\"]//div[contains(text(),\"Computer Science\")]"));
//		System.out.println(subject2.getText());
//		subject2.click();
//
        WebElement subj3 = driver.findElement(By.xpath("//div[@class=\"css-1g6gooi\"]//input[@id=\"subjectsInput\"]"));
        subj3.sendKeys("E");

//		WebElement subject3 = driver.findElement(By.xpath("//div[@class=\" css-2b097c-container\"]//div[contains(text(),\"English\")]"));
//		System.out.println(subject3.getText());
//		subject3.click();

        List<WebElement> subject3 = driver.findElements(By.xpath("//div[@class=\"subjects-auto-complete__menu css-26l3qy-menu\"]"));
        System.out.println("Size subjects: " + subject3.size());

        for(int i = 0; i <= subject3.size()-1; i++) {
            System.out.println(subject3.get(i).getText());
            subject3.get(i).click();
        }

        System.out.println();

        WebElement hobby = driver.findElement(By.xpath("//label[@for=\"hobbies-checkbox-3\"]"));
        System.out.println("Hobbies: " + hobby.getText());

        WebElement hobby2 = driver.findElement(By.xpath("//div[@id=\"hobbiesWrapper\"]/div[2]/div[3]/input[@id=\"hobbies-checkbox-3\"]/following-sibling::label[@for=\"hobbies-checkbox-3\"]"));
        System.out.println(hobby2.getText());
        Assert.assertEquals(hobby.getText(), hobby2.getText());
        hobby2.click();


        WebElement picture = driver.findElement(By.xpath("//label[@for=\"uploadPicture\"]"));
        picture.click();


        WebElement adresa = driver.findElement(By.xpath("//textarea[@placeholder=\"Current Address\"]"));
        adresa.sendKeys("5, rue de l'Exposition, 75343 Paris");

        System.out.println();

        //scroll down the page

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");

        // click on element to colapse the states

        WebElement stat = driver.findElement(By.xpath("//div[@class=\" css-yk16xz-control\"]/div[@class=\" css-1hwfws3\"]"));
        stat.click();

        WebElement stateSelect = driver.findElement(By.xpath("//div[@class=\" css-26l3qy-menu\"]"));
        List<WebElement> state = stateSelect.findElements(By.tagName("div"));
        System.out.println("Size states: " + state.size());

        for(int i = 0; i < state.size(); i++) {
            System.out.println(state.get(i).getText());     //  stale element uneori ?
        }

        state.get(1).click();

        // click on element to colapse the cities

        WebElement city = driver.findElement(By.id("city"));
        city.click();

        WebElement citySelect = driver.findElement(By.xpath("//div[@class=\" css-26l3qy-menu\"]"));
        List<WebElement> cities = citySelect.findElements(By.tagName("div"));
        System.out.println("Size cities: " + cities.size());

        cities.get(1).click();


        Thread.sleep(5000);

//		driver.findElement(By.id("city")).click();
//		List<WebElement> cities = driver.findElements(By.xpath("//div[@class=\" css-26l3qy-menu\"]"));
//		System.out.println("Size cities: " + cities.size());
//
//		for(int i = 0; i < cities.size(); i++) {
//
//            System.out.println(cities.get(i).getText());
//
//            if(cities.get(i).getText().contains("Delhi")) {
//
//            	cities.get(i).click();
//                break;
//
//            }
//        }

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        System.out.println("\n------------------------------------------------------------------------");

        // Modale

        WebElement modalHeader = driver.findElement(By.id("example-modal-sizes-title-lg"));
        System.out.println("\n" + modalHeader.getText() + "\n");
        Assert.assertEquals("Thanks for submitting the form", modalHeader.getText());


        WebElement label = driver.findElement(By.xpath("//div[@class=\"modal-body\"]//tr/th[1]"));
        System.out.println("Header text 1:  " + label.getText());


        List<WebElement> labels = driver.findElements(By.xpath("//div[@class=\"modal-body\"]//tr/td[1]"));
        System.out.println("Number of labels: " + labels.size() + "\n\n-----Body 1: ");

        for(int i = 0; i <= labels.size()-1; i++) {
            System.out.println(labels.get(i).getText());
        }

        WebElement value = driver.findElement(By.xpath("//div[@class=\"modal-body\"]//tr/th[2]"));
        System.out.println("\n------------------------\nHeader text 2:  " + value.getText());

        List<WebElement> values = driver.findElements(By.xpath("//div[@class=\"modal-body\"]//tr/td[2]"));
        System.out.println("Number of values: " + values.size() + "\n\n-----Body 2: ");

        List<String> valori = new ArrayList<String>();

        for(int i = 0; i <= values.size()-1; i++) {
            System.out.println(values.get(i).getText());
            valori.add(values.get(i).getText());
        }

        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println();

        System.out.println("Lista: " + valori);

        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println();


        for(int i = 0; i <= labels.size()-1; i++) {
            for(int j = 0; j<=values.size()-1; j++) {
                if (i == j) {
                    System.out.println(labels.get(i).getText() + " 			--- 			" + values.get(j).getText());
                    break;
                }
                else continue;
            }
        }

        System.out.println("------------------------------------------------------------------------");

        List<WebElement> emailStudent = driver.findElements(By.xpath("//div[@class=\"modal-body\"]//tr[2]/td"));
        System.out.println("Elements on the line: " + emailStudent.size() + "\n");

        for(int i = 0; i < emailStudent.size(); i++) {
            System.out.print(emailStudent.get(i).getText() + "         ");
        }

        System.out.println("\n------------------------------------------------------------------------");

        String student = "Student Name";

        WebElement nameStudent = driver.findElement(By.xpath("//tbody/tr/td[contains(.,\""+student+"\")]/following-sibling::td[1]"));
        System.out.println("\nAssert student name:   " + nameStudent.getText());
        Assert.assertEquals("Izabela Adjani", nameStudent.getText());

        String hobiuri = "Hobbies";

        WebElement hobbies = driver.findElement(By.xpath("//tbody/tr/td[contains(.,\""+hobiuri+"\")]/following-sibling::td[1]"));
        System.out.println("\nAssert hobbies:   " + hobbies.getText());
        Assert.assertEquals(hobby.getText(), hobbies.getText());

        String addressa = "Address";

        WebElement address = driver.findElement(By.xpath("//tbody/tr/td[contains(.,\""+addressa+"\")]/following-sibling::td[1]"));
        System.out.println("\nAssert address:   " + address.getText() + "\n");
        Assert.assertEquals("5, rue de l'Exposition, 75343 Paris", address.getText());

    }


}

