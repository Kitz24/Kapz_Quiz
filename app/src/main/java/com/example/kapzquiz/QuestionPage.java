package com.example.kapzquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class QuestionPage extends AppCompatActivity {
    int questionsDone=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page);

    }
    public void onClickNextButton(View view){
        RadioButton[] option = new RadioButton[4];
        option[0] = findViewById(R.id.checkBoxA);
        option[1] = findViewById(R.id.checkBoxB);
        option[2] = findViewById(R.id.checkBoxC);
        option[3] = findViewById(R.id.checkBoxD);

        Boolean[] optionStateArray = new Boolean[4];
        optionStateArray[0] = option[0].isChecked();
        optionStateArray[1] = option[1].isChecked();
        optionStateArray[2] = option[2].isChecked();
        optionStateArray[3] = option[3].isChecked();

        int correctOption = 0; // TO be fetched using database

        for (int i=0; i<4; i++){
            if (optionStateArray[i]){
                if (i==correctOption){
                    option[i].setBackgroundColor(Color.parseColor("#cbff75"));
                }
                else{
                    option[i].setBackgroundColor(Color.parseColor("#FF0000"));
                    option[correctOption].setBackgroundColor(Color.parseColor("#cbff75"));
                }
            }
        }
        Button b = findViewById(R.id.buttonNextQuestion);
        b.setVisibility(View.GONE);

    }
}