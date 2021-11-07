package com.bounceadmin.testscript;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bounceadmin.baseclass.SetUp;
import com.bounceadmin.objectrepository.DashboardObject;
import com.bounceadmin.objectrepository.LogInObject;
import com.bounceadmin.objectrepository.NotificationTemplateObject;

public class NotificationTemplate extends SetUp{

	LogInObject loginObj;
	DashboardObject dashboardObj;
	NotificationTemplateObject notifitempObj;
	String[] testData;
	
	
	@BeforeClass
	public void initialize()
	{
		loginObj = new LogInObject(driver);
		dashboardObj = new DashboardObject(driver);
	    notifitempObj = new NotificationTemplateObject(driver);
		
		loginObj.logIn(userEmail,userPassword);
		waitForElementToLoad(loginObj.selectDarisnisuperAdmin);
		loginObj.selectDarisnisuperAdmin.click();
		loginObj.selectButton.click();
	}
	
	@Test
	public void verifyPresenceOfAllTemplates() //verify all 18 templates are present when page is loaded
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered verifyPresenceOfAllTemplates test");
			eTest = eReports.createTest("Verify Presence Of All Templates");
			eTest.assignCategory("Notification Template");
			
			waitIfElementClickIsIntercepted(dashboardObj.configurations, "click", "");
			dashboardObj.notificationTemplate.click();
			
			for(int i=0;i<18;i++)
			{
				expectedBoolArray.add(true);
			}
			
			waitForElementToLoad(notifitempObj.addWelcomeMail);
			actualBoolArray.add(isElementPresent(notifitempObj.addWelcomeMail));
			actualBoolArray.add(isElementPresent(notifitempObj.institutionAddPassword));
			actualBoolArray.add(isElementPresent(notifitempObj.newUserProfileAdded));
			actualBoolArray.add(isElementPresent(notifitempObj.passwordChanged));
			actualBoolArray.add(isElementPresent(notifitempObj.nurseryResetPassword));
			actualBoolArray.add(isElementPresent(notifitempObj.addEmployeeToNursery));
			actualBoolArray.add(isElementPresent(notifitempObj.addParent1));
			actualBoolArray.add(isElementPresent(notifitempObj.addParent2));
			actualBoolArray.add(isElementPresent(notifitempObj.otpVerification));
			actualBoolArray.add(isElementPresent(notifitempObj.resentOtp));
			actualBoolArray.add(isElementPresent(notifitempObj.editAccount));
			actualBoolArray.add(isElementPresent(notifitempObj.paymentSucessful));
			actualBoolArray.add(isElementPresent(notifitempObj.paymentFailed));
			actualBoolArray.add(isElementPresent(notifitempObj.newDarsInstitutionAdd));
			actualBoolArray.add(isElementPresent(notifitempObj.institutionStatUpdate));
			actualBoolArray.add(isElementPresent(notifitempObj.suprtTktCreated));
			actualBoolArray.add(isElementPresent(notifitempObj.suprtTktRevoked));
			actualBoolArray.add(isElementPresent(notifitempObj.suprtTktExpired));
			
			waitIfElementClickIsIntercepted(dashboardObj.configurations, "click", "");

		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedBoolArray);
		System.out.println(actualBoolArray);
		Assert.assertEquals(actualBoolArray, expectedBoolArray);
		log.info("Assertion Passed");
	}
	
	@AfterClass
	public void signOt()
	{
		dashboardObj.logout();
	}
}
