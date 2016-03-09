package me.demerzel.util;

import java.util.Arrays;

/**
 * Created by Demerzel on 2/7/16.
 */
public enum Type {
    NORMAL(),
    FIRE(),
    FIGHTING(),
    WATER(),
    FLYING(),
    GRASS(),
    POISON(),
    ELECTRIC(),
    GROUND(),
    PSYCHIC(),
    ROCK(),
    ICE(),
    BUG(),
    DRAGON(),
    GHOST(),
    DARK(),
    STEEL(),
    FAIRY(),
    UNKNOWN();

    private Type[] resistances;
    private Type[] weaknesses;
    private Type[] immune;


    public Type[] getWeaknesses() {
        return weaknesses;
    }

    public Type[] getImmune() {
        return immune;
    }

    public Type[] getResistances() {
        return resistances;
    }

    public boolean isWeakTo(Type attacker){
        return Arrays.asList(weaknesses).contains(attacker);
    }

    public boolean isResistantTo(Type attacker){
        return Arrays.asList(resistances).contains(attacker);
    }

    public boolean isImmuneTo(Type attacker){
        return Arrays.asList(immune).contains(attacker);
    }
}
