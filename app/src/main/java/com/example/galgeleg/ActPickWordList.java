package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.galgeleg.logic.Context;

import java.util.ArrayList;

public class ActPickWordList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Context ctx = Context.getInstance();
    ArrayList<String> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_showlist);

        TextView title = findViewById(R.id.listTitle);
        TextView subtitle = findViewById(R.id.listSubtitle);
        ListView list = findViewById(R.id.list);

        title.setText("Vælg et ord fra listen");
        subtitle.setVisibility(View.GONE);

         words = ctx.getMuligeOrd();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, words);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ctx.setOrdet(words.get(position));
        ctx.startGame();
        Intent i = new Intent(this, ActPlay.class);
        startActivity(i);
    }
}