package presentation;

import java.awt.Color;
/**
 * Specialized Cell panel to be used as a header row.
 * This panel has a white background and no border.
 * 
 * @author Michael J. Holmes
 * @version 1.0 April 4, 2015
 */
public class HeaderCellPanel extends CellPanel 
{

	public HeaderCellPanel() 
	{
		super(-1,-1,null);
		this.setBorder(null);
		this.setBackground(Color.white);
	}


}
