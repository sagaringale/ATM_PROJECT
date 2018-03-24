package co;

import java.util.Date;

public class Transaction {
private int tId=1;
private String tType;
private int tamount;
//private Date tdate;
private String tdate;
private int accountNumber;
public Transaction() {

	tId++;
	// TODO Auto-generated constructor stub
}
public int gettId() {
	return tId;
}
public void settId(int tId) {
	this.tId = tId;
}
public String gettType() {
	return tType;
}
public void settType(String tType) {
	this.tType = tType;
}
public int getTamount() {
	return tamount;
}
public void setTamount(int tamount) {
	this.tamount = tamount;
}
/*public Date getTdate() {
	return tdate;
}
public void setTdate(Date tdate2) {
	this.tdate = tdate2;
}
*/

public int getAccountNumber() {
	return accountNumber;
}
public String getTdate() {
	return tdate;
}
public void setTdate(String tdate) {
	this.tdate = tdate;
}
public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
}
@Override
public String toString() {
	return "Transaction [tId=" + tId + ", tType=" + tType + ", tamount="
			+ tamount + ", tdate=" + tdate + ", accountNumber=" + accountNumber
			+ "]";
}


}
