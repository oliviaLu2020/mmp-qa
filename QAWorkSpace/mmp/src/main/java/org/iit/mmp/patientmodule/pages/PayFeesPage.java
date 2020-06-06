package org.iit.mmp.patientmodule.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PayFeesPage {
	WebDriver driver;
	Random rand=new Random();
	By fee=By.linkText("Fees");
	By pay=By.linkText("Pay Now");
	By amount=By.id("amount");
	By continueB=By.xpath("//input[@value='Continue']");
	By cuName=By.id("name");
	By cardType=By.id("card_name");
	By cid=By.id("cid");
	By cardMonth=By.id("cardMonth");
	By cardYear=By.id("cardYear");
	By cvv=By.id("cvv");
	By sumitB=By.xpath("//input[@value='submit']");
	
	
	public PayFeesPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void naviageToPay()
	{
		driver.findElement(pay).click();
	}
		
	
	public void selectPayment(String amount)
	{
		Select payment=new Select(driver.findElement(By.id("amount")));
		payment.selectByVisibleText(amount);
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}
	
	public void inputCardInfo()
	{
		String cardHolderName="Wales"+rand.nextInt(100)+"";
		driver.findElement(By.id("name")).sendKeys(cardHolderName);
		Select cards=new Select(driver.findElement(By.id("card_name")));
		cards.selectByVisibleText("Visa");
		
		String visaCardNumber=(long) ((rand.nextDouble() * 100000000000000L) + 4400000000000000L)+"";
		driver.findElement(By.id("cid")).sendKeys(visaCardNumber);
		
		Select month=new Select(driver.findElement(By.id("cardMonth")));
		month.selectByValue("04");
		
		Select year=new Select(driver.findElement(By.id("cardYear")));
		year.selectByValue("22");
		
		
		String cvvValue=rand.nextInt(1000)+"";
		driver.findElement(By.id("cvv")).sendKeys(cvvValue);
	}

	public void clickOnSubmit()
	{
		driver.findElement(sumitB).click();
	}
	
	public void payFee()
	{
		naviageToPay();
		selectPayment("$50");
		inputCardInfo();
		clickOnSubmit();
		
	}
	
	
}


