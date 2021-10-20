import edu.duke.Point;
/**
 * Write a description of KivaMoveTest here.
 * 
 * @author (James Dobson 
 */
public class KivaMoveTest {
// Define the FloorMap we'll use for all the tests
String defaultLayout = ""
+ "-------------\n"
+ " P *\n"
+ " ** *\n"
+ " ** *\n"
+ " K D *\n"
+ " * * * * * **\n"
+ "-------------\n";

FloorMap defaultMap = new FloorMap(defaultLayout);

/**Test
 * 
 */
public void testForwardFromUp() {
  
// GIVEN
// A Kiva built with the default map we defined earlier
Kiva kiva = new Kiva(defaultMap);

// WHEN
// We move one space forward
kiva.move(KivaCommand.FORWARD);
  
// THEN
// The Kiva has moved one space up
verifyKivaState("testForwardFromUp",
kiva, new Point(2, 3), FacingDirection.UP, false, false);
}
  
// For you: create all the other tests and call verifyKivaState() for each

private boolean sameLocation(Point a, Point b) {
return a.getX() == b.getX() && a.getY() == b.getY();
}

private void verifyKivaState(
String testName,
Kiva actual,
Point expectLocation,
FacingDirection expectDirection,
boolean expectCarry,
boolean expectDropped) {

Point actualLocation = actual.getCurrentLocation();
if (sameLocation(actualLocation, expectLocation)) {
System.out.println(
String.format("%s: current location SUCCESS", testName));
}
else {
System.out.println(
String.format("%s: current location FAIL!", testName));
System.out.println(
String.format("Expected %s, got %s",
expectLocation, actualLocation));
}

FacingDirection actualDirection = actual.getDirectionFacing();
if (actualDirection == expectDirection) {
System.out.println(
String.format("%s: facing direction SUCCESS", testName));
}
else {
System.out.println(
String.format("%s: facing direction FAIL!", testName));
System.out.println(
String.format("Expected %s, got %s",
expectDirection, actualDirection));
}

boolean actualCarry = actual.isCarryingPod();
if (actualCarry == expectCarry) {
System.out.println(
String.format("%s: carrying pod SUCCESS", testName));
}
else {
System.out.println(
String.format("%s: carrying pod FAIL!", testName));
System.out.println(
String.format("Expected %s, got %s",
expectCarry, actualCarry));
}

boolean actualDropped = actual.isSuccessfullyDropped();
if (actualDropped == expectDropped) {
System.out.println(
String.format("%s: successfully dropped SUCCESS", testName));
}
  
  
}

/**Test
 * 
 */
public void testTurnLeftFromUp() {
  
// GIVEN
// A Kiva built with the default map we defined earlier
Kiva kiva = new Kiva(defaultMap);

// WHEN
// We move one space forward
kiva.move(KivaCommand.TURN_LEFT);
  
// THEN
// The Kiva has moved one space up
verifyKivaState("testTurnLeftFromUp",
kiva, new Point(2, 4), FacingDirection.LEFT, false, false);
}
  
// For you: create all the other tests and call verifyKivaState() for each

public static void verifyKivaState(){

}

/**Test
 * 
 */
public void testTurnLeftFromLeft() {
  
// GIVEN
// A Kiva built with the default map we defined earlier
Kiva kiva = new Kiva(defaultMap);

// WHEN
// We move one space forward
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.TURN_LEFT);
  
// THEN
// The Kiva has moved one space up
verifyKivaState("testTurnLeftFromLeft",
kiva, new Point(2, 4), FacingDirection.DOWN, false, false);
}
  
// For you: create all the other tests and call verifyKivaState() for each
/**Test
 * 
 */
public void testTurnLeftFromDown() {
  
// GIVEN
// A Kiva built with the default map we defined earlier
Kiva kiva = new Kiva(defaultMap);

// WHEN
// We move one space forward
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.TURN_LEFT);
  
// THEN
// The Kiva has moved one space up
verifyKivaState("testTurnLeftFromDown",
kiva, new Point(2, 4), FacingDirection.RIGHT, false, false);
}

