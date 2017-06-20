package presentation;

import gamecomponents.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Creates a window with a Four in a Row game.
 *
 * @author Michael J. Holmes
 * @version 1.0  April 4, 2015
 *
 *
 *  NOTE: Some of the code has been removed for a learning task.
 *        You will need to:
 *              implement buildMenuBar method.
 *              implement buildBoardMenu method.
 *              implement buildGameMenu method.
 *              implement BoardSizeListener inner class.
 *              implement NewGameListener inner class.
 */
public class GameFrame extends JFrame
{
    //---------------------------------------
    // Instance Variables
    //---------------------------------------
    private BoardPanel game;
    private JMenuBar menuBar;
    private JMenu boardMenu, gameMenu;
    private JMenuItem board6x5MenuItem,board7x6MenuItem,board14x12MenuItem, newGameMenuItem;


    //---------------------------------------
    // Constructors
    //---------------------------------------
    /**
     * Constructor that creates a frame of a specific size with a board of
     * with specific dimensions.
     *
     * @param frameSize the desired size in pixels of the frame.
     * @param numRows the desired number of rows of the board.
     * @param numCols the desired number of columns of the board.
     */
    public GameFrame(int frameSize, IBoard aBoard)
    {

    	buildMenuBar();
        this.add("North",menuBar);

        this.setSize(new Dimension(frameSize,frameSize));

        game = new BoardPanel();
        this.add(game);
    }



    /**
     * Paints the frame.
     * @param g Graphics object to use for painting.
     */
    public void paint( Graphics g )
    {
    	super.paint(g);
    }

    //---------------------------------------------------
    // Private helper methods and inner classes
    //---------------------------------------------------
    /**
     * Builds the menu bar for the frame.
     */
    private void buildMenuBar()
    {
        //You need to instantiate the menuBar
        menuBar = new JMenuBar();





        //Call buildBoardMenu and add the boardMenu to the menuBar
        buildBoardMenu();
        menuBar.add(boardMenu);




        //Call buildGameMenu and add the gameMenu to the menuBar
        buildGameMenu();
        menuBar.add(gameMenu);




    }

    /**
     * Builds the Board menu for the frame.
     */
    private void buildBoardMenu()
    {
        //Instantiate boardMenu with a "Board" description.
        boardMenu = new JMenu("Board");




        //Instantiate the board6x5MenuItem as "Small" and add an action listener for a 6x5 board.
        board6x5MenuItem = new JMenuItem("Small");
        board6x5MenuItem.addActionListener(new BoardSizeListener(6,5));




        //Instantiate the board7x6MenuItem as "Medium" and add an action listener for a 7x6 board.
        board7x6MenuItem = new JMenuItem("Medium");
        board7x6MenuItem.addActionListener(new BoardSizeListener(7,5));




        //Instantiate the board14x12MenuItem as "Large" and add an action listener for a 14x12 board.
        board14x12MenuItem = new JMenuItem("Large");
        board14x12MenuItem.addActionListener(new BoardSizeListener(14,12));





        //Add the three menuItems to the boardMenu
        boardMenu.add(board6x5MenuItem);
        boardMenu.add(board7x6MenuItem);
        boardMenu.add(board14x12MenuItem);

        
        
        

    }

    /**
     * Builds the Game menu for the frame.
     */
    private void buildGameMenu()
    {
        //Instantiate the gameMenu with a "Game" description.
        gameMenu = new JMenu("Game");




        //Instantiate the newGameMenuItem as "New" and add a NewGameListener action listener.
        newGameMenuItem = new JMenuItem("New");
        newGameMenuItem.addActionListener(new NewGameListener());



        //Add newGameMenuItem to the gameMenu
        gameMenu.add(newGameMenuItem);




    }


    private class BoardSizeListener implements ActionListener
    {
    	private int newRows;
    	private int newCols;

    	public BoardSizeListener(int numRows, int numCols)
    	{
    		//initialize the instance variables with the provided parameters.
    		newRows = numRows;
            newCols = numCols;
    		


    	}

    	/**
    	 * When the click event occurs, get the next generation and
    	 * update the display.
    	 */
        public void actionPerformed(ActionEvent e)
        {
                //Remove the current boardPanel object from the GameFrame.

                GameFrame.this.remove(game);

                //instantiate game as new BoardPanel ojbect with the new dimensions,
                //and add it to the GameFrame
                game = new BoardPanel(newRows, newCols);
                add(game);






                //Validate and repaint the GameFrame.
        	GameFrame.this.validate();
        	GameFrame.this.repaint();
        }
    }

    private class NewGameListener implements ActionListener
    {

    	/**
    	 * When the click event occurs, get the next generation and
    	 * update the display.
    	 */
        public void actionPerformed(ActionEvent e)
        {
            //Send a message to game to create a new game.
        	game.newGame();
        	
        	//Validate and repaint the GameFrame.
        	GameFrame.this.validate();
            GameFrame.this.validate();
        	

        	
        	

        }
    }

}
