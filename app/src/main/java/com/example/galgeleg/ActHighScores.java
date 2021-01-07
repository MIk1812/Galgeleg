package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

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
        setContentView(R.layout.act_showlist);

        TextView title = findViewById(R.id.listTitle);
        TextView subtitle = findViewById(R.id.listSubtitle);
        ListView scoresList = (ListView) findViewById(R.id.list);

        title.setText("High Scores");

        //Load the scores
        //Inspired by: https://codinginflow.com/tutorials/android/write-text-file-to-internal-storage
        ArrayList<String> scores = new ArrayList<>();
        try {
            FileInputStream fis = openFileInput(Context.HIGHSCORES);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            //Loop through lines from file and collect scores in String Array
            String txt;
            while((txt = br.readLine()) != null)
                scores.add(txt);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //If there aren't any highscores to show
        if(scores.size() == 0){
            subtitle.setText("Ingen high scores endnu");
        } else{
            subtitle.setVisibility(View.GONE);

            //Sort the String Array using custom comparator
            Collections.sort(scores, new HighScoreComparator());

            //Custom adapter has also been implemented, to show custom High Score list
            HighScoreAdapter adapter = new HighScoreAdapter(this, R.layout.high_scorelist, scores);

            //Set the listview's adapter and display it
            scoresList.setAdapter(adapter);
        }

    }
}