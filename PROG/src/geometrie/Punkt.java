package geometrie;

public class Punkt
{

	private int xKoordinate;

	private int yKoordinate;

	public Punkt(int xKoordinate, int yKoordinate)
	{
		this.xKoordinate = xKoordinate;
		this.yKoordinate = yKoordinate;
	}

	public Punkt(Punkt p2)
	{
		xKoordinate = p2.xKoordinate;
		yKoordinate = p2.yKoordinate;

	}

	public int getXKoordinate()
	{
		return xKoordinate;
	}

	public void setXKoordinate(int xKoordinate)
	{
		this.xKoordinate = xKoordinate;
	}

	public int getYKoordinate()
	{
		return yKoordinate;
	}

	public void setYKoordinate(int yKoordinate)
	{
		this.yKoordinate = yKoordinate;
	}

	public double abstand(Punkt p)
	{
		double abstand = Math.sqrt(Math.pow(xKoordinate - p.xKoordinate, 2) + Math.pow((yKoordinate - p.yKoordinate), 2));
		return abstand;
	}

	public void verschieben(int deltaX, int deltaY)
	{
		xKoordinate += deltaX;
		yKoordinate += deltaY;

	}

	public boolean equals(Punkt p)
	{

		return xKoordinate == p.xKoordinate && yKoordinate == p.yKoordinate;

	}

}
