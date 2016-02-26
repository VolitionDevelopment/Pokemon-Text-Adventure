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
        team = new ArrayList<>();
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<EntityPokemon> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<EntityPokemon> team) {
        this.team = team;
    }

    public void addPokemon(EntityPokemon pokemon){
        this.team.add(pokemon);
    }

    public int getAlivePokemon(){
        int i = 0;
        for(EntityPokemon p : getTeam()){
            if(p.getCurrentHP() > 0){
                i++;
            }
        }

        return i;
    }
}
