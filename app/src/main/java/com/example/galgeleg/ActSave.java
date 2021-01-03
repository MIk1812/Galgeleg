package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.galgeleg.logic.Context;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ActSave extends AppCompatActivity implements View.OnClickListener {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_save);

        Button b = (Button) findViewById(R.id.save);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //Get the name typed by the user
        EditText tv = (EditText) findViewById(R.id.input);
        String name = tv.getText().toString();

        //Check is anything has been typed
        if(!name.equals("")){
            saveScore(name);

            Intent i = new Intent(this, ActStart.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);

        }else
            Toast.makeText(this, "Indtast navn", Toast.LENGTH_LONG).show();
    }

    //Inspired by: https://codinginflow.com/tutorials/android/write-text-file-to-internal-storage
    private void saveScore(String name){
        Context ctx = Context.getInstance();
        String score = String.valueOf(ctx.getBrugteBogstaver().size());
        String toSave = score + ", " + name + "\n";

        //Save string like "10, Mike" to the local file highscores.txt
        try {
            FileOutputStream out = openFileOutput(Context.HIGHSCORES, MODE_APPEND);
            out.write(toSave.getBytes());
            Toast.makeText(this, "Gemt", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}