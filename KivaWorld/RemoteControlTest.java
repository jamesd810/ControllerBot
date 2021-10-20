import java.util.Arrays;
import edu.duke.Point;

/**
 * Write a description of RemoteControlTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
