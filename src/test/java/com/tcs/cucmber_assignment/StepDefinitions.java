package com.tcs.cucmber_assignment;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pom.HomePageNav;
import pom.ProductDetailsPage;
import pom.ProductListPage;
import utils.Common;
import utils.Constants;
import utils.ReadProperties;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import dev.failsafe.internal.util.Assert;

public class StepDefinitions {

	WebDriver driver;
	Common common;
	HomePageNav home;
	ProductDetailsPage prod;
	String expectedmsg="Product added to cart";
	
	
	@Before
	public void setup() {
		ReadProperties properties= new ReadProperties();
		properties.loadProperties();
		common=new Common();
		common.invokebrowser(Constants.Browser, "");
		this.driver=common.getDriver();
		
	}
	
	@After
	public void tearDown() {
		common.quitBrowser();
	}
	
	@Given("User on shopclues website homepage")
	public void homePage() {
	   driver.navigate().to(Constants.App_URL);
	}
	@Given("User close the push notification pop up")
	public void closePopup() {
		home= new HomePageNav(driver);
		home.closepopup();
		
	    
	}
	@When("User select {string} from home page and select {string} from menu and change the focus to result page")
	public void productCatSelection(String productcat, String prod) {
		home= new HomePageNav(driver);
		home.NavigateTo(productcat, prod);
	    
	}
	@When("User click on the first result displayed and change the focus to productdetails page")
	public void productSelection() {
		ProductListPage prodlist=new ProductListPage(driver);
		prodlist.NavigateToProductPage();
		
	    
	}
	@When("User click on Add to Cart button")
	public void addToCart() {
	    prod= new ProductDetailsPage(driver);
	    prod.AddtoCart();
	}
	@Then("Validate the success message")
	public void validateMessage() {
		prod= new ProductDetailsPage(driver);
	    String actualmsg=prod.successmsg();
	    Assertions.assertTrue(actualmsg.equals(expectedmsg), "Message validation failed");
	   
	}

}
