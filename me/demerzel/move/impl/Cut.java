package me.demerzel.move.impl;

import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/8/16.
 */
public class Cut extends Move {
    public Cut() {
        super("Cut", 50, 95, 30, MoveType.PHYSICAL, Type.NORMAL);
    }
}
