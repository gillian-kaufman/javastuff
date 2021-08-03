//User defined exception

public class EmptyStackException extends RuntimeException
{
	//constructor
	public EmptyStackException(String err)
	{
		//Calls constructor from superclass
		super(err);
	}
}