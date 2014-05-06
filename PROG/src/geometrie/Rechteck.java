package geometrie;

public class Rechteck extends Figur2D
{

	private int breite;

	private int laenge;

	public Rechteck(Punkt bezug, int b, int l)
	{
		super(bezug);
		this.setBreite(b);
		this.setLaenge(l);
	}

	public int getBreite()
	{
		return breite;
	}

	public void setBreite(int breite)
	{
		if (breite >= 1)
		{
			this.breite = breite;
		}
		else
		{
			this.breite = 1;
			System.out.println("Breite wurde auf 1 gesetzt. Darf nicht negativ oder 0 sein.");
		}
	}

	public int getLaenge()
	{
		return laenge;
	}

	public void setLaenge(int laenge)
	{
		if (laenge >= 1)
		{
			this.laenge = laenge;
		}
		else
		{
			this.laenge = 1;
			System.out.println("Länge wurde auf 1 gesetzt. Darf nicht negativ oder 0 sein.");
		}
	}

	public double umfang()
	{

		double u = 2 * (breite + laenge);
		return u;
	}

	public double flaeche()
	{

		double f = breite * laenge;
		return f;
	}

	public double diagonalenLaenge()
	{
		double c = Math.sqrt((Math.pow(breite, 2) + Math.pow(laenge, 2)));
		return c;
	}

	public boolean flaecheKleinerAls(Figur2D f)
	{

		return this.flaeche() < f.flaeche();
	}

	public boolean umfangKleinerAls(Figur2D f)
	{

		return this.umfang() < f.umfang();
	}

}
