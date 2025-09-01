package arc;
import org.openqa.selenium.WebDriver;
public class LoginPage {
	private WebDriver driver;


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	public void signin() {
		String URL =driver.getCurrentUrl();
		if (URL.equals("https://automationexercise.com/")) {
		    System.out.println("LOGGED IN");
		} else {
		    System.out.println("Invalid credentials" );
		}
	}
}