package arc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class page10 {
    public static void main(String[] args) {
    	WebDriverManager.chromedriver().setup();
        // Tell Selenium where your Chrome profile is
        ChromeOptions options = new ChromeOptions();
        options.addArguments("C:\\Users\\Dell\\AppData\\Local\\Google\\Chrome\\User Data");
        options.addArguments("profile-directory=Profile 5"); // or "Profile 1"

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
    }
}