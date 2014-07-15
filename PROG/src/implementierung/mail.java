package implementierung;

import schnittstellen.IList;
import schnittstellen.IValueElement;

public class mail
{

	public static void main(String[] args)
	{
		IList list = new List();
		IValueElement data00 = new ValueElement("K0", 0);
		IValueElement data01 = new ValueElement("K1", 10);
		IValueElement data02 = new ValueElement("K2", 20);
		IValueElement data03 = new ValueElement("K3", 30);

		list.insertAtTheEnd(data00);
		list.insertAtTheEnd(data01);
		list.insertAtTheEnd(data02);
		list.insertAtTheEnd(data03);

		// System.out.println(list.getElementAt(3));

		System.out.println(list);

		// list.deleteAllOf(data02);
		list.reverse();
		System.out.println(list);

	}

}
