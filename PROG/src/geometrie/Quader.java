package geometrie;

public class Quader extends Figur3D{

	private int hoehe;
	
	public Quader (Rechteck r, int hoehe){
		super(r);
		this.hoehe = hoehe;
	}

	public int getHoehe() {
		return hoehe;
	}

	public void setHoehe(int hoehe) {
		this.hoehe = hoehe;
	}
	
	public double laengeRaumdiagonale(){
		
	
		double d = Math.sqrt(Math.pow(((Rechteck) super.getBoden()).diagonalenLaenge(), 2) + Math.pow(hoehe, 2));
		
		return d;
	}
	
	public static boolean istWuerfel(Object o){

		Quader r = new Quader(null, 0);
		
		if(o.getClass().equals(r.getClass())){
			Quader c = (Quader) o;	
			if(c.hoehe == ((Rechteck) c.getBoden()).getBreite() && c.hoehe == ((Rechteck) c.getBoden()).getLaenge())
					return true;
			else
					return false;
		}
		else
			return false;
	}
	
	public boolean equals(Figur3D f){
		
		Quader r = new Quader(null, 0);
		
		if(f.getClass().equals(r.getClass())){
		
		if(((Rechteck) super.getBoden()).getBreite() == ((Rechteck) ((Quader) f).getBoden()).getBreite() && hoehe == ((Quader) f).hoehe && ((Rechteck) super.getBoden()).getLaenge() == ((Rechteck) ((Quader) f).getBoden()).getLaenge())
			return true;
		else
			return false;
	}
		else
			return false;
	}
	
	public double volumen() {
		double v = this.getBoden().flaeche()*hoehe;
		return v;
	}

	
	public double oberflaeche() {
		
		double o = this.getBoden().flaeche()*2 + hoehe * ((Rechteck) super.getBoden()).getBreite() * 2 + ((Rechteck) super.getBoden()).getLaenge() * hoehe * 2; 
		
		return o;
	}
}
