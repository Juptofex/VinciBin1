public class DessinPriseElectrique {

    public static void main(String[] args) {

        Tortue turtle = new Tortue();
        turtle.accelerate();

        //Draw a circle with steps of 1
        Drawing.circleL(turtle, 1);

        turtle.defineColor("NOIR");
        turtle.turnLeft(90);
        turtle.goForward(50);
        turtle.turnLeft(90);
        turtle.goForward(12.5);
        turtle.defineColor("BLANC");

        //Draw a circle with steps of 0.1
        Drawing.circleL(turtle, 0.1);

        turtle.defineColor("NOIR");
        turtle.turnLeft(155);
        turtle.goForward(25);
        turtle.defineColor("BLANC");

        //Draw a circle with steps of 0.1
        Drawing.circleL(turtle, 0.1);
    }
}
