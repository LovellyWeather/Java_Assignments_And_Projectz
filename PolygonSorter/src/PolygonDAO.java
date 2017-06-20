/**
 * Created by Tanner on 11/2/2015.
 */
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;



public class PolygonDAO {

    private String fileName;

    public PolygonDAO(String myFilePath){

        fileName = myFilePath;

    }

    public ArrayList<String> loadPolygons() throws IOException{

        Scanner fileIn;
        String line;
        String[] values;
        Collections listCollection;
        ArrayList polygons = new ArrayList<IPolygon>();

        try {

            fileIn = new Scanner(new FileInputStream(fileName));

            while ( fileIn.hasNext() ){

                line = fileIn.nextLine();

                line.split(",");

                polygons.add(line);

            }
            fileIn.close();

        }
        catch (IOException e) {

            throw e;

        }

        return polygons;

    }


}
