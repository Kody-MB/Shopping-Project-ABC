import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.concurrent.ThreadLocalRandom;
public class MainSection {
	


	public static void main(String[] args) throws FileNotFoundException{
		String File = "C:\\Users\\kodyd\\eclipse-workspace\\ShoppingProject\\src\\Products.txt";
		Scanner console = new Scanner(System.in);
		boolean Navigation = false;
		Scanner inFile = new Scanner(new FileReader(File));
		int on = 1;
		int Selection = 0;
		boolean login = false;
		int currentID = 0;
		String emailPattern = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(emailPattern);
		int LoginSelection = 0;
		PhysicalProduct[] Physicalitem = new PhysicalProduct [14];
		DigitalProduct[] Digitalitem = new DigitalProduct [14];
		ShoppingCart[]carts = new ShoppingCart[20];
		Customer []Customer = new Customer[20];
		
		for (int i = 0; i < Physicalitem.length; i++) {	
			String type = inFile.next();
			if("Physical".equals(type)){
			Physicalitem[i]= new PhysicalProduct();
			Physicalitem[i].setType(type);
			Physicalitem[i].setProductID(inFile.nextInt());
			Physicalitem[i].setName(inFile.next());
			Physicalitem[i].setPrice(inFile.nextDouble());
			Physicalitem[i].setQuantityAvailable(inFile.nextInt());
			Physicalitem[i].setWeight(inFile.next());
			}
			inFile.nextLine();

		}
		for (int i = 0; i < Digitalitem.length; i++) {	
			String type = inFile.next();
			if("Digital".equals(type)){
				Digitalitem[i]= new DigitalProduct();
				Digitalitem[i].setType(type);
				Digitalitem[i].setProductID(inFile.nextInt());
				Digitalitem[i].setName(inFile.next());
				Digitalitem[i].setPrice(inFile.nextDouble());
				Digitalitem[i].setSize(inFile.next());
			}
			 inFile.nextLine();
		}
			
	
		
		while(on == 1) {
			
			System.out.println("Welcome To Get Literally Anything");
			System.out.println("Press 1 to Login, Press 2 to setup a new account");
			Selection = console.nextInt();
			console.nextLine();
		while(Selection == 1) {
			try {
				boolean flag = false;
				System.out.println("enter your customer id");
				int EnteredID = console.nextInt();
				console.nextLine();
				for(int i = 0; i < Customer.length; i++) {
					if (Customer[i].getCustomerID() == EnteredID  ) {
						System.out.println("Login Successful");
						flag = true;
						login = true;
						currentID = EnteredID;
						Selection = 3;
						break;
						
					}
					else {
						
					}
					if(flag) {
					break;
					}
				}
			}
			
				catch (NullPointerException e) {
					
				}
			}
			
			
		while(Selection == 2) {
			boolean flag = false;
			System.out.println("Please input your information");
			
			for(int i = 0; i < Customer.length; i++) {
				
				if (Customer[i] == null) {
				Customer[i] = new Customer();
				 Customer[i].setCustomerID(ThreadLocalRandom.current().nextInt(1000, 9999));
	
				System.out.println("Enter your Fisrt Name Only");
				Customer[i].setName(console.nextLine()); 
				System.out.println("Enter your Email !NOTE THIS MUST INCLUDE @");
				String email = console.nextLine();
				Matcher matcher = pattern.matcher(email);
				while (!matcher.matches()) {
					System.out.println("Email is invalid try again");
					 email = console.nextLine();
					 matcher = pattern.matcher(email);
				}
				Customer[i].setEmail(email);
				System.out.println("Enter your address");
				Customer[i].setAddress(console.nextLine());
				System.out.println("Sign Up Successful! Logging in");
				System.out.println("Your new Customer ID: " + Customer[i].getCustomerID() );
				flag = true;
				currentID = Customer[i].getCustomerID();
				Selection = 3;
				break;
				}
			}
				if(flag) {
					break;
				}
		
		}
	while (Selection == 3) {
		boolean created = false;
		for(int i = 0; i < Customer.length; i++) { 
			try {
			while (Customer[i].getCustomerID() == currentID  ) {
				for(int m = 0; m < carts.length; m++) {
					if (created) {
						break;
					}
					  try {
					if (carts[m].getID() == currentID) {
						break;
						}
					  }
					  catch(NullPointerException e) {
						carts[m] = new ShoppingCart();
						carts[m].setID(currentID);
						 created = true;
					}
				}
					 
				boolean flag = false;
				LoginSelection = 0;
			
				if (Navigation) {
					LoginSelection = 3;
					Navigation = false;
				}
				else {
				System.out.println(currentID);
				System.out.println("Welcome " + Customer[i].getName());
				System.out.println("To view Digital Items press 1");
				System.out.println("To view Physical Items press 2");
				System.out.println("To add to your cart using an items ID press 3");
				System.out.println("To view your cart 4");
				System.out.println("To place and finalise your order press 5");
				System.out.println("To Logout press 6");
				
				LoginSelection = console.nextInt();
				console.nextLine();
				}
				
			
				switch (LoginSelection){
				
				
					
				case 1:
					System.out.println("Digital Items");
					for(int j = 0; j < Digitalitem.length; j++) {
						System.out.println(Digitalitem[j].toString());
					}
					break;
				case 2:
					System.out.println("Physical Items");
					for(int j = 0; j <Physicalitem.length; j++) {
					System.out.println(Physicalitem[j].toString());
				}
					break;
					
				case 3:
					flag = false;
					for(int m = 0; m < carts.length; m++) {
						if (flag) {
							
							break;
						}
						else if (!flag){
						  try {
						if (carts[m].getID() == currentID) {
								System.out.println("To add to a Physical cart press 1");
								System.out.println("To add to a Digital cart press 2");
								int cartSelection = console.nextInt();
								console.nextLine();
								if (cartSelection == 1) {
				
									System.out.println("To add a new PHYSICAL item to the cart type in the id of the of the product or type -999 to return to start screen");
									int submittedID = console.nextInt();
									console.nextLine();
									boolean itemFound = false;
									for(int k = 0; k < Physicalitem.length; k++) {
										 
										if (submittedID == -999){
												flag = true;
												break;
											}
										else if (Physicalitem[k].getProductID() == submittedID ) {
											if(Physicalitem[k].getQuantityAvailable() == 0) {
												itemFound = true;
												System.out.println("this item is out of stock");
												flag = true;
											}
											else if (Physicalitem[k].getQuantityAvailable() > 0){
											itemFound=true;
											carts[m].addProductsPhysical(Physicalitem[k], carts, k);
											System.out.println("Item added to PHYSICAL CART");
											flag = true;
											break;
										}
										}
										else  {
											
										}
									}
										if (!itemFound) {
											System.out.println("ID doesn't exist returning to start screen");
											flag = true;
										}
										
										if(flag) {
											break;
										}
									}
								
								
								else if (cartSelection == 2) {
									
									System.out.println("To add a new DIGITAL item to the cart type in the id of the of the product or type -999 to return to start screen");
									int submittedID = console.nextInt();
									console.nextLine();
									boolean itemFound = false;
									for(int k = 0; k < Digitalitem.length; k++) {
										 
										if (submittedID == -999){
												flag = true;
												break;
											}
										else if (Digitalitem[k].getProductID() == submittedID ) {
											itemFound=true;
											carts[m].addProductsDigital(Digitalitem[k], carts, k);
											System.out.println("Item added to DIGITAL CART");
											flag = true;
											break;
										}
										else  {
											
										}
									}
										if (!itemFound) {
											System.out.println("ID doesn't exist returning to start screen");
											flag = true;
										}
										
										if(flag) {
											break;
										}
									}
								
								
								
							
							 
							}
					
						  }
						  catch(NullPointerException e) {
							  
						}
					}
				
					}
				break;
				
				case 4:
					flag = false;
					for(int m = 0; m < carts.length; m++) {
						if (flag) {
							break;
						}
						else {
						  try {
						if (carts[m].getID() == currentID) {
							flag = true;
							 System.out.println("Which Cart would you like to look at");
								System.out.println("Physical Cart = 1");
								System.out.println("Digital Cart = 2");
								int choice = console.nextInt();
								console.nextLine();
								if (choice == 1) {
									System.out.println("Physical Items");
									carts[m].displayCartItems(carts, currentID, true);
									if(carts[m].calculatePhysical() == 0) {
										System.out.println("Cart is empty");
										
									}
									else {
										System.out.println("Cart value: $" + carts[m].calculatePhysical());
										System.out.println();
									}
									System.out.println("Would you like to remove a product? or add a new one? ");
									System.out.println("1 = remove");
									System.out.println("2 = add new");
									System.out.println("any other number = return to main");
									int ChoiceInChoice= console.nextInt();
									console.nextLine();
									if(ChoiceInChoice == 1) {
										System.out.println("Please enter the id You would like to remove");
										int RemoveID = console.nextInt();
										carts[m].removeProductsPhysical(carts, RemoveID);
									}
									if(ChoiceInChoice == 2) {
										LoginSelection = 3;
										Navigation = true;
									}
									else {
										
									}
									
								}
								
								else if (choice == 2) {
									System.out.println("Digital Items");
									carts[m].displayCartItems(carts, currentID, false);
									if(carts[m].calculateDigital() == 0) {
										
									}
									if(carts[m].calculatePhysical() == 0) {
										System.out.println("Cart is empty");
										
									}
									else {
										System.out.println("Cart value: $" + carts[m].calculateDigital());
										System.out.println();
									}
									System.out.println("Would you like to remove a product? or add a new one? ");
									System.out.println("1 = remove");
									System.out.println("2 = add new");
									System.out.println("any other number = return to main");
									int ChoiceInChoice= console.nextInt();
									console.nextLine();
									if(ChoiceInChoice == 1) {
										System.out.println("Please enter the id You would like to remove");
										int RemoveID = console.nextInt();
										console.nextLine();
										carts[m].removeProductsDigital(carts, RemoveID);
									}
									if(ChoiceInChoice == 2) {
										LoginSelection = 3;
										Navigation = true;
									}
									else {
										
									}
										
													}
							}
						  }
						  catch(NullPointerException e) {
							  
						}
					}
					}
					
					
					break;

				case 5:
					flag = false;
					for(int m = 0; m < carts.length; m++) {
						if (flag) {
							break;
						}
						else {
						  try {
						if (carts[m].getID() == currentID) {
								flag = true;
								System.out.println("Would you like to place and finalise the order for the Physical cart or the Digital cart");
								System.out.println("Physical = 1 ");
								System.out.println("Digital = 2");
								int orderSelection = console.nextInt();
								console.nextLine();
								
								if(orderSelection == 1) {
									
									carts[m].setOrderPHYSICALID(ThreadLocalRandom.current().nextInt(1000, 9999));
									carts[m].setPHYorder(carts[m].getPHYcart());
									carts[m].OrderPhysical(carts[m]);
				
								}
								else if (orderSelection == 2) {
									carts[m].setOrderDIGITALID(ThreadLocalRandom.current().nextInt(1000, 9999));
									carts[m].setDIGorder(carts[m].getDIGcart());
									carts[m].OrderDigital(carts[m]);
						
								}
							}
						  }
						  catch(NullPointerException e) {
				
						}
					}
					}
					break;
				
				case 6:
					currentID = 0;
					LoginSelection = 0;
					Selection = 0;
					break;
					
			
		}
			
			}
		}
			catch(NullPointerException e) {
				
			}
		
	}
	}


	
	}
}

}

