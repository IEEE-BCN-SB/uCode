package edu.upc.ieee.adidasnow.feature;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ShareCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.upc.ieee.adidasnow.feature.fragments.HomeFragment;
import edu.upc.ieee.adidasnow.feature.fragments.CommentFragment;
import edu.upc.ieee.adidasnow.feature.fragments.InterestedFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.navigation_home) {
                replaceFragment(HomeFragment.newInstance(getString(R.string.title_nav_home)));
                getString(R.string.title_nav_home);
                return true;
            } else if (id == R.id.navigation_comments) {
                replaceFragment(new CommentFragment());
                return true;
            } else if (id == R.id.navigation_interested) {
                replaceFragment(new InterestedFragment());
                return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        replaceFragment(HomeFragment.newInstance(getString(R.string.title_nav_home)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_moreInfo) {
            intentOpenWebPage("http://ieee.upc.edu/");
        }
        if (id == R.id.action_share) {
            intentShareText("http://ieee.upc.edu/");
        }
        return super.onOptionsItemSelected(item);
    }

    void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment).commit();
    }

    public void intentOpenWebPage(String url) {
        Uri uri = Uri.parse(url);

        Intent internetIntent = new Intent(Intent.ACTION_VIEW, uri);

        if (internetIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(internetIntent);
        }

    }

    public void intentShareText(String text) {
        String mimeType = "text/plain";
        String title = "Share your item.";

        ShareCompat.IntentBuilder
                .from(this)
                .setChooserTitle(title)
                .setType(mimeType)
                .setText(text)
                .startChooser();
    }

}
