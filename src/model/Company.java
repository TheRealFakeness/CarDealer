package model;
import model.Salesman;
import model.ParkingLot;
import model.Vehicle;
import java.util.Scanner;
import java.util.ArrayList;

public class Company{
	// constants
	public final static int CURRENTYEAR = 2020;
	
	// attributes
	private Salesman[] salesmen = new Salesman[10];
	private ParkingLot parkingLot = new ParkingLot();
	private String name;
	private String id;
	private double totalEarnings;
	private int sales;
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	Scanner sc = new Scanner(System.in);
	
	// constructor
	public Company(String name, String id, double totalEarnings, int sales){
		this.name = name;
		this.id = id;
		this.totalEarnings = totalEarnings;
		this.sales = sales;
	}
	
	// getters and setters
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public double getTotalEarnings(){
		return totalEarnings;
	}
	
	public void setTotalEarnings(double totalEarnings){
		this.totalEarnings = totalEarnings;
	}
	
	public int getSales(){
		return sales;
	}
	
	public void setSales(int sales){
		this.sales = sales;
	}
	
	public Salesman[] getSalesmen(){
		return salesmen;
	}
	
	public void setSalesmen(Salesman[] salesmen){
		this.salesmen = salesmen;
	}
	
	public ArrayList<Vehicle> getVehicles(){
		return vehicles;
	}
	
	public void setVehicles(ArrayList<Vehicle> vehicles){
		this.vehicles = vehicles;
	}
	
	public ParkingLot getParkingLot(){
		return parkingLot;
	}
	
	public void setParkingLot(ParkingLot parkingLot){
		this.parkingLot = parkingLot;
	}
	
	// methods
	
	/**
	This method displays the information of all salesmen. <br>
	<b>pre:</b>
	<b>post:</b> The salesmen's information will be displayed on screen. <br>
	*/
	public void registerSalesman(){
		boolean free = false;
		int i;
		for(i=0; i<salesmen.length && free == false; i++){
			if(salesmen[i] == null){
				free = true;
			}
		}
		
		if(free){
			System.out.println("\nEnter dealer's first name:");
			String firstName = sc.next();
			
			System.out.println("\nEnter dealer's last name:");
			String lastName = sc.next();
			
			System.out.println("\nEnter dealer's ID:");
			String id = sc.next();
			
			System.out.println("\nEnter dealer's phone number:");
			int sales = sc.nextInt();
			
			salesmen[i - 1] = new Salesman(firstName, lastName, id, sales);
			
			setSales(getSales() + sales);
		}else{
			System.out.println("\nThere's no more space for dealers.");
		}
	}
	
	/**
	This method displays the information of all the salesmen. <br>
	<b>pre:</b>
	<b>post:</b> The salesmen's information will be displayed on screen. <br>
	*/
	public void displaySalesmen(){
		for(int i=0; i < salesmen.length; i++){
			if(salesmen[i] != null){
				System.out.println("\nDealer #" + (i+1) + "\nName: " + salesmen[i].getFirstName() + " " + salesmen[i].getLastName() + "\nID: " + salesmen[i].getId() + "\nTotal sales: " + salesmen[i].getSales() + "\nClients:");
				
				if(salesmen[i].numberOfClients() != 0){
					for(int j=0; j < salesmen[i].getClients().length; j++){
						if(salesmen[i].getClients()[j] != null){
							System.out.println((j+1) + ". " + salesmen[i].getClients()[j].getFirstName() + " " + salesmen[i].getClients()[j].getLastName());
						}
					}
				}else{
					System.out.println("(No clients)");
				}
			}
		}
	}
	
