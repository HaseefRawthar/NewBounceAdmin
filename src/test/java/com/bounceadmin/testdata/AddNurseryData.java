package com.bounceadmin.testdata;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class AddNurseryData {

	Locale local = new Locale("en-IND");
	Faker fake = new Faker(local);
	FakeValuesService fakeService = new FakeValuesService(local, new RandomService());
	TestDataImport tdImport = new TestDataImport();
	String number;
	String[] testData;
	
	public void generateFakeNurseryData()
	{
	   String name =  fake.educator().campus().replaceFirst("Campus", "Nursery")+" Automation";
	   tdImport.writeCell(1, 0, name); 
	   tdImport.writeCell(1, 1, name); 
	   tdImport.writeCell(1, 3, fake.numerify("############"));
	   tdImport.writeCell(1, 4, fake.address().fullAddress());
	   tdImport.writeCell(1, 5, fake.address().streetAddress());
	   tdImport.writeCell(1, 7, fake.address().zipCode());
	   tdImport.writeCell(1, 10, fake.numerify("9#######"));
	   tdImport.writeCell(1, 12, fake.bothify("????????#?#?@email.com"));
	   tdImport.writeCell(1, 18, fake.numerify("2##.##1"));
	   tdImport.writeCell(1, 20, fake.numerify("1#.##1"));
	   tdImport.writeCell(1, 21, fake.name().fullName());
	   tdImport.writeCell(1, 22, fake.address().fullAddress());
	   tdImport.writeCell(1, 24, fake.address().fullAddress());
	   tdImport.writeCell(1, 25, fake.numerify("############"));
	  // tdImport.writeCell(1, 26, fake.bothify("KW##????######################", true));
	   tdImport.writeCell(1, 28, fake.letterify("?????????", true));
	   tdImport.writeCell(1, 29, fake.letterify("???????????????"));
		
	}
	
	public void generateFakeSupplierData()
	{
		tdImport.writeCell(1, 33, fake.bothify("????????#?#?@email.com"));
		number = tdImport.getCellData(1, 10);
		tdImport.writeCell(1, 35, number);
		tdImport.writeCell(1, 39, fake.numerify("4.##1"));
		tdImport.writeCell(1, 40, fake.numerify("3.##"));
	}
	
	public void generateFakeOwnerData()
	{
		String name = fake.name().firstName();
		tdImport.writeCell(1, 0, name+fake.bothify(" ??##"));
		tdImport.writeCell(1, 3, fake.numerify("9#######"));
		tdImport.writeCell(1, 4, fake.bothify(name+"####??@gmail.com"));
		
	}
	
	public String[] addNurseryMandatoryTestData()
	{
		testData = new String[9];
		testData[0] = tdImport.getCellData(1, 0);
		testData[1] = tdImport.getCellData(1, 4);
		testData[2] = tdImport.getCellData(1, 6);
		testData[3] = tdImport.getCellData(1, 9);
		testData[4] = tdImport.getCellData(1, 10);
		testData[5] = tdImport.getCellData(1, 13);
		testData[6] = tdImport.getCellData(1, 14);
		testData[7] = tdImport.getCellData(1, 15);
		testData[8] = tdImport.getCellData(1, 16);
		return testData;
		
	}
	
	public String[] addNurseryNonMandatoryTestData()
	{
		testData = new String[21];
		testData[0] = tdImport.getCellData(1, 1);
		testData[1] = tdImport.getCellData(1, 2);
		testData[2] = tdImport.getCellData(1, 3);
		testData[3] = tdImport.getCellData(1, 5);
		testData[4] = tdImport.getCellData(1, 7);
		testData[5] = tdImport.getCellData(1, 8);
		testData[6] = tdImport.getCellData(1, 11);
		testData[7] = tdImport.getCellData(1, 12);
		testData[8] = tdImport.getCellData(1, 17);
		testData[9] = tdImport.getCellData(1, 18);
		
		testData[10] = tdImport.getCellData(1, 19);
		testData[11] = tdImport.getCellData(1, 20);
		testData[12] = tdImport.getCellData(1, 21);
		testData[13] = tdImport.getCellData(1, 22);
		testData[14] = tdImport.getCellData(1, 23);
		testData[15] = tdImport.getCellData(1, 24);
		testData[16] = tdImport.getCellData(1, 25);
		testData[17] = tdImport.getCellData(1, 26);
		testData[18] = tdImport.getCellData(1, 27);
		testData[19] = tdImport.getCellData(1, 28);
		testData[20] = tdImport.getCellData(1, 29);
		return testData;
		
	}
	
	public String[] addSupplierData()
	{
		testData = new String[4];
		testData[0] = tdImport.getCellData(1, 33);
		testData[1] = tdImport.getCellData(1, 34);
		testData[2] = tdImport.getCellData(1, 35);
		testData[3] = tdImport.getCellData(1, 36);
		
		return testData;
	}
	
	public String[] paymentDetails()
	{
		testData = new String[3];
		testData[0] = tdImport.getCellData(1, 37);
		testData[1] = tdImport.getCellData(1, 39);
		testData[2] = tdImport.getCellData(1, 40);
		return testData;
	}
	
	public String[] paymentMethods()
	{
		return testData = tdImport.getCellData(1, 38).split(",");
		
	}
	
	public String[] addOwnerTestData()
	{
		testData = new String[5];
		testData[0] = tdImport.getCellData(1, 0);
		testData[1] = tdImport.getCellData(1, 1);
		testData[2] = tdImport.getCellData(1, 2);
		testData[3] = tdImport.getCellData(1, 3);
		testData[4] = tdImport.getCellData(1, 4);
		return testData;
	}
	
	public String[] attachments()
	{
		testData = new String[20];
		testData[0] = tdImport.getCellData(1, 31);
		testData[1] = tdImport.getCellData(2, 31);
		testData[2] = tdImport.getCellData(3, 31);
		testData[3] = tdImport.getCellData(4, 31);
		testData[4] = tdImport.getCellData(5, 31);
		testData[5] = tdImport.getCellData(6, 31);
		testData[6] = tdImport.getCellData(7, 31);
		testData[7] = tdImport.getCellData(8, 31);
		testData[8] = tdImport.getCellData(9, 31);
		testData[9] = tdImport.getCellData(10, 31);
		
		testData[10] = tdImport.getCellData(1, 32);
		testData[11] = tdImport.getCellData(2, 32);
		testData[12] = tdImport.getCellData(3, 32);
		testData[13] = tdImport.getCellData(4, 32);
		testData[14] = tdImport.getCellData(5, 32);
		testData[15] = tdImport.getCellData(6, 32);
		testData[16] = tdImport.getCellData(7, 32);
		testData[17] = tdImport.getCellData(8, 32);
		testData[18] = tdImport.getCellData(9, 32);
		testData[19] = tdImport.getCellData(10, 32);
		return testData;
		
	}
	
	public String[] contractualDocuments()
	{
		testData = new String[20];
		testData[0] = tdImport.getCellData(1, 41);
		testData[1] = tdImport.getCellData(2, 41);
		testData[2] = tdImport.getCellData(3, 41);
		testData[3] = tdImport.getCellData(4, 41);
		testData[4] = tdImport.getCellData(5, 41);
		testData[5] = tdImport.getCellData(6, 41);
		testData[6] = tdImport.getCellData(7, 41);
		return testData;
	}
	
	
	public String[] listNurseryData()
	{
		testData = new String[6];
		testData[0] = tdImport.getCellData(1, 0);
		testData[1] = tdImport.getCellData(1, 12);
		testData[2] = tdImport.getCellData(1, 6);
		testData[3] = tdImport.getCellData(1, 9);
		testData[4] = tdImport.getCellData(1, 10);
		return testData;
		
	}
	
	public String[] viewNurseryData()
	{
		testData = new String[31];
		testData[0] = tdImport.getCellData(1, 0);
		testData[1] = tdImport.getCellData(1, 1);
		testData[2] = tdImport.getCellData(1, 2);
		testData[3] = tdImport.getCellData(1, 3);
		testData[4] = tdImport.getCellData(1, 4);
		testData[5] = tdImport.getCellData(1, 5);
		testData[6] = tdImport.getCellData(1, 6);
		testData[7] = tdImport.getCellData(1, 7);
		testData[8] = tdImport.getCellData(1, 8);
		testData[9] = tdImport.getCellData(1, 9).replaceAll("[^\\d+]", "")+" "+tdImport.getCellData(1, 10);
	
		testData[10] = tdImport.getCellData(1, 11);
		testData[11] = tdImport.getCellData(1, 12);
		testData[12] = tdImport.getCellData(1, 14);
		testData[13] = tdImport.getCellData(1, 15);
		testData[14] = tdImport.getCellData(1, 16);
		testData[15] = tdImport.getCellData(1, 17);
		testData[16] = tdImport.getCellData(1, 18);
		testData[17] = tdImport.getCellData(1, 19);
		testData[18] = tdImport.getCellData(1, 20);
		testData[19] = tdImport.getCellData(1, 21);
		testData[20] = tdImport.getCellData(1, 22);
		testData[21] = tdImport.getCellData(1, 23);
		testData[22] = tdImport.getCellData(1, 24);
		testData[23] = tdImport.getCellData(1, 25);
		testData[24] = tdImport.getCellData(1, 26);
		testData[25] = tdImport.getCellData(1, 27);
		testData[26] = tdImport.getCellData(1, 28);
		testData[27] = tdImport.getCellData(1, 29);
		
		testData[28] = tdImport.getCellData(1, 33);
		testData[29] = tdImport.getCellData(1, 34).replaceAll("[^\\d+]", "")+" "+tdImport.getCellData(1, 35);
		testData[30] = tdImport.getCellData(1, 36);
		
		return testData;
		
	}
	
	
	public String[] viewOwnerData()
	{
		testData = new String[4];
		testData[0] = tdImport.getCellData(1, 0);
		testData[1] = tdImport.getCellData(1, 2).replaceAll("[^\\d+]", "")+" "+tdImport.getCellData(1, 3);
		testData[2] = tdImport.getCellData(1, 4);
		testData[3] = tdImport.getCellData(1, 1);
		return testData;
	}

	public String[] editNurseryData()
	{
		testData = new String[6];
		testData[0] = tdImport.getCellData(1, 0)+"__edited";
		testData[1] = tdImport.getCellData(1, 4)+"__edited";
		testData[2] = tdImport.getCellData(1, 5)+"__edited";
		testData[3] = tdImport.getCellData(1, 6);
		testData[4] = tdImport.getCellData(1, 22)+"__edited";
		testData[5] = tdImport.getCellData(1, 24)+"__edited";
		return testData;
	}
	
	public String[] nurseryFilterData()
	{
		testData = new String[7];
		testData[0] = tdImport.getCellData(20, 0);
		testData[1] = tdImport.getCellData(20, 1);
		testData[2] = tdImport.getCellData(20, 2);
		testData[3] = tdImport.getCellData(20, 3);
		testData[4] = tdImport.getCellData(20, 4);
		testData[5] = tdImport.getCellData(20, 5);
		testData[6] = tdImport.getCellData(20, 6);
		return testData;
	}
}
