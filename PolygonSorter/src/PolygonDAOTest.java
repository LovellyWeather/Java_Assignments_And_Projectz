import junit.framework.TestCase;
import java.util.ArrayList;

/**
 * Created by Tanner on 11/2/2015.
 */
public class PolygonDAOTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testLoadPolygons() throws Exception {

        PolygonDAO myDAO = new PolygonDAO("C:\\Users\\Tanner\\IdeaProjects\\PolygonSorter\\src\\PolygonDataInput.txt");

        ArrayList<String> dataFile = myDAO.loadPolygons();

        ArrayList<IPolygon> shapeList = new ArrayList<>();

        String currentLine;

        System.out.println(dataFile);

        System.out.print(dataFile.get(0));

        for (int i=0; i<dataFile.size(); i++) {

            currentLine = dataFile.get(i);
            currentLine.split(",");
            if (currentLine.contains("Square")) {



            }



        }








    }
}