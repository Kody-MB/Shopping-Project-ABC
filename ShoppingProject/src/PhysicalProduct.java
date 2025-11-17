
public class PhysicalProduct extends Product {
private String weight;
private int quantityAvailable;




public int getQuantityAvailable() {
	return quantityAvailable;
}

public void setQuantityAvailable(int quantityAvailable) {
	this.quantityAvailable = quantityAvailable;
}

public String getWeight() {
	return weight;
}

public void setWeight(String weight) {
	this.weight = weight;
}

public PhysicalProduct() {
	
}

public String toString() {
	return super.toString() +"\nQuantitiy Available: " + quantityAvailable + "\nweight: " + weight + "\n";
}

public void UpdateQuantity(int quantityAvailable) {
	this.quantityAvailable = quantityAvailable - 1;
}


}
