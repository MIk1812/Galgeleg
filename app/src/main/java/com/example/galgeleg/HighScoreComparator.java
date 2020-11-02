package com.example.galgeleg;

import java.util.Comparator;

public class HighScoreComparator implements Comparator<String> {

    //Highscore are formattet like "10, Mike", this ensure they are sorted correctly
    @Override
    public int compare(String o1, String o2) {
        int s1 = Integer.parseInt(o1.split(", ")[0]);
        int s2 = Integer.parseInt(o2.split(", ")[0]);

        if(s1>s2) return 1;
        else return 0;
    }
}
