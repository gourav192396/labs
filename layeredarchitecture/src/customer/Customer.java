package customer;

public class Customer {
	private long custId;  
	private String custName; 
	private String address; 
	private long mobile; 
	private String email;
	public long getCustId() {
		return custId;
	}
	public void setCustId(long temp) {
		this.custId = temp;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", address=" + address + ", mobile=" + mobile + ", email="
				+ email + "]";
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobno) {
		this.mobile = mobno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
