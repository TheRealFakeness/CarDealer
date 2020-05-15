package model;
import java.util.Random;

public abstract class Document{

	// attributes
	private int price;
	private int year;
	private int[][] picture;
	Random rnd = new Random();
	
	// getters and setters
	public int getPrice(){
		return price;
	}
	
	public void setPrice(int price){
		this.price = price;
	}
	
	public int getYear(){
		return year;
	}
	
	public void setYear(int year){
		this.year = year;
	}
	
	public int[][] getPicture(){
		return picture;
	}
	
	public void setPicture(int[][] picture){
		this.picture = picture;
	}
	
	// constructors
	public Document(int price, int year, int[][] picture){
		this.price = price;
		this.year = year;
		this.picture = picture;
	}
	
	/**
	This constructor creates a random document. (Except for the year) <br>
	*/
	public Document(int year){
		this.price = rnd.nextInt(80001) + 20000;
		this.year = year;
		int[][] randomPicture = new int[6][6];
		
		for(int i=0; i<randomPicture.length; i++){
			for(int j=0; j<randomPicture.length; j++){
				randomPicture[i][j] = rnd.nextInt(10);
			}
		}
		
		this.picture = randomPicture;
	}
	
	// methods
	
	/**
	This method decodes a document's image using a different matrix traversal depending on the document's type. <br>
	<b>pre:<b> The matrix has to be square.<br>
	<b>post:<b> The decodified code will be returned. <br>
	*/
	public abstract String decode();
}