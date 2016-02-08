package me.demerzel.entity.pokemon;

import me.demerzel.entity.Entity;
import me.demerzel.util.Type;
import me.demerzel.move.Move;
import me.demerzel.util.Utilities;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Demerzel on 2/7/16.
 */
public abstract class EntityPokemon extends Entity{
    private int currentHP;
    private int baseHP;
    private int baseAtk;
    private int baseDef;
    private int baseSpA;
    private int baseSpD;
    private int baseSpe;
    private int exp;
    private int level;
    private int baseExpYield;
    private boolean trainerOwned;

    private String description;
    private Type primaryType;
    private Type secondaryType;
    private HashMap<Integer, Move> learnByLevelUp;
    private ArrayList<Move> currentMoves;
    private ExperienceGroup experienceGroup;

    public EntityPokemon(String name, int baseHP, int baseAtk, int baseDef, int baseSpA, int baseSpD, int baseSpe, int baseExpYield, String description, Type primaryType, Type secondaryType, ExperienceGroup experienceGroup) {
        super(name);
        this.baseHP = baseHP;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpA = baseSpA;
        this.baseSpD = baseSpD;
        this.baseSpe = baseSpe;
        this.baseExpYield = baseExpYield;
        this.description = description;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.experienceGroup = experienceGroup;

        this.exp = 0;
        this.level = 1;
        this.currentHP = baseHP;
        this.trainerOwned = false;
        this.learnByLevelUp = new HashMap<>();
        this.currentMoves = new ArrayList<>();
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public void modHP(int hp){
        this.currentHP += hp;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }

    public int getBaseAtk() {
        return baseAtk;
    }

    public void setBaseAtk(int baseAtk) {
        this.baseAtk = baseAtk;
    }

    public int getBaseDef() {
        return baseDef;
    }

    public void setBaseDef(int baseDef) {
        this.baseDef = baseDef;
    }

    public int getBaseSpA() {
        return baseSpA;
    }

    public void setBaseSpA(int baseSpA) {
        this.baseSpA = baseSpA;
    }

    public int getBaseSpD() {
        return baseSpD;
    }

    public void setBaseSpD(int baseSpD) {
        this.baseSpD = baseSpD;
    }

    public int getBaseSpe() {
        return baseSpe;
    }

    public void setBaseSpe(int baseSpe) {
        this.baseSpe = baseSpe;
    }

    public int getExp() {
        return exp;
    }

    public void addExp(int exp) {
        if(getLevel() < 100){
            this.exp += exp;
            System.out.println(getName() + " has gained " + exp + " EXP!");
            while(getExpToNextLevel() <= 0){
                levelUp();
            }
        }
    }

    public int getExpToLevel(){
        switch(experienceGroup){
            case FAST:
                return (int) (4 * Math.pow(level + 1, 3)) / 5;
            case MEDIUM_FAST:
                return (int) Math.pow(level + 1, 3);
            case MEDIUM_SLOW:
                return (int) ((6/5 * Math.pow(level + 1, 3)) - (15 * Math.pow(level + 1, 2)) + (100 * level + 1) - 140);
            case SLOW:
                return (int) (5 * Math.pow(level + 1, 3)) / 4;
            default:
                return -1;
        }
    }

    public int getExpToNextLevel(){
        return getExpToLevel() - exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void levelUp(){
        level++;
        System.out.println(getName() + " has grown to level " + level + "!");

        if(learnByLevelUp.get(level) != null){
            learnMove(learnByLevelUp.get(level));
        }
    }

    public int getBaseExpYield() {
        return baseExpYield;
    }

    public void setBaseExpYield(int baseExpYield) {
        this.baseExpYield = baseExpYield;
    }

    public boolean isTrainerOwned() {
        return trainerOwned;
    }

    public void setTrainerOwned(boolean trainerOwned) {
        this.trainerOwned = trainerOwned;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getPrimaryType() {
        return primaryType;
    }

    public void setPrimaryType(Type primaryType) {
        this.primaryType = primaryType;
    }

    public Type getSecondaryType() {
        return secondaryType;
    }

    public void setSecondaryType(Type secondaryType) {
        this.secondaryType = secondaryType;
    }

    public HashMap<Integer, Move> getLearnByLevelUp() {
        return learnByLevelUp;
    }

    public void addMoveToLevelUp(int level, Move move){
        learnByLevelUp.put(level, move);
    }

    public ArrayList<Move> getCurrentMoves() {
        return currentMoves;
    }

    public void addCurrentMove(Move move){
        currentMoves.add(move);
    }

    public void learnMove(Move move){
        if(currentMoves.size() == 4){
            String choice = Utilities.getUserInput(getName() + " wants to learn " + move.getName() + " but already knows four moves. Forget a move? (y/n)");
            if(choice.equalsIgnoreCase("y")){
                System.out.println("Which move should be deleted?");
                currentMoves.stream().forEach(toForget -> System.out.println(currentMoves.indexOf(toForget) + " | " + toForget.getName()));
                System.out.println("5 | " + move.getName());
                int forget = Integer.parseInt(Utilities.getUserInput(""));
                if(forget == 5){
                    learnMove(move);
                }else{
                    System.out.println(getName() + " has forgotten " + currentMoves.get(forget).getName() + " and learned " + move.getName() + "!");
                    currentMoves.remove(forget);
                    currentMoves.add(move);
                }
            }
        }else{
            System.out.println(getName() + " has learned " + move.getName() + "!");
            currentMoves.add(move);
        }
    }
}
