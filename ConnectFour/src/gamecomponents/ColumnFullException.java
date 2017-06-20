package gamecomponents;

/**
 * This exception is used when a column on the board is full.
 * 
 * @author Michael J. Holmes
 * @version 1.0 April 4, 2015
 */
public class ColumnFullException extends Exception 
{
	//-------------------------------
	// Constructors
	//-------------------------------
	/**
	 * Default constructor that creates the Column Full Exception.
	 */
	public ColumnFullException() 
	{ 
		super();
	}

	/**
	 * Constructor to create exception with inputed message.
	 * 
	 * @param columnIndex the index of the column that is full.
	 */
	public ColumnFullException(String columnIndex) 
	{
		super(columnIndex);
	}
}
