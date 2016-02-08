package me.demerzel;

import me.demerzel.entity.pokemon.EntityPokemon;
import me.demerzel.entity.pokemon.impl.Bulbasaur;

/**
 * Created by Demerzel on 2/7/16.
 */
public class Start {
    public static void main(String[] args) {
        EntityPokemon bulbasaur = new Bulbasaur();

        bulbasaur.addExp(1757);
    }
}
