package me.demerzel.move.impl;

import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/8/16.
 */
public class ViceGrip extends Move {
    public ViceGrip() {
        super("Vice Grip", 55, 100, 30, MoveType.PHYSICAL, Type.NORMAL);
    }
}
