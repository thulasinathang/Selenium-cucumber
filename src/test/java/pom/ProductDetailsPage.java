package pom;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {

	WebDriver driver;

	@CacheLookup
	@FindBy(id = "add_cart")
	WebElement addtocart;

	@CacheLookup
	@FindBy(xpath = "//div[@id='snackbar']")
	WebElement successmsg;

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Adding the product into card
	public void AddtoCart() {

		addtocart.click();

	}

	// Capturing the success message
	public String successmsg() {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(successmsg));
		String actualmsg = successmsg.getText();
		return actualmsg;
		
	}
	
	public void returnToHomePage() {
		ArrayList<String> winHandle1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(winHandle1.get(0));
	}
}
