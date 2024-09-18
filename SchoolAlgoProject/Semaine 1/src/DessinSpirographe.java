public class DessinSpirographe {

    public static void main(String[] args) {

        Tortue turtle = new Tortue();
        turtle.accelerate();

        //Draw a circle with steps of 1
        Drawing.circleL(turtle, 1);

        //Draw a spiral with steps of 0.5
        Drawing.spiral(turtle, 0.5);
    }
}
