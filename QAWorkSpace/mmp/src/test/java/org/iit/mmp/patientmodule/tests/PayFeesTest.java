package org.iit.mmp.patientmodule.tests;

import org.iit.mmp.adminmodule.pages.CreateFeesAdminPage;
import org.iit.mmp.adminmodule.pages.ScheduleAppointmentAdminPage;
import org.iit.mmp.base.TestBase;
import org.iit.mmp.helper.HelperClass;
import org.iit.mmp.patientmodule.pages.PayFeesPage;
import org.iit.mmp.utility.Utility;
import org.testng.annotations.Test;



public class PayFeesTest extends TestBase {
	
	Utility util;
	HelperClass helperObj;
	PayFeesPage objPFPP;
	CreateFeesAdminPage objCFAP;
	ScheduleAppointmentAdminPage objSAAP;
	
	
	@Test(description="US_006 Pay Fees Page", groups= {"US-006","regression","sanity","patientmodule"})
	public void validatePayFeesTests() throws InterruptedException
	{
		//login to admin portal
		helperObj=new HelperClass(driver);
        helperObj.launchApplicationURL("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/index.php");
        helperObj.login("Thomas_444","Edison_444");
        helperObj.moduleNavigation("Patient");
        helperObj.searchPatient("Ria");
        
        //schedule appointment
        Thread.sleep(3000);
        helperObj.navigateToPatientServices("Create Visit");
        objSAAP=new ScheduleAppointmentAdminPage(driver);
        objSAAP.scheduleAppointment("Beth");
		
		//create fee
		helperObj.searchPatient("Ria");
        Thread.sleep(3000);
        helperObj.navigateToPatientServices("Create Fee");
        objCFAP= new CreateFeesAdminPage(driver);
        objCFAP.createFees("05/11/2020", "Xray");
        objCFAP.readSuccessMessage();
        
		
		//Login to patient portal and pay fee
        helperObj.launchApplicationURL("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
        helperObj.login("ria1","Ria12345");
        helperObj.moduleNavigation("Fees");
        Thread.sleep(3000);
        objPFPP=new PayFeesPage(driver);
        objPFPP.payFee();
		
	}
}
	
	


