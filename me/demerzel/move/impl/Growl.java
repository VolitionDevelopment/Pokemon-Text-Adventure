package me.demerzel.move.impl;

import me.demerzel.entity.pokemon.EntityPokemon;
import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

/**
 * Created by Jackson on 3/14/16.
 */
public class Growl extends Move {
    public Growl() {
        super("Growl", 0, 100, 20, MoveType.STATUS, Type.NORMAL);
    }

    @Override
    public void execute(EntityPokemon user, EntityPokemon target){
        System.out.println(user.getName() + " used " + getName() + "!");

        if(target.getAtkStage().decriment() == target.getAtkStage()){
            System.out.println(target.getName() + "'s Attack couldn't go any lower!");
        }else{
            System.out.println(target.getName() + "'s Attack fell!");
            user.setAtkStage(target.getAtkStage().decriment());
        }
    }
}
