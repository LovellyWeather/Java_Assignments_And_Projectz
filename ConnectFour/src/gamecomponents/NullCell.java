package gamecomponents;

/**
 * Implements the ICell interface using the Null Pattern.
 * 
 * @author Michael J. Holmes
 * @version 1.0 April 4, 2015
 *
 */
public class NullCell extends Cell
{
	//-------------------------------------
	// Instance Variables
	//-------------------------------------
	
	//-------------------------------------
	// Constructors
	//-------------------------------------	
	/**
	 * Default constructor to create a null cell.
	 */
	public NullCell() 
	{
		super(-1,-1);
	}

	
	//-------------------------------------
	// Class Methods
	//-------------------------------------
	/**
	 * A null cell is always less than any other cell.
	 * 
	 * @return this will always return the MIN_VALUE
	 */
	public int compareTo(ICell otherCell) 
	{
		return Integer.MIN_VALUE;
	}

	/**
	 * A null cell will never have neighbors, so this does nothing.
	 * @param aCell the cell to set as neighbor.
	 */
	public void setNorthWestNeighbor(ICell aCell) 
	{
		// Do nothing.	
	}

	/**
	 * A null cell will never have neighbors, so this does nothing.
	 * @param aCell the cell to set as neighbor.
	 */
	public void setNorthNeighbor(ICell aCell) 	
	{
		// Do nothing.	
	}
	
	/**
	 * A null cell will never have neighbors, so this does nothing.
	 * @param aCell the cell to set as neighbor.
	 */
	public void setNorthEastNeighbor(ICell aCell) 	
	{
		// Do nothing.	
	}

	/**
	 * A null cell will never have neighbors, so this does nothing.
	 * @param aCell the cell to set as neighbor.
	 */
	public void setWestNeighbor(ICell aCell) 
	{
		// Do nothing.	
	}

	/**
	 * A null cell will never have neighbors, so this does nothing.
	 * @param aCell the cell to set as neighbor.
	 */
	public void setEastNeighbor(ICell aCell) 
	{
		// Do nothing.	
	}

	/**
	 * A null cell will never have neighbors, so this does nothing.
	 * @param aCell the cell to set as neighbor.
	 */
	public void setSouthWestNeighbor(ICell aCell) 
	{
		// Do nothing.	
	}

	/**
	 * A null cell will never have neighbors, so this does nothing.
	 * @param aCell the cell to set as neighbor.
	 */
	public void setSouthNeighbor(ICell aCell) 
	{
		// Do nothing.	
	}

	/**
	 * A null cell will never have neighbors, so this does nothing.
	 * @param aCell the cell to set as neighbor.
	 */
	public void setSouthEastNeighbor(ICell aCell) 	
	{
		// Do nothing.	
	}

	/**
	 * A null cell will never have a location, so this returns a -1.
	 * @return will always be -1.
	 */
	public int getXPosition() 
	{
		return -1;
	}

	/**
	 * A null cell will never have a location, so this returns a -1.
	 * @return will always be -1.
	 */
	public int getYPosition() 
	{
		return -1;
	}

	/**
	 *  Because a NullCell can never contain a marker, this always
	 *  throws an EmptyCellException. 
	 */
	public IMarker getMarker() throws EmptyCellException 
    {
		throw new EmptyCellException();
	}

	/**
	 * This will ignore the marker and do nothing.
	 */
	public void setMarker(IMarker aMarker) 
	{
		// Do Nothing
	}

	/**
	 * A null cell is always clear so this does nothing.
	 */
	public void clear() 
	{
		// Do Nothing
	}

	/** 
	 * A null cell is always empty, so this will always return true.
	 * 
	 * @return true because the cell is always empty.
	 */
	public boolean isEmpty() 
	{
		return true;
	}

	/**
	 *  The cell has no neighbors, so the result is always 0. 
	 */
	public int getUpperLeftCount() 
	{
		return 0;
	}

	/**
	 *  The cell has no neighbors, so the result is always 0. 
	 */
	public int getUpCount() 
	{
		return 0;
	}

	/**
	 *  The cell has no neighbors, so the result is always 0. 
	 */
	public int getUpperRightCount() 
	{
		return 0;
	}

	/**
	 *  The cell has no neighbors, so the result is always 0. 
	 */
	public int getLeftCount() 
	{
		return 0;
	}

	/**
	 *  The cell has no neighbors, so the result is always 0. 
	 */
	public int getRightCount() 
	{
		return 0;
	}

	/**
	 *  The cell has no neighbors, so the result is always 0. 
	 */
	public int getLowerLeftCount() 
	{
		return 0;
	}

	/**
	 *  The cell has no neighbors, so the result is always 0. 
	 */
	public int getDownCount() 
	{
		return 0;
	}

	/**
	 *  The cell has no neighbors, so the result is always 0. 
	 */
	public int getLowerRightCount() 
	{
		return 0;
	}
	

}
