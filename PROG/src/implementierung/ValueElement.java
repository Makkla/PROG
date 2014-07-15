package implementierung;

import schnittstellen.IValueElement;

public class ValueElement implements IValueElement
{

	private String name;

	private int value;

	public ValueElement(String name, int value)
	{

		if (name != null)
		{
			this.name = name;
			this.value = value;
		}
	}

	public String toString()
	{

		String toString = "Name: " + this.name + ", Value: " + this.value;

		return toString;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String paramName)
	{
		if (paramName != null)
		{
			this.name = paramName;
		}

	}

	public int getValue()
	{

		return this.value;
	}

	public void setValue(int paramName)
	{

		this.value = paramName;

	}

}
