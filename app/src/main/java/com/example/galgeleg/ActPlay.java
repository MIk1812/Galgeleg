package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ActPlay extends AppCompatActivity implements View.OnClickListener {

    Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,ae,oe,aa;
    String alphabet[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","æ","ø","å"};
    int images[] = {R.drawable.galge, R.drawable.forkert1, R.drawable.forkert2, R.drawable.forkert3, R.drawable.forkert4, R.drawable.forkert5, R.drawable.forkert6};
    Button buttons[];
    Logic logic = Logic.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_play);

        System.out.println("onCreate");
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        e = findViewById(R.id.e);
        f = findViewById(R.id.f);
        g = findViewById(R.id.g);
        h = findViewById(R.id.h);
        i = findViewById(R.id.i);
        j = findViewById(R.id.j);
        k = findViewById(R.id.k);
        l = findViewById(R.id.l);
        m = findViewById(R.id.m);
        n = findViewById(R.id.n);
        o = findViewById(R.id.o);
        p = findViewById(R.id.p);
        q = findViewById(R.id.q);
        r = findViewById(R.id.r);
        s = findViewById(R.id.s);
        t = findViewById(R.id.t);
        u = findViewById(R.id.u);
        v = findViewById(R.id.v);
        w = findViewById(R.id.w);
        x = findViewById(R.id.x);
        y = findViewById(R.id.y);
        z = findViewById(R.id.z);
        ae = findViewById(R.id.ae);
        oe = findViewById(R.id.oe);
        aa = findViewById(R.id.aa);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        g.setOnClickListener(this);
        h.setOnClickListener(this);
        i.setOnClickListener(this);
        j.setOnClickListener(this);
        k.setOnClickListener(this);
        l.setOnClickListener(this);
        m.setOnClickListener(this);
        n.setOnClickListener(this);
        o.setOnClickListener(this);
        p.setOnClickListener(this);
        q.setOnClickListener(this);
        r.setOnClickListener(this);
        s.setOnClickListener(this);
        t.setOnClickListener(this);
        u.setOnClickListener(this);
        v.setOnClickListener(this);
        w.setOnClickListener(this);
        x.setOnClickListener(this);
        y.setOnClickListener(this);
        z.setOnClickListener(this);
        ae.setOnClickListener(this);
        oe.setOnClickListener(this);
        aa.setOnClickListener(this);

        buttons = new Button[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, ae, oe, aa};

    }

    @Override
    public void onStart() {
        super.onStart();

        if(logic.erSpilletSlut()){
            logic.startNytSpil();
            updateVisibleWord();
        } else
            updateUI();
    }

    @Override
    public void onClick(View v) {

        for(int i = 0; i < buttons.length; i++) {
            if(v == buttons[i]) {
                logic.gætBogstav(alphabet[i]);
                buttons[i].setBackgroundColor(Color.parseColor("#303030"));
                updateVisibleWord();
                break;
            }
        }

        if(logic.erSpilletSlut()){
            Intent i = new Intent(this, ActEnd.class);
            startActivity(i);
        } else
            updateImage();
    }

    private void updateVisibleWord(){
        TextView visibleWord = findViewById(R.id.visibleWord);
        visibleWord.setText(logic.getSynligtOrd());
    }

    private void updateImage(){
        int failedGuesses = logic.getAntalForkerteBogstaver();
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(images[failedGuesses]);
    }

    private void updateUI() {
        updateVisibleWord();
        updateImage();

        ArrayList<String> usedWords = logic.getBrugteBogstaver();
        for (int i = 0; i < alphabet.length; i++) {
            if(usedWords.contains(alphabet[i]))
                buttons[i].setBackgroundColor(Color.parseColor("#303030"));
        }

    }

}