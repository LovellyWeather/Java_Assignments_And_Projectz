import static org.junit.Assert.*;

/**
 * Created by Tanner on 12/1/2015.
 */
public class BinarySearchTreeTest {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testInsert() throws Exception {


        BinarySearchTree testTree = new BinarySearchTree();

        testTree.insert(1);
        testTree.insert(2);
        testTree.insert(5);

        System.out.println(testTree);

    }
}