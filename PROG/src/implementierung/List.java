package implementierung;

import schnittstellen.IList;
import schnittstellen.IListElement;
import schnittstellen.IValueElement;

public class List implements IList
{

	private IListElement head;

	public List()
	{
		this.head = new ListElement(new ValueElement("head", 0));
	}

	@Override
	public IListElement getHead()
	{

		return this.head;
	}

	@Override
	public void insertAtTheEnd(IValueElement value)
	{
		if (value != null)
		{
			// neues Element mit den einzugfuegenden Werten erzeugen
			ListElement newListElement = new ListElement(value);

			// bei einer neuen Liste gibt es keinen predecessor
			if (this.head.getPredecessor() == null)
			{

				this.head.setPredecessor(newListElement);
				this.head.setSuccessor(newListElement);
			}
			else
			{
				/*
				 * es gibt schon mind. ein Element zusaetzlich zu head, daher
				 * kann man den Predecessor von head als letztes Element
				 * annehmen
				 */

				// das neue Element als Successor des ehemals letzten elements
				// setzen
				this.head.getPredecessor().setSuccessor(newListElement);

				// den predecessor von head auf das neue Element setzen
				this.head.setPredecessor(newListElement);
			}
		}
	}

	@Override
	public void insertAtPos(int pos, IValueElement value)
	{
		if (value != null)
		{

			// Neues ListElement mit den uebergebenene Werten erzeugen
			IListElement x = new ListElement(value);
			// Zaehlvariable fuer Pos

			int i = 1;
			if (pos <= 1)
			{
				// das einzufuegende Element einknuepfen
				x.setSuccessor(head.getSuccessor());
				x.setPredecessor(head);

				// den nachfolger von head auf x setzen
				this.head.setSuccessor(x);
				// den vorgaenger vom nachfolger von x setzen
				x.getSuccessor().setPredecessor(x);
			}
			if (pos > this.getLastListElementPos())
			{
				// neues Element einsortieren
				x.setSuccessor(null);
				x.setPredecessor(this.getListElementAt(getLastListElementPos()));
				// head voraenger auf neues letztes Element setzen
				this.head.setPredecessor(x);

				// Nachfolger des ehemals letzten Elements setzen

				this.getListElementAt(getLastListElementPos()).setSuccessor(x);
			}
			else
			{

				// Element an position einfuegen
				x.setPredecessor(this.getListElementAt(pos - 1));
				x.setSuccessor(this.getListElementAt(pos));

				// vorgaenger des alten elemets an der Position neu setzen
				this.getListElementAt(pos).setPredecessor(x);

				// NAchfolger des vorgaengers neu setzen
				this.getListElementAt(pos - 1).setSuccessor(x);

			}

			{

			}
		}

	}

	@Override
	public IValueElement getElementAt(int position)
	{
		IListElement x = this.getListElementAt(position);
		return x.getValueElement();

	}

	// Eigene Methode um das Listenelemtents an pos zu bekommen.
	public IListElement getListElementAt(int position)
	{

		if (position < 0)
		{
			return null;
		}
		if (position > this.getLastListElementPos())
		{
			return null;
		}
		// Zaehlvariable fuer Position
		int i = 0;
		// ValueElement an Pos
		IListElement x = this.head;
		while (i < position)
		{

			x = x.getSuccessor();
			i++;

			// if (x.getSuccessor() == null)
			// {
			// return null;
			// }

		}
		return x;
	}

	// Eigene Methode um die Position des letzten Listenelemtents zu bekommen.
	public int getLastListElementPos()
	{

		// Zaehlvariable fuer Position
		int i = 0;
		// ValueElement an Pos
		IListElement x = this.head;

		while (x.getSuccessor() != null)
		{
			x = x.getSuccessor();
			i++;
		}
		return i;
	}

	@Override
	public int getFirstPosOf(IValueElement value)
	{
		int i = 0;

		while (this.getListElementAt(i).getValueElement() != value)
		{
			// System.out.println(this.getListElementAt(i).getValueElement());
			if (this.getListElementAt(i).getSuccessor() == null)
			{
				return -1;
			}
			i++;
		}
		return i;
	}

	@Override
	public void deleteFirstOf(IValueElement value)
	{
		int x = this.getFirstPosOf(value);

		// den vorgaenger des Nachfolgers neu setzen
		this.getListElementAt(x + 1).setPredecessor(this.getListElementAt(x - 1));

		// und den nachfolger des vorgaengers neu setzen
		this.getListElementAt(x - 1).setSuccessor(this.getListElementAt(x + 1));

	}

	@Override
	public void deleteAllOf(IValueElement value)
	{
		int x = -2;
		while (x != -1)
		{

			x = this.getFirstPosOf(value);
			if (x == -1)
			{
				break;
			}

			IListElement zwischenspeicher = this.getListElementAt(x);

			if (zwischenspeicher.getSuccessor() == null)
			{
				this.getListElementAt(x - 1).setSuccessor(null);
			}
			else
			{
				// den vorgaenger des Nachfolgers neu setzen
				this.getListElementAt(x + 1).setPredecessor(this.getListElementAt(x - 1));

				// und den nachfolger des vorgaengers neu setzen
				this.getListElementAt(x - 1).setSuccessor(this.getListElementAt(x + 1));
			}

		}

	}

	@Override
	public boolean member(IValueElement value)
	{
		return this.getFirstPosOf(value) != -1;

	}

	@Override
	public void reverse()
	{

		IListElement zwischenspeicher = this.head;

		while (zwischenspeicher.getSuccessor() != null)
		{

			IListElement neuesList = new ListElement(zwischenspeicher.getValueElement());
			neuesList.setPredecessor(zwischenspeicher.getPredecessor());
			neuesList.setSuccessor(zwischenspeicher.getSuccessor());

			System.out.println("Zwichenspeucher Value: " + zwischenspeicher.getValueElement());
			System.out.println("Zwichenspeucher: " + zwischenspeicher);
			System.out.println("Zwichenspeucher.predecessor: " + zwischenspeicher.getPredecessor());
			System.out.println("Zwichenspeucher.successor: " + zwischenspeicher.getSuccessor());
			System.out.println();
			IListElement zwischenspeicher2 = zwischenspeicher;
			// System.out.println("Zwichenspeucher2: " + zwischenspeicher2);

			zwischenspeicher.setPredecessor(neuesList.getSuccessor());
			zwischenspeicher.setSuccessor(neuesList.getPredecessor());

			System.out.println("Zwichenspeucher Value: " + zwischenspeicher.getValueElement());
			System.out.println("Reverse Zwichenspeucher: " + zwischenspeicher);
			System.out.println("Reverse Zwichenspeucher.predecessor: " + zwischenspeicher.getPredecessor());
			System.out.println("Reverse Zwichenspeucher.successor: " + zwischenspeicher.getSuccessor());
			System.out.println();

			zwischenspeicher = new ListElement(neuesList.getSuccessor().getValueElement());
			zwischenspeicher.setPredecessor(neuesList.getSuccessor().getPredecessor());
			zwischenspeicher.setSuccessor(neuesList.getSuccessor().getSuccessor());

		}

	}

	public String toString()
	{
		String x = "";
		for (int i = 0; i <= this.getLastListElementPos(); i++)
		{

			x = x + this.getListElementAt(i).getValueElement().toString() + "\n";
		}
		return x;
	}
}
