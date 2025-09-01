package arc;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class page1 {
    private WebDriver driver;

    public page1(WebDriver driver) {
        this.driver = driver;
    }

    public void fillOrgDetails(String companyMail) throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='companyName']")).sendKeys("Everestwalk Groups");
        driver.findElement(By.xpath("//input[@name='companyEmail']")).sendKeys(companyMail);
        driver.findElement(By.xpath("//span[contains(text(),'Select Company Type')]")).click();

        List<WebElement> companyType = driver.findElements(By.xpath("//div[@role='option']"));
        companyType.stream()
            .filter(s -> s.getText().contains("Joint Venture"))
            .findFirst()
            .ifPresent(WebElement::click);

        driver.findElement(By.xpath("//input[@id='yearOfEstablishment']")).sendKeys("2025");
        driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
    }
}

