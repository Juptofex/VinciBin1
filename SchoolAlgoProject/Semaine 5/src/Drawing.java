public class Drawing {

    //Draw a spiral with a specified length of steps
    static void spiral(Tortue turtle, double step) {
        for (int i = 0; i < 36; i++) {
            for (int j = 0; j < 360; j++) {
                turtle.goForward(step);
                turtle.turnLeft(1);
            }
            for (int j = 0; j < 10; j++) {
                turtle.goForward(step*2);
                turtle.turnLeft(1);
            }
        }
    }

    //Draw a square with sides of specified length
    static void squareL(Tortue turtle, double side) {
        for (int i = 0; i < 4; i++) {
            turtle.goForward(side);
            turtle.turnLeft(90);
        }
    }
    static void squareR(Tortue turtle, double side) {
        for (int i = 0; i < 4; i++) {
            turtle.goForward(side);
            turtle.turnRight(90);
        }
    }

    //Draw a triangle with sides of specified length
    static void triangleL(Tortue turtle, double side) {
        for (int i = 0; i < 3; i++) {
            turtle.goForward(side);
            turtle.turnLeft(120);
        }
    }
    static void triangleR(Tortue turtle, double side) {
        for (int i = 0; i < 3; i++) {
            turtle.goForward(side);
            turtle.turnRight(120);
        }
    }


    //Draw a circle with a specified length of steps
    static void circleL(Tortue turtle, double step) {
        for (int i = 0; i < 360; i++) {
            turtle.goForward(step);
            turtle.turnLeft(1);
        }
    }

    static void circleR(Tortue turtle, double step) {
        for (int i = 0; i < 360; i++) {
            turtle.goForward(step);
            turtle.turnRight(1);
        }
    }
}
