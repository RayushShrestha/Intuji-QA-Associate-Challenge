package arc;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class page10 {
    public static void main(String[] args) throws InterruptedException {
    	WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//String url= "https://automationexercise.com/";
		String url= "https://automationexercise.com/login";
		driver.get(url);
		Signup_page signup=new Signup_page(driver, wait);
		LoginPage log= new LoginPage(driver);
		Product_page products=new Product_page(driver, wait);
		
		
//		signup.createUser();
		log.signin();
		products.filter();
		
		
		driver.quit();
		
    	
    }
}