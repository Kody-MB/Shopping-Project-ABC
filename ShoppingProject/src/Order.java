public class Order  {
private int OrderPHYSICALID;
private int OrderDIGITALID;
private Customer cust;
private PhysicalProduct[]PHYorder = new PhysicalProduct[100];
private DigitalProduct[]DIGorder = new DigitalProduct[100];


public Order() {
	
}

public Order(int OrderPHYSICALID, int OrderDIGITALID, Customer cust ) {
	this.OrderPHYSICALID = OrderPHYSICALID;
	this.OrderDIGITALID = OrderDIGITALID;
	this.cust = cust;
	
}


public void OrderPhysical(ShoppingCart cart ){
	if (cart.calculatePhysical() == 0) {
		System.out.println("Cart is empty");
	}
	else {
	System.out.println("Order Processed");
	System.out.println("This is the Physical Order ID !REMEMBER THIS ID!: " +  cart.getOrderPHYSICALID());
	System.out.println("Total: $" + cart.calculatePhysical());
	cart.clearPhysical();
	}
}

public void OrderDigital(ShoppingCart cart){
	if (cart.calculateDigital() == 0) {
		System.out.println("Cart is empty");
	}
	else {
		System.out.println("Order Processed");
		System.out.println("This is the Digital Order ID !REMEMBER THIS ID!: " +  cart.getOrderDIGITALID());
		System.out.println("Total: $" + cart.calculateDigital());
		cart.clearDigital();
	}
	
}

@Override
public String toString() {
    StringBuilder sb = new StringBuilder("ShoppingCart: ");
    for (PhysicalProduct product : PHYorder) {
        if (product != null) {
            sb.append(product.toString()).append("\n");
        }
    }
        sb.append("Digital Items:\n");
        for (DigitalProduct product : DIGorder) {
            if (product != null) {
                sb.append(product.toString()).append("\n");
            }
        }
    return sb.toString();




}



public Customer getCust() {
	return cust;
}

public void setCust(Customer cust) {
	this.cust = cust;
}

public int getOrderPHYSICALID() {
	return OrderPHYSICALID;
}

public void setOrderPHYSICALID(int orderPHYSICALID) {
	OrderPHYSICALID = orderPHYSICALID;
}

public int getOrderDIGITALID() {
	return OrderDIGITALID;
}

public void setOrderDIGITALID(int orderDIGITALID) {
	OrderDIGITALID = orderDIGITALID;
}

public PhysicalProduct[] getPHYorder() {
	return PHYorder;
}

public void setPHYorder(PhysicalProduct[] pHYorder) {
	PHYorder = pHYorder;
}

public DigitalProduct[] getDIGorder() {
	return DIGorder;
}

public void setDIGorder(DigitalProduct[] dIGorder) {
	DIGorder = dIGorder;
}



}
