package support;

import java.util.Random;

public class Filters {

    public static int generateRandomNumber() {
        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(101);
        return numeroAleatorio;
    }
}
