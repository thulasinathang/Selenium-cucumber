package pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {

	@CacheLookup
	@FindBy(xpath = "//div[@class='column col3']")
	List<WebElement> searchlist;

	WebDriver driver;

	public ProductListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Naigating to product list page
	public void NavigateToProductPage() {

		searchlist.get(0).click();
		ArrayList<String> winHandle1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(winHandle1.get(2));

	}

}
