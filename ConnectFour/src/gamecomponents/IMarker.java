package gamecomponents;

import java.awt.Color;

/**
 * The marker class represents a marker game piece with a color.
 * Two markers can be compared.
 * 
 * @author Michael J. Holmes
 * @version 1.0 April 4, 2015
 *
 */
public interface IMarker extends Comparable<IMarker> 
{
	/**
	 * Returns the color of the marker.
	 * 
	 * @return the color of the marker.
	 */
	public Color getColor();
}
