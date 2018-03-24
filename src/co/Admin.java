package co;

public class Admin {
private int adminId;
private String adminName;
private String adminAddress;
private int contactNumber;
private int adminPin;
public Admin() {
	// TODO Auto-generated constructor stub
}

/*public Admin(int adminId, String adminName) {
	super();
	this.adminId = adminId;
	this.adminName = adminName;
}*/
public String getAdminName() {
	return adminName;
}
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
public String getAdminAddress() {
	return adminAddress;
}
public void setAdminAddress(String adminAddress) {
	this.adminAddress = adminAddress;
}
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public int getContactNumber() {
	return contactNumber;
}
public void setContactNumber(int contactNumber) {
	this.contactNumber = contactNumber;
}
public int getAdminPin() {
	return adminPin;
}
public void setAdminPin(int adminPin) {
	this.adminPin = adminPin;
}


}
