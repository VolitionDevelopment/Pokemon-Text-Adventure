package me.demerzel.entity.pokemon;

import me.demerzel.entity.Entity;
import me.demerzel.entity.human.EntityPlayer;
import me.demerzel.state.Game;
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
    private int baseHP, health;
    private int baseAtk, attack;
    private int baseDef, defense;
    private int baseSpA, specialAttack;
    private int baseSpD, specialDefense;
    private int baseSpe, speed;
    private StatStage atkStage, defStage, spaStage, spdStage, speStage;
    private int accuracy;
    private int exp;
    private int level;
    private int baseExpYield;
    private boolean trainerOwned;

    private String description;
    private String sprite;
    private Type primaryType;
    private Type secondaryType;
    private HashMap<Integer, Move> learnByLevelUp;
    private ArrayList<Move> currentMoves;
    private ExperienceGroup experienceGroup;

    private EntityPokemon evolvesTo;
    private int levelToEvolve;

    public EntityPokemon(String name, int baseHP, int baseAtk, int baseDef, int baseSpA, int baseSpD, int baseSpe, int baseExpYield, String description, Type primaryType, Type secondaryType, ExperienceGroup experienceGroup) {
        super(name);
        this.baseHP = baseHP;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpA = baseSpA;
        this.baseSpD = baseSpD;
        this.baseSpe = baseSpe;

        atkStage = StatStage.STAGE_0;
        defStage = StatStage.STAGE_0;
        spaStage = StatStage.STAGE_0;
        spdStage = StatStage.STAGE_0;
        speStage = StatStage.STAGE_0;

        this.accuracy = 1;
        this.baseExpYield = baseExpYield;
        this.description = description;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.experienceGroup = experienceGroup;

        this.exp = 0;
        this.level = 1;
        this.trainerOwned = false;
        this.learnByLevelUp = new HashMap<>();
        this.currentMoves = new ArrayList<>();

        this.evolvesTo = null;
        this.levelToEvolve = -1;

        updateStats();

        this.currentHP = health;
    }

    public boolean knowsMove(String move){
        for(Move m : currentMoves){
            if(m.getName().equalsIgnoreCase(move)){
                return true;
            }
        }

        return false;
    }

    public void updateStats(){
        health = healthFormula(baseHP);
        attack = otherStatFormula(baseAtk);
        defense = otherStatFormula(baseDef);
        specialAttack = otherStatFormula(baseSpA);
        specialDefense = otherStatFormula(baseSpD);
        speed = otherStatFormula(baseSpe);
    }

    public void setStats(int[] stats){
        stats[0] = health;
        stats[1] = attack;
        stats[2] = defense;
        stats[3] = specialAttack;
        stats[4] = specialDefense;
        stats[5] = speed;
    }

    public int[] getStats(){
        return new int[] {health, attack, defense, specialAttack, specialDefense, speed};
    }

    public void evolve(){
        if(getEvolvesTo() != null){
            System.out.println(getName() + " is evolving!");
            System.out.println(getName() + " has evolved to " + getEvolvesTo().getName());

            EntityPlayer player = Game.getInstance().getPlayer();

            int i = player.getTeam().indexOf(this);

            EntityPokemon p = getEvolvesTo();
            p.setLevel(getLevel());
            p.setExp(getExp());
            p.setCurrentMoves(getCurrentMoves());
            p.updateStats();
            player.getTeam().set(i, p);

        }
    }

    private int healthFormula(int health){
        return (( (2 * health + 31 + (252 / 4) * level) / 100 ) + level + 10);
    }

    private int otherStatFormula(int stat){
        return (int) (((((31 + 2 * stat + (252 / 4)) * level) / 100) + 5) * 1.1);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public StatStage getAtkStage() {
        return atkStage;
    }

    public void setAtkStage(StatStage atkStage) {
        this.atkStage = atkStage;
    }

    public StatStage getDefStage() {
        return defStage;
    }

    public void setDefStage(StatStage defStage) {
        this.defStage = defStage;
    }

    public StatStage getSpaStage() {
        return spaStage;
    }

    public void setSpaStage(StatStage spaStage) {
        this.spaStage = spaStage;
    }

    public StatStage getSpdStage() {
        return spdStage;
    }

    public void setSpdStage(StatStage spdStage) {
        this.spdStage = spdStage;
    }

    public StatStage getSpeStage() {
        return speStage;
    }

    public void setSpeStage(StatStage speStage) {
        this.speStage = speStage;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp){
        this.exp = exp;
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

    public EntityPokemon getEvolvesTo() {
        return evolvesTo;
    }

    public void setEvolvesTo(EntityPokemon evolvesTo) {
        this.evolvesTo = evolvesTo;
    }

    public int getExpToLevel(){
        switch(experienceGroup){
            case FAST:
                return (int) ((4 * Math.pow(level + 1, 3)) / 5.0);
            case MEDIUM_FAST:
                return (int) Math.pow(level + 1, 3);
            case MEDIUM_SLOW:
                return (int) ((6.0/5.0 * Math.pow(level + 1, 3)) - (15 * Math.pow(level + 1, 2)) + (100 * level + 1) - 140);
            case SLOW:
                return (int) ((5 * Math.pow(level + 1, 3)) / 4.0);
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
        updateStats();
        setCurrentHP(health);
        System.out.println(getName() + " has grown to level " + level + "!");

        if(learnByLevelUp.get(level) != null){
            learnMove(learnByLevelUp.get(level));
        }

        if(getEvolvesTo() != null){
            if(levelToEvolve == level){
                setCurrentHP(getHealth());
                evolve();
            }
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

    public void setCurrentMoves(ArrayList<Move> moves){ this.currentMoves = moves;}

    public void addCurrentMove(Move move){
        currentMoves.add(move);
    }

    public void learnMove(Move move){
        if(currentMoves.size() == 4){
            String choice = Utilities.getUserInput(getName() + " wants to learn " + move.getName() + " but already knows four moves. Forget a move? (y/n)");
            if(choice.equalsIgnoreCase("y")){
                System.out.println("Which move should be deleted?");
                currentMoves.stream().forEach(toForget -> System.out.println(currentMoves.indexOf(toForget) + " | " + toForget.getName()));
                System.out.println("4 | " + move.getName());
                int forget = Integer.parseInt(Utilities.getUserInput(""));
                if(forget == 4){
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

    public int getLevelToEvolve() {
        return levelToEvolve;
    }

    public void setLevelToEvolve(int levelToEvolve) {
        this.levelToEvolve = levelToEvolve;
    }

    public boolean useMove(int move, EntityPokemon target){
        currentMoves.get(move).execute(this, target);
        return true;
    }

    public boolean useMove(String move, EntityPokemon target){
        int index = 0;
        for(Move m : getCurrentMoves()){
            if(m.getName().equalsIgnoreCase(move)){
                useMove(index, target);
                return true;
            }

            index++;
        }

        return false;
    }

    @Override
    public String toString() {
        return "EntityPokemon{" +
                "currentHP=" + currentHP +
                ", baseHP=" + baseHP +
                ", health=" + health +
                ", baseAtk=" + baseAtk +
                ", attack=" + attack +
                ", baseDef=" + baseDef +
                ", defense=" + defense +
                ", baseSpA=" + baseSpA +
                ", specialAttack=" + specialAttack +
                ", baseSpD=" + baseSpD +
                ", specialDefense=" + specialDefense +
                ", baseSpe=" + baseSpe +
                ", speed=" + speed +
                '}';
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }
}
