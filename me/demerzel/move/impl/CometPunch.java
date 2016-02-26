package me.demerzel.move.impl;

import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.move.MultiHit;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/8/16.
 */
public class CometPunch extends MultiHit {
    public CometPunch() {
        super("Comet Punch", 18, 85, 15, MoveType.PHYSICAL, Type.NORMAL);
    }
}
