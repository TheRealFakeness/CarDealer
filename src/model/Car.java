package model;

public abstract class Car extends Vehicle{
	// constants
	public final static int SEDAN = 1;
	public final static int TRUCK = 2;

	// attributes
	private int type;
	private int doors;
	private boolean polarized;
	
	// getters and setters
	public int getType(){
		return type;
	}
	
	public void setType(int type){
		this.type = type;
	}
	
	public int getDoors(){
		return doors;
	}
	
	public void setDoors(int doors){
		this.doors = doors;
	}
	
	public boolean getPolarized(){
		return polarized;
	}
	
	public void setPolarized(boolean polarized){
		this.polarized = polarized;
	}
	
	// constructor
	public Car(int basePrice, String brand, int model, int cc, int mileage, boolean newOrNot, String plate, boolean sold, int type, int doors, boolean polarized){
		super(basePrice, brand, model, cc, mileage, newOrNot, plate, sold);
		this.type = type;
		this.doors = doors;
		this.polarized = polarized;
	}
	
	// methods
	
	@Override
	public String getInfo(){
		String info = "";
		
		info += super.getInfo();
		
		if(getType() == SEDAN){
			info += "\nType: Sedan";
		}else if(getType() == TRUCK){
			info += "\nType: Pickup truck";
		}
		
		info += "\nNumber of Doors: " + getDoors();
		
		if(getPolarized()){
			info += "\nPolarized windows: Yes";
		}else {
			info += "\nPolarized windows: No";
		}
		
		return info;
	}
}