/**Test
 * 
 */
public void testTurnLeftFromRight() {
  
// GIVEN
// A Kiva built with the default map we defined earlier
Kiva kiva = new Kiva(defaultMap);

// WHEN
// We move one space forward
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.TURN_LEFT);
  
// THEN
// The Kiva has moved one space up
verifyKivaState("testTurnLeftFromRight",
kiva, new Point(2, 4), FacingDirection.UP, false, false);
}

/**Test
 * 
 */
public void testForwardWhileFacingLeft() {
  
// GIVEN
// A Kiva built with the default map we defined earlier
Kiva kiva = new Kiva(defaultMap);

// WHEN
// We move one space forward
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.FORWARD);
// THEN
// The Kiva has moved one space up
verifyKivaState("testForwardWhileFacingLeft",
kiva, new Point(1,4), FacingDirection.LEFT, false, false);
}

/**Test
 * 
 */
public void testForwardWhileFacingDown() {
  
// GIVEN
// A Kiva built with the default map we defined earlier
Kiva kiva = new Kiva(defaultMap);

// WHEN
// We move one space forward
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.FORWARD);
// THEN
// The Kiva has moved one space up
verifyKivaState("testForwardWhileFacingDown",
kiva, new Point(2,5), FacingDirection.DOWN, false, false);
}

/**Test
 * 
 */
public void testForwardWhileFacingRight() {
  
// GIVEN
// A Kiva built with the default map we defined earlier
Kiva kiva = new Kiva(defaultMap);

// WHEN
// We move one space forward
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.FORWARD);
// THEN
// The Kiva has moved one space up
verifyKivaState("testForwardWhileFacingRight",
kiva, new Point(3,4), FacingDirection.RIGHT, false, false);
}

/**Test
 * 
 */
public void testTurnRightFromUp() {
  
// GIVEN
// A Kiva built with the default map we defined earlier
Kiva kiva = new Kiva(defaultMap);

// WHEN
// We move one space forward
kiva.move(KivaCommand.TURN_RIGHT);

// THEN
// The Kiva has moved one space up
verifyKivaState("testTurnRightFromUp",
kiva, new Point(2,4), FacingDirection.RIGHT, false, false);
}

/**Test
 * 
 */
public void testTurnRightFromLeft() {
  
// GIVEN
// A Kiva built with the default map we defined earlier
Kiva kiva = new Kiva(defaultMap);

// WHEN
// We move one space forward
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.TURN_RIGHT);

// THEN
// The Kiva has moved one space up
verifyKivaState("testTurnRightFromLeft",
kiva, new Point(2,4), FacingDirection.UP, false, false);
}

/**Test
 * 
 */
public void testTurnRightFromDown() {
  
// GIVEN
// A Kiva built with the default map we defined earlier
Kiva kiva = new Kiva(defaultMap);

// WHEN
// We move one space forward
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.TURN_RIGHT);

// THEN
// The Kiva has moved one space up
verifyKivaState("testTurnRightFromLeft",
kiva, new Point(2,4), FacingDirection.LEFT, false, false);
}

/**Test
 * 
 */
public void testTurnRightFromRight() {
  
// GIVEN
// A Kiva built with the default map we defined earlier
Kiva kiva = new Kiva(defaultMap);

// WHEN
// We move one space forward
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.TURN_RIGHT);

// THEN
// The Kiva has moved one space up
verifyKivaState("testTurnRightFromLeft",
kiva, new Point(2,4), FacingDirection.DOWN, false, false);
}

/**Test
 * 
 */
public void testTakeOnPod(){
  
Kiva kiva = new Kiva(defaultMap);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.TURN_RIGHT);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.TAKE);
verifyKivaState("TakeOnPod",
kiva, new Point(8,1), FacingDirection.RIGHT, true, false);
}
  
/**Test
 * 
 */
public void testDropOnZone(){
Kiva kiva = new Kiva(defaultMap);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.TURN_RIGHT);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.TAKE);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.TURN_RIGHT);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.DROP);
  
