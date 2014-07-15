package implementierung;

import schnittstellen.IListElement;
import schnittstellen.IValueElement;

public class ListElement implements IListElement
{

	private IValueElement valueElement;

	private IListElement predecessor;

	private IListElement successor;

	public ListElement(IValueElement valueElement)
	{
		if (valueElement != null)
		{
			this.valueElement = valueElement;
		}

	}

	@Override
	public IValueElement getValueElement()
	{
		return this.valueElement;
	}

	@Override
	public void setValueElement(IValueElement value)
	{
		if (value != null)
		{
			this.valueElement = value;
		}

	}

	@Override
	public IListElement getPredecessor()
	{

		return this.predecessor;
	}

	@Override
	public void setPredecessor(IListElement predecessor)
	{
		this.predecessor = predecessor;

	}

	@Override
	public IListElement getSuccessor()
	{
		return this.successor;
	}

	@Override
	public void setSuccessor(IListElement successor)
	{
		this.successor = successor;

	}

}
