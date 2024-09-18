public class DessinYingYang {

    public static void main(String[] args) {

        Tortue turtle = new Tortue();
        turtle.accelerate();

        //Draw a circle with steps of 1
        Drawing.circleL(turtle, 1);

        //Formation de la "vague centrale"
        turtle.turnLeft(180);
        for (int i = 0; i < 180; i++) {
            turtle.goForward(0.5);
            turtle.turnRight(1);
        }
        for (int i = 0; i < 180; i++) {
            turtle.goForward(0.5);
            turtle.turnLeft(1);
        }

        turtle.turnLeft(90);
        turtle.defineColor("NOIR");
        turtle.goForward(25);
        turtle.defineColor("BLANC");

        //Draw a circle with steps of 0.1
        Drawing.circleL(turtle, 0.1);

        turtle.defineColor("NOIR");
        turtle.goForward(62.5);
        turtle.defineColor("blanc");

        //Draw a circle with steps of 0.1
        Drawing.circleL(turtle, 0.1);
    }
}
