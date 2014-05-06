package geometrie;

public class Zylinder extends Figur3D
{

	private int hoehe;

	public Zylinder(Kreis k, int hoehe)
	{
		super(k);
		this.setHoehe(hoehe);
	}

	public int getHoehe()
	{
		return hoehe;
	}

	public void setHoehe(int hoehe)
	{
		if (hoehe >= 1)
		{
			this.hoehe = hoehe;
		}
		else
		{
			this.hoehe = 1;
			System.out.println("Höhe wurde auf 1 gesetzt. Darf nicht negativ oder 0 sein.");
		}
	}

	public double volumen()
	{
		double v = super.getBoden().flaeche() * hoehe;
		return v;
	}

	public double oberflaeche()
	{
		double a = 2 * Math.PI * ((Kreis) super.getBoden()).getRadius() * (((Kreis) super.getBoden()).getRadius() + hoehe);
		return a;
	}

}
