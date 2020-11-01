package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    protected void onStart() {
        super.onStart();

        Logic logic = Logic.getInstance();
        if(!logic.erSpilletSlut() && logic.getBrugteBogstaver().size() > 0){
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

        if(v == bHelp){
            i = new Intent(this, ActHelp.class);
            startActivity(i);
        }


    }
}