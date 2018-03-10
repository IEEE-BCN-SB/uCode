package edu.upc.ieee.adidasnow.feature.remote;

/**
 * Created by Joan Vinyals on 10/03/2018.
 */

public class APIUtils {

    private APIUtils() {}

    public static final String BASE_URL = "https://www.adidas.es/zapatilla-nmd_r1-stlt-primeknit/";

    public static APIService getAPIService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }

}