/**
 * Created by Tanner on 10/30/2015.
 */
public interface IPolygon extends Comparable<IPolygon> {

    public int numberOfSides();

    public float perimeter();

    public float area();

    public int compareTo(IPolygon other);
}
