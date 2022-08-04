import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQALogin {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/login");

        userName();
        password();
        login();


        Thread.sleep(2000);

        driver.close();
        driver.quit();

    }

    public static void userName() {
        WebElement user = driver.findElement(By.xpath("//div[@id=\"userName-wrapper\"]/div[2]/input[@class=\"mr-sm-2 form-control\"]"));
        user.sendKeys("aura");
    }

    public static void password() {
        WebElement pass = driver.findElement(By.xpath("//div[@id=\"password-wrapper\"]/div[2]/input[@class=\"mr-sm-2 form-control\"]"));
        pass.sendKeys("Automation22!");
    }

    public static void login() throws InterruptedException {
        WebElement login = driver.findElement(By.xpath("//div[@class=\"login-wrapper\"]/form/div[4]/div[1]"));
//		WebElement login = driver.findElement(By.xpath("//div[@id="password-wrapper"]/following-sibling::div[1]/descendant::div[1]/button[@class="btn btn-primary"]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(950,800)");

        System.out.println(login.getLocation().getX());
        System.out.println(login.getLocation().getY());

        System.out.println(login.getText());
        login.click();
        Thread.sleep(3000);

        WebElement logout = driver.findElement(By.xpath("//div[@class=\"text-right col-md-5 col-sm-12\"]/button[@class=\"btn btn-primary\"]"));
        System.out.println(logout.getText());
        logout.click();


    }
}
