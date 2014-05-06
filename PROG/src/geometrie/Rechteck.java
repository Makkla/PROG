package geometrie;

public class Rechteck extends Figur2D{
	
	private int breite;
	private int laenge;
	
	public Rechteck(Punkt bezug, int b, int l){
		super(bezug);
		breite = b;
		laenge = l;
	}

	public int getBreite() {
		return breite;
	}

	public void setBreite(int breite) {
		this.breite = breite;
	}

	public int getLaenge() {
		return laenge;
	}

	public void setLaenge(int laenge) {
		this.laenge = laenge;
	}

	
	public double umfang() {
		
		double u = 2*(breite+laenge);
		return u;
	}

	
	public double flaeche() {
		
		double f = breite*laenge;
		return f;
	}
	
	public double diagonalenLaenge(){
		double c = Math.sqrt((Math.pow(breite, 2) + Math.pow(laenge, 2)));
		return c;
	}
	
	public boolean flaecheKleinerAls(Figur2D f){
		
		if(this.flaeche() < f.flaeche())
			return true;
		else
			return false;
	}
	
	public boolean umfangKleinerAls(Figur2D f){
		
		if(this.umfang() < f.umfang())
			return true;
		else
			return false;
	}
	
	

}
