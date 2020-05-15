package model;

public class GasCar extends Car implements GasType{
	// attributes
	private int tankCapacity;
	private int gasType;
	private double gasConsumption;
	
	// getters and setters
	public int getTankCapacity(){
		return tankCapacity;
	}
	
	public void setTankCapacity(int tankCapacity){
		this.tankCapacity = tankCapacity;
	}
	
	public int getGasType(){
		return gasType;
	}
	
	public void setGasType(int gasType){
		this.gasType = gasType;
	}
	
	// constructor
	public GasCar(int basePrice, String brand, int model, int cc, int mileage, boolean newOrNot, String plate, boolean sold, int type, int doors, boolean polarized, int tankCapacity, int gasType){
		super(basePrice, brand, model, cc, mileage, newOrNot, plate, sold, type, doors, polarized);
		this.tankCapacity = tankCapacity;
		this.gasType = gasType;
		this.gasConsumption = getGasConsumption();
	}
	
	// methods
	/**
	This "getter" calculates gas consumption for gas cars. <br>
	*/
	public double getGasConsumption(){
		return gasConsumption = getTankCapacity() * (getCc() / 100.0);
	}
	
	@Override
	public double getSalePrice(){
		double price = super.getSalePrice();
		return price;
	}
	
	@Override
	public String getInfo(){
		String info = "";
		
		info += super.getInfo();
		
		info += "\nTank capacity: " + getTankCapacity() + " gallons \nGas consumption: " + getGasConsumption() + " gallons per km";
			
		if(getGasType() == REGULAR){
			info += "\nGasoline type: Regular";
		}else if(getGasType() == EXTRA){
			info += "\nGasoline type: Extra";
		}if(getGasType() == DIESEL){
			info += "\nGasoline type: Diesel";
		}
		
		return info;
	}
}