package gamecomponents;

public interface IGameRule 
{
	/**
	 * Returns if the game is over.
	 * 
	 * @param theBoard the board to check for a game over state.
	 * @return true if the game is over, false otherwise.
	 */
	public boolean isGameOver(IBoard theBoard);
	
	/**
	 * Returns if the game is a tie.
	 * 
	 * @param theBoard the board to check for a tie state.
	 * @return true if the game is a tie, false otherwise.
	 */
	public boolean isTie(IBoard theBoard);
	
	/**
	 * Returns if the game is in a win state..
	 * 
	 * @param theBoard the board to check for a win state.
	 * @return true if the game is a win, false otherwise.
	 */
	public boolean isWinner(IBoard theBoard);
	
	/**
	 * Returns the marker of the winning player.
	 * 
	 * @param theBoard the board to check get the winner for.
	 * @return the Marker of the winning player, or null if there is none.
	 */
	public IMarker getWinner(IBoard theBoard);
}
