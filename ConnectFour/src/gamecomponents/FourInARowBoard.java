package gamecomponents;

/** 
 * The game board for a Four in a Row game.
 * 
 * @author Michael J. Holmes
 * @version 1.0 April 4, 2015
 *
 */
public class FourInARowBoard implements IBoard 
{
	//--------------------------------
	// Instance Variables
	//--------------------------------
	private Cell[][] board;
	
	//--------------------------------
	// Constructors
	//--------------------------------
	/**
	 * Default constructor creates a 7x6 board.
	 */
	public FourInARowBoard() 
	{
		board = new Cell[7][6];
		constructBoard();
	}
	
	/**
	 * Constructor to create a board with the inputed dimensions.
	 * 
	 * @param numRows the number of rows in the board.
	 * @param numCols the number of columns in the board.
	 */
	public FourInARowBoard(int numRows, int numCols)
	{
		board = new Cell[numRows][numCols];
		constructBoard();
	}

	
	//----------------------------------
	// Class Methods
	//----------------------------------
	/**
	 * Returns the number of columns in the board.
	 * 
	 * @return the number of columns.
	 */
	public int getNumberOfColumns() 
	{
		return board[0].length;
	}
	
	
	/**
	 * Returns the number of rows in the board.
	 * 
	 * @return the number of rows.
	 */
	public int getNumberOfRows() 
	{
		return board.length;
	}
	
	/**
	 * Returns the cell at the inputed coordinates.
	 * 
	 * @return the Cell at that location.
	 * @param row the row index of the cell.
	 * @param col the column index of the cell.
	 */
	public ICell getCell(int row, int col)
	{
		return board[row][col];
	}

	/**
	 * Returns if the board is full of markers or not.
	 * 
	 * @return true if the board is full, false otherwise.
	 */
	public boolean isFull() 
	{
		for(int row=0; row<getNumberOfRows(); row++)
		{
			for(int col=0; col<getNumberOfColumns(); col++)
			{
				if (board[row][col].isEmpty())
				{
					return false;
				}
			}
		}
		
		return true;
	}

	
	/**
	 * Returns if the column is full or not.
	 * 
	 * @return true if the column is full, false otherwise.
	 * @param columnIndex the index of the column to check.
	 */
	public boolean isColumnFull(int columnIndex) 
	{
		for(int row=0; row<getNumberOfColumns(); row++)
		{
			if (board[row][columnIndex].isEmpty())
			{
				return false;
			}
		}
		
		return true;
	}

	
	/**
	 * Adds the inputed marker to the column.  If the column is full and excpetion
	 * will be thrown.
	 * 
	 * @param columnIndex the index of the column to add the marker to.
	 * @param aMarker the marker to add to the column.
	 * @throws if the column is full, and a marker cannot be added.
	 */
	public void addMarker(int columnIndex, IMarker aMarker) throws ColumnFullException 
	{
		if (isColumnFull(columnIndex))
		{
			throw new ColumnFullException(Integer.toString(columnIndex));
		}
		else
		{
			board[0][columnIndex].setMarker(aMarker);
			floatDown();
			
		}
	}

	/**
	 * Returns the marker at the given cell.  If the cell is empty an exception
	 * will be thrown.
	 * 
	 * @return the marker that is in the cell.
	 * @param row the row index of the cell.
	 * @param col the column index of the cell.
	 */
	public IMarker getMarker(int row, int col) throws EmptyCellException 
	{
		return board[row][col].getMarker();
	}
	
	
	/**
	 * Clears the board and removes all markers from all of the cells in the board.
	 */
	public void clear() 
	{
		for(int row=0; row<getNumberOfRows(); row++)
		{
			for(int col=0; col<getNumberOfColumns(); col++)
			{
				board[row][col].clear();
			}
		}
	}

	/**
	 * Returns the string representation of the board, which is a grid with the values of each cell.
	 * 
	 * @return the string representing the board.
	 */
	public String toString()
	{
		StringBuffer output = new StringBuffer();
		
		for (int row = 0; row<getNumberOfRows(); row++)
		{
			for (int col = 0; col<getNumberOfColumns(); col++)
			{
				output.append("|" + board[row][col].toString());
			}
			
			output.append("\n");

		}
		
		return output.toString();
		
	}
	
	

	
	//----------------------------------------------
	// Private/protected helper methods
	//----------------------------------------------
		/**
		 * The method constructs the board cell by cell adding new
		 * instances to the board array.
		 */
		protected void constructBoard()
		{
			for (int row = 0; row < getNumberOfRows(); row++)
			{
				for (int col = 0; col < getNumberOfColumns(); col++)
				{
				  board[row][col] = new Cell(row,col);
				}
			}
			
			connectCells();
		}
		
		
		/**
		 * This method will loop through the cells in the board,
		 * connecting each to its neighbors.
		 */
		private void connectCells()
		{
			for (int i = 0; i < board.length; i++)
			{
				for (int j = 0; j < board[0].length; j++)
				{
					setNorthNeighbors(i,j);

					setEastWestNeighbors(i,j);

					setSouthNeighbors(i,j);
				}
			}
		}
		
