import java.util.*;

public class Valuedata
{
	//Valuedata name
	private String variable;
	//Valuedata value
	private double value;
	
	//Valuedata Constructor
	public Valuedata(String name, double val)
	{
		variable = name;
		value = val;
	}
	
	//Name		: getValue
	//Behavior	: get Valuedata object's value
	//Parameters: nothing
	//Return	: a double
	public double getValue()
	{
		return value;
	}
	
	//Name		: setValue
	//Behavior	: set Valuedata object's value
	//Parameters: a double
	//Return	: nothing
	public void setValue(double v)
	{
		value = v;
	}
	
	//Name		: getVariable
	//Behavior	: get Valuedata object's name
	//Parameters: nothing
	//Return	: a string
	public String getVariable()
	{
		return variable;
	}
	
	//Name		: setVariable
	//Behavior	: set Valuedata object's name
	//Parameters: a string
	//Return	: nothing
	public void setVariable(String n)
	{
		variable = n;
	}
	
	//Name		: toString
	//Behavior	: print out the Valuedata object
	//Parameters: nothing
	//Return	: a string
	public String toString()
	{
		String name;
		name = variable + " " + value;
		return name;
	}
}