package ui;

import model.Company;
import java.util.Scanner;

public class Menu{
	Scanner sc = new Scanner(System.in);
	Company company = new Company("Green Dolphin Street Dealership", "48329", 21934, 50);
	public void menu(){
		System.out.println("\nMenu: \n1. Register a vehicle \n2. Register a dealer \n3. Register a client \n4. Register interest for client \n5. Display dealers \n6. Display all clients \n7. Display a client's interests \n8. Sell a vehicle \n9. Show vehicle catalog \n10. Display parking lot \n11. Show dealership's info \n0. Exit");
		int menu = 0;
		do{
			menu = sc.nextInt();
		}while(menu < 0 || menu > 11);
		
		switch(menu){
			case 1:
			company.registerVehicle();
			menu();
			break;
			
			case 2:
			company.registerSalesman();
			menu();
			break;
			
			case 3:
			company.registerClient();
			menu();
			break;
			
			case 4:
			company.registerInterest();
			menu();
			break;
			
			case 5:
			company.displaySalesmen();
			menu();
			break;
			
			case 6:
			company.displayAllClients();
			menu();
			break;
			
			case 7:
			company.displayInterest();
			menu();
			break;
			
			case 8:
			company.sellVehicle();
			menu();
			break;
			
			case 9:
			System.out.println("\n1. Display all vehicles. \n2. Display only new vehicles. \n3. Display only used vehicles.");
			int newOld = 0;
			do{
			newOld = sc.nextInt();
			}while(newOld < 1 || newOld > 3);
			company.catalog(newOld);
			menu();
			break;
			
			case 10:
			company.getParkingLot().displayOldCars();
			menu();
			break;
			
			case 11:
			company.companyInfo();
			menu();
			break;
			
			default:
			break;
		}
	}
}