public class DessinEtoile {

    public static void main(String[] args) {

        Tortue turtle = new Tortue();
        for (int i = 0; i < 3; i++) {
            turtle.goForward(100);
            turtle.turnLeft(120);
        }
        turtle.defineColor("NOIR");
        turtle.goForward(50);
        turtle.turnRight(90);
        turtle.goForward(33.33);
        turtle.defineColor("BLANC");
        turtle.turnRight(210);
        for (int i = 0; i < 3; i++) {
            turtle.goForward(100);
            turtle.turnLeft(120);
        }
    }
}
