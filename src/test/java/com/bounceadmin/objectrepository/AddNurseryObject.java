package com.bounceadmin.objectrepository;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bounceadmin.baseclass.SetUp;

public class AddNurseryObject extends SetUp {

	WebDriver driver;

	public AddNurseryObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Nursery Name']//following::small[1]")
	public WebElement nurseryNameMandatoryMsg;
	@FindBy(xpath="//input[@placeholder='Address Line1']//following::small[1]")
	public WebElement addressLine1MandatoryMsg;
	@FindBy(xpath="//select[@formcontrolname='countryId']//following::small[1]")
	public WebElement countryMandatoryMsg;
	@FindBy(xpath="//select[@formcontrolname='phonenumber_code']//following::small[1]")
	public WebElement countryCodeMandatoryMsg;
	@FindBy(xpath="//input[@placeholder='Phone Number']//following::small[1]")
	public WebElement phoneNumberMandatoryMsg;
	@FindBy(xpath="//label[contains(text(),'Logo')]//following::small[1]")
	public WebElement logoMandatoryMsg;
	@FindBy(xpath="//label[contains(text(),'Contract Date From')]//following::small[1]")
	public WebElement dateFromMandatoryMsg;
	@FindBy(xpath="//label[contains(text(),'Contract Date To')]//following::small[1]")
	public WebElement dateToMandatoryMsg;
	@FindBy(xpath="//label[contains(text(),'Contract Type')]//following::small[1]")
	public WebElement contractTypeMandatoryMsg;
	@FindBy(xpath="//small[contains(text(),'Supplier email required')]")
	public WebElement supplierEmailMandatoryMsg;
	@FindBy(xpath="//select[@formcontrolname='supplierCountryCode']//following::small[1]")
	public WebElement supplierCntryCodeMandatoryMsg;
	@FindBy(xpath="//small[contains(text(),'Commercial License required')]")
	public WebElement licenseMandatoryMsg;
	@FindBy(xpath="//small[contains(text(),'Signature Authorization required')]")
	public WebElement signatureMandatoryMsg;
	@FindBy(xpath="//small[contains(text(),'Articles of Association required')]")
	public WebElement articleOfAssociationMandatoryMsg;
	@FindBy(xpath="//small[contains(text(),'Civil Id required')]")
	public WebElement civilIdMandatoryMsg;
	@FindBy(xpath="//small[contains(text(),'Civil Id Back required')]")
	public WebElement civilIdBackMandatoryMsg;
	@FindBy(xpath="//small[contains(text(),'3-parties contract/ agreement required')]")
	public WebElement contractMandatoryMsg;
	@FindBy(xpath="//small[contains(text(),'Account holder name is required')]")
	public WebElement accountHolderNameMandatoryMsg;
	@FindBy(xpath="//small[contains(text(),'Bank name is required')]")
	public WebElement bankNameMandatoryMsg;
	@FindBy(xpath="//small[contains(text(),'Account number is required')]")
	public WebElement accountNumMandatoryMsg;
	@FindBy(xpath="//small[contains(text(),'IBAN is required')]")
	public WebElement ibanMandatoryMsg;
	@FindBy(xpath="//small[contains(text(),'Account number do not match')]")
	public WebElement accNoMatchMandatoryMsg;
	@FindBy(xpath="//div[@aria-label='Select one payment method']")
	public WebElement PaymentMethodMandatoryMsg;
	@FindBy(xpath="//div[@role='alertdialog'][@aria-label='Please add owner details']")
	public WebElement ownerMandatoryMsg;
	
	@FindBy(xpath="//small[contains(text(),'Name is required.')]")
	public WebElement nameMandatoryMsg;
	@FindBy(xpath="//small[contains(text(),'Nationality is required.')]")
	public WebElement nationalityMandatoryMsg;
	@FindBy(xpath="//select[@formcontrolname='phone_code']//following::small[1]")
	public WebElement ownerPhnCodeMandatoryMsg;
	@FindBy(xpath="//input[@formcontrolname='phone_number']//following::small[1]")
	public WebElement ownerPhoneMandatoryMsg;
	@FindBy(xpath="//small[contains(text(),'Email is required.')]")
	public WebElement emailMandatoryMsg;

