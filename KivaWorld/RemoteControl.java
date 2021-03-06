import edu.duke.FileResource;

/**
 * This is the class that controls Kiva's actions. Implement the <code>run()</code>
 * method to deliver the pod and avoid the obstacles.
 *
 * This is starter code that may or may not work. You will need to update the code to
 * complete the project.
 */
public class RemoteControl {
    KeyboardResource keyboardResource;

    /**
     * Build a new RemoteControl.
     */
    public RemoteControl() {
        keyboardResource = new KeyboardResource();
    }

    /**
     * The controller that directs Kiva's activity. Prompts the user for the floor map
     * to load, displays the map, and asks the user for the commands for Kiva to execute.
     *
     * [Here's the method you'll execute from within BlueJ. It may or may not run successfully
     * as-is, but you'll definitely need to add more to complete the project.]
     */
    public void run() {
        System.out.println("Please select a map file.");
        FileResource fileResource = null;
        String inputMap = fileResource.asString();
        FloorMap floorMap = new FloorMap(inputMap);
        System.out.println(floorMap);

        System.out.println("Please enter the directions for the Kiva Robot to take.");
        String directions = keyboardResource.getLine();
        System.out.println("Directions that you typed in: " + directions);
    }
    
    public KivaCommand[] convertToKivaCommands(String userCommands){
        KivaCommand[] commandsToExecute = new KivaCommand[userCommands.length()];
        KivaCommand[] commandChoices = KivaCommand.values();
        int i = 0;
        
        //Loop that iterates over each letter of the string
        for (char directionKey : userCommands.toCharArray()){
            //Iterates over each KivaCommand to find which directionKey the letter matches. 
           
            for (KivaCommand command : commandChoices){
                if (directionKey == command.getDirectionKey()){
                    commandsToExecute[i] = command;
                    break;
                }
            }
            
            if (commandsToExecute[i] == null){
                throw new IllegalArgumentException("Character \'"+directionKey+
                "\' does not correspond to a command!");
            }
            i++;
        }
        
        return commandsToExecute;
    }
 }


    
    
