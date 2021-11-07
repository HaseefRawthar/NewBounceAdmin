package com.bounceadmin.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bounceadmin.baseclass.SetUp;

public class ListNurseryObject extends SetUp {

	WebDriver driver;
	
	public ListNurseryObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(xpath="//input[@formcontrolname='nursery_name']")
	public WebElement nurseryName;
	@FindBy(xpath="//select[@formcontrolname='status']")
	public WebElement status;
	@FindBy(xpath="//input[@formcontrolname='email']")
	public WebElement nurseryEmail;
	@FindBy(xpath="//select[@formcontrolname='country']")
	public WebElement selectCountry;
	@FindBy(xpath="//select[@formcontrolname='phone_code']")
	public WebElement selectCountryCode;
	@FindBy(xpath="//input[@placeholder='Phone Number']")
	public WebElement phoneNumber;
	@FindBy(xpath="//select[@formcontrolname='access']")
	public WebElement access;
	
	@FindBy(xpath="//button[contains(text(),'Filter')]")
	public WebElement filterButton;
	@FindBy(xpath="//button[contains(text(),'Reset')]")
	public WebElement resetButton;
	
	@FindBy(xpath="//i[@class=' fas fa-eye iconColor cursor']")
	public WebElement viewDetails;
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/app-private-layout[1]/div[1]/div[1]/div[1]/app-nursery-list[1]/div[3]/div[1]/div[1]/div[1]/ngx-datatable[1]/div[1]/datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[10]/div[1]/span[1]/span[2]/i[1]")
	public WebElement editDetails;
	
	@FindBy(xpath="//span[@class='mobile-hidden'][contains(text(),'Total Records')]")
	public WebElement totalRecords;

	@FindBy(xpath="//a[@aria-label='go to next page']//i")
	public WebElement goToNextPage;
	@FindBy(xpath="//li[@class='disabled']//a[@aria-label='go to next page']")
	public WebElement lastpagecheck;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	public WebElement saveButton;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[3]/div[1]/span[2]")
	public WebElement nurseryNameSortButton;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[5]/div[1]/span[2]")
	public WebElement nurseryEmailSortButton;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[6]/div[1]/span[2]")
	public WebElement countrySortButton;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[7]/div[1]/span[2]")
	public WebElement createdDateSortButton;
	@FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[8]/div[1]/span[2]")
	public WebElement statusSortButton;
	
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]//span[1]")
	public WebElement sortedNurseryName;
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[5]/div[1]//span[1]")
	public WebElement sortedNurseryEmail;
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]//span[1]")
	public WebElement sortedCountry;
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[7]/div[1]//span[1]")
	public WebElement sortedCreatedDate;
	@FindBy(xpath="//datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]//span[1]")
	public WebElement sortedStatus;

	
	
	
	public void filterNursery(String[] test) //function to filter nursery
	{
		waitForElementToLoad(nurseryName);
		nurseryName.sendKeys(test[0]);
		nurseryEmail.sendKeys(test[1]);
		selectCountry.sendKeys(test[2]);
		selectCountryCode.sendKeys(test[3]);
		phoneNumber.sendKeys(test[4]);
		//status.sendKeys(test[5]);
		
		filterButton.click();
	}
	
}
