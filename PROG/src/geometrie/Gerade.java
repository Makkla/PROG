package geometrie;

public class Gerade {
	
	private Punkt endPos;
	private Punkt startPos;
	
	
	public Gerade(Punkt start, Punkt ende){
		endPos = ende;
		startPos = start;
	}
	
	public Punkt getEndPos(){
		return endPos;
	}
	
	public Punkt getStartPos(){
		return startPos;
	}
	
	public void setEndPos(Punkt endPos){
		this.endPos=endPos;
	}
	
	public void setStartPos(Punkt startPos){
		this.startPos = startPos;
	}
	
	public double laenge(){
		double l = startPos.abstand(endPos);
		return l;
	}
	
	public boolean istLaengerAls(Gerade g2){
		
		if (this.laenge() > g2.laenge())
			return true;
		else
			return false;
	}
	
	public boolean equals(Gerade g2){
		
		if (startPos.equals(g2.startPos) && endPos.equals(g2.endPos))
			return true;
		else
			return false;
	}

}
