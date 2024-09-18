public class DessinVentilateur {

    public static void main(String[] args) {

        Tortue turtle = new Tortue();
        for (int i = 0; i < 3; i++) {

            //Draw a square with sides of 100
            Drawing.squareL(turtle, 100);

            turtle.turnLeft(120);
        }
    }
}
