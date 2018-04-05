package com.example.android.myquizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn = (Button) findViewById(R.id.lesson1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

        Button btn1 = (Button) findViewById(R.id.lesson2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayComingSoon();
            }
        });
        Button btn2 = (Button) findViewById(R.id.lesson3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayComingSoon();
            }
        });

        Button btn3 = (Button) findViewById(R.id.main_menu);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });
    }
    public void openActivity3 () {
        Intent intent = new Intent(this,Main3Activity.class);
        startActivity(intent);
    }
    public void displayComingSoon() {
        Context context = getApplicationContext();
        CharSequence text = "Coming Soon!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void openActivity1 () {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
