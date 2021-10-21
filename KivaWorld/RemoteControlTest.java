import java.util.Arrays;
import edu.duke.Point;

/**
 * This class tests the moves made from the RemoteControl
 * class
 * 
 * @author (James) 
 * 
 */
public class RemoteControlTest {
    /**
     * Tests if convertToKivaCommands is able to convert a string of character
     * commands into KivaCommands.
     */
    public void testConvertToKivaCommands(){
        RemoteControl rc = new RemoteControl();
        
        System.out.println("TEST 1");
        String input = "FFFTRF";
        System.out.println(Arrays.toString(rc.convertToKivaCommands(input)));
        
        System.out.println("TEST 2"); //should throw exception 
        input = "B";
        System.out.println(Arrays.toString(rc.convertToKivaCommands(input)));
    }

}
