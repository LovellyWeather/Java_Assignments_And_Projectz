/**
 * Created by Tanner on 10/30/2015.
 */
public class Square extends Rectangle {

    private float someLength;

    public Square(){

        new Rectangle(2, 2);
    }

    public Square(float aLength){

        someLength = aLength;
        new Rectangle(aLength, aLength);

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

    public float getLength() {

        return  someLength;

    }
}