	@FindBy(xpath="//input[@formcontrolname='nameEn']")
	public WebElement nurseryName;
	@FindBy(xpath="//input[@formcontrolname='legalNameEn']")
	public WebElement nurseryLegalNameEn;
	@FindBy(xpath="//input[@formcontrolname='legalNameAr']")
	public WebElement nurseryLegalNameAr;
	@FindBy(xpath="//input[@formcontrolname='taxId']")
	public WebElement taxId;
	@FindBy(xpath="//input[@placeholder='Address Line1']")
	public WebElement addressLine1;
	@FindBy(xpath="//select[@formcontrolname='countryId']")
	public WebElement country;
	@FindBy(xpath="//select[@formcontrolname='phonenumber_code']")
	public WebElement countryCode;
	@FindBy(xpath="//input[@formcontrolname='phonenumber']")
	public WebElement phoneNumber;
	@FindBy(xpath="//input[@id='fileInputField1']")
	public WebElement browseLogo;
	@FindBy(xpath="//label[contains(text(),'Logo')]//following::img")
	public WebElement logoPreView;
	@FindBy(xpath="//div[@role='alertdialog'][@aria-label='File uploaded successfully']")
	public WebElement logosucessMsg;
	@FindBy(xpath="//label[contains(text(),'Contract Date From')]//following::input[1]")
	public WebElement contractDateFrom;
	@FindBy(xpath="//label[contains(text(),'Contract Date To')]//following::input[1]")
	public WebElement contractDateTo;
	@FindBy(xpath="//select[@formcontrolname='contractType']")
	public WebElement contractType;
	@FindBy(xpath="//button[contains(text(),'ADD')]")
	public WebElement addButton;
	@FindBy(xpath="//span[@class='slider toggle_round']")
	public WebElement onlinePayment;

	@FindBy(xpath="//input[@placeholder='Address Line2']")
	public WebElement addressLine2;
	@FindBy(xpath="//input[@placeholder='Zip Code']")
	public WebElement zipCode;
	@FindBy(xpath="//select[@formcontrolname='stateId']")
	public WebElement state;
	@FindBy(xpath="//select[@formcontrolname='cityId']")
	public WebElement city;
	@FindBy(xpath="//input[@formcontrolname='email']")
	public WebElement email;
	@FindBy(xpath="//textarea[@formcontrolname='contractInfo']")
	public WebElement contractInfo;
	@FindBy(xpath="//input[@formcontrolname='transactionFees']")
	public WebElement fees;
	@FindBy(xpath="//select[@formcontrolname='collectionTerm']")
	public WebElement collectionTerm;
	@FindBy(xpath="//input[@formcontrolname='minimumRequestAmount']")
	public WebElement minimumAmount;

	@FindBy(xpath="//input[@id='method0']")
	public WebElement paymentGateway1CheckBox;
	@FindBy(xpath="//input[@id='method1']")
	public WebElement paymentGateway2CheckBox;
	@FindBy(xpath="//input[@id='method2']")
	public WebElement paymentGateway3CheckBox;
	@FindBy(xpath="//input[@id='method0']//following::input[1]")
	public WebElement fixed1;
	@FindBy(xpath="//input[@id='method0']//following::input[2]")
	public WebElement variable1;

	@FindBy(xpath="//div[@class='cursor attachments ml-3']//span[@class='app-c-add-new-option'][normalize-space()='Add Attachment']")
	public WebElement addAttachment1;
	@FindBy(xpath="//input[@id='fileInputField4']")
	public WebElement browseAttachments1;

	@FindBy(xpath="//div[@class='cursor attachments']//span[@class='app-c-add-new-option'][normalize-space()='Add Attachment']")
	public WebElement addAttachment2;
	@FindBy(xpath="//input[@id='fileInputField5']")
	public WebElement browseAttachments2;

	@FindBy(xpath="//input[@formcontrolname='accountName']")
	public WebElement accountHolderName;
	@FindBy(xpath="//input[@placeholder='Beneficiary Address']")
	public WebElement beneficiaryAddress;
	@FindBy(xpath="//select[@formcontrolname='bankName']")
	public WebElement bankName;
	@FindBy(xpath="//input[@placeholder='Bank Address']")
	public WebElement bankAddress;
	@FindBy(xpath="//input[@placeholder='Account Number']")
	public WebElement accountNumber;
	@FindBy(xpath="//input[@placeholder='Confirm Account Number']")
	public WebElement confirmAccountNumber;
	@FindBy(xpath="//input[@placeholder='IBAN']")
	public WebElement IBAN;
	@FindBy(xpath="//select[@formcontrolname='accountCurrency']")
	public WebElement accountCurrency;
	@FindBy(xpath="//input[@formcontrolname='swiftCode']")
	public WebElement swiftCode;
	@FindBy(xpath="//textarea[@formcontrolname='notes']")
	public WebElement notes;

