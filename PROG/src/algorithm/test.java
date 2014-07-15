package algorithm;

public class test
{

	public static void main(String[] args)
	{
		int[] array =
		{ 10, 9, 8, 7, 6, 0, 4, 3, 2, 1, 5 };

		String stingered = new String(Sort.toString(array));
		System.out.println(stingered);

		Sort.divide(array, 0, 9);

		//

		//
		// Sort.bubbleSort(array, 1, 12);
		//
		System.out.println(Sort.toString(array));

		// Sort.swap(array, 5, 9);
		//
		// System.out.println(Sort.toString(array));

	}
}
