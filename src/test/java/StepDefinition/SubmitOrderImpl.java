package StepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import SeleniumFramework.TestComponents.BaseTest;
import SeleniumFramework.pageObject.CartPage;
import SeleniumFramework.pageObject.CheckoutPage;
import SeleniumFramework.pageObject.ConfirmationPage;
import SeleniumFramework.pageObject.LandingPage;
import SeleniumFramework.pageObject.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubmitOrderImpl extends BaseTest {
	
	public LandingPage landingpage;
	public ProductCatalogue productcatalogue;
	public  ConfirmationPage confirmationpage;
	@Given ("I landed on ecommerce page.")
	
	public void I_landed_on_ecommerce_page() throws IOException
	{
		landingpage= launchApplication();
	}
	
	
	@Given ("^Logged in with username (.+) and password (.+)$")
	
	public void Logged_in_with_username_and_password (String Username, String pwd) {
		  productcatalogue=landingpage.loginApplicaton(Username,pwd);
	}
	
	@When ("^I add Product (.+) to Cart$")
	
	public void I_add_Product_to_Cart(String productName) {
		
		 List <WebElement>  products=  productcatalogue.getProductList();
		  productcatalogue.addProducttoCart(productName);
	}
	
	@When ("^Checkout (.+) and submit the order.$")
	 public void Checkout_and_submit_the_order(String productName) {
		   CartPage cartdisplay=productcatalogue.goToCartHeader();
		   Boolean match= cartdisplay.verifyProductDisplay(productName);
	       Assert.assertTrue(match);
	 
	       CheckoutPage checkoutpage = cartdisplay.gotoCheckout();
	       checkoutpage.selectCountry("India");
	       confirmationpage= checkoutpage.submitOrder();
		}
	@Then ("{string} message is displayed on confirmaton page.")
	
	public void message_is_displayed_on_confirmaton_page(String string)
	{
		String confirmmessage = confirmationpage.getconfirmationMessage();
	       Assert.assertTrue(confirmmessage.equalsIgnoreCase("Thankyou for the order.")) ;
	       driver.close();
	}
	
	 @Then("^\"([^\"]*)\" message is displayed$")
	  public void messageIsDisplayed(String errorMessage) {
		 Assert.assertEquals(errorMessage, landingpage.getErrorMessage());
		 driver.close();
	    }
}
