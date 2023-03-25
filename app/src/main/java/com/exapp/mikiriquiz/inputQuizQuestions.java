package com.exapp.mikiriquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class inputQuizQuestions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_quiz_questions);
        addQuestions();
    }

    public void addQuestions(){
        Bundle bundle = getIntent().getExtras();
        String stuff = bundle.getString("quizTitle");
        int numOfquestions = Integer.parseInt(bundle.getString("noOfQns"));
    }
    public void insertIntoDatabase(View view){
        EditText question = findViewById(R.id.editTextTextPersonName2);
        EditText option1 = findViewById(R.id.editTextTextPersonName7);
        EditText option2 = findViewById(R.id.editTextTextPersonName8);
        EditText option3 = findViewById(R.id.editTextTextPersonName9);
        EditText option4 = findViewById(R.id.editTextTextPersonName10);
        EditText correctAnswer = findViewById(R.id.editTextNumber);

        String ques = String.valueOf(question.getText());
        String opt1 = String.valueOf(option1.getText());
        String opt2 = String.valueOf(option2.getText());
        String opt3 = String.valueOf(option3.getText());
        String opt4 = String.valueOf(option4.getText());
        int ans = Integer.parseInt(correctAnswer.getText().toString());
        try{
            DBHelper db = new DBHelper(this);
            //insert into db with also the table name as first arg
            db.insertDatA(ques,opt1,opt2,opt3,opt4,ans);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}