	/**
	This method displays the information of all the clients of every salesman. <br>
	<b>pre:</b>
	<b>post:</b> The clients' information will be displayed on screen. <br>
	*/
	public void displayAllClients(){
		for(int i=0; i < salesmen.length; i++){
			if(salesmen[i] != null){
				System.out.println("\nDealer: " + salesmen[i].getFirstName() + " " + salesmen[i].getLastName());
				salesmen[i].displayClients();
				
				boolean noClients = false;
				int empty = 0;
				for(int j=0; j<salesmen[i].getClients().length; j++){
					if(salesmen[i].getClients()[j] == null){
						empty++;
					}	
				}
				if(empty == 5){
					System.out.println("(No clients)");
				}
			}
		}
	}
	
	/**
	This method offers the user a series of viewing options for all the vehicles in the dealership. The numbers can be used to access specific vehicles through user input. <br>
	<b>pre:</b> <br>
	<b>post:</b> The vehicles will be displayed alongside their position in the ArrayList +1 <br>
	@param showSold This value states whether already sold vehicles will be shown. <br>
	*/
	public void catalog(int newOld){
		int menu = 0;
		
		System.out.println("What type of vehicle do you want to consult? \n1. Cars \n2. Motorcycles \n3. Gasoline cars \n4. Electic cars \n5. Hybrid cars \n6. All vehicles");
		while(menu < 1 || menu > 6){
			menu = sc.nextInt();
		}
		
		switch(menu){
			case 1:
				if(newOld == 1){
					for(int i=0; i<vehicles.size(); i++){
						if(vehicles.get(i) instanceof Car){
							System.out.println(displayVehicle(i));
						}
					}
				}else if(newOld == 2){
					for(int i=0; i<vehicles.size(); i++){
						if(vehicles.get(i) instanceof Car && vehicles.get(i).getNewOrNot()){
							System.out.println(displayVehicle(i));
						}
					}
				}else if(newOld == 3){
					for(int i=0; i<vehicles.size(); i++){
						if(vehicles.get(i) instanceof Car && vehicles.get(i).getNewOrNot() == false){
							System.out.println(displayVehicle(i));
						}
					}
				}
			break;
			
			case 2:
				if(newOld == 1){
					for(int i=0; i<vehicles.size(); i++){
						if(vehicles.get(i) instanceof Motorcycle){
							System.out.println(displayVehicle(i));
						}
					}
				}else if(newOld == 2){
					for(int i=0; i<vehicles.size(); i++){
						if(vehicles.get(i) instanceof Motorcycle && vehicles.get(i).getNewOrNot()){
							System.out.println(displayVehicle(i));
						}
					}
				}else if(newOld == 3){
					for(int i=0; i<vehicles.size(); i++){
						if(vehicles.get(i) instanceof Motorcycle && vehicles.get(i).getNewOrNot() == false){
							System.out.println(displayVehicle(i));
						}
					}
				}
			break;
			
			case 3:
				if(newOld == 1){
					for(int i=0; i<vehicles.size(); i++){
						if(vehicles.get(i) instanceof GasCar){
							System.out.println(displayVehicle(i));
						}
					}
				}else if(newOld == 2){
					for(int i=0; i<vehicles.size(); i++){
						if(vehicles.get(i) instanceof GasCar && vehicles.get(i).getNewOrNot()){
							System.out.println(displayVehicle(i));
						}
					}
				}else if(newOld == 3){
					for(int i=0; i<vehicles.size(); i++){
						if(vehicles.get(i) instanceof GasCar && vehicles.get(i).getNewOrNot() == false){
							System.out.println(displayVehicle(i));
						}
					}
				}
			break;
			
			case 4:
				if(newOld == 1){
					for(int i=0; i<vehicles.size(); i++){
						if(vehicles.get(i) instanceof ElectricCar){
							System.out.println(displayVehicle(i));
						}
					}
				}else if(newOld == 2){
					for(int i=0; i<vehicles.size(); i++){
						if(vehicles.get(i) instanceof ElectricCar && vehicles.get(i).getNewOrNot()){
							System.out.println(displayVehicle(i));
						}
					}
				}else if(newOld == 3){
					for(int i=0; i<vehicles.size(); i++){
						if(vehicles.get(i) instanceof ElectricCar && vehicles.get(i).getNewOrNot() == false){
							System.out.println(displayVehicle(i));
						}
					}
				}
			break;
			
			case 5:
				if(newOld == 1){
					for(int i=0; i<vehicles.size(); i++){
						if(vehicles.get(i) instanceof HybridCar){
							System.out.println(displayVehicle(i));
						}
					}
				}else if(newOld == 2){
					for(int i=0; i<vehicles.size(); i++){
						if(vehicles.get(i) instanceof HybridCar && vehicles.get(i).getNewOrNot()){
							System.out.println(displayVehicle(i));
						}
					}
				}else if(newOld == 3){
					for(int i=0; i<vehicles.size(); i++){
						if(vehicles.get(i) instanceof HybridCar && vehicles.get(i).getNewOrNot() == false){
							System.out.println(displayVehicle(i));
						}
					}
				}
			break;
			
			case 6:
				if(newOld == 1){
					for(int i=0; i<vehicles.size(); i++){
							System.out.println(displayVehicle(i));
					}
				}else if(newOld == 2){
					for(int i=0; i<vehicles.size(); i++){
						if(vehicles.get(i).getNewOrNot()){
							System.out.println(displayVehicle(i));
						}
					}
				}else if(newOld == 3){
					for(int i=0; i<vehicles.size(); i++){
						if(vehicles.get(i).getNewOrNot() == false){
							System.out.println(displayVehicle(i));
						}
					}
				}
			break;
		}
	}
	
