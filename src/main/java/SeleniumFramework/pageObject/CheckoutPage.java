package SeleniumFramework.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractComponents.abstractComponents;

public class CheckoutPage extends abstractComponents {

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	//
	@FindBy (css=".btnn.action__submit.ng-star-inserted")
	WebElement submitBtn;
	
	////
	@FindBy (xpath="//button[contains(@class,'ta-item ')][2]")
	WebElement selectcountry;
	
	By results = By.cssSelector(".ta-results");
	
	public void selectCountry(String CountryName) {
		   Actions a = new Actions(driver);
	      a.sendKeys(country, CountryName).build().perform();
	      waitForElementtoAppear(results);
	      selectcountry.click();
		
	}
	
	public ConfirmationPage submitOrder() {
		submitBtn.click();
		return new ConfirmationPage(driver);
	}
	
	

	



	


	

}
