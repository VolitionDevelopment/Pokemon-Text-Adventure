package me.demerzel.move.impl;

import me.demerzel.entity.pokemon.EntityPokemon;
import me.demerzel.move.Move;
import me.demerzel.move.MoveType;
import me.demerzel.util.Type;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Demerzel on 2/8/16.
 */
public class RazorWind extends Move {
    private boolean charged = false;

    public RazorWind() {
        super("Razor Wind", 80, 100, 10, MoveType.SPECIAL, Type.NORMAL);
    }

    @Override
    public void execute(EntityPokemon user, EntityPokemon target){
        if(charged){
            System.out.println(user.getName() + " used " + getName() + "!");
            double d = Math.random();
            if(d <= getAccuracy() * 0.01){
                int attack = user.getBaseAtk();
                if(this.getMoveType() == MoveType.SPECIAL){
                    attack = user.getBaseSpA();
                }

                int defense = user.getBaseDef();
                if(this.getMoveType() == MoveType.SPECIAL){
                    defense = user.getBaseSpD();
                }

                double random = ThreadLocalRandom.current().nextDouble(0.85, 1);
                int damage = (int) ((((2 * user.getLevel() + 10) / 250) * (attack / defense) * this.getPower() + 2) * random);
                target.modHP(damage);
                System.out.println(target.getName() + " took " + damage + " damage! [Remaining HP: " + target.getCurrentHP() + "]");
            }else{
                System.out.println("The attack missed!");
            }
        }

        effect(user, target);
    }

    @Override
    public void effect(EntityPokemon user, EntityPokemon target){
        if(!charged){
            System.out.println(user.getName() + " whipped up a whirlwind!");
            charged = true;
        }
    }
}
