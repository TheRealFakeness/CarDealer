package model;

public class Motorcycle extends Vehicle{
	// constants
	public final static int STANDARD = 1;
	public final static int SPORTS = 2;
	public final static int SCOOTER = 3;
	public final static int CROSS = 4; 
	
	// attributes
	private int type;
	private int tankCapacity;
	private double gasConsumption;
	
	// constructor
	public Motorcycle(int basePrice, String brand, int model, int cc, int mileage, boolean newOrNot, String plate, boolean sold, int type, int tankCapacity){
		super(basePrice, brand, model, cc, mileage, newOrNot, plate, sold);
		this.type = type;
		this.tankCapacity = tankCapacity;
		this.gasConsumption = gasConsumption;
	}
	
	// getters and setters
	public int getType(){
		return type;
	}
	
	public void setType(int type){
		this.type = type;
	}
	
	public int getTankCapacity(){
		return tankCapacity;
	}
	
	public void setTankCapacity(int tankCapacity){
		this.tankCapacity = tankCapacity;
	}
	
	// methods
	
	public double getGasConsumption(){
		return gasConsumption = getTankCapacity() * (getCc() / 90);
	}
	
	@Override
	public double getSalePrice(){
		double price = getBasePrice() + (getBasePrice() * 0.04);
		price = super.getSalePrice();
		return price;
	}
	
	@Override
	public String getInfo(){
		String info = "";
		
		info += super.getInfo();
		
		info += "\n Type: ";
		if(getType() == STANDARD){
			info += "Standard bike";
		}else if(getType() == SPORTS){
			info += "Sports bike";
		}else if(getType() == SCOOTER){
			info += "Scooter";
		}else if(getType() == CROSS){
			info += "Cross bike";
		}
		
		info += "\n Tank capacity: " + getTankCapacity() + "\nGas consumption: " + getGasConsumption();
		
		return info;
	}
}