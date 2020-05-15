package model;

public class ElectricCar extends Car implements ElectricType{
	// attributes
	private int chargerType;
	private int batteryLife;
	private double batteryConsumption;
	
	// getters and setters
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
	public ElectricCar(int basePrice, String brand, int model, int cc, int mileage, boolean newOrNot, String plate, boolean sold, int type, int doors, boolean polarized, int chargerType, int batteryLife){
		super(basePrice, brand, model, cc, mileage, newOrNot, plate, sold, type, doors, polarized);
		this.chargerType = chargerType;
		this.batteryLife = batteryLife;
		this.batteryConsumption = getBatteryConsumption();
	}
	
	// methods
	/**
	This "getter" calculates battery consumption for electric cars. <br>
	*/
	public double getBatteryConsumption(){
		double batteryConsumption = 0;
		
		if(chargerType == NORMAL){
			batteryConsumption = (getBatteryLife() + 5) * (getCc() / 100.0);
		}else if(chargerType == FAST){
			batteryConsumption = (getBatteryLife() + 10) * (getCc() / 100.0);
		}
		
		return batteryConsumption;
	}
	
	@Override
	public double getSalePrice(){
		double price = getBasePrice()+(getBasePrice()*0.2);
		price = super.getSalePrice();
		return price;
	}
	
	@Override
	public String getInfo(){
		String info = "";
		
		info += super.getInfo();
		
		info += "\nBattery life: " + getBatteryLife() + " kilometers \nBattery consumption: " + getBatteryConsumption() + " watts per km";
		
		if(getChargerType() == NORMAL){
			info += "\nCharger type: Normal";
		}else if(getChargerType() == FAST){
			info += "\nCharger type: Fast";
		}
		
		return info;
	}
}