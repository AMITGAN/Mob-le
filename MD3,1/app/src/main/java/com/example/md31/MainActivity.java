package com.example.md31;


import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.md31.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        SeekBar.OnSeekBarChangeListener {

    Button btnSave, btnLoad;
    EditText etName;
    Spinner spinner;
    EditText etDay;
    private TextView mTextView, mTextView2;
    ArrayAdapter<String> adapter;

    String[] groups = { "ПИ20-1", "ПИ20-2", "ПИ20-3", "ПИ20-4", "ПИ20-5", "ПИ20-6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        etName = findViewById(R.id.etName);
        etDay = findViewById(R.id.etBirthday);

        spinner = findViewById(R.id.etGroup);
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, groups);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                mTextView2.setText(spinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                mTextView2.setText("-");
            }
        });


        final SeekBar seekBar = (SeekBar)findViewById(R.id.etAge);
        seekBar.setOnSeekBarChangeListener(this);

        mTextView = (TextView)findViewById(R.id.textView);
        mTextView2 = (TextView)findViewById(R.id.textView2);
        mTextView2.setText("-");
        mTextView.setText("0");

        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);

        String name2 = "";
        String age2 = "";
        String group2 = "";
        String birthday2 = "";
        SharedPreferences pref_1 = getPreferences(MODE_PRIVATE);
        name2 = pref_1.getString("name", "");
        etName.setText(name2);

        group2 = pref_1.getString("group", "");
        mTextView2.setText(group2);

        age2 = pref_1.getString("age", "");
        mTextView.setText(age2);

        birthday2 = pref_1.getString("birthday", "");
        etDay.setText(birthday2);
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        mTextView.setText(String.valueOf(seekBar.getProgress()));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        mTextView.setText(String.valueOf(seekBar.getProgress()));
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mTextView.setText(String.valueOf(seekBar.getProgress()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSave:
                String name = "";
                SharedPreferences pref = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor ed = pref.edit();

                name = etName.getText().toString();
                ed.putString("name", name);
                ed.commit();
                Log.i("SPREF", name);

                String group = "";
                group = mTextView2.getText().toString();
                ed.putString("group", group);
                ed.commit();
                Log.i("SPREF", group);

                String age = "";
                age = mTextView.getText().toString();
                ed.putString("age", age);
                ed.commit();
                Log.i("SPREF", age);

                String birthday = "";
                birthday = etDay.getText().toString();
                ed.putString("birthday", birthday);
                ed.commit();
                Log.i("SPREF", birthday);
                break;
            case R.id.btnLoad:
                String name2 = "";
                String age2 = "";
                String group2 = "";
                String birthday2 = "";
                SharedPreferences pref_1 = getPreferences(MODE_PRIVATE);
                name2 = pref_1.getString("name", "");
                etName.setText(name2);

                group2 = pref_1.getString("group", "");
                mTextView2.setText(group2);

                age2 = pref_1.getString("age", "");
                mTextView.setText(age2);

                birthday2 = pref_1.getString("birthday", "");
                etDay.setText(birthday2);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        String name = "";
        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = pref.edit();

        name = etName.getText().toString();
        ed.putString("name", name);
        ed.commit();
        Log.i("SPREF", name);

        String group = "";
        group = mTextView2.getText().toString();
        ed.putString("group", group);
        ed.commit();
        Log.i("SPREF", group);

        String age = "";
        age = mTextView.getText().toString();
        ed.putString("age", age);
        ed.commit();
        Log.i("SPREF", age);

        String birthday = "";
        birthday = etDay.getText().toString();
        ed.putString("birthday", birthday);
        ed.commit();
        Log.i("SPREF", birthday);
    }

}