	/**
	This method shows all the information of the vehicle in the given index.<br>
	<b>pre:</b> There must be a vehicle in the index given.<br>
	<b>post:</b> The info on the vehicle will be shown depending on its type.<br>
	*/
	public String displayVehicle(int pos){
		String info = "";
		int type = 0;
		info += "\nVehicle #" + (pos+1);
		
		if(vehicles.get(pos) instanceof GasCar){
			System.out.println("Gasoline car.");
		}else if(vehicles.get(pos) instanceof ElectricCar){
			System.out.println("Electric car.");
		}else if(vehicles.get(pos) instanceof HybridCar){
			System.out.println("Hybrid car.");
		}else if(vehicles.get(pos) instanceof Motorcycle){
			System.out.println("Motorcycle.");
		}
		
		info += vehicles.get(pos).getInfo();
		
		return info;
	}
	
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	
	/**
	This method lets the user add a vehicle interest for an specified client. Sold vehicles can't be registered as interests.<br>
	<b>pre:</b> There must be at least one salesman, client and vehicle. <br>
	<b>post:</b> The interest will be added to the selected client if possible. <br>
	*/
	public void registerInterest(){
		displaySalesmenNames();
		int menu = 0;
		System.out.println("\n Select dealer:");
		int salesman = 0;
		do{
			salesman = sc.nextInt() - 1;
		}while(salesman < 0 || salesman > (numberOfSalesmen() - 1));
		
		if(salesmen[salesman].numberOfClients() != 0){
			getSalesmen()[salesman].displayClientsNames();
			System.out.println("\n Select client");
			int client = 0;
			do{
				client = sc.nextInt() - 1;
			}while(client < 0 || client > salesmen[salesman].numberOfClients() - 1);
			
			System.out.println("\nConsult catalog now? \n1. Yes \n2. No");
			while(menu < 1 || menu > 2){
				menu = sc.nextInt();
			}
			if(menu == 1){
				catalog(1);
			}
			
			menu = 0;
			System.out.println("Select vehicle");
			do{
				menu = sc.nextInt() - 1;
			}while(menu < 0 || menu > (vehicles.size() - 1));
			
			if(vehicles.get(menu).getSold()){
				System.out.println("ERROR: This vehicle has already been sold.");
			}else{
				getSalesmen()[salesman].getClients()[client].addInterest(vehicles.get(menu));
				System.out.println("Interest added successfully.");
			}
		}else{
			System.out.println("This dealer has no clients.");
		}
	}
	
