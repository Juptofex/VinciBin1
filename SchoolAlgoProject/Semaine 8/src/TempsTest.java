import java.util.Arrays;

public class TempsTest {

    public static void main(String[] args) {

        double[] table = {3, 2, 1, 4, 5, -2, -3};
        Temperatures temp = new Temperatures("Janvier", table);
        System.out.println(temp.moyenne());
        System.out.println();
        System.out.println(temp.temperatureMin());
        System.out.println();
        System.out.println(temp.nombreJoursDeGel());
        System.out.println();
        System.out.println(Arrays.toString(temp.joursDeGel()));
        System.out.println();
        System.out.println(temp.toutesPositives());
        System.out.println();

    }
}
