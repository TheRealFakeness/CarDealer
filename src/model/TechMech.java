package model;

public class TechMech extends Document{
	// attributes
	private int gasLevel;
	
	// constructor
	public TechMech(int price, int year, int[][] picture, int gasLevel){
		super(price, year, picture);
		this.gasLevel = gasLevel;
	}
	
	public TechMech(int year, boolean electric){
		super(year);
		if(electric == false){
			this.gasLevel = rnd.nextInt(10);
		}else{
			this.gasLevel = 0;
		}
	}
	
	// methods
	@Override
	public String decode(){
		String code = "";
		for(int i=0; i<getPicture().length; i++){
		code += getPicture()[0][i];
		}
		for(int i=1; i<getPicture().length; i++){
			code += getPicture()[i][getPicture().length - 1 - i];
		}
		for(int i=0; i<getPicture().length; i++){
		code += getPicture()[getPicture().length - 1][i];
		}
		
		return code;
	}
}