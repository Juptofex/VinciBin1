public class Drawing {

    //Draw a spiral with a specified length of steps
    static void spiral(Tortue turtle, double step) {
        for (int i = 0; i < 36; i++) {
            for (int j = 0; j < 360; j++) {
                turtle.avancer(step);
                turtle.tournerAGauche(1);
            }
            for (int j = 0; j < 10; j++) {
                turtle.avancer(step*2);
                turtle.tournerAGauche(1);
            }
        }
    }

    /**
     * Draw a square with sides of specified length
     * @param turtle
     * @param side
     */
    static void squareL(Tortue turtle, double side) {
        for (int i = 0; i < 4; i++) {
            turtle.avancer(side);
            turtle.tournerAGauche(90);
        }
    }

    /**
     * Draw a square with sides of specified length
     * @param turtle
     * @param side
     */
    static void squareR(Tortue turtle, double side) {
        for (int i = 0; i < 4; i++) {
            turtle.avancer(side);
            turtle.tournerADroite(90);
        }
    }

    /**
     * Draw a triangle with sides of specified length
     * @param turtle
     * @param side
     */
    static void triangleL(Tortue turtle, double side) {
        for (int i = 0; i < 3; i++) {
            turtle.avancer(side);
            turtle.tournerAGauche(120);
        }
    }

    /**
     * Draw a triangle with sides of specified length
     * @param turtle
     * @param side
     */
    static void triangleR(Tortue turtle, double side) {
        for (int i = 0; i < 3; i++) {
            turtle.avancer(side);
            turtle.tournerADroite(120);
        }
    }

    /**
     * Draw a circle with a specified length of steps
     * @param turtle
     * @param step
     */
    static void circleL(Tortue turtle, double step) {
        for (int i = 0; i < 360; i++) {
            turtle.avancer(step);
            turtle.tournerAGauche(1);
        }
    }

    /**
     * Draw a circle with a specified length of steps
     * @param turtle
     * @param step
     */
    static void circleR(Tortue turtle, double step) {
        for (int i = 0; i < 360; i++) {
            turtle.avancer(step);
            turtle.tournerADroite(1);
        }
    }
}
