package com.example.guesstheday;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class infinity extends AppCompatActivity {
    private static final String TAG = "InfinityActivity";

    Button start, end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinity);
        Log.d(TAG, "onCreate: Started");

        start = findViewById(R.id.startgame_infi);
        end = findViewById(R.id.goback_infi);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: CLicked button start");
                openActivityRunInfinity();
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
    public void openActivityRunInfinity()
    {
        Intent intent_infi_runinfi = new Intent(this, runinfinity.class);
        startActivity(intent_infi_runinfi);
    }
    public void openActivityMain()
    {
        Intent intent_infi_mainActivity = new Intent(this, MainActivity.class);
        startActivity(intent_infi_mainActivity);
    }
}