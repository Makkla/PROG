package pp.ampel;

public class AmpelSteuerung extends Thread
{

    private int anzahlAmpeln;

    private static Ampel[] ampeln;

    public AmpelSteuerung(int anzahlAmpeln)
    {

        this.anzahlAmpeln = anzahlAmpeln;

        ampeln = new Ampel[anzahlAmpeln];

        for (int i = 0; i < anzahlAmpeln; i++)
        {

            ampeln[i] = new Ampel();

        }

    }

    public void run()
    {

        while (true)
        {

            for (int i = 0; i < anzahlAmpeln; i++)
            {

                int x = (Math.random() < 0.5) ? 0 : 1;
                // System.out.println("random x=" +x);

                if (x == 0)
                {

                    ampeln[i].schalteRot();
                    System.out.println("Ampel #" + i + " auf rot gesetzt.");
                    try
                    {
                        sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
                else
                {
                    ampeln[i].schalteGruen();
                    System.out.println("Ampel #" + i + " auf gruen gesetzt.");
                    try
                    {
                        sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    public static void main(String[] args)
    {

        int anzahlAmpeln = 10;
        AmpelSteuerung ampelSteuerung = new AmpelSteuerung(anzahlAmpeln);

        ampelSteuerung.start();

        System.out.println("Autos erzeugen");
        Auto a1 = new Auto(ampeln);
        Auto a2 = new Auto(ampeln);
        Auto a3 = new Auto(ampeln);

        a1.start();
        a2.start();
        a3.start();
    }

}
