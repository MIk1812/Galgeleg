package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.galgeleg.logic.Context;

public class ActPickWord extends AppCompatActivity implements View.OnClickListener {

    Button b1, b2;
    Context ctx = Context.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_pickword);

        b1 = (Button) findViewById(R.id.button3);
        b2 = (Button) findViewById(R.id.button4);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        //Let user pick from list
        if(v==b1){
            Intent i = new Intent(this, ActPickWordList.class);
            startActivity(i);
        }

        //Pick random word
        if(v==b2){
            ctx.startGame();
            Intent i = new Intent(this, ActPlay.class);
            startActivity(i);
        }

    }
}