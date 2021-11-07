package com.bounceadmin.testdata;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class LogInData {

	Locale local = new Locale("en-IND");
	Faker fake = new Faker(local);
	FakeValuesService fakeService = new FakeValuesService(local, new RandomService());
	TestDataImport tdImport = new TestDataImport();
	String[] testData;
	
	public String[] getValidLoginData()
	{
		testData = new String[2];
		testData[0] = tdImport.getCellData(1, 0);
		testData[1] = tdImport.getCellData(1, 1);
		return testData;
	}
	
	public String[] getInValidLoginData()
	{
		testData = new String[2];
		testData[0] = tdImport.getCellData(2, 0);
		testData[1] = tdImport.getCellData(2, 1);
		return testData;
	}
	
	public String[] getInValidEmailData()
	{
		testData = new String[2];
		testData[0] = tdImport.getCellData(3, 0);
		testData[1] = tdImport.getCellData(3, 1);
		return testData;
	}
}
