package com.example.project_app_android;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    Home_Fragment homeFragment = new Home_Fragment();
    TransferFragment transferFragment = new TransferFragment();
    ServicesFragment servicesFragment = new ServicesFragment();
    HistoryFragment historyFragment = new HistoryFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
            return true;
        } else if (item.getItemId() == R.id.transfer) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, transferFragment).commit();
            return true;
        } else if (item.getItemId() == R.id.services) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, servicesFragment).commit();
            return true;
        } else if (item.getItemId() == R.id.history) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, historyFragment).commit();
            return true;
        }
        return false;
    }
}
