package praktikum;

public class NumberToString
{

	// letzte Ziffer einer Zahl auslesen

	public static int letzteZiffer(int x)
	{

		return x % 10;

	}

	public static String intToString(int x)
	{

		String s = "Test";

		while (x > 0)
		{

			s += (char) x % 10;

			x = x / 10;

		}
		return s;

	}

	public static int charToInt(String s)
	{

		int i = 0;
		char c;
		int ziffer = 0;
		int zahl = 0;

		while (i < s.length())
		{

			c = s.charAt(i);

			ziffer = c - '0';

			zahl = zahl * 10 + ziffer;

			i++;
		}
		return zahl;

	}

	public static void main(String[] args)
	{

		String x = "1465";

		// System.out.println(letzteZiffer(x));

		// System.out.println(intToString(x));

		System.out.println(charToInt(x));

	}

}
