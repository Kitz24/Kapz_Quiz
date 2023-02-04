package com.exapp.mikiriquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TopicSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_select);
    }

    public void onClickbook(View view){
        Intent intent = new Intent(TopicSelectActivity.this,QuestionPage.class);
        startActivity(intent);
    }
}