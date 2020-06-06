package org.iit.mmp.adminmodule.pages;

import org.iit.mmp.helper.HelperClass;
import org.iit.mmp.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


	
	public class ScheduleAppointmentAdminPage {		
		
		WebDriver driver;
		HelperClass helperObj;
		
		
		By createVisit=By.xpath("//input[@value='Create Visit']");
		
		By datepicker=By.xpath("//input[@id='datepicker']");
		By datepickerMonth=By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div");
		By next=By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span");
		By datepickerDate=By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[2]/a");
		By appoitmentTime=By.id("time");
		By continueB=By.id("ChangeHeatName");
		By sForm=By.xpath("//textarea[@name='sym']");
		By sySumbit=By.xpath("//form[@name='symptoms']/descendant::div/input[@value='Submit']");
		
		
		
		
		public ScheduleAppointmentAdminPage(WebDriver driver)
		{
			this.driver=driver;
			helperObj=new HelperClass(driver);
		}

		
		     
			//create visit-search doctor	
			public void navigateCreateVisit()
			{
				driver.findElement(createVisit).click();
			}
			
			//create visit schedule appointment
			public void scheduleAppointment(String doctorName) throws InterruptedException
			{
				
				driver.findElement(By.xpath("//h4[contains(text(),'"+doctorName+"')]/ancestor::td/button[@id='opener']")).click();
				driver = helperObj.switchToAFrameAvailable("myframe",20);
				String dateOfAppointment = Utility.getFutureDate(10);
				driver.findElement(By.id("datepicker")).sendKeys(dateOfAppointment);
				String time = "10Am";
				new Select(driver.findElement(By.id("time"))).selectByVisibleText(time);
				Thread.sleep(2000);
				driver.findElement(By.id("ChangeHeatName")).click();
				
				String symptoms= "Booking an Appointment "+doctorName +"on date::"+dateOfAppointment+ "for symptom fever";
				Thread.sleep(2000);
				driver.findElement(By.name("sym")).clear();
				driver.findElement(By.name("sym")).sendKeys(symptoms);
				driver.findElement(By.xpath("//input[@value='Submit']")).click();
			}
			
	}
