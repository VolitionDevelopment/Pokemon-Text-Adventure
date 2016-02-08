package me.demerzel.move;

import me.demerzel.entity.Entity;
import me.demerzel.entity.pokemon.EntityPokemon;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/7/16.
 */
public abstract class Move {
    private String name;
    private int power;
    private int accuracy;
    private MoveType moveType;
    private Type type;

    public Move(String name, int power, int accuracy, MoveType moveType, Type type) {
        this.name = name;
        this.power = power;
        this.accuracy = accuracy;
        this.moveType = moveType;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void execute(EntityPokemon user, EntityPokemon target, Move moveUsed){
        int attack = user.getBaseAtk();
        if(moveUsed.getMoveType() == MoveType.SPECIAL){
            attack = user.getBaseSpA();
        }

        int defense = user.getBaseDef();
        if(moveUsed.getMoveType() == MoveType.SPECIAL){
            defense = user.getBaseSpD();
        }

        int damage = ((2 * user.getLevel() + 10) / 250) * (attack / defense) * moveUsed.getPower() + 2;

        target.modHP(damage);
    }
}
