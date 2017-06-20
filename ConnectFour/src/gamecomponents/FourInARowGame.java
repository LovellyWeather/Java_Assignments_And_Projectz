package gamecomponents;

import java.awt.Color;
/** 
 * The game class manages the game interactions and allows for multiple board and
 * rule implementations.
 * 
 * This game is constructed for a basic two player game.
 * 
 * @author Michael J. Holmes
 * @version 1.0 April 4, 2015
 *
 */
public class FourInARowGame 
{
	//---------------------------------------------
	// Instance Variables and Constants
	//---------------------------------------------
	private static IMarker player1 = new Marker(Color.red);
	private static IMarker player2 = new Marker(Color.blue);
	
	private FourInARowBoard theBoard;
	private IGameRule theRules;
	private IMarker currentPlayer;
	
	
	//---------------------------------------------
	// Constructors
	//---------------------------------------------	
	
	/**
	 * Constructs a default game with a 7x6 board and basic rules
	 * of 4 in a row.
	 */
	public FourInARowGame() 
	{
		theBoard = new FourInARowBoard();
		theRules = new FourInARowRules();
		currentPlayer = player1;
	}
	
	
	/**
	 * Constructs a four in a row game with a board the inputed size.
	 * 
	 * @param numRows the number of rows in the board.
	 * @param numCols the number of columns in the board.
	 */
	public FourInARowGame(int numRows, int numCols)
	{
		theBoard = new FourInARowBoard(numRows, numCols);
		theRules = new FourInARowRules();
		currentPlayer = player1;
	}
	
	
	//---------------------------------------------
	// Class Methods
	//---------------------------------------------
	/**
	 * Plays a move in the four in a row game.  It will place a marker
	 * for the current player in the inputed column.
	 * 
	 * @param column the column index of where to place the marker.
	 */
	public void makeMove(int column)
	{
		try 
		{
			theBoard.addMarker(column, currentPlayer);		
			nextPlayer();
		} 
		catch (ColumnFullException e) 
		{
			//Invalid move, do nothing.
		}
	}
	
	
	/**
	 * Returns if the game is over or not.
	 * 
	 * @return true if the game is over, false otherwise.
	 */
	public boolean isGameOver()
	{
		return theRules.isGameOver(theBoard);
	}
	
	
	/**
	 * Returns if the game is a tie or not.
	 * 
	 * @return true if the game is a tie, false otherwise.
	 */	
	public boolean isTie()
	{
		return theRules.isTie(theBoard);
	}
	
	/**
	 * Returns if the game is in a win state or not.
	 * 
	 * @return true if the game is in a win state, false otherwise.
	 */
	public boolean isWinner()
	{
		return theRules.isWinner(theBoard);
	}
	
	/**
	 * Returns if the Marker of the winning player.
	 * 
	 * @return the marker of the winning player.
	 */
	public IMarker getWinner()
	{
		return theRules.getWinner(theBoard);
	}

	/**
	 * Resets the board and starts the game over.
	 */
	public void reset()
	{
		theBoard.clear();
		currentPlayer = player1;
	}
	
	/**
	 * Returns the current board state.
	 * 
	 * @return the current board..
	 */
	public IBoard getBoard()
	{
		return theBoard;
	}
	
	/**
	 * Returns the marker of the current player.
	 * 
	 * @return true if the game is over, false otherwise.
	 */
	public IMarker getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	
	//------------------------------------------
	// Private Helper Methods
	//------------------------------------------
	/**
	 * Switches the current player to the next player.
	 */
	private void nextPlayer()
	{
		if(currentPlayer.compareTo(player1) == 0)
		{
			currentPlayer = player2;
		}
		else
		{
			currentPlayer = player1;
		}
	}
}
