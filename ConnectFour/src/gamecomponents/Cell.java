package gamecomponents;

import com.sun.prism.paint.Color;

/** 
 * The Cell class is a basic implementation of a cell a Four in a Row game board.
 * 
 * It is instantiated with x,y coordinates so it is knows where it location is in the board.
 * It also provides methods allowing it to communicate with its neighbors.
 * 
 * @author Michael J. Holmes
 * @version 1.0 April 4, 2015
 *
 */
public class Cell implements ICell 
{
	//----------------------------------------------------
	// Instance Variables
	//----------------------------------------------------
	private int xPosition;
	private int yPosition;
	private IMarker marker;
	private Cell northWestNeighbor;
	private Cell northNeighbor;
	private Cell northEastNeighbor;
	private Cell westNeighbor;
	private Cell eastNeighbor;
	private Cell southWestNeighbor;
	private Cell southNeighbor;
	private Cell southEastNeighbor;
	
	
	//----------------------------------------------------
	// Constructors
	//----------------------------------------------------
	/**
	 * Constructor to create a Cell with the provided x,y coordinates.
	 * 
	 * @param x the 0 indexed value of the column.
	 * @param y the 0 indexed value of the row.
	 */
	public Cell(int x, int y) 
	{
		this(x,y,null);
	}
	
	/**
	 * Constructor to create a Cell with the provided x,y coordinates.  This
	 * constructor also allows for an initial Marker to be defined.
	 * 
	 * @param x the 0 indexed value of the column.
	 * @param y the indexed value of the row.
	 * @param isAlive the initial state of the cell: true if alive, false if not.
	 */
	public Cell(int x, int y, IMarker aMarker)
	{
		xPosition = x;
		yPosition = y;
		marker = aMarker;
	}
	

	//----------------------------------------------------
	// Class Methods
	//----------------------------------------------------
	/**
	 * Compares the Cell object to another generic ICell object.  
	 * 
	 * It will return a value based on comparing the x and y coordinate 
	 * values of the two cells.
	 * 
	 * @param other the other cell to compare it to.
	 */
	public int compareTo(ICell other) 
	{
		if ( (this.xPosition != other.getXPosition()))
		{
			return this.xPosition - other.getXPosition();
		}
		else
		{
			return this.yPosition - other.getYPosition();
		}
	}

    /**
     * Gets the x coordinate of this cell in the board.
     * 
     * @return the 0 indexed value of the board column the cell is in.
     */
	public int getXPosition()
	{
		return xPosition;
	}
	
    /**
     * Gets the y coordinate of this cell in the board.
     * 
     * @return the 0 indexed value of the board row the cell is in.
     */
	public int getYPosition()
	{
		return yPosition;
	}
	
	/**
	 * Sets the Cell's neighbor to the Northwest.
	 * 
	 * @param aCell the cell to set as the neighbor.
	 */
	public void setNorthWestNeighbor(Cell aCell) 
	{
		northWestNeighbor = aCell;
	}
	
	/**
	 * Sets the Cell's neighbor to the North.
	 * 
	 * @param aCell the cell to set as the neighbor.
	 */
	public void setNorthNeighbor(Cell aCell) 
	{
		northNeighbor = aCell;
	}

	/**
	 * Sets the Cell's neighbor to the Northeast.
	 * 
	 * @param aCell the cell to set as the neighbor.
	 */
	public void setNorthEastNeighbor(Cell aCell) 
	{
		northEastNeighbor = aCell;
	}

	/**
	 * Sets the Cell's neighbor to the West.
	 * 
	 * @param aCell the cell to set as the neighbor.
	 */
	public void setWestNeighbor(Cell aCell) 
	{
		westNeighbor = aCell;
	}

	/**
	 * Sets the Cell's neighbor to the East.
	 * 
	 * @param aCell the cell to set as the neighbor.
	 */
	public void setEastNeighbor(Cell aCell) 
	{
		eastNeighbor = aCell;
	}

	/**
	 * Sets the Cell's neighbor to the SouthWest.
	 * 
	 * @param aCell the cell to set as the neighbor.
	 */
	public void setSouthWestNeighbor(Cell aCell) 
	{
		southWestNeighbor = aCell;
	}

	/**
	 * Sets the Cell's neighbor to the South.
	 * 
	 * @param aCell the cell to set as the neighbor.
	 */
	public void setSouthNeighbor(Cell aCell) 
	{
		southNeighbor = aCell;
	}

	/**
	 * Sets the Cell's neighbor to the SouthEast.
	 * 
	 * @param aCell the cell to set as the neighbor.
	 */
	public void setSouthEastNeighbor(Cell aCell) 
	{
		southEastNeighbor = aCell;
	}

	/**
	 * Gets the marker currently in the cell.  If the cell is empty
	 * it will throw and exception
	 * 
	 * @return the Marker object in the cell.
	 * @throws EmptyCellException if the cell is empty.
	 */
	public IMarker getMarker() throws EmptyCellException
	{
		if (marker == null)
		{
			throw new EmptyCellException();
		}
		else
		{
			return marker;
		}
	}
	

