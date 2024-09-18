public class DessinTestSpirale {


    public static void main(String[] args) {

        Tortue turtle = new Tortue();
        turtle.accelerate();

        //Draw a spiral with steps of 0.5
        Drawing.spiral(turtle, 0.5);

        turtle.turnRight(90);
        turtle.defineColor("noir");
        turtle.goForward(100);
        turtle.turnLeft(90);
        turtle.defineColor("blanc");

        //Draw a spiral with steps of 0.5
        Drawing.spiral(turtle, 0.5);
    }
}
