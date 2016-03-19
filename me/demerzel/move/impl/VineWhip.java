package me.demerzel.move.impl;

import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Jackson on 3/14/16.
 */
public class VineWhip extends Move {
    public VineWhip() {
        super("Vine Whip", 45, 100, 25, MoveType.PHYSICAL, Type.GRASS);
    }
}
