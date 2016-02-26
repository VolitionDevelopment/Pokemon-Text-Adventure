package me.demerzel.move;

import me.demerzel.entity.pokemon.EntityPokemon;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/8/16.
 */
public abstract class MultiHit extends Move {

    public MultiHit(String name, int power, int accuracy, int pp, MoveType moveType, Type type) {
        super(name, power, accuracy, pp, moveType, type);
    }

    @Override
    public void execute(EntityPokemon user, EntityPokemon target){
        double d = Math.random();
        if(d <= 0.33){
            super.execute(user, target);
            super.execute(user, target);
            System.out.println("Hit 2 times!");
        }else if(d <= 0.66){
            super.execute(user, target);
            super.execute(user, target);
            super.execute(user, target);
            System.out.println("Hit 3 times!");
        }else if(d <= 0.827){
            super.execute(user, target);
            super.execute(user, target);
            super.execute(user, target);
            super.execute(user, target);
            System.out.println("Hit 4 times!");
        }else if(d <= 1){
            super.execute(user, target);
            super.execute(user, target);
            super.execute(user, target);
            super.execute(user, target);
            super.execute(user, target);
            System.out.println("Hit 5 times!");
        }
    }
}
