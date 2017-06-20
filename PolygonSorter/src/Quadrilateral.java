/**
 * Created by Tanner on 10/30/2015.
 */
public abstract class Quadrilateral implements IPolygon {

    public int numberOfSides() {

        return 4;

    }

    public abstract float perimeter();

    // calculates and returns perimeter of a quadrilateral

    public abstract float area();

    //calculate and return the area of the quadrilateral

}
