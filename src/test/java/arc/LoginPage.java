package arc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {
	private WebDriver driver;


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	public void signin() {
		String URL =driver.getCurrentUrl();
		
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("abc1756786299170@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Password@12");
		driver.findElement(By.xpath("//button[.='Login']")).click();
		
		
		
		if (URL.equals("https://automationexercise.com/login")) {
		    System.out.println("LOGGED IN");
		} else {
		    System.out.println("Invalid credentials" );
		}
	}
}