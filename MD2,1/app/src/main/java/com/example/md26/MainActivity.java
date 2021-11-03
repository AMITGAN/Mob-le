package com.example.md26;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch(id){
            case R.id.menu_lvl1:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                return true;
            case R.id.menu_lvl2:
                Intent intent2 = new Intent(this, MainActivity2.class);
                startActivity(intent2);
                return true;
            case R.id.menu_lvl3:
                Intent intent3 = new Intent(this, MainActivity3.class);
                startActivity(intent3);
                return true;
            case R.id.menu_lvl4:
                Intent intent4 = new Intent(this, MainActivity4.class);
                startActivity(intent4);
                return true;
        }

        return super.onOptionsItemSelected(item);

    }

    public void onClick(View view) {
        EditText nameText = findViewById(R.id.EDT);
        String name = nameText.getText().toString();
        Intent intent5 = new Intent(this, MainActivity2.class);
        intent5.putExtra("name", name);
        startActivity(intent5);
    }
}