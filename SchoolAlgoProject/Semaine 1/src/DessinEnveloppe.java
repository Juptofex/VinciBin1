public class DessinEnveloppe {

    public static void main(String[] args){

        Tortue turtle = new Tortue();

        //Draw a square with sides of 100
        Drawing.squareL(turtle, 100);

        turtle.turnLeft(45);
        turtle.goForward(70.71);
        turtle.turnRight(90);
        turtle.goForward(70.71);

    }
}
