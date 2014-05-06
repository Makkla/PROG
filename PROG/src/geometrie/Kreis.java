package geometrie;

public class Kreis extends Figur2D{

	
	private static final int DEFAULT_RADIUS = 5;
	private int radius;
	
	public Kreis (Punkt bezug, int radius){
		super(bezug);
		this.radius = radius;
		
		
	}
	
	public Kreis(Punkt bezug){
		 this(bezug, DEFAULT_RADIUS);
		
		
	}
	
	public double umfang(){
		double u = 2*radius*Math.PI;
		return u;
	}
	
	public double flaeche(){
		
		double f = Math.PI * Math.pow(radius, 2);
		return f;
	}
	
	public int getRadius(){
		
		return radius;
	}
	
	public void setRadius(int radius){
		this.radius=radius;
	}
}
