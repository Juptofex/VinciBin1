public class DessinLunette {

    public static void main(String[] args){

        Tortue turtle = new Tortue();

        //Draw a square with sides of 100
        Drawing.squareL(turtle, 100);

        turtle.turnLeft(180);
        turtle.goForward(50);

        //Draw a square with sides of 100
        Drawing.squareL(turtle, 100);
    }
}
