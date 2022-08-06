package tests;
// Text Boxes , Radio Buttons, Buttons


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import junit.framework.Assert;

public class Elements_1 {

    static WebDriver driver;

    public static void main(String[] args ) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com");

        // to minimize the content of the page so that the elements can be seen

        Robot robot = new Robot();

        for (int i = 0; i < 5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        textBox_Attribute_CSSValue();
        radioButtons();
        buttons();

        Thread.sleep(4000);		// opreste executia sistemului pentru 4 secunde

        driver.close();
        driver.quit();
    }

    public static void buttons() {

        // click on Button in the Elements Box

        WebElement buttons = driver.findElement(By.xpath("//span[@class=\"text\"][contains(.,\"Buttons\")]"));
        buttons.click();

        System.out.println();

        // text Buttons under the page title

        WebElement button1 = driver.findElement(By.xpath("//div[@class=\"main-header\"][contains(.,\"Buttons\")]"));
        System.out.println(button1.getText());

        System.out.println();

        // double - click on the first button with Actions

        Actions actions = new Actions(driver);

        WebElement button2 = driver.findElement(By.xpath("//button[@id=\"doubleClickBtn\"]"));
        System.out.println(button2.getText());

        actions.doubleClick(button2).perform();

        // text generated after double - click

        WebElement button3 = driver.findElement(By.id("doubleClickMessage"));
        System.out.println(button3.getText());

        System.out.println();

        // right click on the second element

        WebElement button4 = driver.findElement(By.id("rightClickBtn"));
        System.out.println(button4.getText());

        actions.contextClick(button4).perform();


        // text generated after right click

        WebElement button5 = driver.findElement(By.id("rightClickMessage"));
        System.out.println(button5.getText());

        System.out.println();


        // click on the third element

        WebElement button6 = driver.findElement(By.xpath("//div[3]/button[contains(.,\"Click Me\")]"));
        System.out.println(button6.getText());
        button6.click();


        // text generated after click

        WebElement button7 = driver.findElement(By.id("dynamicClickMessage"));
        System.out.println(button7.getText());

    }

    public static void radioButtons() {

        System.out.println();

        System.out.println("Title of the page:  " + driver.getTitle());
        System.out.println("Current URL:        " + driver.getCurrentUrl());
        System.out.println("Page source:        " + driver.getPageSource());

        System.out.println();

        // click on Radio Button in the Elements Box

        WebElement elem1 = driver.findElement(By.xpath("//span[contains(.,\"Radio Button\")]"));
        elem1.click();

        // text Radio Button under the title of the page

        WebElement elem2 = driver.findElement(By.xpath("//div[contains(text(),\"Radio Button\")]"));
        System.out.println(elem2.getText());

        WebElement elem3 = driver.findElement(By.xpath("//div[contains(text(),\"Do you like the site?\")]"));
        System.out.println(elem3.getText());

        System.out.println();

        // text Impressive text near the radio button   +   click on Impressive !

        WebElement elem4 = driver.findElement(By.xpath("//label[@for=\"impressiveRadio\"]"));	// second child of div attribute
        System.out.println("text " + elem4.getText());

        System.out.println("elem4 isDisplayed before click:  " + elem4.isDisplayed());
        System.out.println("elem4 isEnabled before click:    " + elem4.isEnabled());
        System.out.println("elem4 isSelected before click:   " + elem4.isSelected());

        elem4.click();

        System.out.println();
        System.out.println("text Impressive");
        System.out.println("elem4 isDisplayed after click:  " + elem4.isDisplayed());
        System.out.println("elem4 isEnabled after click:    " + elem4.isEnabled());
        System.out.println("elem4 isSelected after click:   " + elem4.isSelected());


        // radio button

        WebElement elem5 = driver.findElement(By.xpath("//input[@id=\"impressiveRadio\"]"));	// first child of div attribute

        System.out.println();
        System.out.println("input Button");
        System.out.println("text: " + elem5.getText());
        System.out.println("elem5 isDisplayed after click:  " + elem5.isDisplayed());
        System.out.println("elem5 isEnabled after click:    " + elem5.isEnabled());
        System.out.println("elem5 isSelected after click:   " + elem5.isSelected());

        System.out.println();
        System.out.println(elem5.getAttribute("type"));
        System.out.println(elem5.getAttribute("id"));
        System.out.println(elem5.getCssValue("color"));
        System.out.println(elem5.getCssValue("background"));

        // text under the button after click

        WebElement elem6 = driver.findElement(By.xpath("//p[contains(.,\"You have selected \")]"));
        System.out.println(elem6.getText());

        WebElement elem7 = driver.findElement(By.xpath("//p/span[contains(.,\"Impressive\")]"));
        System.out.println("Wow!   " + elem7.getText());

        Assert.assertEquals(elem4.getText(), elem7.getText());

        // disabled no button

        WebElement inputNoRadio = driver.findElement(By.xpath("//input[@class=\"custom-control-input disabled\"]"));	// first child of div

        System.out.println();
        System.out.println("input - first child - Button\n");
        System.out.println("--- input disabled shows no text: \n" + inputNoRadio.getText());
        System.out.println("labelNoRadio isDisplayed:   " + inputNoRadio.isDisplayed());
        System.out.println("labelNoRadio isEnabled:     " + inputNoRadio.isEnabled());
        System.out.println("labelNoRadio isSelected:    " + inputNoRadio.isSelected());

        WebElement labelNoRadio = driver.findElement(By.xpath("//input[@class=\"custom-control-input disabled\"]"));	// first child of div

        System.out.println();
        System.out.println("label - second child - Button\n");
        System.out.println("--- label disabled shows no text: \n" + labelNoRadio.getText());
        System.out.println("labelNoRadio isDisplayed:     " + labelNoRadio.isDisplayed());
        System.out.println("labelNoRadio isEnabled:       " + labelNoRadio.isEnabled());
        System.out.println("labelNoRadio isSelected:      " + labelNoRadio.isSelected());

        System.out.println();

        System.out.println(inputNoRadio.getAttribute("class"));
        boolean disabledBool = inputNoRadio.getAttribute("class").contains("disabled");
        System.out.println("'inputNoRadio' contains disabled:  " + disabledBool);
        Assert.assertTrue(disabledBool);
        Assert.assertTrue("true", disabledBool);


    }

