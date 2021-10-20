import edu.duke.Point;
/**
 * Write a description of KivaConstructorTest here.
 * 
 * @author (James Dobson) 
 * @version (a version number or a date)
 */
public class KivaConstructorTest {
    String defaultLayout = ""
            + "-------------\n"
            + "        P   *\n"
            + "   **       *\n"
            + "   **       *\n"
            + "  K       D *\n"
            + " * * * * * **\n"
            + "-------------\n";

    FloorMap defaultMap = new FloorMap(defaultLayout);

    public void testSingleArgumentConstructor() {
        Kiva kiva = new Kiva(defaultMap);
        Point initialLocation = kiva.getCurrentLocation();
        Point expectedLocation = new Point(2, 4);
        if (sameLocation(initialLocation, expectedLocation)) {
            System.out.println("testSingleArgumentConstructor SUCCESS");
        } else {
            System.out.println(String.format("testSingleArgumentConstructor FAIL: %s != (2,4)!", initialLocation));
        }
    }


    public void testTwoArgumentConstructor() {

        Point point = new Point(5, 6);

        Kiva kiva = new Kiva(
                defaultMap,
                point
        );

        Point initialLocation = kiva.getCurrentLocation();
        if (sameLocation(initialLocation, point)) {
            System.out.println("testTwoArgumentConstructor SUCCESS");
        } else {
            System.out.println(String.format("testTwoArgumentConstructor FAIL: %s != (5,6)!", initialLocation));
        }
    }

    private boolean sameLocation(Point a, Point b) {
        return a.getX() == b.getX() && a.getY() == b.getY();
    }


    public static void main(String[] args) {
        KivaConstructorTest constructorTester = new KivaConstructorTest();
        constructorTester.testTwoArgumentConstructor();
        constructorTester.testSingleArgumentConstructor();

    }


}
