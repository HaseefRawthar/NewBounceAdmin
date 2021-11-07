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
import com.bounceadmin.objectrepository.TaxObject;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class Tax extends SetUp {

	Locale local = new Locale("en-IND");
	LogInObject loginObj;
	DashboardObject dashboardObj;
	TaxObject taxObj;
	Faker fake = new Faker(local);
	FakeValuesService fakeService = new FakeValuesService(local, new RandomService());
	
	@BeforeClass
	public void initialize()
	{
		try
		{
			loginObj = new LogInObject(driver);
			dashboardObj = new DashboardObject(driver);
			taxObj = new TaxObject(driver);
			
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
	public void checkCountries()
	{
		try
		{
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			
			log.info("Entered checkCountries test");
			eTest = eReports.createTest("Verify All Countries are Present");
			eTest.assignCategory("Tax");
			
			waitIfElementClickIsIntercepted(dashboardObj.configurations, "click", "");
			dashboardObj.tax.click();
			
			for(int i=0;i<9;i++)
			{
				expectedBoolArray.add(true);
			}
			
			waitForElementToLoad(taxObj.baharain);
			actualBoolArray.add(isElementPresent(taxObj.baharain));
			actualBoolArray.add(isElementPresent(taxObj.egypt));
			actualBoolArray.add(isElementPresent(taxObj.india));
			actualBoolArray.add(isElementPresent(taxObj.jordan));
			actualBoolArray.add(isElementPresent(taxObj.kuwait));
			actualBoolArray.add(isElementPresent(taxObj.oman));
			actualBoolArray.add(isElementPresent(taxObj.qatar));
			actualBoolArray.add(isElementPresent(taxObj.saudiArabia));
			actualBoolArray.add(isElementPresent(taxObj.uae));
			
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
	
	@Test(priority=2)
	public void editTax()
	{
		try
		{
			actualArraylist = new ArrayList<String>();
			expectedArraylist = new ArrayList<String>();
			
			log.info("Entered checkCountries test");
			eTest = eReports.createTest("Edit Tax Percentage");
			eTest.assignCategory("Tax");
			String tax = fake.numerify("2.###");
			expectedArraylist.add("Success");
			expectedArraylist.add(tax);
			
			waitIfElementClickIsIntercepted(dashboardObj.configurations, "click", "");
			dashboardObj.tax.click();
			
			waitForElementToLoad(taxObj.baharain);
			autoScrollandClick(taxObj.editBaharainTax);
			waitForElementToLoad(taxObj.tax);
			taxObj.tax.sendKeys(tax);
			autoScrollandClick(taxObj.tickButton);
			waitForElementToLoad(taxObj.yesButton);
			autoScrollandClick(taxObj.yesButton);
			waitForElementToLoad(taxObj.success);
			actualArraylist.add(taxObj.success.getText());
			actualArraylist.add(taxObj.baharainTax.getText());
			
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
