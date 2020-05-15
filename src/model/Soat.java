package model;

public class Soat extends Document{
	// attributes
	private int coverage;
	
	// constructors
	public Soat(int price, int year, int[][] picture, int coverage){
		super(price, year, picture);
		this.coverage = coverage;
	}
	
	public Soat(int year){
		super(year);
		this.coverage = rnd.nextInt(900001) + 100000;
	}
	
	// methods
	@Override
	public String decode(){
		String code = "";
			
		for(int i=0; i<getPicture().length; i++){
		code += getPicture()[i][0];
		}
		for(int i=1; i<getPicture().length; i++){
			code += getPicture()[getPicture().length-1][i];
		}
		return code;
	}
}