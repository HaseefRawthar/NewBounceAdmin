package com.bounceadmin.testdata;

import com.bounceadmin.baseclass.SetUp;

public class Transfers extends SetUp {
	
	TestDataImport tdImport = new TestDataImport();
	String[] testData;
	
	public String[] transferFilterData()
	{
		testData = new String[4];
		testData[0] = tdImport.getCellData(1, 0);
		testData[1] = tdImport.getCellData(1, 1);
		testData[2] = tdImport.getCellData(1, 2);
		testData[3] = tdImport.getCellData(1, 3);
		return testData;
	}

}
