package com.example.guesstheday;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    Button quiz, infinity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started");

        quiz = findViewById(R.id.btnquiz);
        infinity = findViewById(R.id.btninfinity);

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: CLicked button open quiz");

                openActivityQuiz();
            }
        });
        infinity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: CLicked button open quiz");

                openActivityInfinity();
            }
        });

    }
    public void openActivityQuiz()
    {
        Intent intent_main_quiz = new Intent(this, quiz.class);
        startActivity(intent_main_quiz);
    }
    public void openActivityInfinity()
    {
        Intent intent_main_infinity = new Intent(this, infinity.class);
        startActivity(intent_main_infinity);
    }
}