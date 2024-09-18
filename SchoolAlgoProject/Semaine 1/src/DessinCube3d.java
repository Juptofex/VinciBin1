public class DessinCube3d {

    public static void main(String[] args) {

        Tortue turtle = new Tortue();
        turtle.accelerate();

        //Draw a square with sides of 100
        Drawing.squareL(turtle, 100);

        turtle.turnRight(30);
        turtle.goForward(70.71);
        turtle.turnLeft(30);
        turtle.goForward(100);
        turtle.turnLeft(150);
        turtle.goForward(70.71);
        turtle.turnRight(60);
        turtle.goForward(100);
        turtle.turnRight(120);
        turtle.goForward(70.71);
        turtle.turnRight(60);
        turtle.goForward(100);
    }
}
