package me.demerzel.entity.human.npc.impl;

import me.demerzel.entity.human.npc.EntityNpc;
import me.demerzel.entity.pokemon.impl.Bulbasaur;

/**
 * Created by Jackson on 2/25/16.
 */
public class Gary extends EntityNpc{
    public Gary() {
        super("Gary", "Rival");
        addPokemon(new Bulbasaur());
    }
}
