
public class Product { 
	
	protected int productID;
	protected String name;
	protected double price;
	
	protected String type;
	
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Product() {
		
	}
	
	public Product(int productID, String name, double price, String Type) {
		this.productID = productID;
		this.name = name;
		this.price = price;
		
	}
	
	

	@Override
	public String toString() {
		return "productID: " + productID + "\nname: " + name + "\nprice: $" + price;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	
	

}
 
