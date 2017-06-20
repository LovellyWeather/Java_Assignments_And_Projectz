package gamecomponents;
/**
 * Represents a two dimensional board of cells.  
 * 
 * @author Michael J. Holmes
 * @version 1.0 April 11, 2015
 *
 */
public interface IBoard 
{
	/**
	 * Gets the number of columns in the board.
	 * @return the number of columns.
	 */
	public int getNumberOfColumns();
	
	/**
	 * Gets the number of rows in the board.
	 * @return the number of rows.
	 */
	public int getNumberOfRows();
	
	/**
	 * Returns if the board is full or not.
	 * 
	 * @return true if everyCell is full, false otherwise.
	 */
	public boolean isFull();
	
	/**
	 * Returns if the specified column is full or not.
	 *
	 * @param columnIndex the index of the column to check.
	 * @return true if the column is full, false otherwise.
	 */
	public boolean isColumnFull(int columnIndex);
	
	/**
	 * Adds a token to the column, it will move to the lowest cell
	 * that is available.
	 * 
	 * @param columnIndex the index value of the column to add the token to.
	 * @param aMarker the marker to add to the board.
	 * @throws ColumnFullException if the column is already full
	 */
	public void addMarker(int columnIndex, IMarker aMarker) throws ColumnFullException;
	
	/**
	 * Get's the cell from the board at position at the x, y coordinates.
	 * @param col the column of the cell.
	 * @param row the row of the cell.
	 * @return the cell object at that location.
	 */
	public IMarker getMarker(int row, int col) throws EmptyCellException;
	
	public ICell getCell(int row, int col);
	
	/**
	 * Clears the board so there all empty cells.
	 */
	public void clear();
}
