package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.galgeleg.logic.Context;

public class ActStart extends AppCompatActivity implements View.OnClickListener {

    Button bPlay, bHighScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_start);

        //Set onClickListeners
        bPlay = (Button) findViewById(R.id.button1);
        bHighScores = (Button) findViewById(R.id.button2);

        bPlay.setOnClickListener(this);
        bHighScores.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Context ctx = Context.getInstance();

        //If the game is currently active
        if(!ctx.erSpilletSlut() && ctx.getBrugteBogstaver().size() > 0){
            //We would like to display "continue game" as supposed to "start game"
            Button b = (Button) findViewById(R.id.button1);
            b.setText("Forsæt spil");
        }
    }

    @Override
    public void onClick(View v) {

        Intent i;

        if (v == bPlay){
            i = new Intent(this, ActPlay.class);
            startActivity(i);
        }

        if(v == bHighScores){
            i = new Intent(this, ActHighScores.class);
            startActivity(i);
        }
    }
}