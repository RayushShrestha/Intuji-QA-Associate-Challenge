package arc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCart {
	private WebDriver driver;
	private WebDriverWait wait;

	public AddCart(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void addItems() throws InterruptedException {
//		driver.navigate().back();
		List<WebElement> firstFourProducts = driver
				.findElements(By.xpath("(//div[@class='productinfo text-center'])[position() <= 4]"));

		for (WebElement product : firstFourProducts) {
			Thread.sleep(4000);
			System.out.println(product.getText());
			product.findElement(By.xpath("//a[@class='btn btn-default add-to-cart']")).click();
		}

		driver.findElement(By.xpath("//u")).click();
//		driver.navigate().back();
		driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
		firstFourProducts.stream().findAny().ifPresent(product -> {

			// Click '+' icon if needed
			WebElement plusIcon = wait.until(ExpectedConditions
					.elementToBeClickable(product.findElement(By.xpath("//a[contains(.,'View Product')]"))));
			plusIcon.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Update quantity input
			WebElement qtyInput = product.findElement(By.xpath(".//input[@type='number']"));
			qtyInput.click();
			qtyInput.clear();
			qtyInput.sendKeys("4");

		});

		Thread.sleep(4000);
	}
}