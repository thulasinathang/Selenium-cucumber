package pom;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageNav {

	private WebDriver driver;

	@CacheLookup
	@FindBy(className = "moe-btn-close")
	WebElement popupbtn;

	@CacheLookup
	@FindBy(id = "nav_46")
	WebElement hmeandkitn;

	@CacheLookup
	@FindBy(partialLinkText = "Curtains")
	WebElement curtainlink;
	

	public HomePageNav(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

// closing the push notification
	public void closepopup() {
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(popupbtn));
		popupbtn.click();
	}

// Navigating to to curtains page
	
	public void NavigateTo(String productcat, String prod) {
		Actions act = new Actions(driver);
		if(productcat.equalsIgnoreCase("Home&Kitchen")) {
		act.moveToElement(hmeandkitn).click().build().perform();
		}
		
		if(prod.equalsIgnoreCase("Curtains")) {
		act.moveToElement(curtainlink).click().build().perform();
		}
		
		ArrayList<String> winHandle = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(winHandle.get(1));

	}
// code end

// code to be continue
}

