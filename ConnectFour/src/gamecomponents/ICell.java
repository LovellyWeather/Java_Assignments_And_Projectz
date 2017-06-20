package gamecomponents;
/**
 * Represents a single cell in Conway's Game of Life.  The cell knows
 * it's x,y coordinates and can also provide how many of its neighbors 
 * are alive. 
 * 
 * @author Michael J. Holmes
 * @version 1.0   April 4, 2015
 *
 */
public interface ICell extends Comparable<ICell> 
{
	/**
	 * Gets the cell's current Marker.
	 * 
	 * @return the Marker in the cell.
	 */
    public IMarker getMarker() throws EmptyCellException;
    
    /**
     * Gets the x coordinate of this cell in the board.
     * 
     * @return the 0 indexed value of the board column the cell is in.
     */
    public int getXPosition();
    
    /**
     * Gets the y coordinate of this cell in the board.
     * 
     * @return the 0 indexed value of the board row the cell is in.
     */
    public int getYPosition();
    
    /**
     * Sets the cell to contain the inputed marker.
     * @param aMarker the marker to set.
     */
    public void setMarker(IMarker aMarker);
    
    /**
     * Clears the contents of the cell and removes the marker.
     */
    public void clear();

    /**
     * Returns if the cell is empty or not.
     * 
     * @return true if the cell is empty, false otherwise.
     */
    public boolean isEmpty();
    
	/**
	 * Gets the number of matching cells diagonally up to the left.
	 * 
	 * @return the count of cells in a row.
	 */
    public int getUpperLeftCount();
    
	/**
	 * Gets the number of matching cells up.
	 * 
	 * @return the count of cells in a row.
	 */
    public int getUpCount();
    
	/**
	 * Gets the number of matching cells diagonally up to the right.
	 * 
	 * @return the count of cells in a row.
	 */
    public int getUpperRightCount();
    
	/**
	 * Gets the number of matching cells to the left.
	 * 
	 * @return the count of cells in a row.
	 */
    public int getLeftCount();
    
	/**
	 * Gets the number of matching cells to the right.
	 * 
	 * @return the count of cells in a row.
	 */
    public int getRightCount();
    
	/**
	 * Gets the number of matching cells diagonally down to the left.
	 * 
	 * @return the count of cells in a row.
	 */
    public int getLowerLeftCount();
    
	/**
	 * Gets the number of matching cells down.
	 * 
	 * @return the count of cells in a row.
	 */
    public int getDownCount();
    
	/**
	 * Gets the number of matching cells diagonally down to the right.
	 * 
	 * @return the count of cells in a row.
	 */
    public int getLowerRightCount();
}
