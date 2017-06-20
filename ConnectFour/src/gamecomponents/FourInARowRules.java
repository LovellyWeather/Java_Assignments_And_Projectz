package gamecomponents;
/** 
 * This class implements the basic Four in a Row game rules.
 * 
 * A winner is determined if there is four markers in a row horizontially,
 * vertically or diagonally.

 * @author Michael J. Holmes
 * @version 1.0 April 4, 2015
 *
 */
public class FourInARowRules implements IGameRule 
{
    //-------------------------------------
	// Constructors
	//-------------------------------------
	/**
	 * Default construct to create an instance of the basic rules.
	 */
	public FourInARowRules() {}

	//--------------------------------------
	// Class Methods
	//--------------------------------------
	/**
	 * Returns if the game is over.
	 * 
	 * @param theBoard the board to check for a game over state.
	 * @return true if the game is over, false otherwise.
	 */
	public boolean isGameOver(IBoard theBoard) 
	{
		return (isWinner(theBoard) || isTie(theBoard));
	}
	
	/**
	 * Returns if the game is a tie.
	 * 
	 * @param theBoard the board to check for a tie state.
	 * @return true if the game is a tie, false otherwise.
	 */
	public boolean isTie(IBoard theBoard) 
	{
		return (theBoard.isFull() && !isWinner(theBoard));
	}

	/**
	 * Returns if the game is in a win state.
	 * 
	 * @param theBoard the board to check for a win state.
	 * @return true if the game is over, false otherwise.
	 */
	public boolean isWinner(IBoard theBoard) 
	{
		for(int row=0; row<theBoard.getNumberOfRows();row++)
			for(int col=0; col<theBoard.getNumberOfColumns(); col++)
			{	
				if(theBoard.getCell(row, col).getUpperLeftCount() >= 4 || 
				   theBoard.getCell(row, col).getUpCount() >= 4 ||
				   theBoard.getCell(row, col).getUpperRightCount() >= 4 ||
				   theBoard.getCell(row, col).getLeftCount() >= 4 ||
				   theBoard.getCell(row, col).getRightCount() >= 4 ||
				   theBoard.getCell(row, col).getLowerLeftCount() >= 4 ||
				   theBoard.getCell(row, col).getDownCount() >= 4 ||
				   theBoard.getCell(row, col).getLowerRightCount() >= 4)
				{
					return true;
				}
			}
		
		return false;
	}

	/**
	 * Returns the marker of the winning player.
	 * 
	 * @param theBoard the board to check get the winner for.
	 * @return the Marker of the winning player, or null if there is none.
	 */
	public IMarker getWinner(IBoard theBoard) 
	{
		if (isWinner(theBoard))
		{
			for(int row=0; row<theBoard.getNumberOfRows();row++)
				for(int col=0; col<theBoard.getNumberOfColumns(); col++)
				{
					if(theBoard.getCell(row, col).getUpperLeftCount() >= 4 || 
					   theBoard.getCell(row, col).getUpCount() >= 4 ||
					   theBoard.getCell(row, col).getUpperRightCount() >= 4 ||
					   theBoard.getCell(row, col).getLeftCount() >= 4 ||
					   theBoard.getCell(row, col).getRightCount() >= 4 ||
					   theBoard.getCell(row, col).getLowerLeftCount() >= 4 ||
					   theBoard.getCell(row, col).getDownCount() >= 4 ||
					   theBoard.getCell(row, col).getLowerRightCount() >= 4)
					{
						try 
						{
							return theBoard.getMarker(row, col);
						} 
						catch (EmptyCellException e) 
						{
							
						}
					}
				 }			
			return null;
		}
		else
		{
			return null;
		}
	}

}
