package me.demerzel.move.impl;

import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/8/16.
 */
public class MegaPunch extends Move {
    public MegaPunch() {
        super("Mega Punch", 80, 85, 20, MoveType.PHYSICAL, Type.NORMAL);
    }
}
