package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.navigate().to("https://demoqa.com/date-picker");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		datePicker();
		datePicker2();

		// next day
		System.out.println(findNextDay(LocalDate.now()));

		// find today plus 1
		System.out.println(findTodayPlusOne(LocalDate.now()));
		
		// find today
		System.out.println(findToday(LocalDate.now()));
		
		System.out.println(findDay(LocalDate.now()));
		
		// current day of the month
		System.out.println(findCurrentDayOfMonth(LocalDate.now()));

		// over 3 days
		System.out.println(findOverThreeDays(LocalDate.now()));

		// over 5 days +2
		System.out.println(findOverFiveDays(LocalDate.now()));
		
		// current day 2
		System.out.println(findCurrentDay2());
		
		// current month
		System.out.println(findCurrentMonth());
		
		// current year
		System.out.println(findCurrentYear());
		
		// finding current day if it has 2 numbers
		datePickerParam1();
		
		// finding next day this month no matter how many numbers the day has
		datePickerParam2();
		
		Thread.sleep(1000);
		
		driver.close();
		driver.quit();
	}
	
	public static void datePickerParam2() throws InterruptedException {
		WebElement inputCalendar = driver.findElement(By.id("datePickerMonthYearInput"));
		inputCalendar.click();
		
		Thread.sleep(1000);
		
		// choosing a day this month
		String nr = String.valueOf(findCurrentDay2()+1);
		if (Integer.valueOf(nr) < 10) { nr = "0" + nr;}
		
		WebElement dateCalendar = driver.findElement(By.xpath("//div[contains(@class,\"react-datepicker__day react-datepicker__day--0"+nr+"\")][not(contains(@class,\"outside\"))]"));
		System.out.println(dateCalendar.getText());
		dateCalendar.click();
		
		Thread.sleep(1000);
		
		// choosing same day next month
//		WebElement dateCalendar2 = driver.findElement(By.xpath("//div[contains(@class,\"react-datepicker__day react-datepicker__day--0"+nr+"\")][contains(@class,\"outside\")]"));
//		dateCalendar2.click();
		
	}
	
	public static void datePickerParam1() throws InterruptedException {
		WebElement inputCalendar = driver.findElement(By.id("datePickerMonthYearInput"));
		inputCalendar.click();
		
		Thread.sleep(1000);
		
		// choosing current day/a day this month, day will have one number
		int nr = findCurrentDay2();
		WebElement dateCalendar = driver.findElement(By.xpath("//div[contains(@class,\"react-datepicker__day react-datepicker__day--0"+nr+"\")][not(contains(@class,\"outside\"))]"));
		System.out.println(dateCalendar.getText());
		dateCalendar.click();
				
	}
	
	private static int findCurrentYear() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		Date date = new Date();
		
		String myDay = dateFormat.format(date);
		return Integer.valueOf(myDay);	  // convert String to int
	}
	
	private static int findCurrentMonth() {
		DateFormat dateFormat = new SimpleDateFormat("MM");
		Date date = new Date();
		
		String myDay = dateFormat.format(date);
		return Integer.valueOf(myDay);
	}
	
	private static int findCurrentDay2() {
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		
		String myDay = dateFormat.format(date);
		return Integer.valueOf(myDay);
	}
	
	private static int findOverFiveDays(LocalDate now) {
		// TODO Auto-generated method stub
		return now.plusDays(5).getDayOfMonth()+2;
	}
	
	private static int findOverThreeDays(LocalDate now) {
		// TODO Auto-generated method stub
		return now.getDayOfMonth()+3;
	}
	
	private static int findCurrentDayOfMonth(LocalDate now) {
		// TODO Auto-generated method stub
		return now.getDayOfMonth();
	}
	
	private static LocalDate findDay(LocalDate now) {
		// TODO Auto-generated method stub
		return now.withDayOfMonth(14);
	}
	
	private static LocalDate findToday(LocalDate now) {
		// TODO Auto-generated method stub
		return now;
	}
	
	private static LocalDate findTodayPlusOne(LocalDate now) {
		// TODO Auto-generated method stub
		return now.plusDays(1);
	}
	
	private static LocalDate findNextDay(LocalDate localdate) {
		// TODO Auto-generated method stub
		return localdate.plusDays(1);
	}

	public static void datePicker() {
		
		// when I can add datas directly in the input field
		
		WebElement inputCalendar = driver.findElement(By.id("datePickerMonthYearInput"));
		
		// delete the 10th characters of the date
		for (int i = 0; i <= 9 ; i++) {
			inputCalendar.sendKeys(Keys.BACK_SPACE);
		}
		
		inputCalendar.sendKeys("08/22/2022");
	}
	
	public static void datePicker2() throws InterruptedException {
		WebElement inputCalendar = driver.findElement(By.id("datePickerMonthYearInput"));
		inputCalendar.click();
		
		Thread.sleep(1000);
		
		// choosing a day this month
		String nr = "02";
		WebElement dateCalendar = driver.findElement(By.xpath("//div[contains(@class,\"react-datepicker__day react-datepicker__day--0"+nr+"\")][not(contains(@class,\"outside\"))]"));
		dateCalendar.click();
		
		Thread.sleep(1000);
		
		// choosing same day next month
//		WebElement dateCalendar2 = driver.findElement(By.xpath("//div[contains(@class,\"react-datepicker__day react-datepicker__day--0"+nr+"\")][contains(@class,\"outside\")]"));
//		dateCalendar2.click();
		
	}

}
