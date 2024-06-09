package SeleniumFramework.TestComponents;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.log4testng.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumFramework.pageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingpage;

	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		 FileInputStream fs = new FileInputStream("C:\\Users\\manis\\WS\\SeleniumFramework\\src\\main\\java\\Resources\\GlobalData.properties");
		 prop.load(fs); 
		
		 String browserName= System.getProperty("browser") !=null ? System.getProperty("browser") :prop.getProperty("browser");
		 if (browserName.equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup();
		      driver = new ChromeDriver();
		 }
		 
		 else if (browserName.equalsIgnoreCase("edge")) {
			 WebDriverManager.edgedriver().setup();
		      driver = new EdgeDriver();
		 }
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   driver.manage().window().maximize();
		   return driver;
		   }
	
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		 driver= initializeDriver();
		 landingpage= new LandingPage(driver);
		 landingpage.goTo();
		return landingpage;
		
	}
	
	@AfterMethod (alwaysRun=true)
	public void teardown() {
		driver.close();
	}
	
	public List<HashMap<String, String>> getJsonDatatoMap(String FilePath) throws IOException {
	String jsoncontent= FileUtils.readFileToString(new File(FilePath), StandardCharsets.UTF_8);
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String, String>> data= mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>(){
		
	});
	
	
	
	
	return data;
	}
	
	public String getScreenShot(String testcasename, WebDriver driver) throws IOException {
		
		TakesScreenshot ts =(TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File dest= new File(System.getProperty("user.dir")+ "\\reports\\"+testcasename+".png");
		FileUtils.copyFile(source, dest);
		return System.getProperty("user.dir")+ "\\reports\\"+testcasename+".png";
	}
	
//	public Object[][] mydata() throws IOException{
//		FileInputStream fis= new FileInputStream("C:\\Users\\manis\\WS\\SeleniumFramework\\src\\test\\java\\Data\\data.xlsx");
//		 HSSFWorkbook wb=new HSSFWorkbook(fis);
//		 HSSFSheet sheet= wb.getSheet("data");
//		 List <HashMap<String,String>> hm =  new <HashMap<String, String>> ();
//		 
//		 
//		 for (int i=1;i<=sheet.getLastRowNum();i++) {
//			 
//			String Firstname= sheet.getRow(i).getCell(0).getStringCellValue();
//			String Lastname=sheet.getRow(i).getCell(1).getStringCellValue();
//			
//			hm.put(Firstname, Lastname);
//		 }
//		return new Object[][] {{hm}};
//		
//		
//	}
	

}
