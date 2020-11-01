package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActEnd extends AppCompatActivity implements View.OnClickListener {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_end);

        b = findViewById(R.id.button);
        b.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView title = (TextView) findViewById(R.id.title);
        TextView subtitle = (TextView) findViewById(R.id.subtitle);
        TextView word = (TextView) findViewById(R.id.word);

        Logic logic = Logic.getInstance();

        if(logic.erSpilletTabt())
            title.setText("Desværre, du tabte");

        int numberOfGuesses = logic.getBrugteBogstaver().size();
        subtitle.setText("Du brugte " + String.valueOf(numberOfGuesses) + " gæt");

        String wordToGuess = logic.getOrdet();
        word.setText(wordToGuess);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, ActStart.class);
        startActivity(i);
    }
}