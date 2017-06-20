import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * Created by Tanner on 11/4/2015.
 */
import java.util.ArrayList;

public class SortableShapes {

    private String nameOfFile;

    public SortableShapes(String fileLocation) {

        nameOfFile = fileLocation;

    }

    public ArrayList<String> convertShapeList() throws IOException {

        PolygonDAO myDAO = new PolygonDAO(nameOfFile);

        ArrayList<String> dataFile = myDAO.loadPolygons();

        ArrayList<IPolygon> shapeList = new ArrayList<>();

        ArrayList<String> sortedFile = new ArrayList<>();

        String currentLine;

        for (int i=0; i<dataFile.size(); i++) {

            currentLine = dataFile.get(i);
            String[] lineArray = currentLine.split(",");

            if (currentLine.contains("Square")) {

                Float squareLength = Float.parseFloat(lineArray[1]);
                shapeList.add(new Square(squareLength));

            } else if (currentLine.contains("Rectangle")) {

                Float recLengthA = Float.parseFloat(lineArray[1]);
                Float recLengthB = Float.parseFloat(lineArray[2]);
                shapeList.add(new Rectangle(recLengthA, recLengthB));

            } else if (currentLine.contains("Trapezoid")) {

                Float trapLengthA = Float.parseFloat(lineArray[1]);
                Float trapLengthB = Float.parseFloat(lineArray[2]);
                Float trapLengthC = Float.parseFloat(lineArray[3]);
                Float trapLengthD = Float.parseFloat(lineArray[4]);
                Float trapLengthE = Float.parseFloat(lineArray[5]);
                shapeList.add(new Trapezoid(trapLengthA, trapLengthB, trapLengthC, trapLengthD, trapLengthE));

            } else if (currentLine.contains("Triangle")) {

                Float triLengthA = Float.parseFloat(lineArray[1]);
                Float triLengthB = Float.parseFloat(lineArray[2]);
                Float triLengthC = Float.parseFloat(lineArray[3]);
                shapeList.add(new Triangle(triLengthA, triLengthB, triLengthC));

            }
        }
        Collections.sort(shapeList);

        for (int j=0; j<shapeList.size(); j++ ) {
            IPolygon aShape = shapeList.get(j);
            if (aShape instanceof Square) {

                sortedFile.add("Square," + ((Square) aShape).getLength());

            }else if (aShape instanceof Rectangle) {

                sortedFile.add("Rectangle," + ((Rectangle) aShape).getLengthA() + "," + ((Rectangle) aShape).getLengthB());

            }else if (aShape instanceof Triangle) {

                sortedFile.add("Triangle," + ((Triangle) aShape).getSides());

            }else if (aShape instanceof Trapezoid) {

                sortedFile.add("Trapezoid," + ((Trapezoid) aShape).getTrapSides());

            }


        }
        return sortedFile;

    }
}
