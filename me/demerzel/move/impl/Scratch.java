package me.demerzel.move.impl;

import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/8/16.
 */
public class Scratch extends Move {
    public Scratch() {
        super("Scratch", 40, 100, 35, MoveType.PHYSICAL, Type.NORMAL);
    }
}
