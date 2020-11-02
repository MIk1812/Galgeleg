package com.example.galgeleg.logic;

import java.util.Random;

public class StatePlaying extends StatesAdapter{

    @Override
    public void guessLetter(Context ctx, String bogstav) {
        if (bogstav.length() != 1) return;
        if (ctx.brugteBogstaver.contains(bogstav)) return;
        if (ctx.spilletErVundet || ctx.spilletErTabt) return;

        ctx.brugteBogstaver.add(bogstav);

        if (ctx.ordet.contains(bogstav)) {
            ctx.sidsteBogstavVarKorrekt = true;
        } else {
            // Vi gættede på et bogstav der ikke var i ordet.
            ctx.sidsteBogstavVarKorrekt = false;
            ctx.antalForkerteBogstaver = ctx.antalForkerteBogstaver + 1;
            if (ctx.antalForkerteBogstaver > 6) {
                ctx.spilletErTabt = true;
            }
        }
        ctx.opdaterSynligtOrd();

        if(ctx.erSpilletSlut())
            ctx.changeState(new StateEnd());
    }
}
