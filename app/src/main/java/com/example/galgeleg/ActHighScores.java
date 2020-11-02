package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.galgeleg.logic.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ActHighScores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<String> scores = new ArrayList<>();

        //Inspired by: https://codinginflow.com/tutorials/android/write-text-file-to-internal-storage
        try {
            FileInputStream fis = openFileInput(Context.HIGHSCORES);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String txt;
            while((txt = br.readLine()) != null)
                scores.add(txt);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(scores);
        HighScoreAdapter adapter = new HighScoreAdapter(this, R.layout.high_score_list, scores);

        ListView listView = new ListView(this);
        listView.setAdapter(adapter);
        setContentView(listView);
    }
}