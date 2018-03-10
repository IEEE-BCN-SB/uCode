package edu.upc.ieee.adidasnow.feature.remote;

import edu.upc.ieee.adidasnow.feature.model.Product;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Joan Vinyals on 10/03/2018.
 */

public interface APIService {
    @GET("{prodUrl}")
    Call<Product> getProduct(@Path("prodUrl") String prodUrl);
}
