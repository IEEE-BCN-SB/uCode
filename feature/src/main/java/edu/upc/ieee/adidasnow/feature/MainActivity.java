package edu.upc.ieee.adidasnow.feature;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.upc.ieee.adidasnow.feature.fragments.BlankFragment;
import edu.upc.ieee.adidasnow.feature.fragments.CommentFragment;
import edu.upc.ieee.adidasnow.feature.fragments.InterestedFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.navigation_home) {
                replaceFragment(BlankFragment.newInstance(getString(R.string.title_nav_home)));
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

        replaceFragment(BlankFragment.newInstance(getString(R.string.title_nav_home)));
    }

    void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment).commit();
    }

}
