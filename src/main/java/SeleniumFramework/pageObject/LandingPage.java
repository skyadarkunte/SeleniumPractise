package SeleniumFramework.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.abstractComponents;

public class LandingPage extends abstractComponents {

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy (id="userEmail")
	WebElement useremail;
	@FindBy (id="userPassword")
	WebElement pwd;
	@FindBy (id="login")
	WebElement login;
	@FindBy (css="div[aria-label='Incorrect email or password.']")
	WebElement loginerrorvalidation;
	
	public ProductCatalogue loginApplicaton(String username, String password) {
		useremail.sendKeys(username);
		pwd.sendKeys(password);
		login.click();
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage() {
		waitForWebElementtoAppear(loginerrorvalidation);
		return loginerrorvalidation.getText();
		
	}

}
