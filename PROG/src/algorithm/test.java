package algorithm;

public class test
{

	public static void main(String[] args)
	{
		int[] array =
		{ 1, 4, 5, 3, 8, 2, };

		String stingered = new String(Sort.toString(array));

		System.out.println(stingered);

		Sort.bubbleSort(array);

		System.out.println(Sort.toString(array));

	}
}
