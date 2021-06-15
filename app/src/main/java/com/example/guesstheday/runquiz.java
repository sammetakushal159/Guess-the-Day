package com.example.guesstheday;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class runquiz extends AppCompatActivity {
    private static final String TAG = "RunQuiz";

    public static final String QUIZ_SAVED = "quiz_sharedPreferences";
    public static final String QUIZ_SCORE = "quiz_score";

    Vibrator vibrator;
    View screenColour;

    private final Handler colourHandler = new Handler();

    TextView question, score, Best, Noofques;
    Button Button1, Button2, Button3, Button4;
    int currentScore = 0, best = 0, noofques;
    int d1 = 0, d2 = 0, m1 = 0, m2 = 0, y1 = 0, y2 = 0, y3 = 0, y4 = 0, rem = 0, ans = 0;
    int opt1 = 0, opt2 = 0, opt3 = 0, opt4 = 0,quiz_savedscore;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runquiz);
        Log.d(TAG, "onCreate: Started");

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        question = findViewById(R.id.quiz_ques);
        Best = findViewById(R.id.quiz_best);
        Noofques = findViewById(R.id.quiz_noofques);
        score = findViewById(R.id.quiz_score);
        Button1 = findViewById(R.id.quiz_btn1);
        Button2 = findViewById(R.id.quiz_btn2);
        Button3 = findViewById(R.id.quiz_btn3);
        Button4 = findViewById(R.id.quiz_btn4);
        screenColour = findViewById(R.id.colour_quiz);

        retrieveData();
        Best.setText("best score :"+quiz_savedscore);
        best = quiz_savedscore;
        getValues();

        if(savedInstanceState!=null)
        {
            currentScore = savedInstanceState.getInt("infi_currentscore");
            best = savedInstanceState.getInt("infi_bestscore");
            noofques = savedInstanceState.getInt("infi_noof question");
            Best.setText("best score :"+best);
            Noofques.setText("ques:" + noofques);
            score.setText("present score :" + currentScore);
        }

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: CLicked button one");
                if (ans == 1)
                {
                    screenColour.setBackgroundColor(Color.GREEN);
                    colourHandler.postDelayed(colourRunnable,500);
                    currentScore+=1;
                }
                else
                {
                    screenColour.setBackgroundColor(Color.RED);
                    vibrator.vibrate(200);
                    colourHandler.postDelayed(colourRunnable,500);
                }
                noofques++;
                checkques();
                getValues();
            }
        });
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: CLicked button two");
                if (ans == 2)
                {
                    screenColour.setBackgroundColor(Color.GREEN);
                    colourHandler.postDelayed(colourRunnable,500);
                    currentScore+=1;
                }
                else
                {
                    screenColour.setBackgroundColor(Color.RED);
                    vibrator.vibrate(200);
                    colourHandler.postDelayed(colourRunnable,500);
                    Best.setText("Best Score :"+best+"");
                }
                noofques++;
                checkques();
                getValues();
            }
        });
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: CLicked button three");
                if (ans == 3)
                {
                    screenColour.setBackgroundColor(Color.GREEN);
                    colourHandler.postDelayed(colourRunnable,500);
                    currentScore+=1;
                }
                else
                {
                    screenColour.setBackgroundColor(Color.RED);
                    vibrator.vibrate(200);
                    colourHandler.postDelayed(colourRunnable,500);
                    Best.setText("Best Score :"+best+"");
                }
                noofques++;
                checkques();
                getValues();
            }
        });
        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: CLicked button four");
                if (ans == 4)
                {
                    screenColour.setBackgroundColor(Color.GREEN);
                    colourHandler.postDelayed(colourRunnable,500);
                    currentScore+=1;
                }
                else
                {
                    screenColour.setBackgroundColor(Color.RED);
                    vibrator.vibrate(200);
                    colourHandler.postDelayed(colourRunnable,500);
                    Best.setText("Best Score :"+best+"");
                }
                noofques++;
                checkques();
                getValues();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void getValues() {
        score.setText("present score :" + currentScore);
        Noofques.setText("ques:" + noofques);
        Generatedd();
        Generatemm();
        Generateyy();
        question.setText("" + ((d1 * 10) + d2) + "/" + ((m1 * 10) + m2) + "/" + ((y1 * 1000) + (y2 * 100) + (y3 * 10) + y4) + "");

        Generateoption();
    }

    private void Generatedd() {
        char[] chars1 = "012".toCharArray();
        char[] chars2 = "0123456789".toCharArray();
        Random random = new Random();
        char a = chars1[random.nextInt(chars1.length)];
        char b = chars2[random.nextInt(chars2.length)];
        while (a == '0' && b == '0') {
            b = chars2[random.nextInt(chars2.length)];
        }
        while (a == '2' && b == '9') {
            b = chars2[random.nextInt(chars2.length)];
        }
        d1 = a - '0';
        d2 = b - '0';
    }

    private void Generatemm() {
        char[] chars1 = "01".toCharArray();
        char[] chars2 = "123456789".toCharArray();
        Random random = new Random();
        char a = chars1[random.nextInt(chars1.length)];
        char b = chars2[random.nextInt(chars2.length)];
        while (a == '1' && b > '2') {
            b = chars2[random.nextInt(chars2.length)];
        }
        m1 = a - '0';
        m2 = b - '0';
    }

    private void Generateyy() {
        char[] chars1 = "12".toCharArray();
        char[] chars2 = "123456".toCharArray();
        char[] chars3 = "0123456789".toCharArray();
        Random random = new Random();
        char a = chars1[random.nextInt(chars1.length)];
        char b = chars2[random.nextInt(chars2.length)];
        while (a == '1' && b < '6') {
            b = chars2[random.nextInt(chars2.length)];
        }
        while (a == '2' && b > '3') {
            b = chars2[random.nextInt(chars2.length)];
        }
        char c = chars3[random.nextInt(chars3.length)];
        char d = chars3[random.nextInt(chars3.length)];
        while (a == '0' && b == '0' && c == '0' && d == '0') {
            d = chars3[random.nextInt(chars3.length)];
        }
        y1 = a - '0';
        y2 = b - '0';
        y3 = c - '0';
        y4 = d - '0';
    }

    @SuppressLint("SetTextI18n")
    private void Generateoption() {
        int f, d, y, m, c;

        d = (d1 * 10) + d2;
        m = (m1 * 10) + m2;
        c = (y1 * 10) + y2;
        y = (y3 * 10) + y4;

        if (m == 1 || m == 2) {
            m = m + 12;
            y = y - 1;
        }

        int temp1, temp2, temp3;

        temp1 = 13 * (m + 1);
        temp1 = temp1 / 5;
        temp2 = y / 4;
        temp3 = c / 4;

        f = d + temp1 + y + temp2 + temp3 + (5 * c);

        rem = f % 7;

        char[] ansOpt = "1234".toCharArray();
        char[] chars = "0123456".toCharArray();
        Random random = new Random();
        char p = ansOpt[random.nextInt(ansOpt.length)];
        char q = chars[random.nextInt(chars.length)];
        char r = chars[random.nextInt(chars.length)];
        char s = chars[random.nextInt(chars.length)];
        while ((q-'0') == rem)
        {
            q = chars[random.nextInt(chars.length)];
        }
        while ((r-'0') == rem||r==q)
        {
            r = chars[random.nextInt(chars.length)];
        }
        while ((s-'0') == rem||s==q||s==r)
        {
            s = chars[random.nextInt(chars.length)];
        }

        ans = p-'0';

        if((p-'0')==1)
        {
            opt1 = rem;
            opt2 = q - '0';
            opt3 = r - '0';
            opt4 = s - '0';
        }
        if((p-'0')==2)
        {
            opt1 = q - '0';
            opt2 = rem;
            opt3 = r - '0';
            opt4 = s - '0';
        }
        if((p-'0')==3)
        {
            opt1 = q - '0';
            opt2 = r - '0';
            opt3 = rem;
            opt4 = s - '0';
        }
        if((p-'0')==4)
        {
            opt1 = q - '0';
            opt2 = r - '0';
            opt3 = s - '0';
            opt4 = rem;
        }

        String option1 = getoption(opt1);
        String option2 = getoption(opt2);
        String option3 = getoption(opt3);
        String option4 = getoption(opt4);
        Button1.setText("" + option1);
        Button2.setText("" + option2);
        Button3.setText("" + option3);
        Button4.setText("" + option4);
    }

    private String getoption(int x) {
        if (x == 0) {
            return "saturday";
        }
        if (x == 1) {
            return "sunday";
        }
        if (x == 2) {
            return "monday";
        }
        if (x == 3) {
            return "tuesday";
        }
        if (x == 4) {
            return "wednesday";
        }
        if (x == 5) {
            return "thursday";
        }
        return "friday";
    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(QUIZ_SAVED, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(QUIZ_SCORE, best);
        editor.apply();
    }

    public void retrieveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(QUIZ_SAVED, MODE_PRIVATE);
        quiz_savedscore = sharedPreferences.getInt(QUIZ_SCORE, 0);
    }
    private final Runnable colourRunnable = new Runnable() {
        @Override
        public void run() {
            screenColour.setBackgroundColor(Color.TRANSPARENT);
        }
    };
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("infi_currentscore",currentScore);
        outState.putInt("infi_bestscore",best);
        outState.putInt("infi_noof question",noofques);
    }
    @SuppressLint("SetTextI18n")
    public void gotoQuiz()
    {
        if(best < currentScore)
        {
            best = currentScore;
        }
        saveData();
        Intent intent_runquiz_quiz = new Intent(this, quiz.class);
        startActivity(intent_runquiz_quiz);
    }
    public void checkques()
    {
        if(noofques == 20)
        {
            gotoQuiz();
        }
    }
}