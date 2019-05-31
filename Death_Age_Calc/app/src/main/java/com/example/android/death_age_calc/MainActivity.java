package com.example.android.death_age_calc;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    EditText Guesseditt;
    Button Guessbutton;
    TextView GuessTextV;
    LinearLayout port;
    RelativeLayout land;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText Guesseditt = (EditText) findViewById(R.id.Guesses);
        Button Guessbutton = (Button) findViewById(R.id.Guessbutton);
        TextView GuessTextV = (TextView) findViewById(R.id.GuessTextView);

        GuessTextV.setVisibility(View.INVISIBLE);
        Guesseditt.setVisibility(View.INVISIBLE);
        Guessbutton.setVisibility(View.INVISIBLE);
    }
    ModelActivity BDA = new ModelActivity();
    int Success=BDA.getSuccess(),Failure=BDA.getFailure();
    int Age;
    int n = BDA.getValue();

    public void Set(View view) {
        EditText Ageeditt = (EditText) findViewById(R.id.Deathage);
        EditText Guesseditt = (EditText) findViewById(R.id.Guesses);
        Button Guessbutton = (Button) findViewById(R.id.Guessbutton);
        TextView GuessTextV = (TextView) findViewById(R.id.GuessTextView);
        Button b = (Button) findViewById(R.id.SetButton);
        String x = Ageeditt.getText().toString();

        if (TextUtils.isEmpty(x)) {
            Toast.makeText(this, "Please enter the age.", Toast.LENGTH_SHORT).show();
            Ageeditt.requestFocus();
            return;
        } else {
            Age = Integer.parseInt(x);
            if (Age > 100 || Age < 1) {
                Toast.makeText(this, "Please enter the age from 1 to 100", Toast.LENGTH_SHORT).show();
                Ageeditt.setText("");
                return;
            } else {
                Ageeditt.setText("Age saved successfully");
                GuessTextV.setVisibility(View.VISIBLE);
                Guesseditt.setVisibility(View.VISIBLE);
                Guessbutton.setVisibility(View.VISIBLE);
                b.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void Guess(View view) {
        EditText Guesseditt = (EditText) findViewById(R.id.Guesses);
        String y = Guesseditt.getText().toString();
        if (TextUtils.isEmpty(y)) {
            Toast.makeText(this, "Please enter the age.", Toast.LENGTH_SHORT).show();
            Guesseditt.requestFocus();
            return;
        } else {
            int Guess = Integer.parseInt(Guesseditt.getText().toString());
            if (Guess > 100 || Guess < 1) {
                Toast.makeText(this, "Please enter your guess from 1 to 100", Toast.LENGTH_SHORT).show();
                return;
            } else {
                n += 1;
                Compare(Age, Guess);
                Guesseditt.setText("");
            }
        }
    }

    String message;

    private void Compare(int Age, int Guess) {

        int Diff = Math.abs(Age - Guess);
        if (Diff == 0) {
            port = (LinearLayout) findViewById(R.id.ContainPort);
            land = (RelativeLayout) findViewById(R.id.ContainLand);
            port.setBackgroundColor(getResources().getColor(R.color.Blacky));
            port.setBackgroundColor(getResources().getColor(R.color.Blacky));
        } else if ((0 < Diff) && (Diff < 10)) {
            port = (LinearLayout) findViewById(R.id.ContainPort);
            land = (RelativeLayout) findViewById(R.id.ContainLand);
            port.setBackgroundColor(getResources().getColor(R.color.Colour1));
            port.setBackgroundColor(getResources().getColor(R.color.Colour1));
        } else if ((10 <= Diff) && (Diff < 20)) {
            port = (LinearLayout) findViewById(R.id.ContainPort);
            land = (RelativeLayout) findViewById(R.id.ContainLand);
            port.setBackgroundColor(getResources().getColor(R.color.Colour2));
            port.setBackgroundColor(getResources().getColor(R.color.Colour2));
        } else if ((20 <= Diff) && (Diff < 30)) {
            port = (LinearLayout) findViewById(R.id.ContainPort);
            land = (RelativeLayout) findViewById(R.id.ContainLand);
            port.setBackgroundColor(getResources().getColor(R.color.Colour3));
            port.setBackgroundColor(getResources().getColor(R.color.Colour3));
        } else if ((30 <= Diff) && (Diff < 40)) {
            port = (LinearLayout) findViewById(R.id.ContainPort);
            land = (RelativeLayout) findViewById(R.id.ContainLand);
            port.setBackgroundColor(getResources().getColor(R.color.Colour4));
            port.setBackgroundColor(getResources().getColor(R.color.Colour4));
        } else if ((40 <= Diff) && (Diff < 50)) {
            port = (LinearLayout) findViewById(R.id.ContainPort);
            land = (RelativeLayout) findViewById(R.id.ContainLand);
            port.setBackgroundColor(getResources().getColor(R.color.Colour5));
            port.setBackgroundColor(getResources().getColor(R.color.Colour5));
        } else {
            port = (LinearLayout) findViewById(R.id.ContainPort);
            land = (RelativeLayout) findViewById(R.id.ContainLand);
            port.setBackgroundColor(getResources().getColor(R.color.Colour6));
            port.setBackgroundColor(getResources().getColor(R.color.Colour6));
        }

        if (n < 7) {
            if (Guess < Age) {
                message = "Your guess is lower than the age.\nTry again with another guess.\nNo of tries =" + n + "\nRemaining No of tries= " + (7 - n) + "\n";
            } else if (Guess > Age) {
                message = "Your guess is greater than the age.\nTry again with another guess.\nNo of tries =" + n + "\nRemaining No of tries= " + (7 - n) + "\n";
            } else {
                message = "WOW!!! That's correct guess\n";
            }
        } else if (n == 7) {
            if (Guess < Age) {
                message = "Your guess is lower than the age.\nTry again with another guess.\nNo of tries =" + n + "\nRemaining No of tries= " + (7 - n) + "\n";
            } else if (Guess > Age) {
                message = "Your guess is greater than the age.\nTry again with another guess.\nNo of tries =" + n + "\nRemaining No of tries= " + (7 - n) + "\n";
            } else {
                message = "WOW!!! That's correct guess\n";
            }
            message.concat(("Your guesses are all over as you have exceeded the limit.\nNo worries.\nTry again with another age of death\n").concat
                    ("Click RETRY to continue"));
            Button Guessbutton = (Button) findViewById(R.id.Guessbutton);
            Guessbutton.setVisibility(View.INVISIBLE);
        }
        TextView Result_text_view = (TextView) findViewById(R.id.result);
        Result_text_view.setText((message));
    }
    public void Retry(View view) {
        n = 0;
        setContentView(R.layout.activity_main);
        TextView Res = (TextView) findViewById(R.id.result);
        Res.setText("");
        EditText Guesseditt = (EditText) findViewById(R.id.Guesses);
        Button Guessbutton = (Button) findViewById(R.id.Guessbutton);
        TextView GuessTextV = (TextView) findViewById(R.id.GuessTextView);
        GuessTextV.setVisibility(View.INVISIBLE);
        Guesseditt.setVisibility(View.INVISIBLE);
        Guessbutton.setVisibility(View.INVISIBLE);
    }
}