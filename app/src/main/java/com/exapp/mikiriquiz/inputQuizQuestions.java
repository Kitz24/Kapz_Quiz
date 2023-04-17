package com.exapp.mikiriquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class inputQuizQuestions extends AppCompatActivity {
    String quizTitle;
    int numOfquestions, counter=0;
    DBHelper db = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_quiz_questions);
        addQuestions();
    }

    public void addQuestions(){
        Bundle bundle = getIntent().getExtras();
        String stuff = bundle.getString("quizTitle");
        numOfquestions = Integer.parseInt(bundle.getString("noOfQns"));
        quizTitle = String.valueOf(bundle.getString("quizTitle"));
        try {
            db.insertTitle(quizTitle,numOfquestions);
        }
        catch (Exception ee){
            System.out.println(ee);
        }
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
            //insert into db with also the table name as first arg
            db.insertDatA(quizTitle,ques,opt1,opt2,opt3,opt4,ans);
        }
        catch(Exception e) {
            System.out.println(e);
        }

        question.getText().clear();
        option1.getText().clear();
        option2.getText().clear();
        option3.getText().clear();
        option4.getText().clear();
        correctAnswer.getText().clear();

        counter++;
        if (counter>=numOfquestions){
            Intent intent = new Intent(inputQuizQuestions.this, SelectCustomQuiz.class);
            startActivity(intent);
            finish();
        }
    }

}