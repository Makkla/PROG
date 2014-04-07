package asbtests;

import java.util.Scanner;

public class Flugzeug {

    private double maxGewicht, leerGewicht, ladungGewicht, reiseGeschw,
    flugStunden, verbrauch, tankKapazitaet, kerosinVorrat;

    private Scanner scanner;

    private String input;

    public Flugzeug(double maxGewicht, double leerGewicht, double ladungGewicht, double reiseGeschw, double flugStunden, double verbrauch, double tankKapazitaet, double kerosinVorrat) {
        this.maxGewicht = maxGewicht;
        this.leerGewicht = leerGewicht;
        this.ladungGewicht = ladungGewicht;
        this.reiseGeschw = reiseGeschw;
        this.flugStunden = flugStunden;
        this.verbrauch = verbrauch;
        this.tankKapazitaet = tankKapazitaet;

        scanner = new Scanner(System.in);
        input = "";

        if (kerosinVorrat > tankKapazitaet) {
            this.kerosinVorrat = tankKapazitaet;
        } else {
            this.kerosinVorrat = kerosinVorrat;
        }

    }

    public double getMaxGewicht() {
        return maxGewicht;
    }

    public double getLeerGewicht() {
        return leerGewicht;
    }

    public double getLadungsGewicht() {
        return ladungGewicht;
    }

    public double getReiseGeschw() {
        return reiseGeschw;
    }

    public double getFlugStunden() {
        return flugStunden;
    }

    public double getVerbrauch() {
        return verbrauch;
    }

    public double getTankKapazitaet() {
        return tankKapazitaet;
    }

    public double getKerosinVorrat() {
        return kerosinVorrat;
    }

    public double getGesamtGewicht() {

        double gesamtGewicht = leerGewicht + ladungGewicht + kerosinVorrat * 0.8;

        return gesamtGewicht;
    }

    public double getReichweite() {

        double reichweite = 0;

        if (verbrauch != 0) {
            reichweite = kerosinVorrat * reiseGeschw / verbrauch;
        } else {
            System.out.println("Dein Flugzeug verbraucht also nix? Du hast gerade die Welt gerettet!! Glückwunsch!!");
        }

        return reichweite;

    }

    public boolean fliegen(double km) {

        if (getReichweite() < km || getGesamtGewicht() > maxGewicht) {
            return false;
        } else {
            flugStunden = km / reiseGeschw;
            kerosinVorrat = kerosinVorrat - flugStunden * verbrauch;
            return true;
        }
    }

    public void tanken(double liter) {

        if (liter > 0 && liter + kerosinVorrat <= tankKapazitaet || liter < 0 && liter + kerosinVorrat >= 0) {
            kerosinVorrat += liter;
            System.out.println("Das Flugzeug wurde mit " + liter + " betankt. (oder entleert, war zu faul das noch zu unterscheiden ;) )");
        }

    }

    public boolean laden(double kg) {

        if (kg > 0 && kg + ladungGewicht <= maxGewicht || kg < 0 && kg >= ladungGewicht) {
            ladungGewicht += kg;
            System.out.println("Das Flugzeug wurde mit " + kg + " beladen. (oder entladen, war zu faul  ;) )");
            return true;
        }

        else {
            System.out.println("Zuviel, Alter!");
            return false;

        }
    }

    public void info() {
        System.out.println("Gesamtgewicht: " + getGesamtGewicht());
        System.out.println("Tankinhalt: " + kerosinVorrat);
        System.out.println("Flugstunden: " + flugStunden);
    }

    public void menu() {
        System.out.println("l zum losfliegen");
        System.out.println("b zum beladen");
        System.out.println("t zum tanken");
        System.out.println("q zum beenden");
        System.out.println("i für info");
        System.out.println(">>");
        input = scanner.nextLine();

    }

    public static void main(String[] args) {

        Flugzeug albatros = new Flugzeug(70000, 35000, 10000, 800, 500, 2500, 25000, 8000);

        System.out.println("Albatros steht im Hangar bereit! Was willst du machen?");
        System.out.println();

        albatros.menu();
        // System.out.println("l zum losfliegen");
        // System.out.println("b zum beladen");
        // System.out.println("t zum tanken");
        // System.out.println("q zum beenden");
        // System.out.println("i für info");
        // System.out.println(">>");
        // input = albatros.scanner.nextLine();

        while (!albatros.input.equalsIgnoreCase("q")) {

            if (albatros.input.equalsIgnoreCase("t")) {
                System.out.println("Wieviel Liter möchtest du tanken? (Nur Zahlen bitte...sei nett ;)");
                System.out.println(">>");
                albatros.input = albatros.scanner.nextLine();

                if (Double.parseDouble(albatros.input) > 0 && Double.parseDouble(albatros.input) + albatros.kerosinVorrat <= albatros.tankKapazitaet || Double.parseDouble(albatros.input) < 0 && Double.parseDouble(albatros.input) + albatros.kerosinVorrat >= 0) {
                    albatros.tanken(Double.parseDouble(albatros.input));
                    System.out.println();
                    albatros.menu();
                } else {
                    System.out.println("Geht nicht! (Frag nicht!)");
                    System.out.println();
                    albatros.menu();
                }
            }

            if (albatros.input.equalsIgnoreCase("b")) {
                System.out.println("Wieviel KG willst du be-/entladen?");
                System.out.println(">>");
                albatros.input = albatros.scanner.nextLine();
                albatros.laden(Double.parseDouble(albatros.input));
                System.out.println();
                albatros.menu();
            }

            if (albatros.input.equalsIgnoreCase("i")) {
                albatros.info();
                System.out.println();

                albatros.menu();
            }

            if (albatros.input.equalsIgnoreCase("q")) {
                System.exit(0);
            }

            if (albatros.input.equalsIgnoreCase("l")) {
                System.out.println("Wie weit in Km?");
                System.out.println(">>");
                albatros.input = albatros.scanner.nextLine();

                if (albatros.fliegen(Double.parseDouble(albatros.input)) == true) {
                    System.out.println("Los geht's");
                    System.out.println();
                    albatros.menu();
                } else {
                    System.out.println("Keine Starterlaubnis erteilt!");
                }
                System.out.println();
                albatros.menu();
            }

        }

        // albatros.laden(1500);
        //
        // if(albatros.fliegen(3000)== true)
        // System.out.println("Los geht's");
        // else
        // System.out.println("Keine Starterlaubnis erteilt!");
        //
        // System.out.println();
        //
        // albatros.tanken(10000);
        //
        //
        // if(albatros.fliegen(3000)== true)
        // System.out.println("Los geht's");
        // else
        // System.out.println("Keine Starterlaubnis erteilt!");
        //
        // System.out.println();
        // albatros.info();
        //
    }

}
