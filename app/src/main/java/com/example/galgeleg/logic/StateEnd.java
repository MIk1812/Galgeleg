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
        ctx.opdaterSynligtOrd();

        //Remeber to change the state of the context
        ctx.changeState(new StatePlaying());
    }

}