	/**
	This method allows the user to sell a vehicle. This will add the vehicle to the client's ownedVehicle, increase the number of sales of the salesman and company by one and add the vehicle's sale price to the company's total sold value. <br>
	<b>pre:</b> There must be at least one salesman, client and vehicle. <br>
	<b>post:</b> <br>
	*/
	public void sellVehicle(){
		displaySalesmenNames();
		int menu = 0;
		System.out.println("\n Select dealer:");
		int salesman = 0;
		do{
			salesman = sc.nextInt() - 1;
		}while(salesman < 0 || salesman > (numberOfSalesmen() - 1));
		
		if(salesmen[salesman].numberOfClients() != 0){
			getSalesmen()[salesman].displayClientsNames();
			System.out.println("\n Select client");
			int client = 0;
			do{
				client = sc.nextInt() - 1;
			}while(client < 0 || client > salesmen[salesman].numberOfClients() - 1);
			
			if(getSalesmen()[salesman].getClients()[client].ownsVehicle() == false){
				System.out.println("Consult catalog now? \n1. Yes \n2. No");
				while(menu < 1 || menu > 2){
					menu = sc.nextInt();
				}
				if(menu == 1){
					catalog(1);
				}
				
				menu = 0;
				System.out.println("\nSelect vehicle");
				do{
					menu = sc.nextInt() - 1;
				}while(menu < 0 || menu > (vehicles.size() - 1));
				
				if(vehicles.get(menu).getSold()){
					System.out.println("\n1ERROR: This vehicle has already been sold.");
				}else{
					getSalesmen()[salesman].getClients()[client].addOwnedVehicle(vehicles.get(menu));
					vehicles.get(menu).setSold(true);
					getSalesmen()[salesman].setSales((getSalesmen()[salesman].getSales()) + 1);
					setSales(getSales() + 1);
					setTotalEarnings((getSalesmen()[salesman].getClients()[client].getOwnedVehicle().getSalePrice()) + getTotalEarnings());
					
					System.out.println("The vehicle has been sold successfully.");
				}
			}else{
				System.out.println("\nERROR: This client already owns a vehicle.");
			}
			
			parkingLot.removeSold();
		}else{
			System.out.println("\nThis salesman has no clients.");
		}
	}
	
	/**
	This method adds the given salesman to the salesmen array. It will print ouy a message if the salesman can't be added. <br>
	<b>pre:</b> <br>
	<b>post:</b> The salesman will be added to the arary if possible <br>
	@param salesman The salesman. <br>
	*/
	public void addSalesman(Salesman salesman){
		boolean free = false;
		int i;
		for(i=0; i<salesmen.length && free == false; i++){
			if(salesmen[i] == null){
				free = true;
			}
		}
		
		if(free){
			salesmen[i-1] = salesman;
		}else{
			System.out.println("There's no more space for dealers.");
		}
	}
	
