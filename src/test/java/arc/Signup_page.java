package arc;




import java.util.NoSuchElementException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signup_page {
	private WebDriver driver;
	private WebDriverWait wait;

	public Signup_page(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	public void createUser() {
		driver.findElement(By.xpath("//a[contains(.,'Signup / Login')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name"))).sendKeys("Hello Intuij ");
		driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[2]")).sendKeys("abc12@gmail.com");
		driver.findElement(By.xpath("//div//button[.='Signup']")).click();
		try {
		    WebElement errorMsg = driver.findElement(By.xpath("//p[.='Email Address already exist!']"));
		    if (errorMsg.isDisplayed()) {
		        System.out.println("Email already exists!");
		       
		    }
		} catch (NoSuchElementException e) {
		    System.out.println("No error message → Signup successful!");
		}
	}
}
