import java.util.Scanner;

public class MiniProjet {

    public static void main(String[] args){

        //Ask user the dimensions for the square and the circle
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the sides of the square - ");
        double a;
        a = sc.nextDouble();
        System.out.print("Enter the length of the steps of the circle - ");
        double b;
        b = sc.nextDouble();

        Tortue turtle = new Tortue();
        turtle.accelerate();

        //Draw seat
        for (int i = 0; i < 10; i++) {
            turtle.turnLeft(60);
            Drawing.triangleL(turtle, a);
            turtle.turnRight(60);
            for (int j = 0; j < 36; j++) {
                turtle.goForward(b);
                turtle.turnRight(1);
            }
        }

        turtle.defineColor("noir");
        turtle.turnRight(90);
        turtle.goForward(b*60);

        turtle.defineColor("blanc");
        turtle.turnLeft(150);

        Drawing.triangleL(turtle, b*60*2);
    }
}
