package com.example.md12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainText = (TextView) findViewById(R.id.mainTxt);
        mainBtn = (Button) findViewById(R.id.mainBtn);
        mainBtn2 = (Button) findViewById(R.id.mainBtn2);
        mainBtn3 = (Button) findViewById(R.id.mainBtn3);
        mainImg = (ImageButton) findViewById(R.id.mainImg);
        mainBtn.setOnClickListener(clickListener);
        mainImg.setOnClickListener(clickListener4);
        mainBtn2.setOnClickListener(clickListener2);
        mainBtn3.setOnClickListener(clickListener3);

    }
    TextView mainText;
    Button mainBtn, mainBtn2, mainBtn3;
    ImageButton mainImg;

    private long score = 0;
    String n = " ";

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            score ++;
            if (score >= 20 & score % 10 != 2 & score % 10 != 3 & score % 10 != 4)
            {
                n = " раз";
            }
            else
            {
                if (score >= 20 & score % 10 == 2 | score % 10 == 3 | score % 10 == 4)
                {
                    n = " раза";
                }
                else
                {
                    if (score >= 5 | score == 1)
                    {
                        n = " раз";
                    }
                    else
                    {
                        n = " раза";
                    }
                }
            }
            String s = "Кнопка нажата " + score + n;
            mainText.setText(s.toCharArray(),0, s.length());


        }
    };
    View.OnClickListener clickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            score -= 1;
            if (score >= 20 & (score % 10 != 2 | score % 10 != 3 | score % 10 != 4))
            {
                n = " раз";
            }
            else
            {
                if (score >= 20 & (score % 10 == 2 | score % 10 == 3 | score % 10 == 4))
                {
                    n = " раза";
                }
                else
                {
                    if (score >= 5 | score == 1)
                    {
                        n = " раз";
                    }
                    else
                    {
                        n = " раза";
                    }
                }
            }
            String s = "Кнопка нажата " + score + n;

            mainText.setText(s.toCharArray(),0, s.length());


        }
    };
    View.OnClickListener clickListener3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            score = 0;
            String s = "Кнопка нажата " + score + " раз";
            mainText.setText(s.toCharArray(),0, s.length());
        }
    };
    View.OnClickListener clickListener4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            score = 0;
            String s = "U are Rick now";
            mainText.setText(s.toCharArray(),0, s.length());
        }
    };

}