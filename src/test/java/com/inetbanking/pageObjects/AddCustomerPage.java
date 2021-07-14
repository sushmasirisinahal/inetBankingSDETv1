package com.inetbanking.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	//Create constructor for Webdriver
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
				
	}
	
	//identify items
	@FindBy(how=How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")///html/body/div[3]/div/ul/li[2]/a
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how=How.NAME, using="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how=How.NAME, using="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how=How.ID_OR_NAME, using="dob")
	@CacheLookup
	WebElement txtDob;
	
	@FindBy(how=How.NAME, using="addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how=How.NAME, using="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how=How.NAME, using="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how=How.NAME, using="pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(how=How.NAME, using="telephoneno")
	@CacheLookup
	WebElement txtTelephone;
	
	@FindBy(how=How.NAME, using="emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how=How.NAME, using="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how=How.NAME, using="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	//Action methods
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}
	

	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender(String cgender) {
		rdGender.click();
	}
	
	public void custDob(String mm, String dd, String yy) {
		txtDob.sendKeys(mm);
		txtDob.sendKeys(dd);
		txtDob.sendKeys(yy);
		
	}
	
	public void custAddress(String caddress) {
		txtAddress.sendKeys(caddress);
	}
	
	public void custCity(String ccity) {
		txtCity.sendKeys(ccity);
	}
	
	public void custState(String cstate) {
		txtState.sendKeys(cstate);
	}
	
	public void custPin(int cpin) {
		txtPin.sendKeys(String.valueOf(cpin));
	}
	
	public void custTelephone(String ctelephoneno) {
		txtTelephone.sendKeys(ctelephoneno);
	}
	
	public void custEmail(String cemailid) {
		txtEmail.sendKeys(cemailid);
	}
	
	public void custPassword(String cpassword) {
		txtPassword.sendKeys(cpassword);
	}
	
	public void custSubmit() {
		btnSubmit.click();
	}
		


}
