package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.galgeleg.logic.Context;

public class ActEnd extends AppCompatActivity implements View.OnClickListener {

    Button b, save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_end);

        //Set listeners
        b = findViewById(R.id.button);
        save = findViewById(R.id.save);
        b.setOnClickListener(this);
        save.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final MediaPlayer mp;
        TextView title = (TextView) findViewById(R.id.title);
        TextView subtitle = (TextView) findViewById(R.id.subtitle);
        TextView word = (TextView) findViewById(R.id.word);

        Context ctx = Context.getInstance();

        //Show correct text depending on if the game was lost or won
        if(ctx.erSpilletTabt()){
            title.setText("Desværre, du tabte");
            Button save = findViewById(R.id.save);
            save.setVisibility(View.GONE);

            mp = MediaPlayer.create(this, R.raw.loosesound);
        } else {
            mp = MediaPlayer.create(this, R.raw.winsound);
        }

        mp.start();

        int numberOfGuesses = ctx.getBrugteBogstaver().size();
        subtitle.setText("Du brugte " + String.valueOf(numberOfGuesses) + " gæt");

        String wordToGuess = ctx.getSidsteOrd();
        word.setText(wordToGuess);
    }

    @Override
    public void onClick(View v) {

        if(v == b)
            onBackPressed();

        if(v == save){
            Intent i = new Intent(this, ActSave.class);
            startActivity(i);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(this, ActStart.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}