
//  Check Box

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Elements_2 {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/checkbox");

        checkBox();

        Thread.sleep(4000);		// opreste executia sistemului pentru 4 secunde

        driver.close();
        driver.quit();
    }

    public static void checkBox() throws InterruptedException {
        WebElement checkBox = driver.findElement(By.xpath("//span[contains(.,\"Check Box\")]"));
        checkBox.click();

        // Home

        WebElement colorCheckBox = driver.findElement(By.xpath("//span[@class=\"rct-node-icon\"]/*"));
        System.out.println(colorCheckBox.getCssValue("color"));
        System.out.println(colorCheckBox.getAttribute("class"));
        Assert.assertTrue(colorCheckBox.getAttribute("class").contains("parent"));

        WebElement checkboxCheckBox = driver.findElement(By.xpath("//span[@class=\"rct-checkbox\"]/*"));
        System.out.println(checkboxCheckBox.getAttribute("class"));
        Assert.assertTrue(checkboxCheckBox.getAttribute("class").contains("uncheck"));
        checkboxCheckBox.click();

        WebElement checkboxCheckBox2 = driver.findElement(By.xpath("//span[@class=\"rct-checkbox\"]/*"));
        System.out.println(checkboxCheckBox2.getAttribute("class"));
        Assert.assertTrue(checkboxCheckBox2.getAttribute("class").contains("check"));

        Thread.sleep(1000);

        // Home text

        WebElement textCheckBox = driver.findElement(By.xpath("//span[@class=\"rct-title\"]"));
        System.out.println(textCheckBox.getText());
        textCheckBox.click();

        Thread.sleep(1000);

        // Home expand

        WebElement collapseCheckBox = driver.findElement(By.xpath("//span[@class=\"rct-text\"]/button[@class=\"rct-collapse rct-collapse-btn\"]/*"));
        System.out.println("Class attribute: " + collapseCheckBox.getAttribute("class"));
        Assert.assertTrue(collapseCheckBox.getAttribute("class").contains("expand"));
        collapseCheckBox.click();

        // Documents

        WebElement documentsText = driver.findElement(By.xpath("//div[@class=\"check-box-tree-wrapper\"]//ol/li[2]//span/label//span[3]"));
        System.out.println(documentsText.getText());

        WebElement documentsClick = driver.findElement(By.xpath("//div/ol/li/ol/li[2]/descendant::button/*"));
        documentsClick.click();

        // Office

        WebElement officeText = driver.findElement(By.xpath("//div[@class=\"check-box-tree-wrapper\"]//ol/li/ol/li[2]/ol/li[2]//label//span[3]"));
        System.out.println(officeText.getText());

        WebElement officeClick = driver.findElement(By.xpath("//div/ol/li/ol/li[2]/ol/li[2]/span/button/*"));
        officeClick.click();

        // Classified

        WebElement classified = driver.findElement(By.xpath("//div/ol/li/ol/li[2]/ol/li[2]/ol/li[3]/descendant::span[@class=\"rct-checkbox\"]/*"));
        classified.click();

        WebElement classifiedText = driver.findElement(By.xpath("//div/ol/li/ol/li[2]/ol/li[2]/ol/li[3]/descendant::span[@class=\"rct-title\"]"));
        System.out.println(classifiedText.getText());

        WebElement classifiedText2 = driver.findElement(By.xpath("//div[@class=\"check-box-tree-wrapper\"]//ol/li[3]//span/label//span[3]"));
        System.out.println(classifiedText2.getText());

        Assert.assertEquals(classifiedText.getText(), classifiedText2.getText());

        WebElement lista = driver.findElement(By.xpath("//div//ol//ol//ol//ol"));

        System.out.println("getCssValue css list-style:             " + lista.getCssValue("list-style"));
        System.out.println("getCssValue css list-style-type:        " + lista.getCssValue("list-style-type"));
        System.out.println("getCssValue css list-style-position:        " + lista.getCssValue("list-style-position"));


    }

}

