package com.example.md13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;





public class MainActivity extends AppCompatActivity {

    TextView mainTxt, mainTxt2;
    EditText mainEdt;
    Button mainBtn, mainBtn2, mainBtn3, mainBtn4, mainBtn5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTxt = (TextView) findViewById(R.id.mainTxt);
        mainTxt2 = (TextView) findViewById(R.id.mainTxt2);
        mainBtn = (Button) findViewById(R.id.mainBtn);
        mainBtn2 = (Button) findViewById(R.id.mainBtn2);
        mainBtn3 = (Button) findViewById(R.id.mainBtn3);
        mainBtn4 = (Button) findViewById(R.id.mainBtn4);
        mainBtn5 = (Button) findViewById(R.id.mainBtn5);
        mainEdt = (EditText) findViewById(R.id.mainEdt);
        mainBtn.setOnClickListener(clickListener);
        mainBtn2.setOnClickListener(clickListener1);
        mainBtn3.setOnClickListener(clickListener3);
        mainBtn4.setOnClickListener(clickListener4);
        mainBtn5.setOnClickListener(clickListener5);
        String s = ans + "";
        mainTxt2.setText(s.toCharArray(),0, s.length());
    }

    private long score = 0;

    View.OnClickListener clickListener3 = new View.OnClickListener(){

        @Override
        public void onClick(View v){
            score = 100;
            mainTxt.setText(getResources().getString(R.string.try_to_guess));
            ans = (long) (Math.floor(Math.random( ) * (0 - score + 1)) + score);
            String s = ans + "";
            mainTxt2.setText(s.toCharArray(),0, s.length());
        }
    };

    View.OnClickListener clickListener4 = new View.OnClickListener(){

        @Override
        public void onClick(View v){
            score = 200;
            mainTxt.setText(getResources().getString(R.string.try_to_guess2));
            ans = (long) (Math.floor(Math.random( ) * (0 - score + 1)) + score);
            String s = ans + "";
            mainTxt2.setText(s.toCharArray(),0, s.length());
        }
    };

    View.OnClickListener clickListener5 = new View.OnClickListener(){

        @Override
        public void onClick(View v){
            score = 300;
            mainTxt.setText(getResources().getString(R.string.try_to_guess3));
            ans = (long) (Math.floor(Math.random( ) * (0 - score + 1)) + score);
            String s = ans + "";
            mainTxt2.setText(s.toCharArray(),0, s.length());
        }
    };
    private long ans = (long) (Math.floor(Math.random( ) * (0 - score + 1)) + score);
    View.OnClickListener clickListener1 = new View.OnClickListener(){

        @Override
        public void onClick(View v){
            finish();
        }
    };

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