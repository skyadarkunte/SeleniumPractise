package SeleniumFramework.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.abstractComponents;

public class ProductCatalogue extends abstractComponents {

	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
//	List <WebElement> products= driver.findElements(By.cssSelector(".mb-3"));= driver.findElements(By.cssSelector(".mb-3"));
	@FindBy (css=".mb-3")
	List <WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	By productsBy= By.cssSelector(".mb-3");
	By addToCart= By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	public List <WebElement> getProductList() {
		
		waitForElementtoAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		
		WebElement prod = getProductList().stream().filter(item->
	      item.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
		
	}
	
	public void addProducttoCart(String productName) {
		
		WebElement prod= getProductByName(productName);
		 prod.findElement(addToCart).click();
		 waitForElementtoAppear(toastMessage);
		  waitForElementtoDisAppear(spinner);
		
	}
	


	

}
