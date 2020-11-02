package com.example.galgeleg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedInputStream;
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
            FileInputStream fis = openFileInput(Logic.HIGHSCORES);
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