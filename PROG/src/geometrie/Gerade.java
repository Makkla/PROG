package geometrie;

public class Gerade
{

	private Punkt endPos;

	private Punkt startPos;

	public Gerade(Punkt start, Punkt ende)
	{
		endPos = ende;
		startPos = start;
	}

	public Punkt getEndPos()
	{
		return endPos;

	}

	public Punkt getStartPos()
	{
		return startPos;
	}

	public void setEndPos(Punkt endPos)
	{
		this.endPos = endPos;
	}

	public void setStartPos(Punkt startPos)
	{
		this.startPos = startPos;
	}

	public double laenge()
	{
		double l = startPos.abstand(endPos);
		return l;
	}

	public boolean istLaengerAls(Gerade g2)
	{

		return this.laenge() > g2.laenge();
	}

	public boolean equals(Gerade g2)
	{

		return startPos.equals(g2.startPos) && endPos.equals(g2.endPos);
	}

}