		/**
		 * This method will set the cell's neighbors to the North.
		 * If it is in the top row or on the edge, it will use NullCell objects
		 * where appropriate.
		 * 
		 * @param x the x coordinate or column of the cell to set.
		 * @param y the y coordinate of the row of the cell to set.
		 */
		private void setNorthNeighbors(int x, int y)
		{
			//The cell is in the top row.
			if (x == 0)
			{
				board[x][y].setNorthWestNeighbor(new NullCell());
				board[x][y].setNorthNeighbor(new NullCell());
				board[x][y].setNorthEastNeighbor(new NullCell());
			}
			//The cell is NOT in the top row.
			else
			{
				//The cell is on the left edge.
				if (y == 0)
				{	       
						board[x][y].setNorthWestNeighbor(new NullCell());
						board[x][y].setNorthNeighbor(board[x-1][y]);
						board[x][y].setNorthEastNeighbor(board[x-1][y+1]);
				}
				//The cell is on the right edge.
				else if ( y == (board[x].length -1))
				{
					board[x][y].setNorthWestNeighbor(board[x-1][y-1]);
					board[x][y].setNorthNeighbor(board[x-1][y]);
					board[x][y].setNorthEastNeighbor(new NullCell());				
				}
				//The cell is in the middle of the board.
				else
				{
					board[x][y].setNorthWestNeighbor(board[x-1][y-1]);
					board[x][y].setNorthNeighbor(board[x-1][y]);
					board[x][y].setNorthEastNeighbor(board[x-1][y+1]);				
				}
			}
		}
		
		/**
		 * This method will set the cell's neighbors to the East and West.
		 * If it is on the edge, it will use NullCell objects
		 * where appropriate.
		 * 
		 * @param x the x coordinate or column of the cell to set.
		 * @param y the y coordinate of the row of the cell to set.
		 */
		private void setEastWestNeighbors(int x, int y)
		{
			//The cell is on the left edge.
			if (y == 0)
			{
				board[x][y].setWestNeighbor(new NullCell());
				board[x][y].setEastNeighbor(board[x][y+1]);
			}
			//The cell is on the right edge.
			else if ( y == (board[x].length -1))
			{
				board[x][y].setWestNeighbor(board[x][y-1]);
				board[x][y].setEastNeighbor(new NullCell());				
			}
			else
			{
				board[x][y].setWestNeighbor(board[x][y-1]);
				board[x][y].setEastNeighbor(board[x][y+1]);				
			}
		}

		/**
		 * This method will set the cell's neighbors to the South.
		 * If it is in the bottom row or on the edge, it will use NullCell objects
		 * where appropriate.
		 * 
		 * @param x the x coordinate or column of the cell to set.
		 * @param y the y coordinate of the row of the cell to set.
		 */
		protected void setSouthNeighbors(int x, int y)
		{

			//The cell is in the bottom row.
			if (x == (board.length - 1))
			{
				board[x][y].setSouthWestNeighbor(new NullCell());
				board[x][y].setSouthNeighbor(new NullCell());
				board[x][y].setSouthEastNeighbor(new NullCell());
			}
			//The cell is NOT in the bottom row.
			else
			{
				//The cell is on the left edge.
				if (y == 0)
				{
						board[x][y].setSouthWestNeighbor(new NullCell());
						board[x][y].setSouthNeighbor(board[x+1][y]);
						board[x][y].setSouthEastNeighbor(board[x+1][y+1]);
				}
				//The cell is on the right edge.
				else if ( y == (board[x].length -1))
				{
					board[x][y].setSouthWestNeighbor(board[x+1][y-1]);
					board[x][y].setSouthNeighbor(board[x+1][y]);
					board[x][y].setSouthEastNeighbor(new NullCell());				
				}
				//The cell is in the middle of the board.
				else
				{
					board[x][y].setSouthWestNeighbor(board[x+1][y-1]);
					board[x][y].setSouthNeighbor(board[x+1][y]);
					board[x][y].setSouthEastNeighbor(board[x+1][y+1]);				
				}
			}
		}
		
		/**
		 * Will loop through the columns and float any markers down so they are 
		 * stacked on the bottom.
		 */
		protected void floatDown()
		{
			for(int col = 0; col< getNumberOfColumns(); col++)
			{
				int workingRow = getNumberOfRows()-1;
				int nextLowestMarker = getIndexOfNextLowestMarker(col,workingRow);
				
				while(nextLowestMarker > -1)
				{
					if(board[workingRow][col].isEmpty())
					{
						try 
						{
							board[workingRow][col].setMarker(board[nextLowestMarker][col].getMarker());
							board[nextLowestMarker][col].clear();
						} 
						catch (EmptyCellException e) 
						{
							//This won't happen because of check above.
						}
					}
					
					workingRow--;
					nextLowestMarker = getIndexOfNextLowestMarker(col,workingRow);
				}
			}
			
		}
		
		/**
		 * Gets the index value of the next lowest marker in the column, starting from
		 * a specific row.
		 * 
		 * @param columnIndex the column to look for the marker.
		 * @param rowToStartFrom the row to start looking from.
		 * @return the index of the next lowest marker in the column.
		 */
		protected int getIndexOfNextLowestMarker(int columnIndex, int rowToStartFrom)
		{
			for(int row = rowToStartFrom; row>=0; row--)
			{
				try
				{
					if (!board[row][columnIndex].isEmpty())
					{
						return row;
					}
				}
				catch(ArrayIndexOutOfBoundsException e)
				{}
			}
			return -1;
		}
	
}
