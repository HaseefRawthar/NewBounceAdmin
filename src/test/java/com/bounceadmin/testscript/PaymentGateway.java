package com.bounceadmin.testscript;

import java.util.ArrayList;
import java.util.Locale;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bounceadmin.baseclass.SetUp;
import com.bounceadmin.objectrepository.DashboardObject;
import com.bounceadmin.objectrepository.LogInObject;
import com.bounceadmin.objectrepository.PaymentGatewayObject;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class PaymentGateway extends SetUp {

	Locale local = new Locale("en-IND");
	LogInObject loginObj;
	DashboardObject dashboardObj;
	PaymentGatewayObject paygateObj;
	Faker fake = new Faker(local);
	FakeValuesService fakeService = new FakeValuesService(local, new RandomService());
	
	@BeforeClass
	public void initialize()
	{
		try
		{
			loginObj = new LogInObject(driver);
			dashboardObj = new DashboardObject(driver);
			paygateObj = new PaymentGatewayObject(driver);
			
			loginObj.logIn(userEmail,userPassword);
			waitForElementToLoad(loginObj.selectDarisnisuperAdmin);
			loginObj.selectDarisnisuperAdmin.click();
			loginObj.selectButton.click();
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}
	
	@Test(priority=1)
	public void editCommission()
	{
		try
		{
			actualArraylist = new ArrayList<String>();
			expectedArraylist = new ArrayList<String>();
			
			log.info("Entered checkCountries test");
			eTest = eReports.createTest("Edit commission Percentage");
			eTest.assignCategory("Tax");
			String fixed = fake.numerify("2.###");
			String variable = fake.numerify("1.###");
			expectedArraylist.add("Success");
			expectedArraylist.add(fixed);
			expectedArraylist.add(variable);
			
			waitIfElementClickIsIntercepted(dashboardObj.configurations, "click", "");
			dashboardObj.paymentGateway.click();
			
			waitForElementToLoad(paygateObj.editBaharain);
			autoScrollandClick(paygateObj.editBaharain);
			waitForElementToLoad(paygateObj.fixedFee);
			paygateObj.fixedFee.sendKeys(fixed);
			paygateObj.variableFee.sendKeys(variable);
			autoScrollandClick(paygateObj.tickButton);
			waitForElementToLoad(paygateObj.yesButton);
			autoScrollandClick(paygateObj.yesButton);
			waitForElementToLoad(paygateObj.success);
			actualArraylist.add(paygateObj.success.getText());
			actualArraylist.add(paygateObj.baharainFixed.getText());
			actualArraylist.add(paygateObj.baharainVariable.getText());
			
			waitIfElementClickIsIntercepted(dashboardObj.configurations, "click", "");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(expectedBoolArray);
		System.out.println(actualBoolArray);
		Assert.assertEquals(actualBoolArray, expectedBoolArray);
		log.info("Assertion passed");
	}
	
	@AfterClass
	public void signOt()
	{
		dashboardObj.logout();
	}
}
