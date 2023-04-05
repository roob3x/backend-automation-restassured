package support;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Filters {

    public static int generateRandomNumber() {
        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(101);
        return numeroAleatorio;
    }

    public static int generateRandomNumberUntilTen() {
        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(11);
        return numeroAleatorio;
    }

    public static String getCurrentDateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .withZone(ZoneOffset.UTC);
        return currentDateTime.format(formatter);
    }
}
