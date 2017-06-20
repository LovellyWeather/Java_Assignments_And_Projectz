package presentation;

import gamecomponents.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * The BoardPanel provides a visual representation of the Four in a row Board.
 *
 * @author Michael J. Holmes
 * @version 1.0 April 4, 2015
 *
 *  NOTE: Some of the code has been removed for a learning task.
 *        You will need to:
 *              implement newGame method.
 *              implement updateDisplay method.
 *              implement paintComponent method.
 *              implement the ColumnListener inner class.
 */
@SuppressWarnings("serial")
public class BoardPanel extends JPanel
{
        //--------------------------------
        // Instance Variables
        //--------------------------------
        private int numOfCols;
        private int numOfRows;
        private CellPanel[][] display;
        private FourInARowGame game;
        private JPanel gameBoardPanel;
        private JLabel message;



        //-------------------------------
        // Constructors
        //-------------------------------
        /**
         * Constructs a BoardPanel with the starting 7x6 Board.
         */
        public BoardPanel()
        {
        	this(7, 6);
        }

        /**
         * Constructs a BoardPanel with the starting Board with the inputed dimensions.
         * @param numRows the number of rows the board should have.
         * @param numCols the number of columns the board should have.
         */
        public BoardPanel(int numRows, int numCols)
        {
            // Call constructor from the JPanel class.
        	super();

            // Initialize instance variables.
            game = new FourInARowGame(numRows, numCols);
            numOfCols = game.getBoard().getNumberOfColumns();
            numOfRows = game.getBoard().getNumberOfRows();
            display = new CellPanel[numOfRows][numOfCols];

            // Set JPanel layout.
            this.setLayout(new BorderLayout());
            gameBoardPanel= new JPanel(new GridLayout(numOfRows+1, numOfCols));

            //Initialize the header row.
            CellPanel columnHeaderPanel;
            for(int col=0; col < numOfCols; col++)
            {
            	columnHeaderPanel = new HeaderCellPanel();
            	columnHeaderPanel.addMouseListener(new ColumnListener(col));
            	gameBoardPanel.add(columnHeaderPanel);
            }

            //Initialize the Display Board
            for (int row = 0; row < numOfRows; row++)
            	for(int col = 0; col < numOfCols; col++)
            	{
            		display[row][col] = new CellPanel(row, col);
            		gameBoardPanel.add(display[row][col]);
            	}
            this.add("Center", gameBoardPanel);

            message = new JLabel(" ");
            message.setFont(new Font("Serif", Font.BOLD, 24));
            this.setBackground(Color.white);
            this.add("North", message);
            updateDisplay();
        }
        //--------------------------------
        //  Class Methods
        //--------------------------------

        /**
         * Restarts the  board to a new game.
         */
        public void newGame()
        {
            //reset the game
            game.reset();


            //set the message to " "
            message.setText(" ");


            //call updateDisplay
            updateDisplay();


        }
        /**
         * Updates and rebuilds the board to display the current state of the board.
         */
        private void updateDisplay() {

            //Loop through the rows and cols of the diplay array adding the appropriate Disks 
            //   to make the display match the current state of the board.
            //   Remember to clear your display cell if it is empty on the board.
            for (int row = 0; row < numOfRows; row++) {
                for (int col = 0; col < numOfCols; col++) {
                    try {
                        display[row][col].setDisk(new Disk(0,0,10, game.getBoard().getMarker(row, col).getColor()));
                    } catch (EmptyCellException e) {
                        display[row][col].clearCell();
                    }
                }
            }

            this.revalidate();
        }

        /**
         * Paints the board.
         */
        public void paintComponent(Graphics g)
        {
            //call the paintComponent method from JPanel
            super.paintComponent(g);
            

            //If there is a winner, update message to display "Winner!" in the winner's color.
            // If there is a tie, update the message to display "Draw!" in black font.
           if (game.isWinner()){
               message.setForeground(game.getWinner().getColor());
               message.setText("Winner");
           }
            if (game.isTie()){
                message.setForeground(Color.black);
                message.setText("Draw!");
            }
        }




    //---------------------------------
    // Private helper classes
    //---------------------------------

        /**
         * A mouse listener to listen when a mouse is clicked on a column.
         * This also hovers a disk of the appropriate color above the row,
         * before the choice is made.
        */
        private class ColumnListener implements MouseListener
	    {
        	//--------------------------
        	// Instance Variables
        	//--------------------------
        	private int columnNumber;

        	//--------------------------
        	// Constructors
        	//--------------------------
        	/**
        	 * Constructs a listener and with the column number that it
        	 * is listening for.
        	 *
        	 * @param columnNum the number of the column.
        	 */
        	public ColumnListener(int columnNum)
        	{
        		super();
        		columnNumber = columnNum;
        	}

        	//--------------------------
        	// Class Methods
        	//--------------------------

        	/**
        	 * When the mouse is clicked, it makes the corresponding move
        	 * in the game.
        	 */
			public void mouseClicked(MouseEvent e)
			{
                                //if the game isn't over
                                if (!game.isGameOver()) {


                                    //     Identify which panel was clicked from the MouseEvent.
                                            HeaderCellPanel panel = (HeaderCellPanel) e.getSource();

                                    //     Set that panel's disk to null
                                            panel.setDisk(null);

                                    //     Send a message to the game to make a move on that column.
                                            game.makeMove(columnNumber);

                                    //     update the display
                                            updateDisplay();

                                    //     repaint the panel
                                            repaint();
                                }
			}

			/**
			 * When the mouse enters the panel hover a disk in the column header.
			 */
			public void mouseEntered(MouseEvent e)
			{

                                //If the game isn't over
                                if (!game.isGameOver()) {

                                    //    identify which panel the mouse entered from the MouseEvent
                                            HeaderCellPanel panel = (HeaderCellPanel) e.getSource();

                                    //    set that panel to have a new Disk that at 2,2 with a radius of 10
                                    //    in the current player's color.
                                            panel.setDisk(new Disk(2,2,10,game.getCurrentPlayer().getColor()));

                                    //     repaint the panel
                                            repaint();
                                }

			}

			/**
			 * When the mouse exits the panel, remove the hover disk.
			 */
			public void mouseExited(MouseEvent e)
			{

                                //If the game isn't over
                                if (!game.isGameOver()) {


                                    //    identify which panel the mouse exited from the MouseEvent
                                    HeaderCellPanel panel = (HeaderCellPanel) e.getSource();

                                    //    set that panel's disk to null
                                    panel.setDisk(null);

                                    //     repaint the panel
                                    panel.repaint();
                                }


			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

    }



}
