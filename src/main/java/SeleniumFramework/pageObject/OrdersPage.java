package SeleniumFramework.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.abstractComponents;

public class OrdersPage extends abstractComponents {

	WebDriver driver;
	@FindBy (css="tr td:nth-child(3)")
	private List <WebElement> productnames;
	
	@FindBy(css=".totalRow button")
	WebElement checkOutEle;
	
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyOrderDisplay(String productName) {
		
		boolean match= productnames.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;}
	
	



	


	

}
