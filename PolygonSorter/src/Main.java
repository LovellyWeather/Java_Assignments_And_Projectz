import java.io.IOException;
import java.io.FileWriter;

/**
 * Created by Tanner on 11/4/2015.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        SortableShapes outputFile = new SortableShapes("C:\\Users\\Tanner\\IdeaProjects\\PolygonSorter\\src\\PolygonDataInput.txt");

        //System.out.println(outputFile.convertShapeList());


        for (int i = 0; i < outputFile.convertShapeList().size(); i++) {

            System.out.println(outputFile.convertShapeList().get(i));

        }

        FileWriter fileOut;
        String fileName = new String("C:\\Users\\Tanner\\IdeaProjects\\PolygonSorter\\src\\PolygonDataOutput.txt");

        try {

            fileOut = new FileWriter(fileName);

            for (int j = 0; j < outputFile.convertShapeList().size(); j++) {
                fileOut.write(outputFile.convertShapeList().get(j) + "\n");
            }

            fileOut.close();

        } catch (IOException e) {

            throw e;

        }

    }

}