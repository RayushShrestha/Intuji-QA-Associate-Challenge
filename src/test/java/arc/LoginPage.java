package arc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {
	private WebDriver driver;


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	public void signin() {

		
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("abc1756786299170@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Password@12");
		driver.findElement(By.xpath("//button[.='Login']")).click();
		 
		String loginText= driver.findElement(By.xpath("(//a)[contains(.,'Logged in as Hello Intuji')]")).getText().trim();
		if(loginText.equals("Logged in as Hello Intuji")) {
			System.out.println(" logged in");
		}
		else
			System.out.println("invalid cred");
		
	}
}