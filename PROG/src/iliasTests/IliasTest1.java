package iliasTests;

public class IliasTest1
{

	public static void main(String[] args)
	{
		int pos;
		int i = 11;
		int k = 42;
		int m = 7;
		pos = ((k % m) + i * i) % m;
		System.out.println(pos);
	}

}
