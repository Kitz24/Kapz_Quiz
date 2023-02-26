package com.exapp.mikiriquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void onClickNormalQuiz(View view){
        Intent intent = new Intent(MainActivity.this,TopicSelectActivity.class);
        startActivity(intent);
    }
    public void onClickCustomQuiz(View view){
        Intent intent = new Intent(MainActivity.this,SelectCustomQuiz.class);
        startActivity(intent);
    }

}
// TODO: add button to view questions and one to display notes
// TODO: add a splash screen on opening app
// TODO: add a manual dark theme cuz api is old for automatic(or update api)