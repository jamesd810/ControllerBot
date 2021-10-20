import edu.duke.Point;
/**
 * This Kiva class contains the floor map along with 
 * instance variables and getter methods for making moves.
 * @author (James) 
 */
public class Kiva {
    private Point currentLocation;
    private FacingDirection directionFacing;
    private FloorMap map;
    private boolean carryingPod;
    private boolean successfullyDropped;
    private long motorLifetime;
       
    /**
     * Kiva robot instance using a FloorMap.
     * It includes the starting location of 
     * the robot, location of the boundaries, obstacles, pod and drop-zone.
     */
    public Kiva(FloorMap map){
        this.currentLocation = map.getInitialKivaLocation();
        this.directionFacing = FacingDirection.UP;
        this.map = map;
        this.carryingPod = false;
        this.successfullyDropped = false;
        this.motorLifetime = 0;
    }
    
    /**
     * 
     * Kiva robot instance using a @param FloorMap and a Point to set 
     * the starting location (currentLocation) of the robot.
     * Includes the locations of the Kiva robot, 
     * drop-zone, obstacles, pod, and boundaries.
     */
    public Kiva(FloorMap map, Point currentLocation){
        this.currentLocation = currentLocation;
        this.directionFacing = FacingDirection.UP;
        this.map = map;
        this.carryingPod = false;
        this.successfullyDropped = false;
        this.motorLifetime = 0;
    }
    
    /**
     * The @param KivaCommand the robot receives, the move method will update the 
     * current location and the direction the robot is facing. 
     * Method also determines whether the robot is carrying a pod or if it has been dropped.
     * The parameter command KivaCommand that indicates the specific movement the 
     * Kiva robot should perform: forward, turn left, turn right, take, or drop.
     */
    public void move(KivaCommand command){
        if (command.getDirectionKey()=='F'){
            moveForward();
        }
        else if (command.getDirectionKey()=='L'){
            turnLeft();
        }
        else if (command.getDirectionKey()=='R'){
            turnRight();
        }
        else if (command.getDirectionKey()=='T'){
            take();
        }
        else if (command.getDirectionKey()=='D'){
            drop();
        }
    }
    
    //METHODS for move KivaCommand command method
    private void moveForward() {
        Point curDir = this.directionFacing.getDelta();
        //Condition for if facing up. Robot moves once space up
        if (curDir.getX()==0 && curDir.getY()==-1){
            Point newLoc = new Point(this.currentLocation.getX(), this.currentLocation.getY()-1);
            FloorMapObject mapObj = this.map.getObjectAtLocation(newLoc);
            this.handleExceptions(newLoc, mapObj);
            this.currentLocation = newLoc;
        }
        //Condition for when facing left. Robot moves once space left.
        else if (curDir.getX()==-1 && curDir.getY()==0){
            Point newLoc = new Point(this.currentLocation.getX()-1, this.currentLocation.getY());
            FloorMapObject mapObj = this.map.getObjectAtLocation(newLoc);
            this.handleExceptions(newLoc, mapObj);
            this.currentLocation = newLoc;
        }
        //COndition for when facing down. Robot moves down one space.
        else if (curDir.getX()==0 && curDir.getY()==1){
            Point newLoc = new Point(this.currentLocation.getX(), this.currentLocation.getY()+1);
            FloorMapObject mapObj = this.map.getObjectAtLocation(newLoc);
            this.handleExceptions(newLoc, mapObj);
            this.currentLocation = newLoc;
        }
        //Condition for if facing right. Robot moves one space right.
        else if (curDir.getX()==1 && curDir.getY()==0){
            Point newLoc = new Point(this.currentLocation.getX()+1, this.currentLocation.getY());
            FloorMapObject mapObj = this.map.getObjectAtLocation(newLoc);
            this.handleExceptions(newLoc, mapObj);
            this.currentLocation = newLoc;
        }
        this.incrementMotorLifetime();
        this.successfullyDropped = false;
    }
            
    //Handle exceptions for moveForward() methods
    private void handleExceptions(Point newLoc, FloorMapObject mapObj){
        //Exception thrown when robot moves off the map
        if ((newLoc.getX() > map.getMaxColNum()) ||
                newLoc.getY() > map.getMaxRowNum()){
            throw new IllegalMoveException(String.format("Can't MOVE: location %s "+
            "is off the map!", newLoc));
        }
        //Exception thrown if robot hits OBSTACLE
        else if (mapObj == FloorMapObject.OBSTACLE){
            throw new IllegalMoveException(String.format("Can't MOVE FORWARD: "+
            "location %s has an %s, hence not EMPTY!", this.currentLocation, mapObj));
        }
    }
    
