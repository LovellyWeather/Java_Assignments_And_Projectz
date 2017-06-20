/**
 * Created by Tanner on 10/30/2015.
 */
public class Trapezoid extends Quadrilateral {

    private float baseA;
    private float baseB;
    private float legC;
    private float legD;
    private float height;

    public Trapezoid(float someA, float someB, float someC, float someD, float someH){

        baseA = someA;
        baseB = someB;
        legC = someC;
        legD = someD;
        height = someH;

    }

    public float perimeter(){

        return baseA + baseB + legC + legD;

    }

    public float area(){

        float average;
        average = ((baseA * baseB) / 2);
        return average * height;
    }

    public int compareTo(IPolygon other) {

        if (this.area() > other.area()) {
            return 1;
        } else if (this.area() == other.area()) {
            return 0;
        }else {
            return -1;
        }
    }

    public String getTrapSides() {

        return (baseA + "," + baseB + "," + legC + "," + legD + "," + height);

    }
}
