package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tables {
	
	static WebDriver driver;
	
	public static void main(String[] args ) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://demoqa.com/webtables");
		
		tables();
		
		// to minimize the content of the page so that the elements can be seen
		
		Robot robot = new Robot();
		
		for (int i = 0; i < 5; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		
		Thread.sleep(4000);		// opreste executia sistemului pentru 4 secunde
		
		driver.close();
		driver.quit();
		
	}
	
	public static void tables() {
		
		WebElement tableRow1 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[1]/div"));
		List<WebElement> lineElem1 = tableRow1.findElements(By.tagName("div"));
		List<String> lineElemStr1 = new ArrayList<String>();
		
		for (WebElement elem : lineElem1 ) {
			System.out.println(elem.getText());
			lineElemStr1.add(elem.getText());
			
		}
		
		System.out.println(lineElemStr1);
		
		System.out.println();
		
		WebElement tableRow2 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[2]/div"));
		List<WebElement> lineElem2 = tableRow2.findElements(By.tagName("div"));
		List<String> lineElemStr2 = new ArrayList<String>();
		
		for (WebElement elem : lineElem2 ) {
			System.out.println(elem.getText());
			lineElemStr2.add(elem.getText());
			
		}
		
		System.out.println(lineElemStr2);
		
		System.out.println();
		
		WebElement tableRow3 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[3]/div"));
		List<WebElement> lineElem3 = tableRow3.findElements(By.tagName("div"));
		List<String> lineElemStr3 = new ArrayList<String>();
		
		for (WebElement elem : lineElem3 ) {
			System.out.println(elem.getText());
			lineElemStr3.add(elem.getText());
			
		}
		
		System.out.println(lineElemStr3);
		
		System.out.println();
		
		// parametrized
		// row   -   get the elements from one line containing one string
		
		System.out.println("Parametrized:");
		System.out.println();
		
		String firstName1 = "Cierra";
		
		WebElement paramLastName1 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[1]/div/div[contains(.,\""+firstName1+"\")]/following-sibling::div[1]"));
		System.out.println(paramLastName1.getText());
		
		WebElement paramAge1 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[1]/div/div[contains(.,\""+firstName1+"\")]/following-sibling::div[2]"));
		System.out.println(paramAge1.getText());

		WebElement paramEmail1 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[1]/div/div[contains(.,\""+firstName1+"\")]/following-sibling::div[3]"));
		System.out.println(paramEmail1.getText());
		
		WebElement paramSalary1 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[1]/div/div[contains(.,\""+firstName1+"\")]/following-sibling::div[4]"));
		System.out.println(paramSalary1.getText());
		
		WebElement paramDepartment1 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[1]/div/div[contains(.,\""+firstName1+"\")]/following-sibling::div[5]"));
		System.out.println(paramDepartment1.getText());
		
		System.out.println();
		
		String firstName2 = "Alden";
		
		WebElement paramLastName2 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[2]/div/div[contains(.,\""+firstName2+"\")]/following-sibling::div[1]"));
		System.out.println(paramLastName2.getText());
		
		WebElement paramAge2 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[2]/div/div[contains(.,\""+firstName2+"\")]/following-sibling::div[2]"));
		System.out.println(paramAge2.getText());

		WebElement paramEmail2 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[2]/div/div[contains(.,\""+firstName2+"\")]/following-sibling::div[3]"));
		System.out.println(paramEmail2.getText());
		
		WebElement paramSalary2 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[2]/div/div[contains(.,\""+firstName2+"\")]/following-sibling::div[4]"));
		System.out.println(paramSalary2.getText());
		
		WebElement paramDepartment2 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[2]/div/div[contains(.,\""+firstName2+"\")]/following-sibling::div[5]"));
		System.out.println(paramDepartment2.getText());
		
		System.out.println();
		
		String lastName3 = "Gentry";
		
		WebElement paramfirstName3 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[3]/div/div[contains(.,\""+lastName3+"\")]/preceding-sibling::div[1]"));
		System.out.println(paramfirstName3.getText());
		
		WebElement paramAge3 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[3]/div/div[contains(.,\""+lastName3+"\")]/following-sibling::div[1]"));
		System.out.println(paramAge3.getText());

		WebElement paramEmail3 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[3]/div/div[contains(.,\""+lastName3+"\")]/following-sibling::div[2]"));
		System.out.println(paramEmail3.getText());
		
		WebElement paramSalary3 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[3]/div/div[contains(.,\""+lastName3+"\")]/following-sibling::div[3]"));
		System.out.println(paramSalary3.getText());
		
		WebElement paramDepartment3 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[3]/div/div[contains(.,\""+lastName3+"\")]/following-sibling::div[4]"));
		System.out.println(paramDepartment3.getText());
		
		System.out.println();
		
		String age4 = "29";
		
		WebElement paramFirstName4 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[3]/div/div[contains(.,\""+age4+"\")]/preceding-sibling::div[2]"));
		System.out.println(paramFirstName4.getText());
		
		WebElement paramLastName4 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[3]/div/div[contains(.,\""+age4+"\")]/preceding-sibling::div[1]"));
		System.out.println(paramLastName4.getText());
		
		WebElement paramEmail4 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[3]/div/div[contains(.,\""+age4+"\")]/following-sibling::div[1]"));
		System.out.println(paramEmail4.getText());
		
		WebElement paramSalary4 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[3]/div/div[contains(.,\""+age4+"\")]/following-sibling::div[2]"));
		System.out.println(paramSalary4.getText());
		
		WebElement paramDepartment4 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[3]/div/div[contains(.,\""+age4+"\")]/following-sibling::div[3]"));
		System.out.println(paramDepartment4.getText());
		
		System.out.println();
		
		String email5 = "cierra@example.com";
		
		WebElement paramFirstName5 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[1]/div/div[contains(.,\""+email5+"\")]/preceding-sibling::div[3]"));
		System.out.println(paramFirstName5.getText());
		
		WebElement paramLastName5 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[1]/div/div[contains(.,\""+email5+"\")]/preceding-sibling::div[2]"));
		System.out.println(paramLastName5.getText());
		
		WebElement paramAge5 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[1]/div/div[contains(.,\""+email5+"\")]/preceding-sibling::div[1]"));
		System.out.println(paramAge5.getText());
		
		WebElement paramSalary5 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[1]/div/div[contains(.,\""+email5+"\")]/following-sibling::div[1]"));
		System.out.println(paramSalary5.getText());
		
		WebElement paramDepartment5 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[1]/div/div[contains(.,\""+email5+"\")]/following-sibling::div[2]"));
		System.out.println(paramDepartment5.getText());
		
		System.out.println();
		
		String salary6 = "12000";
		
		WebElement paramFirstName6 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[2]/div/div[contains(.,\""+salary6+"\")]/preceding-sibling::div[4]"));
		System.out.println(paramFirstName6.getText());
		
		WebElement paramLastName6 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[2]/div/div[contains(.,\""+salary6+"\")]/preceding-sibling::div[3]"));
		System.out.println(paramLastName6.getText());
		
		WebElement paramAge6 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[2]/div/div[contains(.,\""+salary6+"\")]/preceding-sibling::div[2]"));
		System.out.println(paramAge6.getText());
		
		WebElement paramEmail6 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[2]/div/div[contains(.,\""+salary6+"\")]/preceding-sibling::div[1]"));
		System.out.println(paramEmail6.getText());
		
		WebElement paramDepartment6 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[2]/div/div[contains(.,\""+salary6+"\")]/following-sibling::div[1]"));
		System.out.println(paramDepartment6.getText());
		
		System.out.println();
		
		String department7 = "Legal";
		
		WebElement paramFirstName7 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[3]/div/div[contains(.,\""+department7+"\")]/preceding-sibling::div[5]"));
		System.out.println(paramFirstName7.getText());
		
		WebElement paramLastName7 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[3]/div/div[contains(.,\""+department7+"\")]/preceding-sibling::div[4]"));
		System.out.println(paramLastName7.getText());
		
		WebElement paramAge7 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[3]/div/div[contains(.,\""+department7+"\")]/preceding-sibling::div[3]"));
		System.out.println(paramAge7.getText());
		
		WebElement paramEmail7 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[3]/div/div[contains(.,\""+department7+"\")]/preceding-sibling::div[2]"));
		System.out.println(paramEmail7.getText());
		
		WebElement paramSalary7 = driver.findElement(By.xpath("//div[@class=\"rt-tbody\"]/div[3]/div/div[contains(.,\""+department7+"\")]/preceding-sibling::div[1]"));
		System.out.println(paramSalary7.getText());
		
		System.out.println();
		
		// all the elements/cells (70) from the table  -  shown 22
		
		List<WebElement> all = driver.findElements(By.xpath("//div[@class=\"rt-table\"]/descendant::div[@class=\"rt-tbody\"]//div[@class=\"rt-td\"]"));
		
		List<String> allText = new ArrayList<String>();
		
		for (int i = 0; i < all.size() - 48; i++) {
			System.out.println(all.get(i).getText());
			allText.add(all.get(i).getText());
		}
		
		System.out.println(allText);
		
		System.out.println();
		
		// elements from the first column, 10 total, shown 4
		
		List<WebElement> firstCol = driver.findElements(By.xpath("//div[@class=\"rt-tbody\"]/descendant::div[@class=\"rt-tr-group\"]/div/div[1]"));
		
		List<String> firstColText = new ArrayList<String>();
		
		for (int i = 0; i < firstCol.size() - 6; i++) {
			System.out.println(firstCol.get(i).getText());
			firstColText.add(firstCol.get(i).getText());
		}
		
		System.out.println(firstColText);
		
		System.out.println();
		
		// elements from the second column, 10 total, shown 4
		
		List<WebElement> secondCol = driver.findElements(By.xpath("//div[@class=\"rt-tbody\"]/descendant::div[@class=\"rt-tr-group\"]/div/div[2]"));
		
		List<String> secondColText = new ArrayList<String>();
		
		for (int i = 0; i < secondCol.size() - 6; i++) {
			System.out.println(secondCol.get(i).getText());
			secondColText.add(secondCol.get(i).getText());
		}
		
		System.out.println(secondColText);
		
		System.out.println();
		
		// elements from the third column, 10 total, shown 4
		
		List<WebElement> thirdCol = driver.findElements(By.xpath("//div[@class=\"rt-tbody\"]/descendant::div[@class=\"rt-tr-group\"]/div/div[3]"));
		
		List<String> thirdColText = new ArrayList<String>();
		
		for (int i = 0; i < thirdCol.size() - 6; i++) {
			System.out.println(thirdCol.get(i).getText());
			thirdColText.add(thirdCol.get(i).getText());
		}
		
		System.out.println(thirdColText);
		
		System.out.println();
		
		// elements from the fourth column, 10 total, shown 4
		
		List<WebElement> fourthCol = driver.findElements(By.xpath("//div[@class=\"rt-tbody\"]/descendant::div[@class=\"rt-tr-group\"]/div/div[4]"));
		
		List<String> fourthColText = new ArrayList<String>();
		
		for (int i = 0; i < fourthCol.size() - 6; i++) {
			System.out.println(fourthCol.get(i).getText());
			fourthColText.add(fourthCol.get(i).getText());
		}
		
		System.out.println(fourthColText);
		
		System.out.println();
		
		// elements from the fifth column, 10 total, shown 4
		
		List<WebElement> fifthCol = driver.findElements(By.xpath("//div[@class=\"rt-tbody\"]/descendant::div[@class=\"rt-tr-group\"]/div/div[5]"));
		
		List<String> fifthColText = new ArrayList<String>();
		
		for (int i = 0; i < fifthCol.size() - 6; i++) {
			System.out.println(fifthCol.get(i).getText());
			fifthColText.add(fifthCol.get(i).getText());
		}
		
		System.out.println(fifthColText);
		
		System.out.println();
		
		// elements from the sixth column, 10 total, shown 4
		
		List<WebElement> sixthCol = driver.findElements(By.xpath("//div[@class=\"rt-tbody\"]/descendant::div[@class=\"rt-tr-group\"]/div/div[6]"));
		
		List<String> sixthColText = new ArrayList<String>();
		
		for (int i = 0; i < sixthCol.size() - 6; i++) {
			System.out.println(sixthCol.get(i).getText());
			sixthColText.add(sixthCol.get(i).getText());
		}
		
		System.out.println(sixthColText);
		
		System.out.println();
		

		
		
		
	}
	

}
