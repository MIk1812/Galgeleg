package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.galgeleg.logic.Context;

public class Loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_loading);

        new Thread(() -> {
            try {
                Context.getInstance().hentOrdFraRegneark("2");
            } catch (Exception e) {

                //If networking fails, standard words will still be avaliable
                e.printStackTrace();
                runOnUiThread(() -> {
                    Toast.makeText(this, "Networking failed", Toast.LENGTH_LONG).show();
                });
            }

            //When networking is done, start the app
            runOnUiThread(() -> {
                Intent i = new Intent(this, ActStart.class);
                startActivity(i);
                finish();
            });

        }).start();


    }
}