/**
 * Created by Tanner on 10/30/2015.
 */
public class Rectangle extends Quadrilateral {

    private float lengthA;
    private float lengthB;

    public Rectangle(){

        lengthA = 3;
        lengthB = 2;
    }

    public Rectangle(float someA, float someB){

        lengthA = someA;
        lengthB = someB;

    }

    public float perimeter(){

        return (lengthA * 2) + (lengthB * 2);

    }

    public float area(){

        return lengthA * lengthB;

    }

    public int compareTo(IPolygon other){

        if (this.area() > other.area()) {
            return 1;
        } else if (this.area() == other.area()) {
            return 0;
        }else {
            return -1;
        }
    }

    public float getLengthA() {

        return lengthA;

    }

    public float getLengthB() {

        return lengthB;

    }
}
