package presentation;

import java.awt.Color;

import gamecomponents.ColumnFullException;
import gamecomponents.FourInARowBoard;
import gamecomponents.Marker;

public class FourInARowApp 
{

public static void main(String[] args)
{
	FourInARowBoard board = new FourInARowBoard();
	GameFrame myFrame = new GameFrame(600, board);
	
	myFrame.setVisible(true);
	
}

}
