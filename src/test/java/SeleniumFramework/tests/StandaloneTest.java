package SeleniumFramework.tests;


import java.time.Duration;
import java.util.List;
//Test
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SeleniumFramework.pageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest {

	private static final String WebDriver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  WebDriverManager.chromedriver().setup();
		  String productName= "ZARA COAT 3";
		  WebDriver  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  LandingPage landingpage= new LandingPage(driver);
		  
		  driver.get("https://rahulshettyacademy.com/client");
		  
		  
		  driver.manage().window().maximize();
		  driver.findElement(By.id("userEmail")).sendKeys("ss123@gmail.com");
		  driver.findElement(By.id("userPassword")).sendKeys("Test@123");
	      driver.findElement(By.id("login")).click();
	      WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(5));
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	      List <WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
	      WebElement prod = products.stream().filter(item->
	      item.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);	
	      prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	     
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	      wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	      
	      driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	      
	      List <WebElement> cartProducts= driver.findElements(By.cssSelector(".cartSection h3"));
	      Boolean match= cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
	      Assert.assertTrue(match);
	      driver.findElement(By.cssSelector(".totalRow button")).click();
	      
	      Actions a = new Actions(driver);
	      
	      a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	      driver.findElement(By.xpath("//button[contains(@class,'ta-item ')][2]")).click();
	      driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
	      
	      String confirmMessage= driver.findElement(By.cssSelector(".hero-primary")).getText();
	      
	     Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order.")) ;
	     driver.close();
	      
	      //.ng-animating
		  
	}

}
