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
public class Marker implements IMarker 
{
	//----------------------------
	// Instance Variables
	//----------------------------
	Color markerColor;

	
	//----------------------------
	// Constructors
	//----------------------------
	/**
	 * Constructs a marker with the inputed color.
	 * @param aColor the color of the marker.
	 */
	public Marker(Color aColor) 
	{
		markerColor = aColor;
	}
	
	/**
	 * Compares the marker to another color based on the RGB value of its
	 * color.
	 * 
	 * @return negative value if the color is less, 0 if it is the same and positive value if it is greater than.
	 */

	public int compareTo(IMarker other) 
	{
		return markerColor.getRGB() - other.getColor().getRGB();
	}

	/**
	 * Returns the color of the marker.
	 * 
	 * @return the color of the marker.
	 */
	public Color getColor() 
	{
		return markerColor;
	}

}
