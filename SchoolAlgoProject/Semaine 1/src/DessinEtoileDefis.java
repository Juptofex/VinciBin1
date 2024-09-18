public class DessinEtoileDefis {

    public static void main(String[] args) {

        Tortue turtle = new Tortue();
        for (int i = 0; i < 6; i++) {
            turtle.turnLeft(60);
            turtle.goForward(100);
            turtle.turnRight(60);
            turtle.goForward(100);
            turtle.turnLeft(60);
            
        }
    }
}
