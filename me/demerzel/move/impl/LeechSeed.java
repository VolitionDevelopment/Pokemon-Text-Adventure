package me.demerzel.move.impl;

import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/7/16.
 */
public class LeechSeed extends Move {
    public LeechSeed() {
        super("Leech Seed", 0, 90, MoveType.STATUS, Type.GRASS);
    }
}
