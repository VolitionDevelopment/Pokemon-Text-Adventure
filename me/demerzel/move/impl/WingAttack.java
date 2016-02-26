package me.demerzel.move.impl;

import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/8/16.
 */
public class WingAttack extends Move {
    public WingAttack() {
        super("Wing Attack", 60, 100, 35, MoveType.SPECIAL, Type.FLYING);
    }
}
