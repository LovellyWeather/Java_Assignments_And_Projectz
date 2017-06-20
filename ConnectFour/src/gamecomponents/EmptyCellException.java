package gamecomponents;

/**
 * This exception is used when a cell is empty.
 * 
 * @author Michael J. Holmes
 * @version 1.0 April 4, 2015
 */
public class EmptyCellException extends Exception 
{
	/**
	 * Default constructor that creates the Empty Cell Exception.
	 */
	public EmptyCellException() 
	{
		super();
	}

	/**
	 * Constructor to create exception with inputed message.
	 * 
	 * @param context any context to be added about why the exception occurred.
	 */
	public EmptyCellException(String context) 
	{
		super(context);
	}
}
