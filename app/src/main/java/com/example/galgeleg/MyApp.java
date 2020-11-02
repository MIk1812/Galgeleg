package com.example.galgeleg;

import android.app.Application;

import com.example.galgeleg.logic.Context;

public class MyApp extends Application {

    //This is only run once, which is smart, because we don't want to fetch the same words over and over again
    //Since we do networking, it is done in a thread
    //Since "startGame()" has already been called on Context.class, these words are only active after round 1
    public MyApp(){
        new Thread(() -> {
            try {
                Context.getInstance().hentOrdFraRegneark("2");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}