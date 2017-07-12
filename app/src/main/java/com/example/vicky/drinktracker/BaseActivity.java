package com.example.vicky.drinktracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class BaseActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.main_activity) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent); }
        { if (item.getItemId() == R.id.add_drink) {
                Intent intent1 = new Intent(this, AddDrinkActivity.class);
                startActivity(intent1);
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }

}