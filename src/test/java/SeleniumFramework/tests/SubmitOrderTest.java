package SeleniumFramework.tests;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
//import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFramework.TestComponents.BaseTest;
import SeleniumFramework.pageObject.CartPage;
import SeleniumFramework.pageObject.CheckoutPage;
import SeleniumFramework.pageObject.ConfirmationPage;
import SeleniumFramework.pageObject.LandingPage;
import SeleniumFramework.pageObject.OrdersPage;
import SeleniumFramework.pageObject.ProductCatalogue;


public class SubmitOrderTest extends BaseTest{

	private static Logger logger = LogManager.getLogger(SubmitOrderTest.class);
	String productName= "ZARA COAT 3";
	
	

@Test(dataProvider="getData1", groups="PurchaseOrder")
	public void SubmitOrder(HashMap<String, String> input) throws IOException   {
		

		  
		  ProductCatalogue productcatalogue=landingpage.loginApplicaton(input.get("Username"),input.get("pwd"));
		  List <WebElement>  products=  productcatalogue.getProductList();
		   productcatalogue.addProducttoCart(input.get("productName"));
		   CartPage cartdisplay=productcatalogue.goToCartHeader();
		   Boolean match= cartdisplay.verifyProductDisplay(input.get("productName"));
	       Assert.assertTrue(match);
	       CheckoutPage checkoutpage = cartdisplay.gotoCheckout();
	       checkoutpage.selectCountry("India");
	       ConfirmationPage confirmationpage= checkoutpage.submitOrder();
	       String confirmmessage = confirmationpage.getconfirmationMessage();
	       Assert.assertTrue(confirmmessage.equalsIgnoreCase("Thankyou for the order.")) ;
	       
	      }
@Test (dependsOnMethods= {"SubmitOrder"})
  public void Ordervalidation() {
	  ProductCatalogue productcatalogue=landingpage.loginApplicaton("ss123@gmail.com", "Test@123");
	  OrdersPage orderspage= productcatalogue.goToOrdersPage();
	 Assert.assertTrue(orderspage.verifyOrderDisplay(productName));
  }






//public Object[][] getData() {
//	
//	return new Object[][] {{"ss123@gmail.com", "Test@123","ZARA COAT 3"},{"ss123@gmail.com", "Test@123","ADIDAS ORIGINAL"}};
//}


@DataProvider
public Object[][] getData1() throws IOException {
	
	List <HashMap<String,String>> data= getJsonDatatoMap(System.getProperty("user.dir")+"\\src\\test\\java\\Data\\data.json");
	
	return new Object[][] {{data.get(0)},{data.get(1)}};
}

//public Object[][] getData1() {
//	
//	HashMap<String, String> hm1= new HashMap<String, String>();
//	hm1.put("Username", "ss123@gmail.com");
//	hm1.put("pwd", "Test@123");
//	hm1.put("productName", "ZARA COAT 3");
//	
//	HashMap<String, String> hm2= new HashMap<String, String>();
//	hm2.put("Username", "ss123@gmail.com");
//	hm2.put("pwd", "Test@123");
//	hm2.put("productName", "ADIDAS ORIGINAL");
//	
//	return new Object[][] {{hm1},{hm2}};
//}

}
