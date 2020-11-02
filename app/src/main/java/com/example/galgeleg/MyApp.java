package com.example.galgeleg;

import android.app.Application;

import com.example.galgeleg.logic.Context;
import com.example.galgeleg.logic.Logic;

public class MyApp extends Application {

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