package com.example.galgeleg;

import android.app.Application;

import java.util.concurrent.Executors;

public class MyApp extends Application {

    public MyApp(){

        new Thread(() -> {
            try {
                System.out.println("HARLO");
                Logic.getInstance().hentOrdFraRegneark("2");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
