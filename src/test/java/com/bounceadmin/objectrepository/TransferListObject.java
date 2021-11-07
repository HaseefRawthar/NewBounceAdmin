package com.bounceadmin.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bounceadmin.baseclass.SetUp;

public class TransferListObject extends SetUp {

	WebDriver driver;

	public TransferListObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath="//select[@formcontrolname='nurseryId']")
	public WebElement nurseryName;
	@FindBy(xpath="//label[contains(text(),'From')]//following::input[1]")
	public WebElement fromDate;
	@FindBy(xpath="//label[contains(text(),'To')]//following::input[1]")
	public WebElement toDate;
	@FindBy(xpath="//select[@formcontrolname='status']")
	public WebElement status;

	@FindBy(xpath="//button[contains(text(),'Filter')]")
	public WebElement filterButton;
	@FindBy(xpath="//button[contains(text(),'Reset')]")
	public WebElement resetButton;
	@FindBy(xpath="//button[contains(text(),'PRINT')]")
	public WebElement printButton;

	@FindBy(xpath="//div[@class='total-rows']//span[@class='mobile-hidden']")
	public WebElement totalRecords;
	@FindBy(xpath="//a[@aria-label='go to next page']//i")
	public WebElement goToNextPage;
	@FindBy(xpath="//li[@class='disabled']//a[@aria-label='go to next page']")
	public WebElement lastpagecheck;

	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[2]/div[1]/span[2]")
	public WebElement transferReqIdSortButton;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[5]/div[1]/span[2]")
	public WebElement BankSortButton;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[8]/div[1]/span[2]")
	public WebElement bounceCommisionSortButton;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[9]/div[1]/span[2]")
	public WebElement deductionSortButton;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[10]/div[1]/span[2]")
	public WebElement additionSortButton;

	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[2]/div[1]")
	public WebElement sortedTransferReqId;
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]")
	public WebElement sortedBank;
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]")
	public WebElement sortedBounceCommision;
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[9]/div[1]")
	public WebElement sortedDeduction;
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[10]/div[1]")
	public WebElement sortedAddition;


	public void transferListFilter(String name, String from, String to, String stat)
	{
		try
		{
			waitForElementToLoad(status);
			nurseryName.sendKeys(name);
			fromDate.sendKeys(from);
			toDate.sendKeys(to);
			status.sendKeys(stat);
			filterButton.click();
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info(e);
		}
	}
}
