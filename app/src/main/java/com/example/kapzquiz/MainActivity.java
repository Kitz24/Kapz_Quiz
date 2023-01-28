package com.example.kapzquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void onClickBtn(View view){
        EditText nameInput = findViewById(R.id.nameInputField);
        EditText passwordInput = findViewById(R.id.passWordInputField);
        EditText emailInput = findViewById(R.id.emailInputField);

        String nameOutput = String.valueOf(nameInput.getText());
        String passwordOutput = String.valueOf(passwordInput.getText());
        String emailOutput = String.valueOf(emailInput.getText());

        TextView nameView = findViewById(R.id.firstViewField);
        TextView passwordView = findViewById(R.id.secondViewField);
        TextView emailView = findViewById(R.id.thirdViewField);

        nameView.setText(nameOutput);
        passwordView.setText(passwordOutput);
        emailView.setText(emailOutput);

    }

}