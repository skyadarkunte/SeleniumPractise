package SeleniumFramework.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.abstractComponents;

public class CartPage extends abstractComponents {

	WebDriver driver;
	@FindBy (css=".cartSection h3")
	private List <WebElement> producttitles;
	
	@FindBy(css=".totalRow button")
	WebElement checkOutEle;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyProductDisplay(String productName) {
		
		boolean match= producttitles.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;}
	public CheckoutPage gotoCheckout() {
		checkOutEle.click();
		return new CheckoutPage(driver);
		
	}
	



	


	

}
