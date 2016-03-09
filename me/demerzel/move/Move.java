package me.demerzel.move;

import me.demerzel.entity.pokemon.EntityPokemon;
import me.demerzel.util.Type;

/**
 * Created by Demerzel on 2/7/16.
 */
public abstract class Move {
    private String name;
    private String description;
    private int power;
    private int accuracy;
    private int maxPP;
    private int currentPP;
    private boolean goesLast;
    private MoveType moveType;
    private Type type;
    private CritStage critStage;

    public Move(String name, int power, int accuracy, int maxPP, MoveType moveType, Type type) {
        this.name = name;
        this.description = "NULl MOVE";
        this.power = power;
        this.accuracy = accuracy;
        this.moveType = moveType;
        this.type = type;
        this.goesLast = false;
        this.critStage = CritStage.STAGE_0;
        this.maxPP = maxPP;
        this.currentPP = maxPP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getMaxPP() {
        return maxPP;
    }

    public void setMaxPP(int maxPP) {
        this.maxPP = maxPP;
    }

    public int getCurrentPP() {
        return currentPP;
    }

    public void setCurrentPP(int currentPP) {
        this.currentPP = currentPP;
    }

    public boolean doesGoLast() {
        return goesLast;
    }

    public void setGoesLast(boolean goesLast) {
        this.goesLast = goesLast;
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

    public CritStage getCritStage() {
        return critStage;
    }

    public void setCritStage(CritStage critStage) {
        this.critStage = critStage;
    }

    public void execute(EntityPokemon user, EntityPokemon target){
        System.out.println(user.getName() + " used " + getName() + "!");
        double d = Math.random();
        double atkMultiplier = user.getAtkStage().getMultiplier();
        double defMultiplier = user.getDefStage().getMultiplier();
        if(d <= getAccuracy() * 0.01){
            int attack = user.getAttack();
            if(this.getMoveType() == MoveType.SPECIAL){
                attack = user.getSpecialAttack();
                atkMultiplier = user.getSpaStage().getMultiplier();
            }

            int defense = user.getDefense();
            if(this.getMoveType() == MoveType.SPECIAL){
                defense = user.getSpecialDefense();
                defMultiplier = user.getSpdStage().getMultiplier();
            }

            //double random = ThreadLocalRandom.current().nextDouble(0.85, 1);

            double multiplier = 1;

            if(target.getPrimaryType().isWeakTo(getType())){
                multiplier *= 2;
            }

            if(target.getSecondaryType().isWeakTo(getType())){
                multiplier *= 2;
            }

            if(target.getPrimaryType().isResistantTo(getType())){
                multiplier *= 0.5;
            }

            if(target.getSecondaryType().isResistantTo(getType())){
                multiplier *= 0.5;
            }

            if(target.getPrimaryType().isImmuneTo(getType())){
                multiplier = 0;
            }

            if(target.getSecondaryType().isImmuneTo(getType())){
                multiplier = 0;
            }

            if(multiplier > 1){
                System.out.println("It's super effective!");
            }else if(multiplier == 0){
                System.out.println("It had no effect!");
            }else if(multiplier < 1){
                System.out.println("It's not very effective...");
            }

            int damage = (int) ((((user.getLevel() * 2 + 10) / 250.0) * (getPower()) * (attack * atkMultiplier/ defense * defMultiplier) + 2) * multiplier);
            target.modHP(-damage);
            setCurrentPP(getCurrentPP() - 1);
        }else{
            System.out.println("The attack missed!");
        }

        effect(user, target);
    }

    public void effect(EntityPokemon user, EntityPokemon target){

    }
}
