package com.bounceadmin.testscript;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bounceadmin.baseclass.SetUp;
import com.bounceadmin.objectrepository.DashboardObject;
import com.bounceadmin.objectrepository.LogInObject;
import com.bounceadmin.testdata.LogInData;
import com.bounceadmin.testdata.TestDataImport;

public class LogIn extends SetUp{

	LogInObject loginObj;
	TestDataImport tdImport;
	LogInData logindataObj;
	DashboardObject dashboardObj;
	String[] loginData;


	@BeforeClass
	public void initialize()
	{
		try
		{
			loginObj = new LogInObject(driver);
			tdImport = new TestDataImport();
			logindataObj = new LogInData();
			dashboardObj = new DashboardObject(driver);
			tdImport.readSheet("Login");	
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}

	@Test(priority = 5)
	public void validLoginAsDarisniSuperAdmin() //valid login with role=DarisniSuperAdmin
	{
		try
		{
			log.info("Entered validLoginAsDarisniSuperAdmin test");	
			eTest = eReports.createTest("Valid Login As DarisniSuperAdmin");
			eTest.assignCategory("LogIn");	
			driver.navigate().refresh();

			loginData = logindataObj.getValidLoginData();
			expectedMsg = "Darisni Super Admin";
			loginObj.logIn(loginData[0], loginData[1]);
			waitForElementToLoad(loginObj.selectDarisnisuperAdmin);
			loginObj.selectDarisnisuperAdmin.click();
			loginObj.selectButton.click();
			waitForElementToLoad(dashboardObj.currentRole);
			actualMsg = dashboardObj.currentRole.getText();
			dashboardObj.logout();
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg);
		log.info("Assertion passed");

	}

	@Test(priority = 4)
	public void validLoginAsBounceAdmin() //valid login with role=DarisniAdmin
	{
		try
		{
			log.info("Entered validLoginAsBounceAdmin test");		
			eTest = eReports.createTest("Valid Login As BounceAdmin");
			eTest.assignCategory("LogIn");	
			driver.navigate().refresh();

			loginData = logindataObj.getValidLoginData();
			expectedMsg = "Bounce Admin";

			loginObj.logIn(loginData[0], loginData[1]);
			waitForElementToLoad(loginObj.selectBounceAdmin);
			loginObj.selectBounceAdmin.click();
			loginObj.selectButton.click();
			waitForElementToLoad(dashboardObj.currentRole);
			actualMsg = dashboardObj.currentRole.getText();
			dashboardObj.logout();
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg);
		log.info("Assertion passed");

	}

	@Test(priority = 3)
	public void noCredentials() //login without any credentials
	{
		try
		{
			log.info("Entered noCredentials test");
			eTest = eReports.createTest("No Credentials");
			eTest.assignCategory("LogIn");	
			driver.navigate().refresh();

			actualArray = new String[2];
			expectedArray = new String[2];
			expectedArray[0] = "Email is required.";
			expectedArray[1] = "Password is required";

			loginObj.logIn("", "");
			waitForElementToLoad(loginObj.noEmailMsg);
			actualArray[0] = loginObj.noEmailMsg.getText();
			actualArray[1] = loginObj.noPasswordMsg.getText();
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		for(int i =0;i<actualArray.length;i++)
		{
			System.out.println(actualArray[i]);
		}
		Assert.assertEquals(actualArray, expectedArray);
		log.info("Assertion passed");
	}

	@Test(priority= 2)
	public void invalidCredentials() //login with wrong credentials
	{
		try {
			log.info("Entered invalidCredentials test");
			eTest = eReports.createTest("Invalid Credentials");
			eTest.assignCategory("LogIn");
			driver.navigate().refresh();

			expectedMsg = "Provided email and/or password are incorrect";
			loginData = logindataObj.getInValidLoginData();

			loginObj.logIn(loginData[0], loginData[1]);
			waitForElementToLoad(loginObj.invalidMsg);
			actualMsg = loginObj.invalidMsg.getText();

		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg);
		log.info("Assertion passed");
	}

	@Test(priority = 1)
	public void invalidEmail() //login with invalid email id
	{
		try
		{
			log.info("Entered invalidEmail test");	
			eTest = eReports.createTest("Invalid Email");
			eTest.assignCategory("LogIn");

			expectedMsg = "email must be a valid email";
			loginData = logindataObj.getInValidEmailData();

			loginObj.logIn(loginData[0], loginData[1]);
			waitForElementToLoad(loginObj.invalidEmailMsg);
			actualMsg = loginObj.invalidEmailMsg.getText();

		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg);
		log.info("Assertion passed");
	}
}
