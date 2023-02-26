package com.exapp.mikiriquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

public class createQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);
    }

    public void submitQuiz (View view) {
        EditText num = findViewById(R.id.editNumber);
        EditText str = findViewById(R.id.editTitle);
        String number = String.valueOf(num.getText().toString());
        String title = str.getText().toString();

        Intent intent = new Intent (createQuiz.this,inputQuizQuestions.class);
        Bundle bundle = new Bundle();
        bundle.putString("noOfQns", number);
        bundle.putString("quizTitle", title);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}