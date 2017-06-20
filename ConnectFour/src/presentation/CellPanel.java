package presentation;

import java.awt.*;
import javax.swing.*;


/**
 * A CellPanel represents a single cell in the Game of Life board.
 * Live cells will be colored and dead cells will be white.
 *
 * @author Michael J. Holmes
 * @version 1.0 April 4, 2015
 *
 *  NOTE: Some of the code has been removed for a learning task.
 *        You will need to:
 *              implement getColumn.
 *              implement getRow.
 *              implement clearCell.
 *              implement setDisk.
 *              implement paintComponent.
 */
public class CellPanel extends JPanel
{
    //--------------------------------
    // Instance Variables
    //--------------------------------
    private Disk disk;
    private int col;
    private int row;


    //-------------------------------
    // Constructors
    //-------------------------------
    /**
     * Constructor to create a cell at the x,y coordinate without a disk.
     * @param x the column of cell
     * @param y the row of the cell
     */
    public CellPanel(int x, int y)
    {
        this(x,y,null);
    }


    /**
     * Constructor to create a cell at the x,y coordinate with a disk.
     * Allows a color to be used if there is a preferred color.
     *
     * @param x the column of cell
     * @param y the row of the cell
     * @param aDisk disk to add to the cell.
     */
    public CellPanel(int x, int y, Disk aDisk)
    {
    	super();

        col = x;
        row = y;
        disk = aDisk;

        this.setBorder(BorderFactory.createLineBorder(Color.black,1));
    }



    //--------------------------------
    //  Class Methods
    //--------------------------------

    /**
     * Get's the x or column of the cell.
     * @return the column the cell is in.
     */
    public int getColumn()
    {
    	//Need to implement.
        return col;


    }

    /**
     * Get's the y or row of the cell.
     * @return the row the cell is in.
     */
    public int getRow()
    {
    	//Need to implement.
        return row;


    }


    public void clearCell()
    {
    	//Need to implement.
        disk = null;


    }

    public void setDisk(Disk aDisk)
    {
    	//Need to implement.
        disk = aDisk;


    }



    /**
     * Paints the cell to the screen.
     * @param g the graphics object to use in drawing to the screen.
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
     	if (disk != null)
     	{
            //The board may have changed size, so we need to update the disk.
                int newRadius = Math.min(this.getWidth(), this.getHeight()) /2 -4;
     		int newX = (this.getWidth() - (newRadius * 2)) / 2;
     		int newY = (this.getHeight() - (newRadius * 2)) / 2;

            //Move the disk to the new x,y coordinates.
            disk.moveTo(newX, newY);
            //Set the radius of the disk to the new radius
            disk.setRadius(newRadius);


            //paint the disk.
            disk.paint(g);


     	}
    }


}
