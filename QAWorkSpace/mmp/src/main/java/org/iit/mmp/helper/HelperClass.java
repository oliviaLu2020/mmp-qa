package org.iit.mmp.helper;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {
	WebDriver driver ;
	public HelperClass(WebDriver driver)
	{
		this.driver = driver;
	}
	
	 
	public void moduleNavigation(String moduleName)
	{
		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
	}
	 
	public void launchApplicationURL(String url)
	{
		driver.get(url);
		 
	}
	public WebDriver switchToAFrameAvailable(String frameId,int timeinSecs)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeinSecs);
		driver = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		return driver;
	}
	public void login(String userName,String pwd) 
	{
		  driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		  driver.findElement(By.xpath("//input[@type='submit']")).click();

    }
	public void captureScreenshot(String tc_Name) throws IOException
	{
		
		TakesScreenshot tsh = (TakesScreenshot)driver;
		File sourceFile = tsh.getScreenshotAs(OutputType.FILE);
		System.out.println(sourceFile.getAbsolutePath());
		String destinationPath = System.getProperty("user.dir")+"\\screenshots\\"+tc_Name+"_"+
											Calendar.getInstance().getTimeInMillis()%1000000000+".jpg";
		File destFile = new File(destinationPath); 
		FileUtils.copyFile(sourceFile,destFile);
		
	}
	
	public void searchDoctor(String drName)
	{
		driver.findElement(By.xpath("//h4[contains(text(),'"+drName+"')]/ancestor::td/button")).click();
	}
	
	
	
	
	//write symptoms
		public void inputSymptoms(String symptom)
		{
			driver.findElement(By.xpath("//textarea[@name='sym']")).clear();
			driver.findElement(By.xpath("//textarea[@name='sym']")).sendKeys(symptom);
			driver.findElement(By.xpath("//form[@name='symptoms']/descendant::div/input[@value='Submit']")).click();
		}
		
		
		public void searchPatient(String pName) throws InterruptedException
		{
			
			driver.findElement(By.id("search")).sendKeys(pName);
			driver.findElement(By.className("tfbutton")).click();
			Thread.sleep(3000);
			List<WebElement> pLis=driver.findElements(By.xpath("//div[@id='show']/descendant::table/tbody/tr/td/a"));
			for(int i=0;i<pLis.size();i++)
			{ 
				try
				{
					if(pLis.get(i).getTagName().contains(pName));
				
				{
					pLis.get(i).click();
					break;
				}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}

	}
		public void navigateToPatientServices(String serviceName)
		{
			driver.findElement(By.xpath("//input[@value='"+serviceName+"']")).click();
		}

}
