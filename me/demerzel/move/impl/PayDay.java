package me.demerzel.move.impl;

import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/8/16.
 */
public class PayDay extends Move {
    public PayDay() {
        super("Pay Day", 40, 100, 20, MoveType.PHYSICAL, Type.NORMAL);
    }
}