    /**
     * Robot's direction will turn to the left.  
     */
    public void turnLeft() {
        Point curDir = this.directionFacing.getDelta();
        //Condition for when facing left. Robot moves LEFT.
        if (curDir.getX()==0 && curDir.getY()==-1){
            this.directionFacing = FacingDirection.LEFT;
        }
        //Condition when facing left. Robot moves DOWN
        else if (curDir.getX()==-1 && curDir.getY()==0){
            this.directionFacing = FacingDirection.DOWN;
        }
        //Condition when facing down. Robot moves RIGHT
        else if (curDir.getX()==0 && curDir.getY()==1){
            this.directionFacing = FacingDirection.RIGHT;
        }
        //Condition when facign rigiht. Robot moves UP.
        else if (curDir.getX()==1 && curDir.getY()==0){
            this.directionFacing = FacingDirection.UP;
        }
        this.incrementMotorLifetime();
        this.successfullyDropped = false;
    }
    
    /**
     * Kiva object's direction will turn to the right. 
     */
    public void turnRight() {
        Point curDir = this.directionFacing.getDelta();
        //WHEN FACING UP --> RIGHT
        if (curDir.getX()==0 && curDir.getY()==-1){
            this.directionFacing = FacingDirection.RIGHT;
        }
        //WHEN FACING LEFT --> UP
        else if (curDir.getX()==-1 && curDir.getY()==0){
            this.directionFacing = FacingDirection.UP;
        }
        //WHEN FACING DOWN --> LEFT
        else if (curDir.getX()==0 && curDir.getY()==1){
            this.directionFacing = FacingDirection.LEFT;
        }
        //WHEN FACING RIGHT --> DOWN
        else if (curDir.getX()==1 && curDir.getY()==0){
            this.directionFacing = FacingDirection.DOWN;
        }
        this.incrementMotorLifetime();
        this.successfullyDropped = false;
    }
    
    /**
     * Kiva method for taking a pod. 
     * Method will throw a NoPodException if robot is already holding a pod 
     * or, if there is no pod at currentLocation.
     */
    public void take() {
        FloorMapObject mapObj = this.map.getObjectAtLocation(this.currentLocation);
        
        if (mapObj != FloorMapObject.POD || this.carryingPod == true){
            throw new NoPodException(String.format("Can't TAKE: location %s is %s, "+
            "not POD!", this.currentLocation, mapObj));
        }
        this.carryingPod = true;
        this.successfullyDropped = false;
    }
    
    /**
     * Kiva method for dropping a pod. 
     * This will throw a IllegalMoveException if it is not holding a pod at the 
     * time of the drop or, an IllegalDropZoneException if it is not 
     * at a drop-zone location.
     */
    public void drop() {
        FloorMapObject mapObj = this.map.getObjectAtLocation(this.currentLocation);
        // Exception if robot tries to drop pod when it is not holding a pod
        if (this.carryingPod == false){
            throw new IllegalMoveException(String.format("Can't DROP: currently "+
            "not holding a pod."));
        }
        //Exception if robot tries to drop pod in a non-drop-zone location
        else if (mapObj != FloorMapObject.DROP_ZONE){
            throw new IllegalDropZoneException(String.format("Can't DROP: "+
            "location %s is %s not a DROP_ZONE!", this.currentLocation, mapObj));
        }
        this.successfullyDropped = true;
        this.carryingPod = false;
    }
    
    /**
     * Adds 1000 milliseconds (1 second) to the motorLifetime
     */
    public void incrementMotorLifetime(){
        this.motorLifetime = this.motorLifetime + 1000;
    }
    
    //End of helper methods
    
    //Getter methods
    /**
     * Returns the current location of the Kiva object
     * in the form of x, y coordianate.
     */
    protected Point getCurrentLocation(){
        return this.currentLocation;
    }
    
    /**
     * Returns the direction that the Kiva object is facing on the map:
     * UP, DOWN, LEFT, RIGHT.
     */
    protected FacingDirection getDirectionFacing(){
        return this.directionFacing;
    }
    
    /**
     * Returns the map which the robot is using to navigate.
     */
    protected FloorMap getMap(){
        return this.map;
    }
    
    /**
     * Returns true if robot is carrying the pod and false if not.
     */
    public boolean isCarryingPod(){
        return this.carryingPod;
    }
    
    /**
     * Returns true if robot successfully dropped the pod and false if not.
     */
    public boolean isSuccessfullyDropped(){
        return this.successfullyDropped;
    }
    
    /**
     * Returns the motorLifetime utilized by the Kiva, measured in milliseconds.
     */
    public long getMotorLifetime(){
        return this.motorLifetime;
    }
}
