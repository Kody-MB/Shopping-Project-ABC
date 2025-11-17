
public class DigitalProduct extends Product {
String Size;

public String getSize() {
	return Size;
}

public void setSize(String size) {
	Size = size;
}

public DigitalProduct() {
	
}

@Override
public String toString() {
	return super.toString() + "\nFile Size: " + Size + "\n";
}

}

