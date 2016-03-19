package me.demerzel.move.impl;

import me.demerzel.entity.pokemon.EntityPokemon;
import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/8/16.
 */

//TODO: Implement stat changing moves
public class SwordsDance extends Move {
    public SwordsDance() {
        super("Swords Dance", 0, 100, 20, MoveType.STATUS, Type.NORMAL);
    }

    @Override
    public void execute(EntityPokemon user, EntityPokemon target){
        System.out.println(user.getName() + " used " + getName() + "!");

        if(user.getAtkStage().increment() == user.getAtkStage()){
            System.out.println(user.getName() + "'s Attack couldn't go any higher!");
        }else{
            System.out.println(user.getName() + "'s Attack rose sharply!");
            user.setAtkStage(user.getAtkStage().increment());
            user.setAtkStage(user.getAtkStage().increment());
        }
    }
}
