package com.example.guesstheday;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class quiz extends AppCompatActivity {
    private static final String TAG = "quizActivity";

    Button start, end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Log.d(TAG, "onCreate: Started");

        start = findViewById(R.id.startgame_quiz);
        end = findViewById(R.id.goback_quiz);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: CLicked button start");
                openActivityRunQuiz();
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: CLicked button go back");
                openActivityMain();
            }
        });
    }
    public void openActivityRunQuiz()
    {
        Intent intent_quiz_runquiz = new Intent(this, runquiz.class);
        startActivity(intent_quiz_runquiz);
    }
    public void openActivityMain()
    {
        Intent intent_quiz_mainActivity = new Intent(this, MainActivity.class);
        startActivity(intent_quiz_mainActivity);
    }
}