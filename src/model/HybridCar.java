package model;

public class HybridCar extends Car implements GasType, ElectricType{
	// attributes
	private int tankCapacity;
	private int gasType;
	private double gasConsumption;
	private int chargerType;
	private int batteryLife;
	private double batteryConsumption;
	
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
	
	public int getChargerType(){
		return chargerType;
	}
	
	public void setChargerType(int chargerType){
		this.chargerType = chargerType;
	}
	
	public int getBatteryLife(){
		return batteryLife;
	}
	
	public void setBatteryLife(int batteryLife){
		this.batteryLife = batteryLife;
	}
	
	// constructor
	public HybridCar(int basePrice, String brand, int model, int cc, int mileage, boolean newOrNot, String plate, boolean sold, int type, int doors, boolean polarized, int tankCapacity, int gasType, int chargerType, int batteryLife){
		super(basePrice, brand, model, cc, mileage, newOrNot, plate, sold, type, doors, polarized);
		this.tankCapacity = tankCapacity;
		this.gasType = gasType;
		this.gasConsumption = getGasConsumption();
		this.chargerType = chargerType;
		this.batteryLife = batteryLife;
		this.batteryConsumption = getBatteryConsumption();
	}
	
	// methods
	/**
	This "getter" calculates battery consumption for hybrid cars. <br>
	<b>pre:</b> chargerType, batteryLife and cc have to have been initialized.
	<b>post:</b> 
	*/
	public double getBatteryConsumption(){
		double batteryConsumption = 0;
		
		if(chargerType == NORMAL){
			batteryConsumption = (getBatteryLife() + 5) * (getCc() / 100.0);
		}else if(chargerType == FAST){
			batteryConsumption = getBatteryLife() * (getCc() / 100.0);
		}
		
		return batteryConsumption;
	}
	
	/**
	This "getter" calculates gas consumption for hybrid cars. <br>
	*/
	public double getGasConsumption(){
		return gasConsumption = getTankCapacity() * (getCc() / 110.0);
	}
	
	@Override
	public double getSalePrice(){
		double price = getBasePrice() + (getBasePrice() * 0.15);
		price = super.getSalePrice();
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
		
		info += "\n Battery life: " + getBatteryLife() + " kilometers \nBattery consumption: " + getBatteryConsumption() + "watts per km";
			
		if(getChargerType() == NORMAL){
			info += "\nCharger type: Normal";
		}else if(getChargerType() == FAST){
			info += "\nCharger type: Fast";
		}
		
		return info;
	}
}