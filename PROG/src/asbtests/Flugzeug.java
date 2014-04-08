public class Flugzeug
{

	private double maxGewicht;

	private double leerGewicht;

	private double ladungGewicht;

	private double reiseGeschw;

	private double flugStunden;

	private double verbrauch;

	private double tankKapazitaet;

	private double kerosinVorrat;

	public Flugzeug(double maxGewicht, double leerGewicht, double ladungGewicht, double reiseGeschw, double flugStunden, double verbrauch, double tankKapazitaet, double kerosinVorrat)
	{

		this.maxGewicht = maxGewicht;
		this.leerGewicht = leerGewicht;
		this.ladungGewicht = ladungGewicht;
		this.reiseGeschw = reiseGeschw;
		this.flugStunden = flugStunden;
		this.verbrauch = verbrauch;
		this.tankKapazitaet = tankKapazitaet;

		if (kerosinVorrat > tankKapazitaet)
		{
			this.kerosinVorrat = tankKapazitaet;
		}
		else
		{
			this.kerosinVorrat = kerosinVorrat;
		}
	}

	public double getMaxGewicht()
	{
		return maxGewicht;
	}

	public double getLeerGewicht()
	{
		return leerGewicht;
	}

	public double getLadungGewicht()
	{
		return ladungGewicht;
	}

	public double getReiseGeschw()
	{
		return reiseGeschw;
	}

	public double getFlugStunden()
	{
		return flugStunden;
	}

	public double getVerbrauch()
	{
		return verbrauch;
	}

	public double getTankKapazitaet()
	{
		return tankKapazitaet;
	}

	public double getKerosinVorrat()
	{
		return kerosinVorrat;
	}

	public double getGesamtGewicht()
	{

		double gesamtGewicht = leerGewicht + ladungGewicht + kerosinVorrat * 0.8;

		return gesamtGewicht;
	}

	public double getReichweite()
	{

		double reichweite = kerosinVorrat / verbrauch * reiseGeschw;

		return reichweite;
	}

	public boolean fliegen(double km)
	{

		if (km <= 0)
		{
			return false;
		}

		if (this.getReichweite() < km || this.getGesamtGewicht() > maxGewicht)
		{
			// System.out.println("Reichweite: " + this.getReichweite());
			System.out.println("nicht geflogen");
			return false;

		}
		else
		{

			// System.out.println("Reichweite: " + this.getReichweite());
			flugStunden = flugStunden + km / reiseGeschw;

			kerosinVorrat = kerosinVorrat - verbrauch * km / reiseGeschw;
			System.out.println("geflogen");
			return true;
		}

	}

	public void tanken(double liter)
	{

		double k = kerosinVorrat;

		if (liter > 0)
		{

			while (kerosinVorrat < k + liter && kerosinVorrat < tankKapazitaet)
			{

				kerosinVorrat++;

			}
			System.out.println("getankt");
		}
		else
		{

			while (kerosinVorrat > k + liter && kerosinVorrat > 0)
			{

				kerosinVorrat--;

			}
			System.out.println("abgelassen");
		}

	}

	public boolean laden(double kg)
	{

		if (this.getGesamtGewicht() + kg > maxGewicht)
		{

			return false;

		}

		if (ladungGewicht + kg < 0)
		{

			ladungGewicht = 0;

			return true;

		}
		else
		{

			ladungGewicht = ladungGewicht + kg;

			return true;

		}

	}

	public void info()
	{

		System.out.println("Flugstundenzähler: " + flugStunden);
		System.out.println("Tankinhalt: " + kerosinVorrat);
		System.out.println("Gesamtgewicht: " + this.getGesamtGewicht());

	}

	public static void main(String[] args)
	{

		Flugzeug albatros = new Flugzeug(70000.0, 35000.0, 10000.0, 800.0, 500.0, 2500.0, 25000.0, 8000.0);

		albatros.info();
		// albatros.laden(1500);
		//
		// albatros.info();
		// albatros.fliegen(3000);
		// albatros.info();
		// albatros.tanken(10000);
		// albatros.info();

		System.out.println("Reichweite: " + albatros.getReichweite());

		albatros.fliegen(750);

		System.out.println("Reichweite: " + albatros.getReichweite());

		albatros.info();

	}
}