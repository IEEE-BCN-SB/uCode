package edu.upc.ieee.adidasnow.feature;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import edu.upc.ieee.adidasnow.feature.model.Product;
import edu.upc.ieee.adidasnow.feature.remote.*;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private APIService mAPIService;

    TextView t;
    Call<Product> ps;
    Product p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = (TextView) findViewById(R.id.hello_text);
        mAPIService = APIUtils.getAPIService();
        try {
            final Handler handler = new Handler();
            ps = mAPIService.getProduct("CE2036.html");
            //handler.postDelayed(new Runnable() {@Override public void run() {}}, 5000);
            ExecuteCall ec = new ExecuteCall();
            ec.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public class ExecuteCall extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            Log.d("TEST1", "Executing...");
            try {
                p = ps.execute().body();
            } catch (IOException e) {
                Log.d("TEST1",e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            //Log.d("TEST1", "Name: " + p.getName());
            t.setText(p.getName());
        }
    }
}
