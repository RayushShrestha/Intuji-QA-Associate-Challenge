package arc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Product_page {
	private WebDriver driver;
	private WebDriverWait wait;

	public Product_page(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	public void filter() throws InterruptedException {
	

		List<WebElement> navBar=driver.findElements(By.xpath("//ul//li"));
		navBar.stream().filter(s->s.getText().contains(" Products")).findFirst().ifPresent(WebElement::click);
		
		driver.findElement(By.xpath("(//h4)[1]")).click();
		List<WebElement> genderDress=driver.findElements(By.xpath("(//div[@class='panel-body'])[1]//ul//li"));
		genderDress.stream().filter(s->s.getText().contains("Dress ")).findFirst().ifPresent(WebElement::click);
//		Assert.assertEquals("Women > Dress", driver.findElement(By.xpath("(//section//div//div//ol//li)[2]")).getText());
//		System.out.println("Filtered applied successfully");
		if (driver.findElement(By.xpath("(//h2)[3]")).getText()=="Women - Dress Products") {
			System.out.println("Filtered successfully");
		}
		
		Thread.sleep(4000);
		
	}
}

