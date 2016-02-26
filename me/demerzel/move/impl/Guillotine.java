package me.demerzel.move.impl;

import me.demerzel.entity.human.EntityPlayer;
import me.demerzel.entity.pokemon.EntityPokemon;
import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/8/16.
 */
public class Guillotine extends Move {
    public Guillotine() {
        super("Guillotine", 0, 0, 5, MoveType.PHYSICAL, Type.NORMAL);
    }

    @Override
    public void execute(EntityPokemon user, EntityPokemon target){
        int accuracy = (user.getLevel() - target.getLevel()) + 30;
        double d = Math.random();
        System.out.println(user.getName() + " used " + getName() + "!");
        if(d <= accuracy * 0.01){
            target.setCurrentHP(0);
            System.out.println("It was a one-hit KO!");
        }else{
            System.out.println("The attack missed!");
        }
    }
}