	/**
	This method allows the user to register a new vehicle. The vehicle will be added to the parking lot if it meets the conditions. <br>
	<b>pre:</b> <br>
	<b>post:</b> The vehicle will be added to the ArrayList vehicles and the parking lot if possible.<br>
	*/
	public void registerVehicle(){
		int menu = 0;
		int menu2 = 0;
		
		int basePrice = 0;
		String brand;
		int model = 0;
		int cc = 0;
		int mileage = 0;
		boolean newOrNot;
		String plate;
		boolean sold;
		int type = 0;
		int doors = 0;
		boolean polarized = false;
		int tankCapacity = 0;
		int gasType = 0;
		int chargerType = 0;
		int batteryLife = 0;
		
		System.out.println("\nWhat type of vehicle is going to be registered? \n1. Gas car \n2. Electric car \n3. Hybrid car \n4. Motorcycle");
		while(menu < 1 || menu > 4){
			menu = sc.nextInt();
		}
		
		System.out.println("\nEnter base price:");
		basePrice = sc.nextInt();
		
		System.out.println("\nEnter brand:");
		brand = sc.next();
		
		System.out.println("\nEnter model (year):");
		while(model > CURRENTYEAR || model < 1){
			model = sc.nextInt();
		}
		System.out.println("\nEnter engine displacement (in CC):");
		cc = sc.nextInt();
		
		System.out.println("\nEnter kilometrage:");
		mileage = sc.nextInt();
		
		newOrNot = false;
		
		if(mileage == 0){
			newOrNot = true;
		}
		
		System.out.println("\nEnter license plate:");
		plate = sc.next();
		
		System.out.println("\nIs it sold?: \n1. Yes \n2. No");
		while(menu2 < 1 || menu2 > 2){
			menu2 = sc.nextInt();
		}
		sold = false;
		
		if(menu2 == 1){
			sold = true;
		}
		
		if(menu == 1 || menu == 2 || menu == 3){
			System.out.println("\nEnter car type \n1. Sedan \n2. Pickup truck");
			while(menu2 < 1 || menu2 > 2){
			menu2 = sc.nextInt();
			}
			
			if(menu2 == 1){
				type = 1;
			}else{
				type = 2;
			}
			
			System.out.println("\nEnter number of doors:");
			doors = sc.nextInt();
			
			System.out.println("\nAre the windows polarized? \n1. Yes \n2. No");
			polarized = false;
			menu2 = 0;
			
			while(menu2 < 1 || menu2 > 2){
			menu2 = sc.nextInt();
			}
			
			if(menu2 == 1){
				polarized = true;
			}
			
			if(menu == 2 || menu == 3){
				System.out.println("\nEnter charger type: \n1. Normal \n2. Fast");
				chargerType = 0;
				while(chargerType < 1 || chargerType > 2){
				chargerType = sc.nextInt();
				}
				
				System.out.println("\nEnter battery life (in kilometers):");
				batteryLife = sc.nextInt();
			}
			
			if(menu == 1 || menu == 3){
				System.out.println("\nEnter gas type: \n1. Regular \n2. Extra \n3. Diesel");
				gasType = sc.nextInt();
			}
		}
		
		if(menu == 1 || menu == 3 || menu == 4){
			System.out.println("\nEnter tank capacity (in gallons)");
			tankCapacity = sc.nextInt();
		}
		
		if(menu == 4){
			System.out.println("\nEnter motorcycle type: \n1. Standard bike \n2. Sports bike \n3. Scooter bike \n4. Cross bike");
			type = sc.nextInt();
		}
		
		switch(menu){
			case 1:
			GasCar gasCar = new GasCar(basePrice, brand, model, cc, mileage, newOrNot, plate, sold, type, doors, polarized, tankCapacity, gasType);
			
			addVehicle(gasCar);
			break;
			
			case 2:
			ElectricCar electricCar = new ElectricCar(basePrice, brand, model, cc, mileage, newOrNot, plate, sold, type, doors, polarized, chargerType, batteryLife);
			
			addVehicle(electricCar);
			break;
			
			case 3:
			HybridCar hybridCar = new HybridCar(basePrice, brand, model, cc, mileage, newOrNot, plate, sold, type, doors, polarized, tankCapacity, gasType, chargerType, batteryLife);
			
			addVehicle(hybridCar);
			break;
			
			case 4:
			Motorcycle motorcycle = new Motorcycle(basePrice, brand, model, cc, mileage, newOrNot, plate, sold, type, tankCapacity);
			
			addVehicle(motorcycle);
			break;
		}
		
		System.out.println("\nEnter year of latest pair of documents (can't be later than current year or prior to model):");
		int soat = 0;
		while(soat > CURRENTYEAR || soat < model){
			soat = sc.nextInt();
		}
		
		boolean electric = false;
		if(menu == 2){
			electric = true;
		}
		
		if(soat != model){
			for(int i=0; i<(soat - model); i++){
				vehicles.get(vehicles.size() - 1).addRandomDocuments((model + i), electric);
			}
		}else{
			vehicles.get(vehicles.size() - 1).addRandomDocuments(model, electric);
		}
		
		if(model <= 2015 && sold == false && vehicles.get(vehicles.size() - 1) instanceof Car && newOrNot == false){
			if(parkingLot.registerOldCar(vehicles.get(vehicles.size() - 1))){
				System.out.println("\nThis car was added to the parking lot.");
			}else{
				System.out.println("\nThere's no room on the parking lot for this car.");
			}
		}
	}
	
