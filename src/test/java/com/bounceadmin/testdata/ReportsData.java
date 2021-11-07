package com.bounceadmin.testdata;

public class ReportsData {

	TestDataImport tdImport = new TestDataImport();
	String[] testData;
	
	public String[] activeStudentsFilterData()
	{
		testData = new String[5];
		testData[0] = tdImport.getCellData(1, 0);
		testData[1] = tdImport.getCellData(1, 1);
		testData[2] = tdImport.getCellData(1, 2);
		testData[3] = tdImport.getCellData(1, 3);
		testData[4] = tdImport.getCellData(1, 4);
		return testData;
	}
	
	public String[] countries()
	{
		return testData =  tdImport.getCellData(1, 0).split(",");
	}
	
	public String[] nurseries()
	{
		return testData =  tdImport.getCellData(1, 1).split(",");
	}
	
	public String[] dates()
	{
		testData = new String[3];
		testData[0] = tdImport.getCellData(1, 2);
		testData[1] = tdImport.getCellData(1, 3);
		testData[2] = tdImport.getCellData(1, 4);
		return testData;
	}
}
