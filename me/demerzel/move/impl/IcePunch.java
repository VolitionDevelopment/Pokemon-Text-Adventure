package me.demerzel.move.impl;

import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/8/16.
 */
public class IcePunch extends Move {
    public IcePunch() {
        super("Ice Punch", 75, 100, 15, MoveType.PHYSICAL, Type.ICE);
    }
}
