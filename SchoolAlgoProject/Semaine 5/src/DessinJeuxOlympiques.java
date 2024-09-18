public class DessinJeuxOlympiques {
    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        tortue.accelerate();
        for (int i = 0; i < 3; i++) {
            Drawing.circleL(tortue,1);
            tortue.goForward(11);
            tortue.defineColor("noir");
            tortue.goForward(114);
            tortue.defineColor("blanc");
        }
        tortue.defineColor("noir");
        tortue.turnLeft(90);
        tortue.goForward(50);
        tortue.turnLeft(90);
        tortue.goForward(185);
        tortue.defineColor("blanc");
        for (int i = 0; i < 2; i++) {
            Drawing.circleR(tortue, 1);
            tortue.goForward(11);
            tortue.defineColor("noir");
            tortue.goForward(114);
            tortue.defineColor("blanc");
        }
    }
}
