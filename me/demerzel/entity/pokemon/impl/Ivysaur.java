package me.demerzel.entity.pokemon.impl;

import me.demerzel.entity.pokemon.EntityPokemon;
import me.demerzel.entity.pokemon.ExperienceGroup;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/8/16.
 */
public class Ivysaur extends EntityPokemon {
    public Ivysaur() {
        super("Ivysaur", 60, 62, 63, 80, 80, 60, 142, "There is a plant bulb on its back. When it absorbs nutrients, the bulb is said to blossom into a large flower.", Type.GRASS, Type.POISON, ExperienceGroup.MEDIUM_SLOW);
    }
}
