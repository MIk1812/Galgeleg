package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        EditText tv = (EditText) findViewById(R.id.input);
        String name = tv.getText().toString();
        System.out.println(name);

        if(!name.equals("")){
            saveScore(name);
            this.finish();
        }else
            Toast.makeText(this, "Indtast navn", Toast.LENGTH_LONG).show();

    }

    //Inspired by: https://codinginflow.com/tutorials/android/write-text-file-to-internal-storage
    private void saveScore(String name){
        Logic logic = Logic.getInstance();
        String score = String.valueOf(logic.getBrugteBogstaver().size());
        String toSave = score + ", " + name + "\n";

        try {
            FileOutputStream out = openFileOutput(Logic.HIGHSCORES, MODE_APPEND);
            out.write(toSave.getBytes());
            Toast.makeText(this, "Gemt", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}