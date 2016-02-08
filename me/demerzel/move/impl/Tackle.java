package me.demerzel.move.impl;

import me.demerzel.entity.pokemon.EntityPokemon;
import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/7/16.
 */
public class Tackle extends Move {
    public Tackle() {
        super("Tackle", 50, 100, MoveType.PHYSICAL, Type.NORMAL);
    }
}
