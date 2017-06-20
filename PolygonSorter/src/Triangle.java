/**
 * Created by Tanner on 10/30/2015.
 */
public class Triangle implements IPolygon {

    private float sideA;
    private float sideB;
    private float sideC;

    public Triangle(){

        sideA = 2;
        sideB = 2;
        sideC = 2;
    }

    public Triangle(float someA, float someB, float someC){

        sideA = someA;
        sideB = someB;
        sideC = someC;

    }

    public int numberOfSides(){

        return 3;

    }

    public float perimeter(){

        return sideA + sideB + sideC;

    }

    public float area(){

        float s;
        s = perimeter() / 2;
        float x = s * (s - sideA) * (s - sideB) * (s - sideC);

        return (float) Math.sqrt(x);

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

    public String getSides() {

        return (sideA + "," + sideB + "," + sideC);

    }

}

