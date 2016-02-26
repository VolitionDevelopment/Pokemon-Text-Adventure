package me.demerzel.entity.pokemon.impl;

import me.demerzel.entity.pokemon.EntityPokemon;
import me.demerzel.entity.pokemon.ExperienceGroup;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/8/16.
 */
public class Pokemon extends EntityPokemon {
    public Pokemon(String name, int baseHP, int baseAtk, int baseDef, int baseSpA, int baseSpD, int baseSpe, int baseExpYield, String description, Type primaryType, Type secondaryType, ExperienceGroup experienceGroup) {
        super(name, baseHP, baseAtk, baseDef, baseSpA, baseSpD, baseSpe, baseExpYield, description, primaryType, secondaryType, experienceGroup);
    }
}
