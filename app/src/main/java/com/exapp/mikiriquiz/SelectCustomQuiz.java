package com.exapp.mikiriquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectCustomQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_custom_quiz);
    }

    public void onClickAddQuiz (View view) {
        Intent intent = new Intent(SelectCustomQuiz.this, createQuiz.class);
        startActivity(intent);
    }
}