	/**
	This method allows the user to consult the interests of a client. <br>
	<b>pre:</b> <br>
	<b>post:</b> The interests will be shown. <br>
	*/
	public void displayInterest(){
		displaySalesmenNames();
		System.out.println("\n Select dealer:");
		int salesman = 0;
		do{
			salesman = sc.nextInt() - 1;
		}while(salesman < 0 || salesman > (numberOfSalesmen() - 1));
		
		if(salesmen[salesman].numberOfClients() != 0){
			getSalesmen()[salesman].displayClientsNames();
			System.out.println("\n Select client");
			int client = 0;
			do{
				client = sc.nextInt() - 1;
			}while(client < 0 || client > salesmen[salesman].numberOfClients() - 1);
		
		salesmen[salesman].getClients()[client].displayInterest();
		}else{
			System.out.println("This dealer has no clients.");
		}
	}
	
	/**
	This method shows the salesmen's names and their numbers. <br>
	<b>pre:</b>
	<b>post:</b> Info shown. <br>
	*/
	public void displaySalesmenNames(){
		for(int i=0; i < salesmen.length; i++){
			if(salesmen[i] != null){
				System.out.println((i + 1)+". " + salesmen[i].getFirstName() + " " +salesmen[i].getLastName());
			}
		}
	}
	
	/**
	Display company's info.
	<b>pre:</b> Company properly initialized. <br>
	<b>post:</b> <br>
	*/
	public void companyInfo(){
		System.out.println("\nName: " + name + "\nNIT: " + id + "\nTotal earnings: " + totalEarnings + "\nTotal sales: " + sales);
	}
	
	/**
	Allows the user to register a new client. <br>
	<b>pre:</b> <br>
	<b>post:</b> <br>
	*/
	public void registerClient(){
		displaySalesmenNames();
		System.out.println("\nSelect dealer:");
		int salesman = 0;
		do{
			salesman = sc.nextInt() - 1;
		}while(salesman < 0 || salesman > (numberOfSalesmen()) - 1);
		
		salesmen[salesman].registerClient();
	}
	
	/**
	Returns the number of salesmen currently initialized. <br>
	<b>pre:</b> <br>
	<b>post:</b> <br>
	@return numberOfSalesmen Number of salesmen. <br>
	*/
	public int numberOfSalesmen(){
		int numberOfSalesmen = 0;
		for(int i=0; i < salesmen.length; i++){
			if(salesmen[i] != null){
				numberOfSalesmen++;
			}
		}
		
		return numberOfSalesmen;
	}
	
	/**
	Lets the user see the clients of a salesman. <br>
	<b>pre:</b> There must be at least one salesman. <br>
	<b>post:</b> <br>
	*/
	public void displaySalesmanClients(){
		displaySalesmenNames();
		System.out.println("Select dealer:");
		int salesman = 0;
		while(salesman < 1 || salesman > (numberOfSalesmen()) - 1){
			salesman = sc.nextInt() - 1;
		}
		
		salesmen[salesman].displayClients();
	}
}