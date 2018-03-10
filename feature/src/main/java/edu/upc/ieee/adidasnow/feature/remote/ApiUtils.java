package edu.upc.ieee.adidasnow.feature.remote;

/**
 * Created by alejandro on 11/11/17.
 */


public class ApiUtils {

    public static final String BASE_URL = "http://ec2-18-197-139-220.eu-central-1.compute.amazonaws.com:8000/";


    public static SOServices getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOServices.class);
    }
}