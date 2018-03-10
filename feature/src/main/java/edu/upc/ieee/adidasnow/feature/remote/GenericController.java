package edu.upc.ieee.adidasnow.feature.remote;

import edu.upc.ieee.Product;
import retrofit2.Response;

/**
 * Created by alejandro on 11/11/17.
 */

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class GenericController {


    private static GenericController instance = null;

    public GenericController(){
        mServices = ApiUtils.getSOService();
    }

    public static GenericController getInstance() {
        if(instance == null) {
            instance = new GenericController();
        }
        return instance;
    }

    private SOServices mServices;


    public Product getProduct(String url) throws Resources.NotFoundException {
        Product prod = null;
        String uri = Uri.encode(url);
        try {
            Response<Product> ret = mServices.getProduct(uri).execute();
            prod = ret.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prod;
    }



}

