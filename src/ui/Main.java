package ui;
import model.*;
import ui.Menu;

public class Main{
	public static void main(String[] args) {
		Menu menu = new Menu();
		
		GasCar g1 = new GasCar(250000, "Maserati", 2017, 250, 80, false, "KJD-203", false, 2, 6, true, 2600, 2);
		
		ElectricCar e1 = new ElectricCar(986250, "Tesla", 2013, 450, 27000, true, "DAN-087", true, 1, 2, false, 1, 2700);
		
		menu.company.addVehicle(g1);
		menu.company.getVehicles().get(0).addRandomDocuments(2011, false);
		menu.company.addVehicle(e1);
		menu.company.getVehicles().get(1).addRandomDocuments(2020, true);
		
		Salesman s1 = new Salesman("Bruno", "Buccellati", "12389", 13);
		Salesman s2 = new Salesman("Pannacotta", "Fugo", "49421", 6);
		menu.company.addSalesman(s1);
		menu.company.addSalesman(s2);
		
		Client c1 = new Client("Robert", "Speedwagon", "83914", "320-2000-4923", "reo@spwfoundation.com");
		Client c2 = new Client("Gyro", "Zeppeli", "39213", "394-1293-1300", "mozarellarella@steelballrun.com");
		Client c3 = new Client("Dire", "Straits", "49523", "305-5032-2093", "tcsa@hamail.com");
		menu.company.getSalesmen()[0].addClient(c1);
		menu.company.getSalesmen()[1].addClient(c2);
		menu.company.getSalesmen()[0].addClient(c3);
	
		System.out.println("Welcome to " + menu.company.getName());
		menu.menu();
	}
}