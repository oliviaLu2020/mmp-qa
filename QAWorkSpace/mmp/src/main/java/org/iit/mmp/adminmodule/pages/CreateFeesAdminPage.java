package org.iit.mmp.adminmodule.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateFeesAdminPage{
	WebDriver driver;
	By createFees=By.xpath("//input[@value='Create Fee']");
	By appointment=By.id("app_date");
	By service=By.id("service");
	By submitB=By.xpath("//input[@value='submit']");
	
	
	public CreateFeesAdminPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	/*public void navigateCreateFees()
	{
		driver.findElement(createFees).click();
	}*/
	
	public void createFees(String date, String serviceName)
	{ 
		Select appt=new Select(driver.findElement(appointment));
	    appt.selectByVisibleText(date);
	    Select sev=new Select(driver.findElement(service));
	    sev.selectByVisibleText(serviceName);
	    driver.findElement(submitB).click();
	}
	
	public String readSuccessMessage()
	{
		Alert aler=driver.switchTo().alert();
		String text=aler.getText();
		aler.accept();
		return text;
	}

}
