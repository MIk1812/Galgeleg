package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.galgeleg.logic.Context;

import java.util.ArrayList;

public class ActPlay extends AppCompatActivity implements View.OnClickListener {

    Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,ae,oe,aa;
    String alphabet[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","æ","ø","å"};
    int images[] = {R.drawable.galge, R.drawable.forkert1, R.drawable.forkert2, R.drawable.forkert3, R.drawable.forkert4, R.drawable.forkert5, R.drawable.forkert6};
    Button buttons[];
    Context ctx = Context.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_play);

        //Set onClickListeners
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

        if(ctx.erSpilletSlut()){
            ctx.startGame();
            updateVisibleWord();
        } else
            //The allows you to leave and come back to the same game
            updateUI();
    }

    @Override
    public void onClick(View v) {

        //Loop through and find letter pressed
        for(int i = 0; i < buttons.length; i++) {
            if(v == buttons[i]) {

                //update the context and the UI
                ctx.guessLetter(alphabet[i]);
                buttons[i].setBackgroundColor(Color.parseColor("#303030"));
                updateVisibleWord();
                break;
            }
        }

        //Check if game is over
        if(ctx.erSpilletSlut()){
            Intent i = new Intent(this, ActEnd.class);
            startActivity(i);

            //Finish the activity, since we don't want it on the stack
            this.finish();
        } else
            updateImage();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(this, ActStart.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    private void updateVisibleWord(){
        TextView visibleWord = findViewById(R.id.visibleWord);
        visibleWord.setText(ctx.getSynligtOrd());
    }

    private void updateImage(){
        //From "getAntalForkerteBogstaver" we can conclude what image needs to be shown
        int failedGuesses = ctx.getAntalForkerteBogstaver();
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(images[failedGuesses]);
    }

    //The allows you to leave and come back to the same game
    private void updateUI() {
        updateVisibleWord();
        updateImage();

        //Loop through buttons and find which once need to be marked as already pressed
        ArrayList<String> usedWords = ctx.getBrugteBogstaver();
        for (int i = 0; i < alphabet.length; i++) {
            if(usedWords.contains(alphabet[i]))
                buttons[i].setBackgroundColor(Color.parseColor("#303030"));
        }

    }
}