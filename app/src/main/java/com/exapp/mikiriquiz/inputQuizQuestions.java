package com.exapp.mikiriquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class inputQuizQuestions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_quiz_questions);
        func();
    }

    public void func(){
        Bundle bundle = getIntent().getExtras();
        String stuff = bundle.getString("quizTitle");
        int numOfquestions = Integer.parseInt(bundle.getString("noOfQns"));
    }
}