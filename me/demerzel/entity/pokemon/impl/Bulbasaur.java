package me.demerzel.entity.pokemon.impl;

import me.demerzel.entity.pokemon.ExperienceGroup;
import me.demerzel.move.impl.*;
import me.demerzel.util.Type;
import me.demerzel.entity.pokemon.EntityPokemon;

/**
 * Created by Demerzel on 2/7/16.
 */
public class Bulbasaur extends EntityPokemon {

    public Bulbasaur() {
        super("Bulbasaur", 45, 49, 49, 65, 65, 45, 64, "", Type.GRASS, Type.POISON, ExperienceGroup.FAST);

        addCurrentMove(new Tackle());
        addMoveToLevelUp(3, new Growl());
        addMoveToLevelUp(7, new LeechSeed());
        addMoveToLevelUp(9, new VineWhip());
        addMoveToLevelUp(13, new PoisonPowder());
    }
}
