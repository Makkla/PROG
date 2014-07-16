package algorithm;

public class test
{

	public static void main(String[] args)
	{
		int[] array =
		{ 9, 16, 17, 5, 3, 18, 14, 4, 14, 17 };

		String stingered = new String(Sort.toString(array));
		System.out.println(stingered);

		int x = Sort.divide(array, 0, 9);

		System.out.println(x);

		// Sort.bubbleUp(array, 0, 9);

		// Sort.bubbleSort(array);
		//
		System.out.println(Sort.toString(array));

		// Sort.quickSort(array);

		// Sort.swap(array, 5, 9);

		System.out.println(Sort.toString(array));
		//
		// System.out.println(Sort.toString(array));
		// [9, 16, 17, 5, 3, 18, 14, 4, 14, 17]
		// [9, 16, 5, 3, 17, 14, 4, 14, 17, 18]
		// [9, 16, 17, 5, 3, 17, 14, 4, 14, 18]

		int i;
		int n = 6;
		int j;
		i = 0;
		// while (i <= n)
		// {
		// j = 1;
		// while (j < i)
		// {
		// System.out.print('*');
		// j++;
		// }
		// i++;
		// }
		int bla = 0;
		int k;
		for (i = 0; i < n; i++)
		{
			for (j = 0; j < 2 * n; j++)
			{
				for (k = 0; k < n / 3; k++)
				{
					System.out.println(bla);
					System.out.print('*');

					bla++;
				}
			}
		}

	}
}
