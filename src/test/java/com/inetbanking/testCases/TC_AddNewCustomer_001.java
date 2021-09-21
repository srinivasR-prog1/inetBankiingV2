package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.BaseClass;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddNewCustomer_001 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.btnSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addCust= new AddCustomerPage(driver);
		
		addCust.clickAddNewCustomer();
		
		addCust.custName("Mahesh");
		
		addCust.custGender("Male");
		
		addCust.custDob("11","05", "2000");
		addCust.custAddr("Mumbai");
		addCust.custCity("Mumbai");
		addCust.custState("Maharastra");
		addCust.custPin(500006);
		addCust.custMobileno(987654321);
		addCust.custEmail("abc@gmail.com");
		addCust.custPwd("abcd");
		addCust.custsubmitBtn();
		
		
		
	}
	
	
	
	
	

}
