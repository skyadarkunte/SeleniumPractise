package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumFramework.pageObject.CartPage;
import SeleniumFramework.pageObject.OrdersPage;

public class abstractComponents {

	WebDriver driver;
	
	
	
	public abstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy (css="[routerlink*='myorders']")
	WebElement orderHeader;
	
	
	
	public CartPage goToCartHeader() {
		
		cartHeader.click();
		CartPage cartdisplay = new CartPage(driver);
		return cartdisplay;
	}
	
	public OrdersPage goToOrdersPage() {
		
		orderHeader.click();
		OrdersPage orderspage = new OrdersPage(driver);
		return orderspage;
	}
	
	public void waitForElementtoAppear(By findby) {
		
	      WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(5));
	      wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	      
	      
	}
	
	public void waitForWebElementtoAppear(WebElement findby) {
		
	      WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(5));
	      wait.until(ExpectedConditions.visibilityOf(findby));
	}
	
	public void waitForElementtoDisAppear(WebElement ele) {
		 WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

}
