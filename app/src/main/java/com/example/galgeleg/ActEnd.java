package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        b = findViewById(R.id.button);
        save = findViewById(R.id.save);
        b.setOnClickListener(this);
        save.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView title = (TextView) findViewById(R.id.title);
        TextView subtitle = (TextView) findViewById(R.id.subtitle);
        TextView word = (TextView) findViewById(R.id.word);

        Context ctx = Context.getInstance();

        if(ctx.erSpilletTabt()){
            title.setText("Desværre, du tabte");
            Button save = findViewById(R.id.save);
            save.setVisibility(View.GONE);
        }

        int numberOfGuesses = ctx.getBrugteBogstaver().size();
        subtitle.setText("Du brugte " + String.valueOf(numberOfGuesses) + " gæt");

        String wordToGuess = ctx.getOrdet();
        word.setText(wordToGuess);
    }

    @Override
    public void onClick(View v) {

        if(v == b){
            Intent i = new Intent(this, ActStart.class);
            startActivity(i);

            //Finish the activity, since we don't want it on the stack
            this.finish();
        }

        if(v == save){
            Intent i = new Intent(this, ActSave.class);
            startActivity(i);

            //Finish the activity, since we don't want it on the stack
            this.finish();
        }
    }
}