verifyKivaState("testDropOnZone",
kiva, new Point(10,4), FacingDirection.DOWN, false, true);
}

/**Test
 * 
 */
//Illegal Move exception off floorMap
public void testMoveOfBounds(){
Kiva kiva = new Kiva(defaultMap);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.TURN_LEFT);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
System.out.println("testMoveOfBounds:(expect an illegalMoveException)");
kiva.move(KivaCommand.FORWARD);
//This only runs if no exception was thrown
System.out.println("testMoveOfBounds FAIL!");
System.out.println("Moved outside the FloorMap!");
  
  
}  
 
/**Test
 * 
 */
//Illegal Move exception Obstacle
public void testMoveObstacle(){
Kiva kiva = new Kiva(defaultMap);
kiva.move(KivaCommand.TURN_RIGHT);
kiva.move(KivaCommand.TURN_RIGHT);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.TURN_RIGHT);
kiva.move(KivaCommand.FORWARD);
System.out.println("testMoveObstacle:(expect an illegalMoveException)");
  
//This only runs if no exception was thrown
System.out.println("testMoveObstacle FAIL!");
System.out.println("Obstacle in way!");
  

}
   
/**Test
 * 
 */
//No Pod Exception pod collision checking
public void testMovePodCollision(){
Kiva kiva = new Kiva(defaultMap);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.TURN_RIGHT);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.TAKE);
kiva.move(KivaCommand.TAKE);
System.out.println("testMovePodCollision:(expect an NoPodException)");
  
//This only runs if no exception was thrown
System.out.println("testMovePodCollision FAIL!");
System.out.println("Current location not a POD!");
  
  
}

/**Test
 * 
 */
//No Pod Exception pick up with no pod
public void testTakeNoPod(){
Kiva kiva = new Kiva(defaultMap);
kiva.move(KivaCommand.TAKE);
System.out.println("testTakeNoPod:(expect an NoPodException)");
  
//This only runs if no exception was thrown
System.out.println("testTakeNoPod FAIL!");
System.out.println("Current location not a POD!");
  
  
}

/**Test
 * 
 */
//Illegal Drop Zone
public void testMoveOutOfDropZone(){
Kiva kiva = new Kiva(defaultMap);
kiva.move(KivaCommand.DROP);

System.out.println("testMoveOutOfDropZone:(expect an illegalDropZoneException)");

//This only runs if no exception was thrown
System.out.println("testMoveOutOfDropZone FAIL!");
System.out.println("Not a drop zone!");
  

}

/**Test
 * 
 */
//Illegal Move excepion not carrying pod in dropzone
public void testMoveNoPodInDropZone(){
Kiva kiva = new Kiva(defaultMap);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.TURN_RIGHT);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.TURN_RIGHT);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.FORWARD);
kiva.move(KivaCommand.DROP);
System.out.println("testMoveNoPodInDropZone:(expect an illegalMoveException)");
  
//This only runs if no exception was thrown
System.out.println("testMoveNoPodInDropZone FAIL!");
System.out.println("Not carrying pod in drop zone!");

}


/**Test
 * 
 */
public void KivaMotorLifetimeTester(){
String defaultLayout = ""
+ "-----\n"
+ "|K D|\n"
+ "| P |\n"
+ "|* *|\n"
+ "-----";
Kiva kiva = new Kiva(new FloorMap(defaultLayout));

System.out.println(kiva.getMotorLifetime());
kiva.move(KivaCommand.TURN_RIGHT);
System.out.println(kiva.getMotorLifetime());
kiva.move(KivaCommand.FORWARD);
System.out.println(kiva.getMotorLifetime());
kiva.move(KivaCommand.TURN_RIGHT);
System.out.println(kiva.getMotorLifetime());
kiva.move(KivaCommand.FORWARD);
System.out.println(kiva.getMotorLifetime());
kiva.move(KivaCommand.TAKE);
System.out.println(kiva.getMotorLifetime());
} 
}  
