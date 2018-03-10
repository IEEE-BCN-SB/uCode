package edu.upc.ieee.adidasnow.feature.remote;

import edu.upc.ieee.Product;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by alejandro on 11/11/17.
 */

public interface SOServices {
        // Request method and URL specified in the annotation

        // Callback for the parsed response is the last parameter



        @GET("product?uri={uri}")
        Call<Product> getProduct(@Path("uri") String uri);


}
