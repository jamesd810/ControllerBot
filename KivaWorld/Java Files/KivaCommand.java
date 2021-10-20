import edu.duke.FileResource;
/**
 * Write a description of Directions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

    public enum KivaCommand {
    FORWARD('F'),
    TURN_LEFT('L'),
    TURN_RIGHT('R'),
    TAKE('T'),
    DROP('D');
    
    char directionKey;
    
    private KivaCommand(char directionKey){
        this.directionKey = directionKey;
    }
    
    /**
     * Returns the char associated with its KivaCommand.
     * Direction Keys: 'F','L','R','T','D'.
     */
    public char getDirectionKey(){
        return this.directionKey;
    }
 }

