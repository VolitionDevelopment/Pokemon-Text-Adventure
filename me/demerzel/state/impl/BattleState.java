package me.demerzel.state.impl;

import me.demerzel.entity.human.EntityPlayer;
import me.demerzel.entity.human.npc.EntityNpc;
import me.demerzel.entity.human.npc.impl.Gary;
import me.demerzel.entity.pokemon.EntityPokemon;
import me.demerzel.state.Game;
import me.demerzel.state.State;
import me.demerzel.util.Utilities;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Demerzel on 2/7/16.
 */
public class BattleState implements State {
    private static BattleState battleState;

    private EntityPlayer player;
    private EntityNpc opponent;

    private EntityPokemon p1;
    private EntityPokemon p2;

    private BattleState(){
        opponent = new Gary();
        player = Game.getInstance().getPlayer();
    }

    public static BattleState getInstance(){
        if(battleState == null){
            battleState = new BattleState();
        }

        return battleState;
    }

    @Override
    public void onEnterState() {
        System.out.println("=======================================");
        System.out.println(opponent.getFullName() + " wants to battle!");
        System.out.println("You sent out " + player.getTeam().get(0).getName());
        System.out.println(opponent.getFullName() + " sent out " + opponent.getTeam().get(0).getName());
        p1 = player.getTeam().get(0);
        p2 = opponent.getTeam().get(0);
        System.out.println("=======================================");
        System.out.println();

    }

    @Override
    public void run(){
        showPokemon(p1);
        showPokemon(p2);
        showMenu();
    }

    private void showMenu(){
        System.out.println("What will you do?");
        Utilities.drawMenu("Fight", "Items", "Pokemon", "Run");

        String input = Utilities.getUserInput("> ").toLowerCase();

        switch(input){
            case "fight":
                System.out.println();
                fight();
                break;
            case "switch":
            case "pokemon":
            case "team":
                System.out.println();
                switchTo();
                break;
            default:
                System.out.println("Unrecognized command!");
                showMenu();
        }
    }

    private boolean check(){
        if(p1.getCurrentHP() <= 0){
            System.out.println(p1.getName() + " fainted!");

            if(player.getAlivePokemon() == 0){
                System.out.println("You have no more Pokemon that can fight!");
                System.out.println(player.getName() + " blacked out...");
                Game.getInstance().setState(GameState.getInstance());
                return false;
            }

            switchTo();
        }

        if(p2.getCurrentHP() <= 0){
            int gained = (int) ((1.5 * p2.getBaseExpYield() * 1 * p2.getLevel() * 1 * 1 * 1 * 1) / 7);

            System.out.println("The enemy " + p2.getName() + " fainted!");
            p1.addExp(gained);

            if(opponent.getAlivePokemon() == 0){
                System.out.println("You win!");
                Game.getInstance().setState(GameState.getInstance());
                return false;
            }
        }

        return true;
    }

    private void fight(){
        System.out.println("Choose a move: ");
        ArrayList<String> moves = new ArrayList<>();
        p1.getCurrentMoves().stream().forEach(s -> moves.add(s.getName()));
        Utilities.drawMenu(moves.toArray(new String[moves.size()]));

        String input = Utilities.getUserInput("> ");

        if(input.equalsIgnoreCase("back")){
            return;
        }

        if(p1.getSpeed() >= p2.getSpeed()){
            if(!p1.useMove(input, p2)){
                System.out.println("Pokemon doesn't know that move!");
                fight();
            }

            if(!check()){
                return;
            }

            Random rand = new Random();
            System.out.print("Enemy ");
            p2.useMove(rand.nextInt(p2.getCurrentMoves().size()), p1);

            check();
        }else{
            Random rand = new Random();
            System.out.print("Enemy ");
            p2.useMove(rand.nextInt(p2.getCurrentMoves().size()), p1);

            if(!check()){
                return;
            }

            if(!p1.useMove(input, p2)){
                System.out.println("Pokemon doesn't know that move!");
                fight();
            }

            check();
        }
    }

    private void switchTo(){
        System.out.println("Choose a Pokemon: ");

        for(int i = 0; i < player.getTeam().size(); i++){
            EntityPokemon pokemon = player.getTeam().get(i);
            System.out.println("> [" + i + "] " + pokemon.getName() + " [HP: " + pokemon.getCurrentHP() + "]");
        }

        String in = Utilities.getUserInput("> ");

        if(in.equalsIgnoreCase("back")){
            return;
        }

        int input = Integer.parseInt(in);

        if(player.getTeam().get(input).equals(p1)){
            System.out.println("That Pokemon is already out!");
            switchTo();
        }

        System.out.print(p1.getName() + " was withdrawn. ");
        p1 = player.getTeam().get(input);
        System.out.println("Go, " + p1.getName() + "!");

    }

    public EntityPlayer getPlayer() {
        return player;
    }

    public void setPlayer(EntityPlayer player) {
        this.player = player;
    }

    public EntityNpc getOpponent() {
        return opponent;
    }

    public void setOpponent(EntityNpc opponent) {
        this.opponent = opponent;
    }

    private void showPokemon(EntityPokemon pokemon){
        double yourHpPercent = (pokemon.getCurrentHP() * 1.0 / pokemon.getHealth()) * 100D;

        System.out.println("=======================================");

        if(pokemon.equals(p2)){
            System.out.print("Enemy ");
        }

        System.out.println(pokemon.getName() + " LV: " + pokemon.getLevel());
        System.out.print("HP: " + pokemon.getCurrentHP() + "/" + pokemon.getHealth() + " | ");
        System.out.print("[");
        for(int i = 0; i < yourHpPercent / 5.0; i++){
            System.out.print("=");
        }
        System.out.println("]");
        System.out.println("=======================================");
    }
}
