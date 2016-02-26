package me.demerzel.move.impl;

import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/8/16.
 */
public class Pound extends Move {
    public Pound() {
        super("Pound", 40, 100, 35, MoveType.PHYSICAL, Type.NORMAL);
        setDescription("The target is physically pounded with a long tail, a foreleg, or the like.");
    }
}