	@FindBy(xpath="//span[contains(text(),'Add Owner/Manager')]")
	public WebElement addOwner;
	@FindBy(xpath="//input[@formcontrolname='name']")
	public WebElement ownerName;
	@FindBy(xpath="//label[contains(text(),'Nationality')]//following::select[1]")
	public WebElement ownerNationality;
	@FindBy(xpath="//select[@formcontrolname='phone_code']")
	public WebElement ownerCountrycode;
	@FindBy(xpath="//input[@formcontrolname='phone_number']")
	public WebElement ownerPhoneNumber;
	@FindBy(xpath="//input[@id='inputEmail']")
	public WebElement ownerEmail;
	@FindBy(xpath="//div[@class='form-group']//button[contains(text(),'ADD')]")
	public WebElement ownerAddButton;
	@FindBy(xpath="//button[@class='btn btn btn-outline-danger']")
	public WebElement ownerCancelButton;
	
	@FindBy(xpath="//label[contains(text(),' 1. Commercial License ')]//following::input[@id='fileInputField6'][1]")
	public WebElement commercialLicense;
	@FindBy(xpath="//h4[contains(text(),'Contractual Documents')]//following::img[1]")
	public WebElement commercialLicenseImg;
	@FindBy(xpath="//label[contains(text(),' 2. Signature Authorization ')]//following::input[@id='fileInputField6'][1]")
	public WebElement signatureAutorization;
	@FindBy(xpath="//h4[contains(text(),'Contractual Documents')]//following::img[2]")
	public WebElement signatureAutorizationImg;
	@FindBy(xpath="//label[contains(text(),' 3. Articles of Association ')]//following::input[@id='fileInputField6'][1]")
	public WebElement articleOfAssociation;
	@FindBy(xpath="//h4[contains(text(),'Contractual Documents')]//following::img[3]")
	public WebElement articleOfAssociationImg;
	@FindBy(xpath="//label[contains(text(),' 4. Civil Id ')]//following::input[@id='fileInputField6'][1]")
	public WebElement civilId;
	@FindBy(xpath="//h4[contains(text(),'Contractual Documents')]//following::img[4]")
	public WebElement civilIdImg;
	@FindBy(xpath="//label[contains(text(),' 5. Civil Id Back ')]//following::input[@id='fileInputField6'][1]")
	public WebElement civilIdBack;
	@FindBy(xpath="//h4[contains(text(),'Contractual Documents')]//following::img[5]")
	public WebElement civilIdBackImg;
	@FindBy(xpath="//label[contains(text(),' 6. 3-parties contract/ agreement ')]//following::input[@id='fileInputField6'][1]")
	public WebElement contractAgreement;
	@FindBy(xpath="//h4[contains(text(),'Contractual Documents')]//following::img[6]")
	public WebElement contractAgreementImg;
	@FindBy(xpath="//label[contains(text(),' 7. Others ')]//following::input[@id='fileInputField6'][1]")
	public WebElement others;
	@FindBy(xpath="//h4[contains(text(),'Contractual Documents')]//following::img[7]")
	public WebElement othersImg;
	
	@FindBy(xpath="//input[@formcontrolname='supplierEmail']")
	public WebElement supplierEmail;
	@FindBy(xpath="//select[@formcontrolname='supplierCountryCode']")
	public WebElement supplierCountryCode;
	@FindBy(xpath="//input[@formcontrolname='supplierPhoneNumber']")
	public WebElement supplierPhoneNumber;
	@FindBy(xpath="//select[@formcontrolname='depositTerms']")
	public WebElement depositTerms;

	@FindBy(xpath="//div[@aria-label='Institution Created Successfully']")
	public WebElement nurserySuccessMsg;
	@FindBy(xpath="//div[@aria-label='Institution Updated Successfully']")
	public WebElement nurseryUpdateMsg;
	@FindBy(xpath="//i[@class='far fa-trash-alt cursor']")
	public WebElement deleteOwner;
	@FindBy(xpath="//button[contains(text(),'Yes')]")
	public WebElement yes;
	
	@FindBy(xpath="//th[contains(text(),'Payment Gateway')]")
	public WebElement paymentGatewayLabel;

	public void addNurseryMandatoryFields(String[] test) //sending data to mandatory fields only
	{
		try {
			log.info("Entered addNursery method");
			waitForElementToLoad(nurseryName);
			nurseryName.sendKeys(test[0]);
			addressLine1.sendKeys(test[1]);
			country.sendKeys(test[2]);
			countryCode.sendKeys(test[3]);
			phoneNumber.sendKeys(test[4]);
			browseLogo.sendKeys(projectFolder+test[5]);
			waitForElementToLoad(logoPreView);
			String msg = logosucessMsg.getText();
			log.info(msg);
			System.out.println("logo"+msg);
			contractDateFrom.sendKeys(test[6]);
			Thread.sleep(500);
			waitForElementToLoad(contractDateTo);
			contractDateTo.sendKeys(test[7]);
			Thread.sleep(500);
			waitForElementToLoad(contractType);
			contractType.sendKeys(test[8]);

		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}

	}

