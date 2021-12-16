package com.example.md23;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NameActivity extends AppCompatActivity {
    EditText etName1;
    Button mainBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        etName1 = (EditText) findViewById(R.id.etName);
        mainBtn = (Button) findViewById(R.id.btnOK);
        mainBtn.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("name", etName1.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }

}