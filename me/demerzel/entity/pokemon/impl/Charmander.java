package me.demerzel.entity.pokemon.impl;

import me.demerzel.entity.pokemon.EntityPokemon;
import me.demerzel.entity.pokemon.ExperienceGroup;
import me.demerzel.move.impl.Ember;
import me.demerzel.move.impl.FirePunch;
import me.demerzel.move.impl.Growl;
import me.demerzel.move.impl.Scratch;
import me.demerzel.util.Type;

/**
 * Created by Jackson on 3/14/16.
 */
public class Charmander extends EntityPokemon {
    public Charmander() {
        super("Charmander", 39, 52, 43, 60, 50, 65, 62, "", Type.FIRE, Type.NONE, ExperienceGroup.MEDIUM_SLOW);

        addCurrentMove(new Scratch());
        addCurrentMove(new Ember());
        addCurrentMove(new Growl());

        addMoveToLevelUp(2, new FirePunch());
    }
}
