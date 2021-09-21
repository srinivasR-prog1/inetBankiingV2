package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(xpath="//a[text()='New Customer']")
	@CacheLookup
	WebElement lnkAddNewCust;
	
	
	@FindBy(name="name")
	@CacheLookup
	WebElement txtCustName;
	
	@FindBy(name="rad1")	
	WebElement btnRadClick;
	
	@FindBy(name="dob")
	@CacheLookup
	WebElement txtDob;
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement txtAddr;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement txtPinno;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement txtMobileno;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement txtEmailid;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="sub")	
	WebElement btnSubmit;
	
	
	public void clickAddNewCustomer()
	{
		
		lnkAddNewCust.click();
		
		
	}

	
	public void custName(String cname)
	{
		
		txtCustName.clear();
		txtCustName.sendKeys(cname);
		
		
	}
	
	public void custGender(String cgender)
	{
		
		btnRadClick.click();		
		
		
	}
	
	public void custDob(String dd, String mm,String yyyy)
	{
		
		txtDob.sendKeys(dd);
		txtDob.sendKeys(mm);
		txtDob.sendKeys(yyyy);
		
		
	}
	
	public void custAddr(String addr)
	{
		txtAddr.clear();
		txtAddr.sendKeys(addr);
		
	}
	
	
	public void custCity(String city)
	{
		txtCity.clear();
		txtCity.sendKeys(city);
		
	}
	
	
	public void custState(String state)
	{
		txtState.clear();
		txtState.sendKeys(state);
		
	}
	
	public void custPin(int pin)
	{
		txtPinno.clear();
		txtPinno.sendKeys(String.valueOf(pin));
		
	}
	
	public void custMobileno(long mobileno)
	{
		txtMobileno.clear();
		txtMobileno.sendKeys(String.valueOf(mobileno));
		
	}
	public void custEmail(String email)
	{
		txtEmailid.clear();
		txtEmailid.sendKeys(email);
		
	}
	public void custPwd(String cpwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(cpwd);
		
	}
	
	public void custsubmitBtn()
	{
		
		btnSubmit.click();
		
	}
	
	
	
	
	

}
