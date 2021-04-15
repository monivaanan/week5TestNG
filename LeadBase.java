package AssignmentWeek5_DataProvider;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadBase {
	
	public ChromeDriver driver;
	public String excelFile;
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preCondition(String url, String username, String password) throws InterruptedException 
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Leads")).click();

	}
	
	@DataProvider(name="sendData")
	public String[][] sendData() throws IOException {

		return ExcelData.readExcel(excelFile);
		//classname.methodname();

	}
	
	@AfterMethod
	public void postCondition() 
	{
		driver.close();
	}
	
	
	
}

