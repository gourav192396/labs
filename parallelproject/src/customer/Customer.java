package customer;

public class Customer {
private String name;
private long customerId;
private double balance;
//private long acoountNo;
private String mobile; 
private String email;
private String password;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
//public long getAcoountNo() {
//	return acoountNo;
//}
//public void setAcoountNo(long acoountNo) {
//	this.acoountNo = acoountNo;
//}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public long getCustomerId() {
	return customerId;
}
public void setCustomerId(long customerId) {
	this.customerId = customerId;
}
public Customer(){
	
}
public Customer(String name,  String email,
		String mobile, String password, double balance) {
	super();
	this.name = name;
	//this.address = address;
	this.email = email;
	this.mobile = mobile;
	this.password = password;
	this.balance = balance;
}

@Override
public String toString() {
	return "Customer [name=" + name + ", customerId=" + customerId + ", balance=" + balance + ", mobile=" + mobile
			+ ", email=" + email + ", password=" + password + "]";
}





//@Override
//public String toString() {
//	return "Customer [name=" + name + ", customerId=" + customerId + ", mobile=" + mobile + ", email=" + email
//			+ ", password=" + password + "]";
//}



//@Override
//public String toString() {
//	return "Customer [name=" + name + ", balance=" + balance + ", acoountNo="
//			+ acoountNo + ", mobile=" + mobile + ", email=" + email
//			+ ", password=" + password + ",customerId="+customerId+"]";




}
