package edu.upc.ieee.adidasnow.feature.http;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

/**
 * Created by Joan Vinyals on 10/03/2018.
 */

public class HttpClient {

    Context cont;

    public HttpClient(Context cont){
        this.cont = cont;
    }

    public String getRequest(){
        RequestQueue queue = Volley.newRequestQueue(cont);
        String url ="https://www.adidas.es/zapatilla-nmd_r1-stlt-primeknit/CQ2029.html";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("TAG", "Response "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAG", "Didn't worked.");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
        return "Fuck you!";
    }
}
