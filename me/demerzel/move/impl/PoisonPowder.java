package me.demerzel.move.impl;

import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/7/16.
 */
public class PoisonPowder extends Move {
    public PoisonPowder() {
        super("Poison Powder", 0, 75, MoveType.STATUS, Type.POISON);
    }
}
