package me.demerzel.move.impl;

import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/8/16.
 */
public class FirePunch extends Move {
    public FirePunch() {
        super("Fire Punch", 75, 100, 15, MoveType.PHYSICAL, Type.FIRE);
    }
}
