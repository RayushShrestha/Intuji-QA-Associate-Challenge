package arc;

import java.sql.Driver;
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
		if (driver.findElement(By.xpath("(//h2)[3]")).getText().equals("WOMEN - DRESS PRODUCTS")) {
			System.out.println("Filtered successfully");
		}
		List<WebElement>productList =driver.findElements(By.xpath("//div[@class='productinfo text-center']"));
		// Assume productList is a List<WebElement> of products
		productList.stream()
		    .findAny()
		    .ifPresent(product -> {
		        // Capture product info from list page (optional, to compare later)
		        String expectedName = product.findElement(By.xpath("(//p[.='Sleeveless Dress'])[1]")).getText();
		        String expectedPrice = product.findElement(By.xpath("(//div//h2)[4]")).getText();
		        // Click the product
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[contains(.,'View Product')]"))).click();

		        // Now on the product detail page
		        String actualName = driver.findElement(By.xpath("(//h2)[3]")).getText();
		        String actualPrice = driver.findElement(By.xpath("//span[.='Rs. 1000']")).getText();
		        String availability = driver.findElement(By.xpath("(//p)[4]")).getText();
		        

		        // Verifications
		        Assert.assertEquals(actualName, expectedName, "Product name mismatch!");
		        Assert.assertEquals(actualPrice, expectedPrice, "Product price mismatch!");
		        Assert.assertTrue(availability.contains("Availability: In Stock"), "Product is not available!");
		    });	
	}
}

