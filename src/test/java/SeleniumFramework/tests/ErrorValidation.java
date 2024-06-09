package SeleniumFramework.tests;


import java.io.IOException;
import java.time.Duration;
//import java.time.Duration;
import java.util.List;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sun.net.httpserver.Authenticator.Retry;

import SeleniumFramework.TestComponents.BaseTest;
import SeleniumFramework.pageObject.CartPage;
import SeleniumFramework.pageObject.CheckoutPage;
import SeleniumFramework.pageObject.ConfirmationPage;
import SeleniumFramework.pageObject.LandingPage;
import SeleniumFramework.pageObject.ProductCatalogue;


public class ErrorValidation extends BaseTest{


@Test (groups= {"Error validation"})
	public void loginErrorvalidation() throws IOException   {
		

		  String productName= "ZARA COAT 3";
		  System.out.println(productName);
		  ProductCatalogue productcatalogue=landingpage.loginApplicaton("ss1234@gmail.com", "Tes2t@123");
	      Assert.assertEquals("Incorrect1 email or password.", landingpage.getErrorMessage());
		  }
@Test
public void productvalidation() {
	
	  String productName= "ZARA COAT 3";
	  ProductCatalogue productcatalogue=landingpage.loginApplicaton("ss123@gmail.com", "Test@123");
	  List <WebElement>  products=  productcatalogue.getProductList();
	   productcatalogue.addProducttoCart(productName);
	   CartPage cartdisplay=productcatalogue.goToCartHeader();
	   Boolean match= cartdisplay.verifyProductDisplay("ZARA COAT 33");
       Assert.assertFalse(match);
       
       SoftAssert softassert = new SoftAssert();
       
       softassert.assertTrue(false);
     
}

}
