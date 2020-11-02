package com.example.galgeleg.logic;

import java.util.Random;

public class StateEnd extends StatesAdapter{

    @Override
    public void startGame(Context ctx) {
        ctx.brugteBogstaver.clear();
        ctx.antalForkerteBogstaver = 0;
        ctx.spilletErVundet = false;
        ctx.spilletErTabt = false;
        if (ctx.muligeOrd.isEmpty()) throw new IllegalStateException("Listen over mulige ord er tom!");
        ctx.ordet = ctx.muligeOrd.get(new Random().nextInt(ctx.muligeOrd.size()));
        System.out.println("Nyt spil - det skjulte ord er: "+ctx.ordet);
        ctx.opdaterSynligtOrd();
        ctx.changeState(new StatePlaying());
    }

}
