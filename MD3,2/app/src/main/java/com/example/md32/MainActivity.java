package com.example.md32;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd, btnDelete, btnRead;
    EditText etName, etName2;
    TextView Text;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnRead = findViewById(R.id.btnRead);
        etName = findViewById(R.id.etName);
        etName2 = findViewById(R.id.etName2);
        Text = findViewById(R.id.Text);
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        dbHelper = new DBHelper(this);
    }

    public class DBHelper  extends SQLiteOpenHelper{

        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "contactDb";
        public static final String TABLE_CONTACTS = "contacts";

        public static final String KEY_ID = "_id";
        public static final String KEY_NAME = "name";
        public static final String KEY_MAIL = "mail";

        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table " + TABLE_CONTACTS + "(" + KEY_ID
                    + " integer primary key," + KEY_NAME + " text," + KEY_MAIL + " text" + ")");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists " + TABLE_CONTACTS);

            onCreate(db);

        }
    }

    @Override
    public void onClick(View v) {
        String name = etName.getText().toString();
        String dl = etName2.getText().toString();
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String job = "";

        switch (v.getId()){
            case R.id.btnAdd:
                cv.put("name", dl);
                cv.put("mail", name);
                db.insert("contacts", null, cv);
                break;
            case R.id.btnDelete:
                db.delete("contacts", null, null);
                break;
            case R.id.btnRead:
                Cursor c = db.query("contacts", null, null, null, null, null, null);
                if (c.moveToFirst()) {
                    int dlColIndex = c.getColumnIndex("name");
                    int nameColIndex = c.getColumnIndex("mail");
                    do {
                        job = job + "Date = " + c.getString(dlColIndex) + ", task = " + c.getString(nameColIndex) + "\n";
                    }
                    while (c.moveToNext());
                    Text.setText(job);
                }
                else
                    Text.setText("-");
                c.close();


                break;
            default:
                break;
        }


    }

}
