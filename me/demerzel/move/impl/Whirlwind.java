package me.demerzel.move.impl;

import me.demerzel.entity.pokemon.EntityPokemon;
import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/8/16.
 */

//TODO: Implement switching/fleeing
public class Whirlwind extends Move {
    public Whirlwind() {
        super("Whirlwind", 0, 100, 20, MoveType.STATUS, Type.FLYING);
        setGoesLast(true);
    }

    @Override
    public void execute(EntityPokemon user, EntityPokemon target){

    }
}
