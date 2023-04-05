package schemas;

public class PostPetPayload {
    public static final String CUSTOM_PET_PAYLOAD = "{\n" +
            "  \"id\": IDENTIFICATION,\n" +
            "  \"category\": {\n" +
            "    \"id\": CATEGORYID,\n" +
            "    \"name\": \"CATEGORYNAME\"\n" +
            "  },\n" +
            "  \"name\": \"PETNAME\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"string\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": TAGID,\n" +
            "      \"name\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"available\"\n" +
            "}";
}
