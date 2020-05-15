package model;
import model.Document;
import model.Company;
import java.util.ArrayList;

public abstract class Vehicle{
	// constants
	private final static int EXPIRED_PRICE = 500000;
	
	// attributes
	private int basePrice;
	private String brand;
	private int model;
	private int cc;
	private int mileage;
	private boolean newOrNot;
	private String plate;
	private boolean sold;
	private ArrayList<Document> documents = new ArrayList<Document>();
	
	// getters and setter
	public int getBasePrice(){
		return basePrice;
	}
	
	public void setBasePrice(int basePrice){
		this.basePrice = basePrice;
	}
	
	public String getBrand(){
		return brand;
	}
	
	public void setBrand(String brand){
		this.brand = brand;
	}
	
	public int getModel(){
		return model;
	}
	
	public void setModel(){
		this.model = model;
	}
	
	public int getCc(){
		return cc;
	}
	
	public void setCc(int cc){
		this.cc = cc;
	}
	
	public int getMileage(){
		return mileage;
	}
	
	public void setMileage(int mileage){
		this.mileage = mileage;
	}
	
	public boolean getNewOrNot(){
		return newOrNot;
	}
	
	public void setNewOrNot(boolean newOrNot){
		this.newOrNot = newOrNot;
	}
	
	public String getPlate(){
		return plate;
	}
	
	public void setPlate(String plate){
		this.plate = plate;
	}
	
	public boolean getSold(){
		return sold;
	}
	
	public void setSold(boolean sold){
		this.sold = sold;
	}
	
	//constructor
	
	public Vehicle(int basePrice, String brand, int model, int cc, int mileage, boolean newOrNot, String plate, boolean sold){
		this.basePrice = basePrice;
		this.brand = brand;
		this.model = model;
		this.cc = cc;
		this.mileage = mileage;
		this.newOrNot = newOrNot;
		this.plate = plate;
		this.sold = sold;
	}
	
	// methods
	
	/**
	This "getter" gets the sale price using the operations specified for vehicles. <br>
	<b>pre:</b> The vehicle has to have beeen properly initialized.<br>
	<b>post:</b> The partial (basic) sale price for the vehicle is returned. <br>
	@param basePrice The price that will be converted. <br>
	@return price The converted price. <br>
	*/
	public double getSalePrice(){
		double price = getBasePrice();
		if(getNewOrNot() == false){
			price -= price*0.1;
		}
		
		if(expiredOrNot()){
			price += EXPIRED_PRICE;
		}
		
		return price;
	}
	
	/**
	This method returns a truth value that states whether the vehicle has at least two documents registered in the current year. <br>
	<b>pre:</b> <br>
	<b>post:</b> <br>
	@return A truth value that indicates if the documents are expired.
	*/
	public boolean expiredOrNot(){
		boolean expired = true;
		int nonExpired = 0;
		for(int i=0; i<documents.size(); i++){
			if(documents.get(i).getYear() >= Company.CURRENTYEAR){
				nonExpired++;
			}
		}
		
		if(nonExpired >= 2){
			expired = false;
		}
		
		return expired;
	}
	
	/**
	This method returns the most recent document the vehicle has, depending on the type. <br>
	<b>pre:</b> There must be at least one document of the type looked for. The parameter must be 1 or 2.<br>
	<b>post:</b> The most recent document found will be returned<br>
	@param type 1 for SOAT. 2 for Technomechanical revision <br>
	*/
	public Document recentDocument(int type){
		Document mostRecent = documents.get(0);
		boolean found = false;
		if(type == 1){
			for(int i=0; i<documents.size() && found == false; i++){
				if(documents.get(i) instanceof Soat){
					mostRecent = documents.get(i);
				}
			}
			
			for(int i=0; i<documents.size(); i++){
				if(documents.get(i) instanceof Soat && documents.get(i).getYear() > mostRecent.getYear()){
					mostRecent = documents.get(i);
				}
			}
		}else if(type == 2){
			for(int i=0; i<documents.size() && found == false; i++){
				if(documents.get(i) instanceof TechMech){
					mostRecent = documents.get(i);
				}
			}
			
			for(int i=0; i<documents.size(); i++){
				if(documents.get(i) instanceof TechMech && documents.get(i).getYear() > mostRecent.getYear()){
					mostRecent = documents.get(i);
				}
			}
		}
		
		return mostRecent; 
	}
	
	/**
	This method is meant to return information specific to each type of vehicle. <br>
	<b>pre:</b> The vehicle has to have been properly initialized with its specific attributes. <br>
	<b>post:</b> The info will be returned. <br>
	*/
	public String getInfo(){
		String info = "";
		
		info += "\n \nBase Price: " + getBasePrice() + "\nSale Price: $" + getSalePrice() + "\nBrand: " + getBrand() + "\nModel: " + getModel() + "\nCC: " + getCc() + "\nMileage :" + getMileage() + "km \nNew: ";
		
		if(getNewOrNot()){
			info += "Yes";
		}else{
			info += "No";
		}
		
		info += "\nLicense plate: " + getPlate();
		
		if(getSold()){
			info += "\nSold: Yes";
		}else{
			info += "\nSold: No";
		}
		
		if(expiredOrNot()){
			info += "\nExpired documents: Yes";
		}else{
			info += "\nExpired documents: No";
		}
		
		info += "\nMost recent SOAT (" + recentDocument(1).getYear() + "): " + recentDocument(1).decode();
		
		info += "\nMost recent Technomechanical revision (" + recentDocument(2).getYear() + "): " + recentDocument(2).decode();
		
		return info;
	}
	
	public void addDocument(Document document) {
		documents.add(document);
	}
	
	/**
	This method adds randomly generated SOAT and Technomechanical revision. <br>
	<b>pre:</b> <br>
	<b>post</b> <br>
	@param year Is the year both documents will have. <br>
	@param electric Whether the vehicle is an electric car or not (To set gas emmission to 0) <br>
	*/
	public void addRandomDocuments (int year, boolean electric){
		Soat randomDocument = new Soat(year);
		documents.add(randomDocument);
		
		TechMech randomDocument2 = new TechMech(year, electric);
		documents.add(randomDocument2);
	}
}