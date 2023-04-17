package com.exapp.mikiriquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class actualCustomQuizPage extends AppCompatActivity {


    DBHelper db = new DBHelper(this);
    Cursor result;
    String qntxt;
    String opt1txt;
    String opt2txt;
    String opt3txt;
    String opt4txt;
    int correctOption;
    RadioButton[] option = new RadioButton[4];
    TextView questionBox;
    RadioGroup rd = findViewById(R.id.radioGroup3);

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_custom_quiz_page);

        //code starts here
        Bundle bundle = getIntent().getExtras();
        String selectedTitle = String.valueOf(bundle.getString("titlekey"));
        result = db.getQuizData(selectedTitle);
        questionBox = findViewById(R.id.textView6);
        option[0] = findViewById(R.id.radioButton1);
        option[1] = findViewById(R.id.radioButton2);
        option[2] = findViewById(R.id.radioButton3);
        option[3] = findViewById(R.id.radioButton4);

        if(result.getCount()==0){
            Toast.makeText(this,"No entry found", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            if (result.moveToFirst()) {
               // do {
                qntxt = result.getString(result.getColumnIndex("question"));
                    questionBox.setText(qntxt);
                //} while (result.moveToNext());
                opt1txt = result.getString(result.getColumnIndex("option1"));
                opt2txt = result.getString(result.getColumnIndex("option2"));
                opt3txt = result.getString(result.getColumnIndex("option3"));
                opt4txt = result.getString(result.getColumnIndex("option4"));
                correctOption = result.getInt(result.getColumnIndex("correctOption"));

                option[0].setText(opt1txt);
                option[1].setText(opt2txt);
                option[2].setText(opt3txt);
                option[3].setText(opt4txt);


            }
        }
    }
    public void initialization(){

    }
    public void submit(View view){
        Boolean[] optionStateArray = new Boolean[4];
        optionStateArray[0] = option[0].isChecked();
        optionStateArray[1] = option[1].isChecked();
        optionStateArray[2] = option[2].isChecked();
        optionStateArray[3] = option[3].isChecked();

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
    }

    @SuppressLint("Range")
    public void next(View view){
        int color = Color.TRANSPARENT;
        Drawable background = view.getBackground();
        if (background instanceof ColorDrawable)
            color = ((ColorDrawable) background).getColor();
        rd.clearCheck();

        option[0].setBackgroundColor(color);
        option[1].setBackgroundColor(color);
        option[2].setBackgroundColor(color);
        option[3].setBackgroundColor(color);
        if(result.moveToNext()) {
            questionBox = findViewById(R.id.textView6);
            option[0] = findViewById(R.id.radioButton1);
            option[1] = findViewById(R.id.radioButton2);
            option[2] = findViewById(R.id.radioButton3);
            option[3] = findViewById(R.id.radioButton4);

            qntxt = result.getString(result.getColumnIndex("question"));
            questionBox.setText(qntxt);

            opt1txt = result.getString(result.getColumnIndex("option1"));
            opt2txt = result.getString(result.getColumnIndex("option2"));
            opt3txt = result.getString(result.getColumnIndex("option3"));
            opt4txt = result.getString(result.getColumnIndex("option4"));
            correctOption = result.getInt(result.getColumnIndex("correctOption"));

            option[0].setText(opt1txt);
            option[1].setText(opt2txt);
            option[2].setText(opt3txt);
            option[3].setText(opt4txt);
        }
        else{
            Toast.makeText(this,"NO MORE QUESTIONS", Toast.LENGTH_SHORT).show();
        }
    }

}