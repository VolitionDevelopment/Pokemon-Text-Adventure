package me.demerzel.move.impl;

import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/8/16.
 */
public class DoubleSlap extends Move {
    public DoubleSlap(){
        super("Double Slap", 15, 85, 10, MoveType.PHYSICAL, Type.NORMAL);
    }
}
