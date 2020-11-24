package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random random = new Random();
    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateNumber();
    }

    public void generateNumber() {
        randomNumber = random.nextInt(20) + 1;
        Log.i("Number Generated: ", Integer.toString(randomNumber));
    }

    public void guessingFunction(View view) {
        Log.i("Info", "Button is Pressed!");

        EditText editTextUserGuess = (EditText) findViewById(R.id.editTextUserGuess);

        if (!editTextUserGuess.getText().toString().matches("")) {

            int guessValue = Integer.parseInt(editTextUserGuess.getText().toString());
            String message;

            if (guessValue > randomNumber) {
                Log.i("Entered Number: ", Integer.toString(guessValue));
                Log.i("Random Number: ", Integer.toString(randomNumber));

                message = "Go Lower!";
                editTextUserGuess.getText().clear();
            } else if (guessValue < randomNumber) {
                Log.i("Entered Number: ", Integer.toString(guessValue));
                Log.i("Random Number: ", Integer.toString(randomNumber));

                message = "Go Higher!";
                editTextUserGuess.getText().clear();
            } else {
                Log.i("Entered Number: ", Integer.toString(guessValue));
                Log.i("Random Number: ", Integer.toString(randomNumber));

                message = "You Got It!\nTry Again!";
                editTextUserGuess.getText().clear();
                generateNumber();
            }

            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }
}