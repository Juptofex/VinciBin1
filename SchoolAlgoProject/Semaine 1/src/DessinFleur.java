public class DessinFleur {

    public static void main(String[] args) {

        Tortue turtle = new Tortue();
        turtle.accelerate();
        for (int i = 0; i < 4; i++) {

            //Draw a triangle with sides of 100
            Drawing.triangleL(turtle, 100);

            turtle.turnLeft(90);
        }
    }
}
