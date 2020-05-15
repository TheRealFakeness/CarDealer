package model;
import model.Car;

public class ParkingLot{
	// attributes
	Vehicle [][] oldCars = new Car[5][10];
	
	// constructor
	public ParkingLot(){}
	
	// getters and setters
	public Vehicle[][] getOldCars(){
		return oldCars;
	}
	
	public void setOldCars(Vehicle[][] oldCars){
		this.oldCars = oldCars;
	}
	
	// methods
	/**
	This method registers the car given if there's an available spot for it. It also returns a truth value that states whether the car could be added.<br>
	<b>pre:</b> The car has to have its model value initialized. <br>
	<b>post:</b> The car will be registered if possible. The value returned will tell whether the car can be registered anywhere.<br>
	@param car Is the car to be registered. <br>
	@return registered Available spot. <br>
	*/
	public boolean registerOldCar(Vehicle car){
		boolean registered = false;
		int i;
		if(car.getModel() > 2015){
			registered = false;
		}else if(car.getModel() == 2015){
			for(i=0; i<oldCars[0].length && registered == false; i++){
				if(oldCars[0][i] == null){
					registered = true;
					oldCars[0][i] = car;
				}
			}
		}else if(car.getModel() == 2014){
			for(i=0; i<oldCars[0].length && registered == false; i++){
				if(oldCars[1][i] == null){
					registered = true;
					oldCars[1][i] = car;
				}
			}
		}else if(car.getModel() == 2013){
			for(i=0; i<oldCars[0].length && registered == false; i++){
				if(oldCars[2][i] == null){
					registered = true;
					oldCars[2][i] = car;
				}
			}
		}else if(car.getModel() == 2012){
			for(i=0; i<oldCars[0].length && registered == false; i++){
				if(oldCars[3][i] == null){
					registered = true;
					oldCars[3][i] = car;
				}
			}
		}else if(car.getModel() <= 2011){
			for(i=0; i<oldCars[0].length && registered == false; i++){
				if(oldCars[4][i] == null){
					registered = true;
					oldCars[4][i] = car;
				}
			}
		}
		return registered;
	}
	
	/**
	This method removes sold vehicles from the lot.<br>
	<b>pre:</b> <br>
	<b>post:</b> Sold vehicles will be removed from the lot.<br>
	*/
	public void removeSold(){
		for(int i=0; i < oldCars.length; i++){
			for(int j = 0; j < oldCars[0].length; j++){
				if(oldCars[i][j] != null){
					if(oldCars[i][j].getSold()){
						oldCars[i][j] = new GasCar(0, "", 0, 0, 0, true, "", false, 0, 0, false, 0, 0);
					}
				}
			}
		}
	}
	
	public void displayOldCars(){
		for(int i=0; i < oldCars.length; i++){
			for(int j = 0; j < oldCars[0].length; j++){
				if(oldCars[i][j] != null){
					System.out.println("\nRow " + (i+1) + ": " + oldCars[i][j].getInfo());
				}
			}
		}
	}
}