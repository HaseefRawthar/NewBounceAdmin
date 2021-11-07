package com.bounceadmin.testdata;


public class PaymentTransactionData {

	TestDataImport tdImport = new TestDataImport();
	String[] testData;
	
	public String[] paymentFilterData()
	{
		testData = new String[10];
		testData[0] = tdImport.getCellData(1, 0);
		testData[1] = tdImport.getCellData(1, 1);
		testData[2] = tdImport.getCellData(1, 2);
		testData[3] = tdImport.getCellData(1, 3);
		testData[4] = tdImport.getCellData(1, 4);
		testData[5] = tdImport.getCellData(1, 5);
		testData[6] = tdImport.getCellData(1, 6);
		testData[7] = tdImport.getCellData(1, 7);
		testData[8] = tdImport.getCellData(1, 8);
		testData[9] = tdImport.getCellData(1, 9);
		return testData;
	}
}
