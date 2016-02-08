package me.demerzel.move.impl;

import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/7/16.
 */
public class VineWhip extends Move {
    public VineWhip() {
        super("Vine Whip", 45, 100, MoveType.PHYSICAL, Type.GRASS);
    }
}
