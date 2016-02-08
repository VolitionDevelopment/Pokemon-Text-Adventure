package me.demerzel.entity.human;

import me.demerzel.entity.Entity;
import me.demerzel.entity.pokemon.EntityPokemon;
import me.demerzel.location.Location;

import java.util.ArrayList;

/**
 * Created by Demerzel on 2/7/16.
 */
public abstract class EntityHuman extends Entity {
    private int wallet;
    private Location location;
    private ArrayList<EntityPokemon> team;


    public EntityHuman(String name) {
        super(name);
    }
}
