package com.bounceadmin.testdata;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class AddStaffData {

	Locale local = new Locale("en-IND");
	Faker fake = new Faker(local);
	FakeValuesService fakeService = new FakeValuesService(local, new RandomService());
	TestDataImport tdImport = new TestDataImport();
	String[] testData;
	
	public void generateFakeStaffData()
	{
		tdImport.writeCell(1, 0, fake.name().firstName());
		tdImport.writeCell(1, 1, fake.name().lastName());
		tdImport.writeCell(1, 2, fake.name().lastName());
		tdImport.writeCell(1, 3, fake.bothify("????????#?#?@email.com"));
		tdImport.writeCell(1, 5, fake.numerify("9#######"));
		
	}
	
	public String[] addStaffTestData()
	{
		testData = new String[6];
		testData[0] = tdImport.getCellData(1, 0);
		testData[1] = tdImport.getCellData(1, 1);
		testData[2] = tdImport.getCellData(1, 2);
		testData[3] = tdImport.getCellData(1, 3);
		testData[4] = tdImport.getCellData(1, 4);
		testData[5] = tdImport.getCellData(1, 5);
		return testData;
	}
	
	public String[] viewStaffData()
	{
		testData = new String[3];
		testData[0] = tdImport.getCellData(1, 0)+" "+tdImport.getCellData(1, 1)+" "+tdImport.getCellData(1, 2);
		testData[1] = tdImport.getCellData(1, 4).replaceAll("[^\\d+]", "")+" "+tdImport.getCellData(1, 5);
		testData[2] = tdImport.getCellData(1, 3);
		return testData;
	}
	
	public String[] staffFilterData()
	{
		testData = new String[4];
		testData[0] = tdImport.getCellData(20, 0);
		testData[1] = tdImport.getCellData(20, 1);
		testData[2] = tdImport.getCellData(20, 2);
		testData[3] = tdImport.getCellData(20, 3);
		return testData;
	}
	
	public String[] staffRoles()
	{
		testData = new String[6];
		testData[0] = tdImport.getCellData(1, 6);
		testData[1] = tdImport.getCellData(2, 6);
		testData[2] = tdImport.getCellData(3, 6);
		testData[3] = tdImport.getCellData(4, 6);
		testData[4] = tdImport.getCellData(5, 6);
		testData[5] = tdImport.getCellData(6, 6);
		return testData;
	}
}
