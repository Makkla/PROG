package aufgabe;

import geometrie.Kreis;
import geometrie.Punkt;
import geometrie.Quader;
import geometrie.Rechteck;
import geometrie.Zylinder;

public class AufgabePool
{
	private Quader q; // r

	private Zylinder z1; // k1

	private Zylinder z2; // k2

	private Zylinder z3; // k3

	public AufgabePool()
	{

		q = new Quader(new Rechteck(new Punkt(74, 390), 316, 875), 2);

		z1 = new Zylinder(new Kreis(new Punkt(949 - 316 / 2, 390), 316 / 2), 2);

		z2 = new Zylinder(new Kreis(new Punkt(0, 390), 296 / 4), 2);

		z3 = new Zylinder(new Kreis(new Punkt(0, 74 + (316 - 20) / 2), 296 / 4), 2);

	}

	public double poolVolumen()
	{

		double poolVolumen = q.volumen() + z1.volumen() / 2 + z2.volumen() / 2 + z3.volumen() / 2;
		return poolVolumen;
	}

	public double poolUmfang()
	{
		double poolUmfang = q.getBoden().umfang() + z1.getBoden().umfang() / 2 + z2.getBoden().umfang() / 2 + z3.getBoden().umfang() / 2 - ((Kreis) z2.getBoden()).getRadius() * 4 - ((Kreis) z1.getBoden()).getRadius() * 2;
		return poolUmfang;
	}

	public double poolInnererMantel()
	{

		double poolInnererMantel = poolWasserOberflaeche() + poolUmfang() * 2;
		return poolInnererMantel;

	}

	public double poolWasserOberflaeche()
	{
		double poolWasserOberflaeche = q.getBoden().flaeche() + z1.getBoden().flaeche() / 2 + z2.getBoden().flaeche() / 2 + z3.getBoden().flaeche() / 2;
		return poolWasserOberflaeche;
	}

	public double kostenZaun(double preisProStueck)
	{
		double ganzZahlZaunstuecke = Math.ceil(this.poolUmfang() / 5);

		double kostenZaun = ganzZahlZaunstuecke * preisProStueck;
		return kostenZaun;
	}

	public Quader getQ()
	{
		return q;
	}

	public Zylinder getZ1()
	{
		return z1;
	}

	public Zylinder getZ2()
	{
		return z2;
	}

	public Zylinder getZ3()
	{
		return z3;
	}
}