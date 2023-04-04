package schemas;

public class PostUserPayload {

    public static final String CUSTOM_USER_PAYLOAD = "{\n" +
            "  \"id\": ID,\n" +
            "  \"username\": \"USERNAME\",\n" +
            "  \"firstName\": \"FIRSTNAME\",\n" +
            "  \"lastName\": \"LASTNAME\",\n" +
            "  \"email\": \"EMAIL\",\n" +
            "  \"password\": \"PASSWORD\",\n" +
            "  \"phone\": \"PHONE\",\n" +
            "  \"userStatus\": USERSTATUS\n" +
            "}";

    public static final String USER_PAYLOAD_FIX = "{\n" +
            "  \"id\": 12,\n" +
            "  \"username\": \"mariaassuncao\",\n" +
            "  \"firstName\": \"Maria\",\n" +
            "  \"lastName\": \"Assunçao\",\n" +
            "  \"email\": \"mariadobairro\",\n" +
            "  \"password\": \"12345678\",\n" +
            "  \"phone\": \"81988117158\",\n" +
            "  \"userStatus\": 1\n" +
            "}";
}
