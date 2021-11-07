package com.bounceadmin.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bounceadmin.baseclass.SetUp;

public class PaymentTransactionListObject extends SetUp{

	WebDriver driver;
	
	public PaymentTransactionListObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//label[contains(text(),'From Date')]//following::input[1]")
	public WebElement fromDate;
	@FindBy(xpath="//label[contains(text(),'To Date')]//following::input[1]")
	public WebElement toDate;
	@FindBy(xpath="//select[@formcontrolname='paymentMode']")
	public WebElement paymentMode;
	@FindBy(xpath="//select[@formcontrolname='paymentGateway']")
	public WebElement paymentGateway;
	@FindBy(xpath="//select[@formcontrolname='paymentMethod']")
	public WebElement paymentMethod;
	@FindBy(xpath="//select[@formcontrolname='nurseryId']")
	public WebElement nurseryName;
	@FindBy(xpath="//select[@formcontrolname='transactionStatus']")
	public WebElement transactionStatus;
	@FindBy(xpath="//select[@formcontrolname='reconciliationStatus']")
	public WebElement reconciliationStatus;
	@FindBy(xpath="//select[@formcontrolname='transferStatus']")
	public WebElement transferStatus;
	@FindBy(xpath="//input[@formcontrolname='pgTransactionRefId']")
	public WebElement paymentGatewayRefId;
	@FindBy(xpath="//button[contains(text(),'Filter')]")
	public WebElement filterButton;
	@FindBy(xpath="//button[contains(text(),'Reset')]")
	public WebElement resetButton;
	@FindBy(xpath="//button[contains(text(),'PRINT')]")
	public WebElement printButton;
	@FindBy(xpath="//cr-button[@class='action-button']")
	public WebElement print;
	
	@FindBy(xpath="//datatable-body[@class='datatable-body']//datatable-row-wrapper[1]//datatable-body-cell[13]//span")
	public WebElement getpatmentGatewayRefId;
	
	@FindBy(xpath="//div[@class='total-rows']//span[@class='mobile-hidden']")
	public WebElement totalRecords;
	@FindBy(xpath="//a[@aria-label='go to next page']//i")
	public WebElement goToNextPage;
	@FindBy(xpath="//li[@class='disabled']//a[@aria-label='go to next page']")
	public WebElement lastpagecheck;
	
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[3]/div[1]/span[2]")
	public WebElement customerRefIdSortButton;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[4]/div[1]/span[2]")
	public WebElement bouncePayIdSortButton;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[5]/div[1]/span[2]")
	public WebElement nurseryNameSortButton;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[6]/div[1]/span[2]")
	public WebElement payDateSortButton;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[7]/div[1]/span[2]")
	public WebElement AmountSortButton;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[10]/div[1]/span[2]")
	public WebElement paygatewaySortButton;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[11]/div[1]/span[2]")
	public WebElement payMethodSortButton;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[12]/div[1]/span[2]")
	public WebElement payModeSortButton;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[13]/div[1]/span[2]")
	public WebElement payGatewayRefSortButton;
	
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]")
	public WebElement sortedCustomerRefId;
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]")
	public WebElement sortedBouncePayId;
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]")
	public WebElement sortedNurseryName;
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]")
	public WebElement sortedPayDate;
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[7]/div[1]")
	public WebElement sortedAmount;
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[10]/div[1]")
	public WebElement sortedGateway;
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[11]/div[1]")
	public WebElement sortedMethod;
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[12]/div[1]")
	public WebElement sortedMode;
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[13]/div[1]")
	public WebElement sortedGatewayRef;
	
	public void PaymentTransactionListFilter(String[] test)
	{
		waitForElementToLoad(fromDate);
		fromDate.sendKeys(test[0]);
		toDate.sendKeys(test[1]);
		paymentMode.sendKeys(test[2]);
		paymentGateway.sendKeys(test[3]);
		paymentMethod.sendKeys(test[4]);
		nurseryName.sendKeys(test[5]);
		transactionStatus.sendKeys(test[6]);
		reconciliationStatus.sendKeys(test[7]);
		transferStatus.sendKeys(test[8]);
		paymentGatewayRefId.sendKeys(test[9]);
		filterButton.click();
	}
}
