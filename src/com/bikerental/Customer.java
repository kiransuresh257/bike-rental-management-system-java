package com.bikerental;

public class Customer {
	private int customerId;
	private String customerName;
	private String mobileNumber;
	private String licenseNumber;
      
      public Customer(int customerId, String customerName,String mobileNumber,String licenseNumber){
    	  this.customerId=customerId;
    	  this.customerName=customerName;
    	  this.mobileNumber=mobileNumber;
    	  this.licenseNumber=licenseNumber;
      }

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
      
     
}