	/**
	 * Sets the marker to the inputed marker.
	 * 
	 * @param aMarker the marker to put in the cell.
	 */
	public void setMarker(IMarker aMarker) 
	{
		marker = aMarker;
	}

	/**
	 * Clears the cell and removes any marker that is there.
	 */
	public void clear() 
	{
		marker = null;
	}

	/**
	 * Returns weather the cell is currently empty or not.
	 * 
	 * @return true if it is empty, false otherwise.
	 */
	public boolean isEmpty() 
	{
		return (marker == null);
	}

	/**
	 * Gets the number of matching cells diagonally up to the left.
	 * 
	 * @return the count of cells in a row.
	 */
	public int getUpperLeftCount() 
	{
		if (isEmpty())
		{
			return 0;
		}
		
		try 
		{
			if (northWestNeighbor.getMarker().equals(marker))
			{
				return northWestNeighbor.getUpperLeftCount() + 1;
			}
			else
			{
				return 1;
			}
		} 
		catch (EmptyCellException e) 
		{
			//Neighbor cell is empty.
			return 1;
		}
	}

	/**
	 * Gets the number of matching cells up.
	 * 
	 * @return the count of cells in a row.
	 */
	public int getUpCount() 
	{
		if (isEmpty())
		{
			return 0;
		}
		
		try 
		{
			if (northWestNeighbor.getMarker().equals(marker))
			{
				return northWestNeighbor.getUpperLeftCount() + 1;
			}
			else
			{
				return 1;
			}
		} 
		catch (EmptyCellException e) 
		{
			//Neighbor cell is empty.
			return 1;
		}
	}

	/**
	 * Gets the number of matching cells diagonally up to the right.
	 * 
	 * @return the count of cells in a row.
	 */
	public int getUpperRightCount() 
	{
		if (isEmpty())
		{
			return 0;
		}
		
		try 
		{
			if (northEastNeighbor.getMarker().equals(marker))
			{
				return northEastNeighbor.getUpperRightCount() + 1;
			}
			else
			{
				return 1;
			}
		} 
		catch (EmptyCellException e) 
		{
			//Neighbor cell is empty.
			return 1;
		}
	}

	/**
	 * Gets the number of matching cells to the left.
	 * 
	 * @return the count of cells in a row.
	 */
	public int getLeftCount() 
	{
		if (isEmpty())
		{
			return 0;
		}
		
		try 
		{
			if (westNeighbor.getMarker().equals(marker))
			{
				return westNeighbor.getLeftCount() + 1;
			}
			else
			{
				return 1;
			}
		} 
		catch (EmptyCellException e) 
		{
			//Neighbor cell is empty.
			return 1;
		}
	}

	/**
	 * Gets the number of matching cells to the right.
	 * 
	 * @return the count of cells in a row.
	 */
	public int getRightCount() 
	{
		if (isEmpty())
		{
			return 0;
		}
		
		try 
		{
			if (eastNeighbor.getMarker().equals(marker))
			{
				return eastNeighbor.getRightCount() + 1;
			}
			else
			{
				return 1;
			}
		} 
		catch (EmptyCellException e) 
		{
			//Neighbor cell is empty.
			return 1;
		}
	}

	/**
	 * Gets the number of matching cells diagonally down to the left.
	 * 
	 * @return the count of cells in a row.
	 */
	public int getLowerLeftCount() 
	{
		if (isEmpty())
		{
			return 0;
		}
		
		try 
		{
			if (southWestNeighbor.getMarker().equals(marker))
			{
				return southWestNeighbor.getLowerLeftCount() + 1;
			}
			else
			{
				return 1;
			}
		} 
		catch (EmptyCellException e) 
		{
			//Neighbor cell is empty.
			return 1;
		}
	}

	/**
	 * Gets the number of matching cells down.
	 * 
	 * @return the count of cells in a row.
	 */
	public int getDownCount() 
	{
		if (isEmpty())
		{
			return 0;
		}
		
		try 
		{
			if (southNeighbor.getMarker().equals(marker))
			{
				return southNeighbor.getDownCount() + 1;
			}
			else
			{
				return 1;
			}
		} 
		catch (EmptyCellException e) 
		{
			//Neighbor cell is empty.
			return 1;
		}
	}

	/**
	 * Gets the number of matching cells diagonally down to the right.
	 * 
	 * @return the count of cells in a row.
	 */
	public int getLowerRightCount() 
	{
		if (isEmpty())
		{
			return 0;
		}
		
		try 
		{
			if (southEastNeighbor.getMarker().equals(marker))
			{
				return southEastNeighbor.getLowerRightCount() + 1;
			}
			else
			{
				return 1;
			}
		} 
		catch (EmptyCellException e) 
		{
			//Neighbor cell is empty.
			return 1;
		}
	}
	
	/**
	 * Returns the cell as a space, X or O based on its marker value.
	 * 
	 * @return the String representation of the cell.
	 */
	public String toString()
	{
		if(isEmpty())
			return " ";
		else
		{
			if (marker.getColor().equals(Color.RED))
				return "O";
			else
				return "X";
		}
	}
	
}
