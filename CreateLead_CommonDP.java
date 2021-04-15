package AssignmentWeek5_DataProvider;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead_CommonDP extends LeadBase {
	
	@BeforeTest
	public void setFileName() 
	{
		excelFile="CreateLead";
	}
	
	@Test(dataProvider="sendData")
	public void runCreateLead(String companyName, String firstName, String lastName, String phonenum) 
	{

		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phonenum);
		driver.findElement(By.name("submitButton")).click();
		
	}

}
