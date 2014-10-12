package algorithm;

public class Sort
{
	public static void bubbleSort(int[] list)
	{
		for (int i = list.length - 1; i > 0; i--)
		{
			Sort.bubbleUp(list, 0, i);
		}
	}

	public static void bubbleSort(int[] list, int leftIdx, int rightIdx)
	{
		if (rightIdx < leftIdx || rightIdx < 0 || leftIdx < 0 || rightIdx > list.length - 1 || leftIdx > list.length - 1)
		{
			throw new IllegalArgumentException("Illegal Arguments");
		}

		for (int i = rightIdx; i > leftIdx; i--)
		{
			Sort.bubbleUp(list, leftIdx, i);
		}

	}

	public static void bubbleUp(int[] list, int leftIdx, int i)
	{
		if (i < 0 || leftIdx < 0 || i > list.length - 1 || leftIdx > list.length - 1)
		{
			throw new IllegalArgumentException("Illegal Arguments");
		}

		for (int j = leftIdx; j < i; j++)
		{
			if (list[j] > list[j + 1])
			{
				Sort.swap(list, j, j + 1);
			}
		}

	}

	public static void quickSort(int[] list)
	{

		Sort.quickSort(list, 0, list.length - 1);

	}

	public static void quickSort(int[] list, int leftIdx, int rightIdx)
	{

		if (leftIdx < rightIdx)
		{
			if (leftIdx < 0 || rightIdx < 0 || leftIdx > list.length - 1 || rightIdx > list.length - 1)
			{
				throw new IllegalArgumentException("Illegal Arguments");
			}

			int pivotIndex = Sort.divide(list, leftIdx, rightIdx);

			Sort.quickSort(list, leftIdx, pivotIndex - 1);
			Sort.quickSort(list, pivotIndex + 1, rightIdx);

		}

	}

	public static int divide(int[] list, int leftIdx, int rightIdx)
	{

		if (leftIdx < 0 || rightIdx < 0 || leftIdx > list.length - 1 || rightIdx > list.length - 1)
		{
			throw new IllegalArgumentException("Illegal Arguments");
		}

		int i = leftIdx;
		int j = rightIdx - 1;
		int pivotIndex = rightIdx;
		int pivotValue = list[rightIdx];

		for (; i < j;)
		{

			while (list[i] < pivotValue & i < rightIdx)
			{
				i++;
			}

			while (list[j] >= pivotValue & j > leftIdx)
			{
				if (j > 0)
				{

					j--;
				}
			}

			if (i < j)
			{
				swap(list, i, j);

			}

		}

		if (list[i] > pivotValue)
		{
			swap(list, i, pivotIndex);
		}

		return i;
	}

	public static void swap(int[] list, int i, int j)
	{
		if (i < 0 || j < 0 || i > list.length - 1 || j > list.length - 1)
		{
			throw new IllegalArgumentException("Illegal Arguments");
		}
		// wert zwischenspeichern
		int dummy = list[i];

		list[i] = list[j];
		list[j] = dummy;

	}

	public static String toString(int[] list, int start, int end)
	{
		if (end > start || end < 0 || start < 0 || end > list.length - 1 || start > list.length - 1)
		{
			throw new IllegalArgumentException("Illegal Arguments");
		}

		StringBuffer buffer = new StringBuffer();

		for (int i1 = start; i1 <= end; i1++)
		{
			buffer.append(list[i1]);
			buffer.append(" | ");

		}

		String output = new String(buffer);
		return output;
	}

	public static String toString(int[] list)
	{

		StringBuffer buffer = new StringBuffer();

		for (int i1 = 0; i1 < list.length; i1++)
		{
			buffer.append(list[i1]);
			buffer.append(" | ");

		}

		String output = new String(buffer);
		return output;
	}
}
