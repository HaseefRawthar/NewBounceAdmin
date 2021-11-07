package com.bounceadmin.testscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bounceadmin.baseclass.SetUp;
import com.bounceadmin.objectrepository.AddNurseryObject;
import com.bounceadmin.objectrepository.DashboardObject;
import com.bounceadmin.objectrepository.ListNurseryObject;
import com.bounceadmin.objectrepository.LogInObject;
import com.bounceadmin.objectrepository.ViewNurseryObject;
import com.bounceadmin.testdata.AddNurseryData;
import com.bounceadmin.testdata.TestDataImport;

public class AddNursery extends SetUp {

	LogInObject loginObj;
	DashboardObject dashboardObj;
	AddNurseryObject addnurseryObj;
	AddNurseryData addnurserydataObj;
	TestDataImport tdImport;
	ListNurseryObject listnurseryObj;
	ViewNurseryObject viewnurseryObj;
	String[] addNurseryMandatoryData;
	String[] addNurseryNonMandatoryData;
	String[] addOwnerData;
	String[] attachmentData;
	String[] contractDocs;
	String[] testData;
	String[] testData2;
	String[] edittestData;

	@BeforeClass
	public void initialize()
	{
		try
		{
			loginObj = new LogInObject(driver);
			dashboardObj = new DashboardObject(driver);
			addnurseryObj = new AddNurseryObject(driver);
			tdImport = new TestDataImport();
			addnurserydataObj = new AddNurseryData();
			listnurseryObj = new ListNurseryObject(driver);
			viewnurseryObj = new ViewNurseryObject(driver);

			tdImport.readSheet("AddNursery");

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
	public void verifyMandatoryMsgVisibleWithoutOnlinePayment() // verify mandatory msg is present when adding nursery without filling them
	{
		try {
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered verifyMandatoryMsgVisible test");		
			eTest = eReports.createTest("Verify Mandatory Message without online payment");
			eTest.assignCategory("Add Nursery");
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			for (int i = 0; i < 10; i++) 
			{
				expectedBoolArray.add(true);
			}
			for (int i = 10; i < 23; i++) 
			{
				expectedBoolArray.add(false);
			}
			System.out.println(expectedBoolArray);
			dashboardObj.clickAddNurseries();
			waitForElementToLoad(addnurseryObj.addButton);
			autoScrollandClick(addnurseryObj.addButton);
			waitForElementToLoad(addnurseryObj.nurseryNameMandatoryMsg);
			actualBoolArray.add(isElementPresent(addnurseryObj.nurseryNameMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.addressLine1MandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.countryMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.countryCodeMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.phoneNumberMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.logoMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.dateFromMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.dateToMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.contractTypeMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.ownerMandatoryMsg));
			
			actualBoolArray.add(isElementPresent(addnurseryObj.supplierEmailMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.supplierCntryCodeMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.licenseMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.signatureMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.civilIdMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.civilIdBackMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.articleOfAssociationMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.contractMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.accountHolderNameMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.accountNumMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.bankNameMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.ibanMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.PaymentMethodMandatoryMsg));
			waitIfElementClickIsIntercepted(dashboardObj.nurseries, "click", "");

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
	public void verifyMandatoryMsgVisibleWithOnlinePayment() // verify mandatory msg is present when adding nursery without filling them
	{
		try {
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered verifyMandatoryMsgVisible test");		
			eTest = eReports.createTest("Verify Mandatory Message with online payment");
			eTest.assignCategory("Add Nursery");
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			for (int i = 0; i < 23; i++) 
			{
				expectedBoolArray.add(true);
			}
			System.out.println(expectedBoolArray);
			dashboardObj.clickAddNurseries();
			waitForElementToLoad(addnurseryObj.addButton);
			autoScrollandClick(addnurseryObj.addButton);
			waitForElementToLoad(addnurseryObj.nurseryNameMandatoryMsg);
			actualBoolArray.add(isElementPresent(addnurseryObj.nurseryNameMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.addressLine1MandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.countryMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.countryCodeMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.phoneNumberMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.logoMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.dateFromMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.dateToMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.contractTypeMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.ownerMandatoryMsg));
			
			waitForElementToLoad(addnurseryObj.onlinePayment);
			autoScrollandClick(addnurseryObj.onlinePayment);
			waitForElementToLoad(addnurseryObj.addButton);
			autoScrollandClick(addnurseryObj.addButton);
			Thread.sleep(2000);
			waitForElementToLoad(addnurseryObj.supplierEmailMandatoryMsg);
			actualBoolArray.add(isElementPresent(addnurseryObj.supplierEmailMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.supplierCntryCodeMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.licenseMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.signatureMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.civilIdMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.civilIdBackMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.articleOfAssociationMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.contractMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.accountHolderNameMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.accountNumMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.bankNameMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.ibanMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.PaymentMethodMandatoryMsg));
			waitForElementToLoad(addnurseryObj.onlinePayment);
			autoScrollandClick(addnurseryObj.onlinePayment);
			waitIfElementClickIsIntercepted(dashboardObj.nurseries, "click", "");

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

	@Test(priority=3)
	public void verifyMandatoryMsgVisibleForOwner() // verify mandatory msg is present when adding nursery without filling them
	{
		try {
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();

			log.info("Entered verifyMandatoryMsgVisibleForOwner test");		
			eTest = eReports.createTest("Verify Mandatory Message for owner");
			eTest.assignCategory("Add Nursery");
			actualBoolArray = new ArrayList<Boolean>();
			expectedBoolArray = new ArrayList<Boolean>();
			for (int i = 0; i < 5; i++) 
			{
				expectedBoolArray.add(true);
			}
			System.out.println(expectedBoolArray);
			dashboardObj.clickAddNurseries();
			waitForElementToLoad(addnurseryObj.addOwner);
			autoScrollandClick(addnurseryObj.addOwner);
			waitForElementToLoad(addnurseryObj.ownerAddButton);
			autoScrollandClick(addnurseryObj.ownerAddButton);
			waitForElementToLoad(addnurseryObj.ownerName);
			actualBoolArray.add(isElementPresent(addnurseryObj.nameMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.nationalityMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.ownerPhnCodeMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.ownerPhoneMandatoryMsg));
			actualBoolArray.add(isElementPresent(addnurseryObj.emailMandatoryMsg));
			autoScrollandClick(addnurseryObj.ownerCancelButton);
			waitIfElementClickIsIntercepted(dashboardObj.nurseries, "click", "");

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

	
	@Test(priority=4)
	public void verifyAddNurserywithMnadatoryOnly() //add a nursery by adding only mandatory data
	{
		try {
			actualArraylist = new ArrayList<String>();
			expectedArraylist = new ArrayList<String>();

			log.info("Entered verifyAddNurserywithMnadatoryOnly test");		
			eTest = eReports.createTest("Add Nursery with Mandatory field Only");
			eTest.assignCategory("Add Nursery");	

			addnurserydataObj.generateFakeNurseryData();
			addNurseryMandatoryData = addnurserydataObj.addNurseryMandatoryTestData();
			addNurseryNonMandatoryData = addnurserydataObj.addNurseryNonMandatoryTestData();
			testData = new String[5];
			testData[0] = addNurseryMandatoryData[0];
			testData[1] ="";
			testData[2] = addNurseryMandatoryData[2];
			testData[3] = addNurseryMandatoryData[3];
			testData[4] = addNurseryMandatoryData[4];
			for(int i=0;i<testData.length;i++)
			{
				System.out.println(testData[i]);
			}
			for(int i=0;i<addNurseryMandatoryData.length;i++)
			{
				System.out.println(addNurseryMandatoryData[i]);
			}
			expectedArraylist.add("Institution Created Successfully");
			expectedArraylist.add(addNurseryMandatoryData[0]);
			expectedArraylist.add(addNurseryMandatoryData[1]);
			expectedArraylist.add(addNurseryMandatoryData[2]);
			expectedArraylist.add(addNurseryMandatoryData[3].replaceAll("[^\\d+]", "")+" "+addNurseryMandatoryData[4]);
			expectedArraylist.add(addNurseryMandatoryData[6]);
			expectedArraylist.add(addNurseryMandatoryData[7]);
			expectedArraylist.add(addNurseryMandatoryData[8]);
			expectedArraylist.add(addNurseryNonMandatoryData[11]);
			tdImport.readSheet("AddOwner");
			addnurserydataObj.generateFakeOwnerData();
			addOwnerData = addnurserydataObj.addOwnerTestData();
			for(int i=0;i<addOwnerData.length;i++)
			{
				System.out.println(addOwnerData[i]);
			}
			expectedArraylist.add(addOwnerData[0]);
			expectedArraylist.add(addOwnerData[1]);
			expectedArraylist.add(addOwnerData[2].replaceAll("[^\\d+]", "")+" "+addOwnerData[3]);
			expectedArraylist.add(addOwnerData[4]);
			System.out.println(expectedArraylist);
			dashboardObj.clickAddNurseries();
			addnurseryObj.addNurseryMandatoryFields(addNurseryMandatoryData);
			addnurseryObj.minimumAmount.sendKeys(addNurseryNonMandatoryData[11]);
			addnurseryObj.addOwner(addOwnerData);
			waitForElementToLoad(addnurseryObj.addButton);
			autoScrollandClick(addnurseryObj.addButton);
			waitForElementToLoad(addnurseryObj.nurserySuccessMsg);

			actualArraylist.add(addnurseryObj.nurserySuccessMsg.getText());
			waitForElementToLoad(listnurseryObj.filterButton);
			driver.navigate().refresh();
			listnurseryObj.filterNursery(testData);
			Thread.sleep(2000);
			waitForElementToLoad(listnurseryObj.viewDetails);
			autoScrollandClick(listnurseryObj.viewDetails);
			waitForElementToLoad(viewnurseryObj.viewNurseryName);
			actualArraylist.add(viewnurseryObj.viewNurseryName.getText());
			actualArraylist.add(viewnurseryObj.viewAddressLine1.getText());
			actualArraylist.add(viewnurseryObj.viewCountry.getText());
			actualArraylist.add(viewnurseryObj.viewPhoneNumber.getText());
			actualArraylist.add(viewnurseryObj.viewContractDateFrom.getText());
			actualArraylist.add(viewnurseryObj.viewContractDateTo.getText());
			actualArraylist.add(viewnurseryObj.viewContractType.getText());
			actualArraylist.add(viewnurseryObj.viewMiniumAmount.getText());

			actualArraylist.add(viewnurseryObj.viewOwnerName.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerNationality.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerPhoneNo.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerEmail.getText());
			waitIfElementClickIsIntercepted(dashboardObj.nurseries, "click", "");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualMsg);
		Assert.assertEquals(actualArraylist, expectedArraylist);
		log.info("Assertion passed");

	}

	@Test(priority=5)
	public void verifyAddNurserywithAllFieldsWithOutOnlinePayment() //add nursery by filling all the fields
	{
		try
		{
			actualArraylist = new ArrayList<String>();
			expectedArraylist = new ArrayList<String>();

			log.info("Entered verifyAddNurserywithAllFields test");
			eTest = eReports.createTest("Add Nursery with All Fields WithOut Online Payment");
			eTest.assignCategory("Add Nursery");
			tdImport.readSheet("AddNursery");
			expectedArraylist.add("Institution Created Successfully");

			addnurserydataObj.generateFakeNurseryData();
			addNurseryMandatoryData = addnurserydataObj.addNurseryMandatoryTestData();

			addNurseryNonMandatoryData = addnurserydataObj.addNurseryNonMandatoryTestData();
			attachmentData = addnurserydataObj.attachments();
			for(int i=0;i<addNurseryMandatoryData.length;i++)
			{
				System.out.println(addNurseryMandatoryData[i]);
			}
			for(int i=0;i<addNurseryNonMandatoryData.length;i++)
			{
				System.out.println(i+" "+addNurseryNonMandatoryData[i]);
			}
			testData = addnurserydataObj.viewNurseryData();

			for(int i =0;i<testData.length-3;i++)
			{
				if(testData[i]=="")
				{
					testData[i] = "-";
					testData[i].trim();
				}
				expectedArraylist.add(testData[i]);
			}
			System.out.println(expectedArraylist);
			testData = addnurserydataObj.listNurseryData();

			tdImport.readSheet("AddOwner");
			addnurserydataObj.generateFakeOwnerData();

			addOwnerData = addnurserydataObj.addOwnerTestData();
			for(int i=0;i<addOwnerData.length;i++)
			{
				System.out.println(addOwnerData[i]);
			}
			testData2 = addnurserydataObj.viewOwnerData();
			for(int i =0;i<testData2.length;i++)
			{
				System.out.println(testData2[i]);
				expectedArraylist.add(testData2[i]);
			}
			System.out.println(expectedArraylist);

			dashboardObj.clickAddNurseries();
			addnurseryObj.addNurseryMandatoryFields(addNurseryMandatoryData);
			addnurseryObj.addOwner(addOwnerData);
			addnurseryObj.addAttachments(addnurseryObj.addAttachment1, addnurseryObj.browseAttachments1, attachmentData, 3);
			addnurseryObj.addNurseryNonMandatoryFields(addNurseryNonMandatoryData);
			addnurseryObj.addAttachments(addnurseryObj.addAttachment2, addnurseryObj.browseAttachments2, attachmentData, 3);
			waitForElementToLoad(addnurseryObj.addButton);
			autoScrollandClick(addnurseryObj.addButton);
			waitForElementToLoad(addnurseryObj.nurserySuccessMsg);

			actualArraylist.add(addnurseryObj.nurserySuccessMsg.getText());

			System.out.println();
			for(int i =0;i<testData.length;i++)
			{
				System.out.println(testData[i]);
			}

			waitForElementToLoad(listnurseryObj.filterButton);
			driver.navigate().refresh();
			listnurseryObj.filterNursery(testData);
			Thread.sleep(2000);
			waitForElementToLoad(listnurseryObj.viewDetails);
			autoScrollandClick(listnurseryObj.viewDetails);
			waitForElementToLoad(viewnurseryObj.viewNurseryName);
			actualArraylist.add(viewnurseryObj.viewNurseryName.getText());
			actualArraylist.add(viewnurseryObj.viewLegalNameEn.getText());
			actualArraylist.add(viewnurseryObj.viewLegalNameAr.getText());
			actualArraylist.add(viewnurseryObj.viewTaxId.getText());
			actualArraylist.add(viewnurseryObj.viewAddressLine1.getText());
			actualArraylist.add(viewnurseryObj.viewAddressLine2.getText());
			actualArraylist.add(viewnurseryObj.viewCountry.getText());
			actualArraylist.add(viewnurseryObj.viewZipcode.getText());
			actualArraylist.add(viewnurseryObj.viewState.getText());
			actualArraylist.add(viewnurseryObj.viewPhoneNumber.getText());
			actualArraylist.add(viewnurseryObj.viewCity.getText());
			actualArraylist.add(viewnurseryObj.viewEmail.getText());

			actualArraylist.add(viewnurseryObj.viewContractDateFrom.getText());
			actualArraylist.add(viewnurseryObj.viewContractDateTo.getText());
			actualArraylist.add(viewnurseryObj.viewContractType.getText());
			actualArraylist.add(viewnurseryObj.viewContractInfo.getText());
			actualArraylist.add(viewnurseryObj.viewFees.getText().replaceAll("[^\\d.]", "").trim());
			actualArraylist.add(viewnurseryObj.viewCollectionTerms.getText());
			actualArraylist.add(viewnurseryObj.viewMiniumAmount.getText().replaceAll("[^\\d.]", "").trim());
			actualArraylist.add(viewnurseryObj.viewAccountHolderName.getText());
			actualArraylist.add(viewnurseryObj.viewBeneficaryAddress.getText());
			actualArraylist.add(viewnurseryObj.viewBankName.getText());
			actualArraylist.add(viewnurseryObj.viewBankAddress.getText());
			actualArraylist.add(viewnurseryObj.viewAccountNumber.getText());
			actualArraylist.add(viewnurseryObj.viewIBAN.getText());
			actualArraylist.add(viewnurseryObj.viewAccountCurrency.getText());
			actualArraylist.add(viewnurseryObj.viewSwiftcode.getText());
			actualArraylist.add(viewnurseryObj.viewNotes.getText().trim());

			actualArraylist.add(viewnurseryObj.viewOwnerName.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerPhoneNo.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerEmail.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerNationality.getText());
			waitIfElementClickIsIntercepted(dashboardObj.nurseries, "click", "");

		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualArraylist);
		System.out.println(expectedArraylist);
		Assert.assertEquals(actualArraylist, expectedArraylist);
		log.info("Assertion passed");
	}
	
	@Test(priority=6)
	public void AddNurseryWithOnlinePayment()
	{
		try
		{
			tdImport.readSheet("AddNursery");
			actualArraylist = new ArrayList<String>();
			expectedArraylist = new ArrayList<String>();
			String[] supplier;
			String[] paymode, pay;

			log.info("Entered AddNurseryWithOnlinePayment test");
			eTest = eReports.createTest("Edit nursery and Add Online Payment");
			eTest.assignCategory("Add Nursery");
			expectedArraylist.add("Institution Updated Successfully");
			
			addnurserydataObj.generateFakeSupplierData();
			contractDocs = addnurserydataObj.contractualDocuments();
            supplier = addnurserydataObj.addSupplierData();
			paymode = addnurserydataObj.paymentMethods();
			pay = addnurserydataObj.paymentDetails();
			expectedArraylist.add(supplier[0]);
			expectedArraylist.add(supplier[1].replaceAll("[^\\d+]", "")+" "+supplier[2]);
			expectedArraylist.add(supplier[3]);
			for(int i =0;i<paymode.length;i++)
			{
				expectedArraylist.add(pay[0]);
				expectedArraylist.add(paymode[i]);
				expectedArraylist.add(pay[1]);
				expectedArraylist.add(pay[2]);
				
			}
			testData = addnurserydataObj.listNurseryData();
			dashboardObj.clickListNurseries();
			listnurseryObj.filterNursery(testData);
			Thread.sleep(2000);
			waitForElementToLoad(listnurseryObj.editDetails);
			autoScrollandClick(listnurseryObj.editDetails);
			Thread.sleep(2500);
			waitForElementToLoad(addnurseryObj.onlinePayment);
			addnurseryObj.addContractualDocuments(addnurseryObj.commercialLicense, addnurseryObj.commercialLicenseImg, contractDocs[0]);
			addnurseryObj.addContractualDocuments(addnurseryObj.signatureAutorization, addnurseryObj.signatureAutorizationImg, contractDocs[1]);
			scrollDown(500);
			addnurseryObj.addContractualDocuments(addnurseryObj.articleOfAssociation, addnurseryObj.articleOfAssociationImg, contractDocs[2]);
			addnurseryObj.addContractualDocuments(addnurseryObj.civilId, addnurseryObj.civilIdImg, contractDocs[3]);
			addnurseryObj.addContractualDocuments(addnurseryObj.civilIdBack, addnurseryObj.civilIdBackImg, contractDocs[4]);
			addnurseryObj.addContractualDocuments(addnurseryObj.contractAgreement, addnurseryObj.contractAgreementImg, contractDocs[5]);
			addnurseryObj.addContractualDocuments(addnurseryObj.others, addnurseryObj.othersImg, contractDocs[6]);
			Thread.sleep(2000);
			autoScrollandClick(addnurseryObj.onlinePayment);
			waitForElementToLoad(addnurseryObj.supplierEmail);
			addnurseryObj.addSupplierDetails(supplier);
			addnurseryObj.addPayment(paymode, pay[1], pay[2]);
			Thread.sleep(2000);
			autoScrollandClick(listnurseryObj.saveButton);
			waitForElementToLoad(addnurseryObj.nurseryUpdateMsg);
			actualArraylist.add(addnurseryObj.nurseryUpdateMsg.getText());
			

			listnurseryObj.filterNursery(testData);
			Thread.sleep(2000);
			waitForElementToLoad(listnurseryObj.viewDetails);
			autoScrollandClick(listnurseryObj.viewDetails);
			waitForElementToLoad(viewnurseryObj.viewNurseryName);

			actualArraylist.add(viewnurseryObj.viewSupplierEmail.getText());
			actualArraylist.add(viewnurseryObj.viewSupplierPhoneNum.getText());
			actualArraylist.add(viewnurseryObj.viewDepositeTerms.getText());
 
			scrollDown(1500);
			Thread.sleep(3000);
			waitForElementToLoad(viewnurseryObj.paymenGateway);
			if(isElementPresent(viewnurseryObj.paymenGateway)) {
			
				for(int i=1;i<=paymode.length;i++)
				{
					actualArraylist.add(driver.findElement(By.xpath("//app-nursery-view[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[2]")).getText());
					actualArraylist.add(driver.findElement(By.xpath("//app-nursery-view[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[3]")).getText()); 
					actualArraylist.add(driver.findElement(By.xpath("//app-nursery-view[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[4]")).getText().replaceAll("[^\\d.]", "").trim()); 
					actualArraylist.add(driver.findElement(By.xpath("//app-nursery-view[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[5]")).getText().replaceAll("[^\\d.]", "").trim()); 
				}
			}
			waitIfElementClickIsIntercepted(dashboardObj.nurseries, "click", "");

		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualArraylist);
		System.out.println(expectedArraylist);
		Assert.assertEquals(actualArraylist, expectedArraylist);
		log.info("Assertion passed");
	}
	
	@Test(priority=7)
	public void verifyAddNurserywithAllFieldsWithOnlinePayment()
	{
		try
		{
			actualArraylist = new ArrayList<String>();
			expectedArraylist = new ArrayList<String>();
			String[] supplier;
			String[] paymode, pay;

			log.info("Entered verifyAddNurserywithAllFields test");
			eTest = eReports.createTest("Add Nursery with All Fields With Online Payment");
			eTest.assignCategory("Add Nursery");
			tdImport.readSheet("AddNursery");
			expectedArraylist.add("Institution Created Successfully");

			addnurserydataObj.generateFakeNurseryData();
			addnurserydataObj.generateFakeSupplierData();
			addNurseryMandatoryData = addnurserydataObj.addNurseryMandatoryTestData();

			addNurseryNonMandatoryData = addnurserydataObj.addNurseryNonMandatoryTestData();
			attachmentData = addnurserydataObj.attachments();
			testData = addnurserydataObj.viewNurseryData();
			contractDocs = addnurserydataObj.contractualDocuments();

			for(int i =0;i<testData.length;i++)
			{
				expectedArraylist.add(testData[i]);
			}
			System.out.println(expectedArraylist);
			testData = addnurserydataObj.listNurseryData();
			supplier = addnurserydataObj.addSupplierData();
			
			paymode = addnurserydataObj.paymentMethods();
			pay = addnurserydataObj.paymentDetails();

			for(int i =0;i<paymode.length;i++)
			{
				expectedArraylist.add(pay[0]);
				expectedArraylist.add(paymode[i]);
				expectedArraylist.add(pay[1]);
				expectedArraylist.add(pay[2]);
				
			}
			tdImport.readSheet("AddOwner");
			addnurserydataObj.generateFakeOwnerData();

			addOwnerData = addnurserydataObj.addOwnerTestData();
			for(int i=0;i<addOwnerData.length;i++)
			{
				System.out.println(addOwnerData[i]);
			}
			testData2 = addnurserydataObj.viewOwnerData();
			for(int i =0;i<testData2.length;i++)
			{
				System.out.println(testData2[i]);
				expectedArraylist.add(testData2[i]);
			}
			System.out.println(expectedArraylist);
			dashboardObj.clickAddNurseries();
			addnurseryObj.addNurseryMandatoryFields(addNurseryMandatoryData);
			addnurseryObj.addOwner(addOwnerData);
			autoScrollandClick(addnurseryObj.onlinePayment);
			addnurseryObj.addAttachments(addnurseryObj.addAttachment1, addnurseryObj.browseAttachments1, attachmentData, 3);
			addnurseryObj.addNurseryNonMandatoryFields(addNurseryNonMandatoryData);
			addnurseryObj.addSupplierDetails(supplier);
			addnurseryObj.addPayment(paymode, pay[1], pay[2]);
			addnurseryObj.addContractualDocuments(addnurseryObj.commercialLicense, addnurseryObj.commercialLicenseImg, contractDocs[0]);
			addnurseryObj.addContractualDocuments(addnurseryObj.signatureAutorization, addnurseryObj.signatureAutorizationImg, contractDocs[1]);
			scrollDown(500);
			addnurseryObj.addContractualDocuments(addnurseryObj.articleOfAssociation, addnurseryObj.articleOfAssociationImg, contractDocs[2]);
			addnurseryObj.addContractualDocuments(addnurseryObj.civilId, addnurseryObj.civilIdImg, contractDocs[3]);
			addnurseryObj.addContractualDocuments(addnurseryObj.civilIdBack, addnurseryObj.civilIdBackImg, contractDocs[4]);
			addnurseryObj.addContractualDocuments(addnurseryObj.contractAgreement, addnurseryObj.contractAgreementImg, contractDocs[5]);
			addnurseryObj.addContractualDocuments(addnurseryObj.others, addnurseryObj.othersImg, contractDocs[6]);
			addnurseryObj.addAttachments(addnurseryObj.addAttachment2, addnurseryObj.browseAttachments2, attachmentData, 3);
			scrollDown(500);
			waitForElementToLoad(addnurseryObj.addButton);
			//autoScrollandClick(addnurseryObj.addButton);
			waitForElementToLoad(addnurseryObj.nurserySuccessMsg);
			actualArraylist.add(addnurseryObj.nurserySuccessMsg.getText());
			
			listnurseryObj.filterNursery(testData);
			Thread.sleep(2000);
			waitForElementToLoad(listnurseryObj.viewDetails);
			autoScrollandClick(listnurseryObj.viewDetails);
			waitForElementToLoad(viewnurseryObj.viewNurseryName);
			driver.navigate().refresh();
			waitForElementToLoad(viewnurseryObj.viewNurseryName);
			actualArraylist.add(viewnurseryObj.viewNurseryName.getText());
			actualArraylist.add(viewnurseryObj.viewLegalNameEn.getText());
			actualArraylist.add(viewnurseryObj.viewLegalNameAr.getText());
			actualArraylist.add(viewnurseryObj.viewTaxId.getText());
			actualArraylist.add(viewnurseryObj.viewAddressLine1.getText());
			actualArraylist.add(viewnurseryObj.viewAddressLine2.getText());
			actualArraylist.add(viewnurseryObj.viewCountry.getText());
			actualArraylist.add(viewnurseryObj.viewZipcode.getText());
			actualArraylist.add(viewnurseryObj.viewState.getText());
			actualArraylist.add(viewnurseryObj.viewPhoneNumber.getText());
			actualArraylist.add(viewnurseryObj.viewCity.getText());
			actualArraylist.add(viewnurseryObj.viewEmail.getText());

			actualArraylist.add(viewnurseryObj.viewContractDateFrom.getText());
			actualArraylist.add(viewnurseryObj.viewContractDateTo.getText());
			actualArraylist.add(viewnurseryObj.viewContractType.getText());
			actualArraylist.add(viewnurseryObj.viewContractInfo.getText());
			actualArraylist.add(viewnurseryObj.viewFees.getText().replaceAll("[^\\d.]", "").trim());
			actualArraylist.add(viewnurseryObj.viewCollectionTerms.getText());
			actualArraylist.add(viewnurseryObj.viewMiniumAmount.getText().replaceAll("[^\\d.]", "").trim());
			actualArraylist.add(viewnurseryObj.viewAccountHolderName.getText());
			actualArraylist.add(viewnurseryObj.viewBeneficaryAddress.getText());
			actualArraylist.add(viewnurseryObj.viewBankName.getText());
			actualArraylist.add(viewnurseryObj.viewBankAddress.getText());
			actualArraylist.add(viewnurseryObj.viewAccountNumber.getText());
			actualArraylist.add(viewnurseryObj.viewIBAN.getText());
			actualArraylist.add(viewnurseryObj.viewAccountCurrency.getText());
			actualArraylist.add(viewnurseryObj.viewSwiftcode.getText());
			actualArraylist.add(viewnurseryObj.viewNotes.getText().trim());

			
			actualArraylist.add(viewnurseryObj.viewSupplierEmail.getText());
			actualArraylist.add(viewnurseryObj.viewSupplierPhoneNum.getText());
			actualArraylist.add(viewnurseryObj.viewDepositeTerms.getText());
			
			scrollDown(1500);
			Thread.sleep(3000);
			waitForElementToLoad(viewnurseryObj.paymenGateway);
			if(isElementPresent(viewnurseryObj.paymenGateway)) {
			
				for(int i=1;i<=paymode.length;i++)
				{
			        Thread.sleep(500);
			        String ate = driver.findElement(By.xpath("//app-nursery-view[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[2]")).getText();
					actualArraylist.add(driver.findElement(By.xpath("//app-nursery-view[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[2]")).getText());
					System.out.println(ate);
					actualArraylist.add(driver.findElement(By.xpath("//app-nursery-view[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[3]")).getText()); 
					actualArraylist.add(driver.findElement(By.xpath("//app-nursery-view[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[4]")).getText().replaceAll("[^\\d.]", "").trim()); 
					actualArraylist.add(driver.findElement(By.xpath("//app-nursery-view[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[5]")).getText().replaceAll("[^\\d.]", "").trim()); 
				}
			}

			actualArraylist.add(viewnurseryObj.viewOwnerName.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerPhoneNo.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerEmail.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerNationality.getText());


			waitIfElementClickIsIntercepted(dashboardObj.nurseries, "click", "");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		System.out.println(actualArraylist);
		System.out.println(expectedArraylist);
		Assert.assertEquals(actualArraylist, expectedArraylist);
		log.info("Assertion passed");
	}

	@Test(priority=8)
	public void listandViewNurseryDetails() //list a nursery, view and verify all its data
	{
		try
		{
			actualArraylist = new ArrayList<String>();
			expectedArraylist = new ArrayList<String>();
			String[] paymode, pay;

			log.info("Entered listandViewNurseryDetails test");
			eTest = eReports.createTest("List and View Nursery Details");
			eTest.assignCategory("List Nursery");
			tdImport.readSheet("AddNursery");
			paymode = addnurserydataObj.paymentMethods();
			pay = addnurserydataObj.paymentDetails();


			testData = addnurserydataObj.listNurseryData();
			for(int i =0;i<testData.length;i++)
			{
				System.out.println(testData[i]);
			}
			dashboardObj.clickListNurseries();
			listnurseryObj.filterNursery(testData);
			Thread.sleep(2000);
			testData = addnurserydataObj.viewNurseryData();

			for(int i =0;i<testData.length;i++)
			{
				expectedArraylist.add(testData[i]);
			}
			for(int i =0;i<paymode.length;i++)
			{
				expectedArraylist.add(pay[0]);
				expectedArraylist.add(paymode[i]);
				expectedArraylist.add(pay[1]);
				expectedArraylist.add(pay[2]);
				
			}
			tdImport.readSheet("AddOwner");
			testData = addnurserydataObj.viewOwnerData();

			for(int i =0;i<testData.length;i++)
			{
				expectedArraylist.add(testData[i]);
			}
			
			System.out.println(expectedArraylist);
			waitForElementToLoad(listnurseryObj.viewDetails);
			autoScrollandClick(listnurseryObj.viewDetails);
			waitForElementToLoad(viewnurseryObj.viewNurseryName);
			actualArraylist.add(viewnurseryObj.viewNurseryName.getText());
			actualArraylist.add(viewnurseryObj.viewLegalNameEn.getText());
			actualArraylist.add(viewnurseryObj.viewLegalNameAr.getText());
			actualArraylist.add(viewnurseryObj.viewTaxId.getText());
			actualArraylist.add(viewnurseryObj.viewAddressLine1.getText());
			actualArraylist.add(viewnurseryObj.viewAddressLine2.getText());
			actualArraylist.add(viewnurseryObj.viewCountry.getText());
			actualArraylist.add(viewnurseryObj.viewZipcode.getText());
			actualArraylist.add(viewnurseryObj.viewState.getText());
			actualArraylist.add(viewnurseryObj.viewPhoneNumber.getText());
			actualArraylist.add(viewnurseryObj.viewCity.getText());
			actualArraylist.add(viewnurseryObj.viewEmail.getText());

			actualArraylist.add(viewnurseryObj.viewContractDateFrom.getText());
			actualArraylist.add(viewnurseryObj.viewContractDateTo.getText());
			actualArraylist.add(viewnurseryObj.viewContractType.getText());
			actualArraylist.add(viewnurseryObj.viewContractInfo.getText());
			actualArraylist.add(viewnurseryObj.viewFees.getText().replaceAll("[^\\d.]", "").trim());
			actualArraylist.add(viewnurseryObj.viewCollectionTerms.getText());
			actualArraylist.add(viewnurseryObj.viewMiniumAmount.getText().replaceAll("[^\\d.]", "").trim());
			actualArraylist.add(viewnurseryObj.viewAccountHolderName.getText());
			actualArraylist.add(viewnurseryObj.viewBeneficaryAddress.getText());
			actualArraylist.add(viewnurseryObj.viewBankName.getText());
			actualArraylist.add(viewnurseryObj.viewBankAddress.getText());
			actualArraylist.add(viewnurseryObj.viewAccountNumber.getText());
			actualArraylist.add(viewnurseryObj.viewIBAN.getText());
			actualArraylist.add(viewnurseryObj.viewAccountCurrency.getText());
			actualArraylist.add(viewnurseryObj.viewSwiftcode.getText());
			actualArraylist.add(viewnurseryObj.viewNotes.getText().trim());

			
			actualArraylist.add(viewnurseryObj.viewSupplierEmail.getText());
			actualArraylist.add(viewnurseryObj.viewSupplierPhoneNum.getText());
			actualArraylist.add(viewnurseryObj.viewDepositeTerms.getText());
 
			Thread.sleep(3000);
			autoscrollToView(viewnurseryObj.paymenGateway);
			if(isElementPresent(viewnurseryObj.paymenGateway)) {
			
				for(int i=1;i<=paymode.length;i++)
				{
					actualArraylist.add(driver.findElement(By.xpath("//app-nursery-view[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[2]")).getText());
					actualArraylist.add(driver.findElement(By.xpath("//app-nursery-view[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[3]")).getText()); 
					actualArraylist.add(driver.findElement(By.xpath("//app-nursery-view[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[4]")).getText().replaceAll("[^\\d.]", "").trim()); 
					actualArraylist.add(driver.findElement(By.xpath("//app-nursery-view[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[5]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[5]")).getText().replaceAll("[^\\d.]", "").trim()); 
				}
			}

			actualArraylist.add(viewnurseryObj.viewOwnerName.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerPhoneNo.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerEmail.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerNationality.getText());
			System.out.println(actualArraylist);
			waitIfElementClickIsIntercepted(dashboardObj.nurseries, "click", "");
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}

		Assert.assertEquals(actualArraylist, expectedArraylist);
	}
	
	@Test(priority=9) //edit nursery details,delete owner and add new owner
	public void editNursery()
	{
		try
		{
			tdImport.readSheet("AddNursery");
			actualArraylist = new ArrayList<String>();
			expectedArraylist = new ArrayList<String>();

			log.info("Entered editNursery test");
			eTest = eReports.createTest("Edit Nursery");
			eTest.assignCategory("List Nursery");
			testData = addnurserydataObj.listNurseryData();

			dashboardObj.clickListNurseries();
			listnurseryObj.filterNursery(testData);
			waitForElementToLoad(listnurseryObj.editDetails);

			autoScrollandClick(listnurseryObj.editDetails);
			expectedArraylist.add("Institution Updated Successfully");
			edittestData = addnurserydataObj.editNurseryData();
			for(int i=0;i<edittestData.length;i++)
			{
				System.out.println(edittestData[i]);
				expectedArraylist.add(edittestData[i]);
			}
			waitForElementToLoad(viewnurseryObj.deleteOwner);
			autoScrollandClick(viewnurseryObj.deleteOwner);
			waitIfElementClickIsIntercepted(viewnurseryObj.yesButton, "click", "");
			waitForElementToLoad(addnurseryObj.nurseryName);
			addnurseryObj.nurseryName.sendKeys("__edited");
			addnurseryObj.addressLine1.sendKeys("__edited");
			addnurseryObj.addressLine2.sendKeys("__edited");
			addnurseryObj.beneficiaryAddress.sendKeys("__edited");
			addnurseryObj.bankAddress.sendKeys("__edited");

			tdImport.readSheet("AddOwner");
			addnurserydataObj.generateFakeOwnerData();
			addOwnerData = addnurserydataObj.addOwnerTestData();
			addnurseryObj.addOwner(addOwnerData);
			expectedArraylist.add(addOwnerData[0]);
			expectedArraylist.add(addOwnerData[2].replaceAll("[^\\d+]", "")+" "+addOwnerData[3]);
			expectedArraylist.add(addOwnerData[4]);
			expectedArraylist.add(addOwnerData[1]);

			System.out.println(expectedArraylist);
			Thread.sleep(2000);
			autoScrollandClick(listnurseryObj.saveButton);

			waitForElementToLoad(addnurseryObj.nurseryUpdateMsg);
			actualArraylist.add(addnurseryObj.nurseryUpdateMsg.getText());
			testData[0] = edittestData[0];
			listnurseryObj.filterNursery(testData);
			Thread.sleep(2000);
			waitForElementToLoad(listnurseryObj.viewDetails);
			autoScrollandClick(listnurseryObj.viewDetails);
			waitForElementToLoad(viewnurseryObj.viewNurseryName);
			actualArraylist.add(viewnurseryObj.viewNurseryName.getText());
			actualArraylist.add(viewnurseryObj.viewAddressLine1.getText());
			actualArraylist.add(viewnurseryObj.viewAddressLine2.getText());
			actualArraylist.add(viewnurseryObj.viewCountry.getText());
			actualArraylist.add(viewnurseryObj.viewBeneficaryAddress.getText());
			actualArraylist.add(viewnurseryObj.viewBankAddress.getText());

			actualArraylist.add(viewnurseryObj.viewOwnerName.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerPhoneNo.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerEmail.getText());
			actualArraylist.add(viewnurseryObj.viewOwnerNationality.getText());
			dashboardObj.nurseries.click();
			System.out.println(actualArraylist);
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
		Assert.assertEquals(actualArraylist, expectedArraylist);
		log.info("Assertion passed");
	}


	@AfterClass
	public void signOt()
	{
		dashboardObj.logout();
	}

}
