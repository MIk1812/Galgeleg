package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActStart extends AppCompatActivity implements View.OnClickListener {

    Button bPlay, bHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_start);

        bPlay = (Button) findViewById(R.id.button1);
        bHelp = (Button) findViewById(R.id.button2);

        bPlay.setOnClickListener(this);
        bHelp.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        Intent i;

        if (v == bPlay){
            i = new Intent(this, ActPlay.class);
            startActivity(i);
        }

        if(v == bHelp){
            i = new Intent(this, ActHelp.class);
            startActivity(i);
        }


    }
}