public class DessinDoubleEtoile {

    public static void main(String[] args) {

        Tortue turtle = new Tortue();
        turtle.accelerate();
        for (int n = 0; n < 3; n++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    turtle.goForward(100);
                    turtle.turnLeft(90);
                }
                turtle.turnLeft(120);
            }
            turtle.turnLeft(40);
        }
    }
}
