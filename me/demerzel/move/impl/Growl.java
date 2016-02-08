package me.demerzel.move.impl;

import me.demerzel.entity.pokemon.EntityPokemon;
import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/7/16.
 */
public class Growl extends Move {
    public Growl() {
        super("Growl", 0, 0, MoveType.STATUS, Type.NORMAL);
    }

    @Override
    public void execute(EntityPokemon user, EntityPokemon target, Move move){

    }
}
