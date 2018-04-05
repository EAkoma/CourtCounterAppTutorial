package com.example.android.myquizapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ResetScore();
    }

    public void submitResults(View view) {
        score = questionOne() + questionTwo() + questionThree() + questionFour() + questionFive();
        Context context = getApplicationContext();
        CharSequence text = "Your Score is: " + score + "%";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        ResetScore();
    }


    public int questionOne() {
        RadioButton questionOneChoice1 = (RadioButton) findViewById(R.id.q1c1);
        RadioButton questionOneChoice2 = (RadioButton) findViewById(R.id.q1c2);
        RadioButton questionOneChoice3 = (RadioButton) findViewById(R.id.q1c3);
        RadioButton questionOneChoice4 = (RadioButton) findViewById(R.id.q1c4);

        if (questionOneChoice2.isChecked()) {
            questionOneChoice2.setBackgroundColor(Color.GREEN);
            questionOneChoice1.setBackgroundColor(Color.RED);
            questionOneChoice3.setBackgroundColor(Color.RED);
            questionOneChoice4.setBackgroundColor(Color.RED);
            score = 20;
        } else {
            questionOneChoice2.setBackgroundColor(Color.GREEN);
            questionOneChoice1.setBackgroundColor(Color.RED);
            questionOneChoice3.setBackgroundColor(Color.RED);
            questionOneChoice4.setBackgroundColor(Color.RED);
            score = 0;
        }
        return score;
    }

    public int questionTwo() {
        CheckBox questionTwoChoice1 = (CheckBox) findViewById(R.id.q2c1);
        CheckBox questionTwoChoice3 = (CheckBox) findViewById(R.id.q2c3);
        CheckBox questionTwoChoice4 = (CheckBox) findViewById(R.id.q2c4);
        CheckBox questionTwoChoice2 = (CheckBox) findViewById(R.id.q2c2);

        if (questionTwoChoice1.isChecked() && questionTwoChoice3.isChecked() && questionTwoChoice4.isChecked()) {
            questionTwoChoice1.setBackgroundColor(Color.GREEN);
            questionTwoChoice3.setBackgroundColor(Color.GREEN);
            questionTwoChoice4.setBackgroundColor(Color.GREEN);
            questionTwoChoice2.setBackgroundColor(Color.RED);

            score = 20;
        } else {
            questionTwoChoice1.setBackgroundColor(Color.GREEN);
            questionTwoChoice3.setBackgroundColor(Color.GREEN);
            questionTwoChoice4.setBackgroundColor(Color.GREEN);
            questionTwoChoice2.setBackgroundColor(Color.RED);

            score = 0;
        }

        return score;
    }

    public int questionThree() {
        RadioButton questionThreeChoice1 = (RadioButton) findViewById(R.id.q3c1);
        RadioButton questionThreeChoice2 = (RadioButton) findViewById(R.id.q3c2);
        RadioButton questionThreeChoice3 = (RadioButton) findViewById(R.id.q3c3);
        RadioButton questionThreeChoice4 = (RadioButton) findViewById(R.id.q3c4);


        if (questionThreeChoice3.isChecked()){
            questionThreeChoice1.setBackgroundColor(Color.RED);
            questionThreeChoice3.setBackgroundColor(Color.GREEN);
            questionThreeChoice4.setBackgroundColor(Color.RED);
            questionThreeChoice2.setBackgroundColor(Color.RED);

            score = 20;
        } else {

            questionThreeChoice1.setBackgroundColor(Color.RED);
            questionThreeChoice3.setBackgroundColor(Color.GREEN);
            questionThreeChoice4.setBackgroundColor(Color.RED);
            questionThreeChoice2.setBackgroundColor(Color.RED);

            score = 0;
        }
        return score;
    }


    public int questionFour() {

        EditText edittext = (EditText) findViewById(R.id.q4c1);
        String answer = edittext.getText().toString();
        if (answer.equals("no")) {
            score = 20;
        } else {
            score = 0;
        }
        return score;
    }

    public int questionFive() {

        RadioButton questionFiveChoice1 = (RadioButton) findViewById(R.id.q5c1);
        RadioButton questionFiveChoice2 = (RadioButton) findViewById(R.id.q5c2);
        RadioButton questionFiveChoice3 = (RadioButton) findViewById(R.id.q5c3);
        RadioButton questionFiveChoice4 = (RadioButton) findViewById(R.id.q5c4);

        if (questionFiveChoice4.isChecked()) {
            questionFiveChoice4.setBackgroundColor(Color.GREEN);
            questionFiveChoice3.setBackgroundColor(Color.RED);
            questionFiveChoice2.setBackgroundColor(Color.RED);
            questionFiveChoice1.setBackgroundColor(Color.RED);
            score = 20;
        } else {
            questionFiveChoice4.setBackgroundColor(Color.GREEN);
            questionFiveChoice3.setBackgroundColor(Color.RED);
            questionFiveChoice2.setBackgroundColor(Color.RED);
            questionFiveChoice1.setBackgroundColor(Color.RED);
            score = 0;
        }
        return score;
    }

    public int ResetScore() {

        score = 0;

        return score;
    }


}



