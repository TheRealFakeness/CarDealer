package model;
import model.Vehicle;
import java.util.ArrayList;
import java.util.Scanner;

public class Client extends Person{
	// attributes
	private String phoneNumber;
	private String email;
	private ArrayList<Vehicle> interest = new ArrayList<Vehicle>();
	private Vehicle ownedVehicle;
	Scanner sc = new Scanner(System.in);
	
	// getters and setters
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public Vehicle getOwnedVehicle(){
		return ownedVehicle;
	}
	
	public void setOwnedVehicle(Vehicle ownedVehicle){
		this.ownedVehicle = ownedVehicle;
	}
	
	// constructors
	public Client(String firstName, String lastName, String id, String phoneNumber, String email){
		super(firstName, lastName, id);
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
		
	public Client(String firstName, String lastName, String id, String phoneNumber, String email, Vehicle ownedVehicle){
		super(firstName, lastName, id);
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.ownedVehicle = ownedVehicle;
	}
	
	// methods
	
	public void addInterest(Vehicle vehicle){
		interest.add(vehicle);
	}
	
	public void addOwnedVehicle(Vehicle vehicle){
		this.ownedVehicle = vehicle;
	}
	
	public boolean ownsVehicle(){
		if(getOwnedVehicle() == null){
			return false;
		}else{
			return true;
		}
	}
	
	public void displayInterest(){
		for(int i=0; i < interest.size(); i++){
			if(interest.get(i).getSold() == false){
				System.out.println(interest.get(i).getInfo());
			}else{
				System.out.println("\nA vehicle this client was interested in has been sold: " + interest.get(i).getBrand() + "Model " + interest.get(i).getModel());
			}
		}
		
		if(interest.size() == 0){
			System.out.println("\nNo interest yet");
		}
	}
}