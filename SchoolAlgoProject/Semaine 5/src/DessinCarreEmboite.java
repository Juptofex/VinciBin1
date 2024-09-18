public class DessinCarreEmboite {
    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        tortue.accelerate();
        for (int i = 1; i < 6; i++) {
            Drawing.squareL(tortue, 50*i);
        }
    }
}
