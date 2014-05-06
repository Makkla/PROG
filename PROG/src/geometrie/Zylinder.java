package geometrie;

public class Zylinder extends Figur3D{

	private int hoehe;
	
	public Zylinder(Kreis k, int hoehe){
		super(k);
		this.hoehe = hoehe;
		}

	public int getHoehe() {
		return hoehe;
	}

	public void setHoehe(int hoehe) {
		this.hoehe = hoehe;
	}

	
	public double volumen() {
		double v = super.getBoden().flaeche() * hoehe;
		return v;
	}

	
	public double oberflaeche() {
		double a = 2 * Math.PI * ((Kreis) super.getBoden()).getRadius() * (((Kreis) super.getBoden()).getRadius() + hoehe);
		return a;
	}
	
	
}
