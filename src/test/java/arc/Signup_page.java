package arc;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signup_page {
	private WebDriver driver;
	private WebDriverWait wait;

	public Signup_page(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void createUser() throws InterruptedException {
		String userEmail="abc" + System.currentTimeMillis() + "@gmail.com";
		driver.findElement(By.xpath("//a[contains(.,'Signup / Login')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name"))).sendKeys("Hello Intuji ");
		driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]")).sendKeys(userEmail);
		System.out.println(userEmail);
		driver.findElement(By.xpath("//div//button[.='Signup']")).click();
//		try {
//			WebElement errorMsg = driver.findElement(By.xpath("//p[.='Email Address already exist!']"));
//			if (errorMsg.isDisplayed()) {
//				System.out.println("Email already exists!");
//
//			}
//		} catch (NoSuchElementException e) {
//			System.out.println("No error message: Signup successful!");
//		}
		
		//account information
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.name("password")).sendKeys("Password@12");
		// select day
		WebElement day = driver.findElement(By.name("days"));
		Select selectDay = new Select(day);
		selectDay.selectByVisibleText("31");
		Thread.sleep(200);
		// select month
		WebElement month = driver.findElement(By.name("months"));
		Select selectMonth = new Select(month);
		selectMonth.selectByVisibleText("December");
		Thread.sleep(200);
		//select year
		WebElement year = driver.findElement(By.name("years"));
		Select selectYear = new Select(year);
		selectYear.selectByVisibleText("1990");
		driver.findElement(By.xpath("//label[.='Sign up for our newsletter!']")).click();
		driver.findElement(By.xpath("//label[.='Receive special offers from our partners!']")).click();
		
		//address information
		driver.findElement(By.name("first_name")).sendKeys("Jhon");
		
		driver.findElement(By.name("last_name")).sendKeys("Doe");
		driver.findElement(By.name("company")).sendKeys("INTUJI");
		driver.findElement(By.name("address1")).sendKeys("chabhil");
		driver.findElement(By.name("address2")).sendKeys("saraswati nagar");
		
		WebElement country=driver.findElement(By.name("country"));
		Select countryList=new Select(country);
		countryList.selectByVisibleText("Canada");
		driver.findElement(By.name("state")).sendKeys("Bagmati");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Kathmandu");
		driver.findElement(By.name("zipcode")).sendKeys("123456");
		driver.findElement(By.name("mobile_number")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[.='Create Account']")).click();
		driver.findElement(By.xpath("//a[.='Continue']")).click();
		driver.findElement(By.xpath("//a[.=' Logout']")).click();
		Thread.sleep(2000);
	}

}
