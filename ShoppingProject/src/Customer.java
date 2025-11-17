
public class Customer {
	
private int customerID;
private String name;
private String email;
private String address;


	public Customer() {
	
}

	public Customer(int customerID, String name, String email, String address){
		this.customerID = customerID;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
	

	@Override
	public String toString() {
		return ("\ncustomerID: " + customerID + "\nname: " + name + "\nemail: " + email + "\nnaddress+ " + address);
	}



	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
}
