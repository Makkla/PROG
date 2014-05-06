package geometrie;

public abstract class Figur2D
{

	private Punkt bezug;

	public Figur2D(Punkt bezug)
	{
		this.bezug = bezug;
	}

	public Figur2D(int bezugX, int bezugY)
	{
		this.bezug.setXKoordinate(bezugX);
		this.bezug.setYKoordinate(bezugY);
	}

	public Punkt getBezug()
	{
		return bezug;
	}

	public void setBezug(Punkt punkt)
	{
		this.bezug = punkt;
	}

	public abstract double umfang();

	public abstract double flaeche();

}