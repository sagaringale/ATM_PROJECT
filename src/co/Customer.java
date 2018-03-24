package co;

import java.util.Date;


public class Customer {
private  int customerId;
private  String customerName;
private String customerEmail;
private  String contactNumber;
private  String customerAddress;
private Date customerDOB;

public Customer() {
	// TODO Auto-generated constructor stub
}
public String getCustomerEmail() {
	return customerEmail;
}
public void setCustomerEmail(String customerEmail) {
	this.customerEmail = customerEmail;
}
public Date getCustomerDOB() {
	return customerDOB;
}
public void setCustomerDOB(Date customerDOB) {
	this.customerDOB = customerDOB;
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
public String getContactNumber() {
	return contactNumber;
}
public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}
public String getCustomerAddress() {
	return customerAddress;
}
public void setCustomerAddress(String customerAddress) {
	this.customerAddress = customerAddress;
}

}
