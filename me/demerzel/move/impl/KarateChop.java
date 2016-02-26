package me.demerzel.move.impl;

import me.demerzel.move.CritStage;
import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/8/16.
 */
public class KarateChop extends Move {
    public KarateChop() {
        super("Karate Chop", 50, 100, 25, MoveType.PHYSICAL, Type.FIGHTING);
        setDescription("The target is attacked with a sharp chop. Critical hits land more easily.");
        setCritStage(CritStage.STAGE_1);
    }
}
