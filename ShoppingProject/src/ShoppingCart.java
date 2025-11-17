
public class ShoppingCart extends Order {
	private PhysicalProduct[]PHYcart = new PhysicalProduct[100];
	private DigitalProduct[]DIGcart = new DigitalProduct[100];
	private int ID;	

public ShoppingCart() {
	
}

public ShoppingCart(int ID){
		this.ID = ID;
}

public int getID() {
	return ID;
}

public void setID(int iD) {
	ID = iD;
}

public void clearDigital() {
	for(int i = 0; i < DIGcart.length; i++) {
		DIGcart[i] = null;
	}
}

public void clearPhysical() {
	for(int i = 0; i < PHYcart.length; i++) {
		PHYcart[i].UpdateQuantity(PHYcart[i].getQuantityAvailable());
		PHYcart[i] = null;
	}
}

public void addProductsDigital(DigitalProduct Digitalitem, ShoppingCart [] cart, int k) {
	boolean itemAdded = false;
	boolean fullCart = true;
	for (int i = 0; i < DIGcart.length; i++){
		if (itemAdded) {
			break;
			
		}
		else if(DIGcart[i] == null ) {
			DIGcart[i] = Digitalitem;
			itemAdded = true;
			fullCart = false;
		}
	
}
	if (fullCart) {
		System.out.println("Digital cart is full");
	}
}

public void addProductsPhysical(PhysicalProduct physicalitem, ShoppingCart[] carts, int k) {
	boolean itemAdded = false;
	boolean fullCart = true;
	for (int i = 0; i < PHYcart.length; i++){
		if (itemAdded) {
			break;
			
		}
		else if(PHYcart[i] == null ) {
			PHYcart[i] = physicalitem;
			itemAdded = true;
			fullCart = false;
		}
	}
	if (fullCart) {
		System.out.println("Digital cart is full");
	}
}


public void removeProductsDigital(ShoppingCart[] cart, int ID) {
	boolean removed = false;
	for(int k = 0; k < DIGcart.length; k++) {
		try {
			if (DIGcart[k].getProductID() == ID) {
				DIGcart[k] = null;
				removed = true;
			}
		}
	catch (NullPointerException e) {
		
		}
	
	}
	if (removed) {
		System.out.println("item removed");
	}
	else if(!removed) {
		System.out.println("ID doesn't exist returning back to home");
	}
	
}

public void removeProductsPhysical(ShoppingCart[] cart, int ID) {
	boolean removed = false;
	for(int k = 0; k < PHYcart.length; k++) {
		try {
			if (PHYcart[k].getProductID() == ID) {
				PHYcart[k] = null;
				removed = true;
			}
		}
	catch (NullPointerException e) {
		
		}
	
	}
	if (removed) {
		System.out.println("item removed");
	}
	else if(!removed) {
		System.out.println("ID doesn't exist returning back to home");
	}
}

public double calculateDigital() {
	double calculate = 0;
	
	for(int k = 0; k < DIGcart.length; k++) {
		try {
			calculate = DIGcart[k].getPrice() + calculate;
		}
	catch (NullPointerException e) {
		
		}
	
	}
	return calculate;
	}
	
	
	


public  double calculatePhysical() {
	double calculate = 0;
	
	for(int k = 0; k < PHYcart.length; k++) {
		try {
	calculate = PHYcart[k].getPrice() + calculate;
		}
	catch (NullPointerException e) {
		
		}
	
	}
	return calculate;
}

public void displayCartItems(ShoppingCart[] carts, int currentID, boolean isPhysical) {
    for (ShoppingCart cart : carts) {
        try {
            if (cart.getID() == currentID) {
                if (isPhysical) {
                    for (PhysicalProduct item : cart.PHYcart) {
                        if (item != null) {
                            System.out.println(item.toString());
                        }
                    }
                } else {
                    for (DigitalProduct item : cart.DIGcart) {
                        if (item != null) {
                            System.out.println(item.toString());
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            
        }
    }
}

@Override
public String toString() {
    StringBuilder sb = new StringBuilder("ShoppingCart: ");
    for (PhysicalProduct product : PHYcart) {
        if (product != null) {
            sb.append(product.toString()).append("\n");
        }
    }
        sb.append("Digital Items:\n");
        for (DigitalProduct product : DIGcart) {
            if (product != null) {
                sb.append(product.toString()).append("\n");
            }
        }
    return sb.toString();




}

public PhysicalProduct[] getPHYcart() {
	return PHYcart;
}

public void setPHYcart(PhysicalProduct[] pHYcart) {
	PHYcart = pHYcart;
}

public DigitalProduct[] getDIGcart() {
	return DIGcart;
}

public void setDIGcart(DigitalProduct[] dIGcart) {
	DIGcart = dIGcart;
}
}
