package me.demerzel.move.impl;

import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Jackson on 3/14/16.
 */
public class Ember extends Move {
    public Ember() {
        super("Ember", 40, 100, 25, MoveType.SPECIAL, Type.FIRE);
    }
}
