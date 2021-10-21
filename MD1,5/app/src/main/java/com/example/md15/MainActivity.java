package com.example.md15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    TextView mainTxt, mainTxt2, tv;
    EditText mainEdt;
    Button mainBtn;

    private long score = 100;
    private long ans = (long) (Math.floor(Math.random( ) * (0 - score + 1)) + score);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTxt = (TextView) findViewById(R.id.mainTxt);
        mainTxt2 = (TextView) findViewById(R.id.mainTxt2);
        mainBtn = (Button) findViewById(R.id.mainBtn);
        mainEdt = (EditText) findViewById(R.id.mainEdt);
        mainBtn.setOnClickListener(clickListener);
        String s = ans + "";
        mainTxt2.setText(s.toCharArray(),0, s.length());
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        int id = item.getItemId();
        String s = ans + "";
        switch(id){
            case R.id.menu_exit:
                finish();
                return true;
            case R.id.menu_lvl1:
                score = 100;
                mainTxt.setText(getResources().getString(R.string.try_to_guess));
                ans = (long) (Math.floor(Math.random( ) * (0 - score + 1)) + score);
                s = ans + "";
                mainTxt2.setText(s.toCharArray(),0, s.length());
                return true;
            case R.id.menu_lvl2:
                score = 200;
                mainTxt.setText(getResources().getString(R.string.try_to_guess2));
                ans = (long) (Math.floor(Math.random( ) * (0 - score + 1)) + score);
                s = ans + "";
                mainTxt2.setText(s.toCharArray(),0, s.length());
                return true;
            case R.id.menu_lvl3:
                score = 300;
                mainTxt.setText(getResources().getString(R.string.try_to_guess3));
                ans = (long) (Math.floor(Math.random( ) * (0 - score + 1)) + score);
                s = ans + "";
                mainTxt2.setText(s.toCharArray(),0, s.length());
                return true;
            case R.id.menu_new:
                ans = (long) (Math.floor(Math.random() * (0 - score + 1)) + score);
                s = ans + "";
                mainTxt2.setText(s.toCharArray(),0, s.length());
                return true;
        }

        return super.onOptionsItemSelected(item);

    }




    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String s = ans + "";
            mainTxt2.setText(s.toCharArray(),0, s.length());
            mainBtn.setText(getResources().getString(R.string.input_value));
            try
            {
                int n = Integer.parseInt(mainEdt.getText().toString());
                if (n < 0 || n > score)
                {
                    mainTxt.setText(getResources().getString(R.string.error));
                }
                else
                {
                    if (n > ans) {
                        mainTxt.setText(getResources().getString(R.string.to_more));
                    }
                    if (n < ans) {
                        mainTxt.setText(getResources().getString(R.string.to_less));
                    }
                    if (n == ans) {
                        mainTxt.setText(getResources().getString(R.string.hit));
                        mainBtn.setText(getResources().getString(R.string.play_more));
                        ans = (long) (Math.floor(Math.random() * (0 - score + 1)) + score);
                    }
                }
            }
            catch (NumberFormatException exception)
            {
                mainTxt.setText(getResources().getString(R.string.no_int));
            }
        }

    };

}