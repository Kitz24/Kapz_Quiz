package com.exapp.mikiriquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SelectCustomQuiz extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_custom_quiz);

        //drop down menu starts here
        String[] spinnerArray = {"1","2"};

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }

    @SuppressLint("Range")
    public void goToSelectedDropDownQuiz(View view){
        Button goButton = findViewById(R.id.goBtn);
        String text = spinner.getSelectedItem().toString();
        int num = Integer.parseInt(text);
        DBHelper DB = new DBHelper(this);
        Cursor result = DB.getData(num);
        if(result.getCount()==0){
            Toast.makeText(this,"No entry found", Toast.LENGTH_SHORT).show();
            return;
        }

        String variable1 = "";
        if(result.moveToFirst()){
            do{
                variable1 = variable1 + result.getString(result.getColumnIndex("questionNo"));

            }while (result.moveToNext());
            TextView tv = findViewById(R.id.textView5);
            tv.setText(variable1);
        }

    }

    public void onClickAddQuiz (View view) {
        Intent intent = new Intent(SelectCustomQuiz.this, createQuiz.class);
        startActivity(intent);
    }
}