    public static void textBox_Attribute_CSSValue() {
        WebElement elem1 = driver.findElement(By.xpath("//div[@class=\"card mt-4 top-card\"][1]"));
        elem1.click();

        WebElement elem2 = driver.findElement(By.xpath("//span[contains(.,\"Text Box\")]"));
        elem2.click();

        WebElement elem3 = driver.findElement(By.xpath("//input[@id=\"userName\"]"));
        elem3.sendKeys("Ioan");

        WebElement elem4 = driver.findElement(By.xpath("//input[@id=\"userEmail\"]"));
        elem4.sendKeys("ioan@yahoo.com");

        WebElement elem5 = driver.findElement(By.xpath("//textarea[@id=\"currentAddress\"]"));
        elem5.sendKeys("adresa curenta");

        WebElement elem6 = driver.findElement(By.xpath("//textarea[@id=\"permanentAddress\"]"));
        elem6.sendKeys("adresa permanenta");


        WebElement elem7 = driver.findElement(By.xpath("//button[@id=\"submit\"]"));

        // used to scroll to the element (not seen directly due to the screen resolution) on the page and find it
        // after finding the element we can click it
        // in order to find the element on the page, we can use the Robot class to minimize the content of the page
        // we can use either Robot class or JavascriptExecutor, or both

        // JavascriptExecutor   -   clasa la nivel de Selenium care se numeste JavascriptExecutor
        // JavascriptExecutor   -   poate face handle la scroll
        // JavascriptExecutor   -   introduce java script in aplicatia mea
        // (JavascriptExecutor) driver   -   converteste driverul la JavascriptExecutor

        // coordonatele la nivel de pagina sunt in x si y si reprezinta pixelii
        // distanta de sus pana jos in pixeli si distanta de la stanga pana la elementul respectiv


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(2200,800)");	// position in pixels from top to bottom
        // we give those values depending on the position
        // of the not clickable element because it's
        // not seen on the page
        // if it scrolls and finds the element, then this part it will be a success

        // location

        System.out.println("Submit button's position on X-axis: " + elem7.getLocation().getX());	// location of the element elem7 depending on our screen resolution on X-axis
        System.out.println("Submit button's position on Y-axis: " + elem7.getLocation().getY());	// location of the element elem7 depending on our screen resolution on Y-axis

        // my position is: 2196 / 1606 , 622 / 620

        System.out.println();

        // good to know
        // iau atributele elementului elem7, submit

        System.out.println("getAttribute id:     " + elem7.getAttribute("id"));
        System.out.println("getAttribute type:   " + elem7.getAttribute("type"));
        System.out.println("getAttribute class:  " + elem7.getAttribute("class"));


        // iau textul elementului elem7, submit

        System.out.println("getText:             " + elem7.getText());	 // metoda de a lua textul(atributele) unui element - cea mai folosita
        System.out.println();


        // iau valori definite la nivel de CSS


        System.out.println("getCssValue css font:                   " + elem7.getCssValue("font"));
        System.out.println("getCssValue css font-size:              " + elem7.getCssValue("font-size"));
        System.out.println("getCssValue css font-family:            " + elem7.getCssValue("font-family"));
        System.out.println("getCssValue css font-style:             " + elem7.getCssValue("font-style"));
        System.out.println("getCssValue css font-weight:            " + elem7.getCssValue("font-weight"));
        System.out.println("getCssValue css font-variant:           " + elem7.getCssValue("font-variant"));

        System.out.println("getCssValue css display:                " + elem7.getCssValue("display"));
        System.out.println("getCssValue css visibility:             " + elem7.getCssValue("visibility"));

        // proprietatea overflow detectează dacă continutul elementului depaseste zona rezervată si este necesara bara de derulare

        System.out.println("getCssValue css overflow:               " + elem7.getCssValue("overflow"));
        System.out.println("getCssValue css cursor:                 " + elem7.getCssValue("cursor"));

        // modelul box în CSS

        //		margin - o zonă goală în jurul unui chenar. Marginea nu are culoare de fundal și este complet transparentă.
        //		border - un chenar care înconjoară conținutul.
        //		padding - o zonă goală în jurul conținutului. Această zonă este afectată de culoarea de fundal a casetei.
        //		content - conținutul casetei, unde apar textul și imaginile.

        //		width
        //		height
        //		padding
        //		border
        //		margin

        // margins

        System.out.println("getCssValue css margin:                 " + elem7.getCssValue("margin"));
        System.out.println("getCssValue css margin-left:            " + elem7.getCssValue("margin-left"));
        System.out.println("getCssValue css margin-right:           " + elem7.getCssValue("margin-right"));
        System.out.println("getCssValue css background-image:       " + elem7.getCssValue("background-image"));

        // chenare   -   proprietatea CSS border definește chenarul din jurul unui element

        System.out.println("getCssValue css border:                 " + elem7.getCssValue("border"));
        System.out.println("getCssValue css border-style:           " + elem7.getCssValue("border-style"));
        System.out.println("getCssValue css border-color:           " + elem7.getCssValue("border-color"));
        System.out.println("getCssValue css border-width:           " + elem7.getCssValue("border-width"));
        System.out.println("getCssValue css border-top:             " + elem7.getCssValue("border-top"));
        System.out.println("getCssValue css border-bottom:          " + elem7.getCssValue("border-bottom"));
        System.out.println("getCssValue css border-left:            " + elem7.getCssValue("border-left"));
        System.out.println("getCssValue css border-right:           " + elem7.getCssValue("border-right"));
        System.out.println("getCssValue css border-bottom-color:    " + elem7.getCssValue("border-bottom-color"));
        System.out.println("getCssValue css border-left-style:      " + elem7.getCssValue("border-left-style"));
        System.out.println("getCssValue css border-top-width:       " + elem7.getCssValue("border-top-width"));
        System.out.println("getCssValue css border-right-color:     " + elem7.getCssValue("border-right-color"));



        // proprietatea CSS padding definește spațiul dintre chenar și conținut


        System.out.println("getCssValue css padding:                " + elem7.getCssValue("padding"));
        System.out.println("getCssValue css padding-top:            " + elem7.getCssValue("padding-top"));
        System.out.println("getCssValue css padding-bottom:         " + elem7.getCssValue("padding-bottom"));
        System.out.println("getCssValue css padding-right:          " + elem7.getCssValue("padding-right"));
        System.out.println("getCssValue css padding-left:           " + elem7.getCssValue("padding-left"));


        // liste

        System.out.println("getCssValue css list-style:             " + elem7.getCssValue("list-style"));
        System.out.println("getCssValue css list-style-type:        " + elem7.getCssValue("list-style-type"));
        System.out.println("getCssValue css list-style-type:        " + elem7.getCssValue("list-style-position"));
        System.out.println("getCssValue css list-style-image:       " + elem7.getCssValue("list-style-image"));

        // text

        System.out.println("getCssValue css color:                  " + elem7.getCssValue("color"));
        System.out.println("getCssValue css direction:              " + elem7.getCssValue("direction"));
        System.out.println("getCssValue css line-height:            " + elem7.getCssValue("line-height"));
        System.out.println("getCssValue css letter-spacing:         " + elem7.getCssValue("letter-spacing"));
        System.out.println("getCssValue css vertical-align:         " + elem7.getCssValue("vertical-align"));
        System.out.println("getCssValue css white-space:            " + elem7.getCssValue("white-space"));
        System.out.println("getCssValue css direction:              " + elem7.getCssValue("word-spacing"));

        System.out.println("getCssValue css text-align:             " + elem7.getCssValue("text-align"));
        System.out.println("getCssValue css text-shadow:            " + elem7.getCssValue("text-shadow"));
        System.out.println("getCssValue css text-decoration:        " + elem7.getCssValue("text-decoration"));
        System.out.println("getCssValue css text-transform:         " + elem7.getCssValue("text-transform"));
        System.out.println("getCssValue css text-indent:            " + elem7.getCssValue("text-indent"));
        System.out.println("getCssValue css text-shadow:            " + elem7.getCssValue("text-shadow"));
        System.out.println("getCssValue css text-decoration:        " + elem7.getCssValue("text-decoration"));
        System.out.println("getCssValue css text-transform:         " + elem7.getCssValue("text-transform"));

        // background

        System.out.println("getCssValue css background:             " + elem7.getCssValue("background"));
        System.out.println("getCssValue css background-image:       " + elem7.getCssValue("background-image"));
        System.out.println("getCssValue css background-color:       " + elem7.getCssValue("background-color"));
        System.out.println("getCssValue css background-repeat:      " + elem7.getCssValue("background-repeat"));
        System.out.println("getCssValue css background-position:    " + elem7.getCssValue("background-position"));
        System.out.println("getCssValue css background-attachment:  " + elem7.getCssValue("background-attachment"));

        // outlines  -  linii exterioare

        System.out.println("getCssValue css outline:                " + elem7.getCssValue("outline"));
        System.out.println("getCssValue css outline-color:          " + elem7.getCssValue("outline-color"));
        System.out.println("getCssValue css outline-style:          " + elem7.getCssValue("outline-style"));
        System.out.println("getCssValue css outline-width:          " + elem7.getCssValue("outline-width"));


        System.out.println("getCssValue css filter:                 " + elem7.getCssValue("filter"));
        System.out.println("getCssValue css transform:              " + elem7.getCssValue("transform"));

        // dimensiunile unui element

        System.out.println("getCssValue css height:                 " + elem7.getCssValue("height"));
        System.out.println("getCssValue css max-height:             " + elem7.getCssValue("max-height"));
        System.out.println("getCssValue css min-height:             " + elem7.getCssValue("min-height"));

        System.out.println("getCssValue css width:                  " + elem7.getCssValue("width"));
        System.out.println("getCssValue css max-width:              " + elem7.getCssValue("max-width"));
        System.out.println("getCssValue css min-width:              " + elem7.getCssValue("min-width"));

        // s-au terminat de accesat atributele elementului submit, adica elem7

        System.out.println();

        // dam click pe element

        elem7.click();


        WebElement elem8 = driver.findElement(By.xpath("//div[@id=\"output\"]//p[@id=\"name\"]"));
        System.out.println(elem8.getText());

        WebElement elem9 = driver.findElement(By.xpath("//div[@id=\"output\"]//p[@id=\"name\"]/following-sibling::p[@id=\"email\"]"));
        System.out.println(elem9.getText());

        WebElement elem10 = driver.findElement(By.xpath("//div[@id=\"output\"]//p[@id=\"name\"]/following-sibling::p[@id=\"currentAddress\"]"));
        System.out.println(elem10.getText());

        WebElement elem11 = driver.findElement(By.xpath("//p[contains(.,\"Permananet Address :\")]"));
        System.out.println(elem11.getText());


        Assert.assertEquals("Name:Ioan", elem8.getText());
        Assert.assertEquals("Email:ioan@yahoo.com", elem9.getText());
        Assert.assertEquals("Current Address :adresa curenta", elem10.getText());
        Assert.assertEquals("Permananet Address :adresa permanenta", elem11.getText());


    }
}