	public void addNurseryNonMandatoryFields(String[] test) //sending data to non mandatory fields only
	{
		try
		{
			log.info("Entered addNurseryNonMandatoryFields Method");		
			waitForElementToLoad(addressLine2);
			nurseryLegalNameEn.sendKeys(test[0]);
			nurseryLegalNameAr.sendKeys(test[1]);
			taxId.sendKeys(test[2]);
			addressLine2.sendKeys(test[3]);
			zipCode.sendKeys(test[4]);
			state.sendKeys(test[5]);

			email.sendKeys(test[7]);
			contractInfo.sendKeys(test[8]);
			fees.sendKeys(test[9]);
			collectionTerm.sendKeys(test[10]);
			minimumAmount.sendKeys(test[11]);


			waitForElementToLoad(accountHolderName);
			accountHolderName.sendKeys(test[12]);
			beneficiaryAddress.sendKeys(test[13]);
			Thread.sleep(1000);
			bankName.sendKeys(test[14]);
			Thread.sleep(500);
			bankAddress.sendKeys(test[15]);
			accountNumber.sendKeys(test[16]);
			confirmAccountNumber.sendKeys(test[16]);
			IBAN.sendKeys(test[17]);
			accountCurrency.sendKeys(test[18]);
			swiftCode.sendKeys(test[19]);
			waitForElementToLoad(city);
			city.sendKeys(test[6]);
			notes.sendKeys(test[20]);


		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}


	public void addOwner(String[] test) //add owner details
	{
		try {
			log.info("Entered addOwner Method");
			waitForElementToLoad(addOwner);
			//addOwner.click();
			autoScrollandClick(addOwner);
			waitForElementToLoad(ownerName);
			ownerName.sendKeys(test[0]);
			ownerNationality.sendKeys(test[1]);
			waitForElementToLoad(ownerCountrycode);
			ownerCountrycode.sendKeys(test[2]);
			ownerPhoneNumber.sendKeys(test[3]);
			ownerEmail.sendKeys(test[4]);
			waitForElementToLoad(ownerAddButton);
			ownerAddButton.click();
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}

	}

	public void addAttachments(WebElement element1, WebElement element2, String[] test, int n ) //add attachments, n=no.of attachments(max=10)
	{
		try
		{
			String one;
			if(element1==addAttachment1) {
				one = "//div[@class='cursor attachments ml-3']//span[@class='app-c-add-new-option'][normalize-space()='Add Attachment']";
			}
			else {
				one="//div[@class='cursor attachments']//span[@class='app-c-add-new-option'][normalize-space()='Add Attachment']";
			}
			wait600Sec = new WebDriverWait(driver, 600);
			for(int i=1;i<=n;i++)
			{

				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("arguments[0].click();", element1);

				element2.sendKeys(projectFolder+test[i - 1]);

				wait600Sec.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(one+"//following::img["+i+"]")));
				WebElement attachmentName = driver.findElement(By.xpath(one+"//following::input[@placeholder='Attachment Name']["+i+"]"));
				//waitForElementToLoad(logosucessMsg);
				//log.info (logosucessMsg.getText()+", "+i);
				waitForElementToLoad(attachmentName);
				attachmentName.sendKeys(test[9+i]);

			}

		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}
	
	public void addSupplierDetails(String[] test)
	{
		try
		{
			waitForElementToLoad(supplierEmail);
			supplierEmail.sendKeys(test[0]);
			supplierCountryCode.sendKeys(test[1]);
			supplierPhoneNumber.sendKeys(test[2]);
			depositTerms.sendKeys(test[3]);
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}
	
	public void addPayment(String[] method, String fixed, String variable)
	{
		try
		{
			if(isElementPresent(paymentGateway1CheckBox))
			{
				for(int i=0;i<method.length;i++)
				{
					waitForElementToLoad(paymentGatewayLabel);
					Thread.sleep(1500);
					if(isElementPresent(driver.findElement(By.xpath("//td[contains(text(),'"+method[i]+"')]//preceding::input[1]"))))
					{
						WebElement element = driver.findElement(By.xpath("//td[contains(text(),'"+method[i]+"')]//preceding::input[1]"));
						autoScrollandClick(element);
						driver.findElement(By.xpath("//td[contains(text(),'"+method[i]+"')]//following::input[1]")).sendKeys(fixed);
						driver.findElement(By.xpath("//td[contains(text(),'"+method[i]+"')]//following::input[2]")).sendKeys(variable);
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}
	
	public void addContractualDocuments(WebElement upload, WebElement image, String attachment)
	{
		try
		{
			//waitForElementToLoad(upload);
			upload.sendKeys(projectFolder+attachment);
			fileUploadWait(image);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}
}
