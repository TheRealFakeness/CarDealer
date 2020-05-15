package model;
import model.Client;
import java.util.Scanner;

public class Salesman extends Person{
	//attributes
	private Client[] clients = new Client[5];
	private int sales;
	Scanner sc = new Scanner(System.in);
	
	// getters and setters
	public Client[] getClients(){
		return clients;
	}
	
	public void setClients(Client[] clients){
		this.clients = clients;
	}
	
	public int getSales(){
		return sales;
	}
	
	public void setSales(int sales){
		this.sales = sales;
	}
	
	//constructors
	public Salesman(String firstName, String lastName, String id, int sales){
		super(firstName, lastName, id);
		this.sales = sales;
	}
	
	public Salesman(String firstName, String lastName, String id, int sales, Client[] clients){
		super(firstName, lastName, id);
		this.sales = sales;
		this.clients = clients;
	}
	
	//methods
	
	/**
	This method adds a client to the salesman based on the user's input. <br>
	<b>pre:</b> The salesman has yo have been initialized. <br>
	<b>post:</b> The client will be added to the salesman's list. If there are no spaces available, the user will be informed and the option to enter the client's info will not be given. <br>
	*/
	public void registerClient(){
		boolean free = false;
		int i;
		for(i=0; i<clients.length && free == false; i++){
			if(clients[i] == null){
				free = true;
			}
		}
		
		if(free){
			System.out.println("\nEnter client's first name:");
			String firstName = sc.next();
			
			System.out.println("\nEnter client's last name:");
			String lastName = sc.next();
			
			System.out.println("\nEnter client's ID:");
			String id = sc.next();
			
			System.out.println("\nEnter client's phone number:");
			String phoneNumber = sc.next();
			
			System.out.println("\nEnter client's email:");
			String email = sc.next();
			
			clients[i - 1] = new Client(firstName, lastName, id, phoneNumber, email);
		}else{
			System.out.println("\nThis dealer already can't take any more clients.");
		}
	}
	
	/**
	This method displays the information of all the clients the salesman has. <br>
	<b>pre:</b>
	<b>post:</b> The clients' information will be displayed on screen. <br>
	*/
	public void displayClients(){
		for(int i=0; i < clients.length; i++){
			if(clients[i] != null){
				System.out.println("\nClient #" + (i+1) + ": \nName: " + clients[i].getFirstName() + " " + clients[i].getLastName() + "\nID: " + clients[i].getId() + "\nPhone Number: " + clients[i].getPhoneNumber() + "\nE-mail: " + clients[i].getEmail());
				
				if(clients[i].ownsVehicle()){
					System.out.println("Owns a vehicle: Yes");
				}else{
					System.out.println("Owns a vehicle: No");
				}
			}
		}
	}
	
	public void addClient(Client client){
		boolean free = false;
		int i;
		for(i=0; i<clients.length && free == false; i++){
			if(clients[i] == null){
				free = true;
			}
		}
		
		if(free){
			clients[i-1] = client;
		}else{
			System.out.println("This dealear can't take any more clients.");
		}
	}
	
	public void displayClientsNames(){
		for(int i=0; i < clients.length; i++){
			if(clients[i] != null){
				System.out.println((i + 1)+". " + clients[i].getFirstName() + " " +clients[i].getLastName());
			}
		}
	}
	
	public int numberOfClients(){
		int numberOfClients = 0;
		for(int i=0; i < clients.length; i++){
			if(clients[i] != null){
				numberOfClients++;
			}
		}
		
		return numberOfClients;
	}
}