package arc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Women')]"))).click();
		driver.findElement(By.xpath("//a[contains(@href,'/category_products/1')]")).click();
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("(//h2)[3]")).getText()=="Women - Dress Products") {
			System.out.println("Filtered successfully");
		}
		

		
	}
}

