package me.demerzel.state;

import me.demerzel.entity.human.EntityPlayer;
import me.demerzel.entity.pokemon.impl.Bulbasaur;
import me.demerzel.entity.pokemon.impl.Ivysaur;
import me.demerzel.state.impl.*;
import sun.awt.SunToolkit;

/**
 * Created by Demerzel on 2/7/16.
 */
public class Game {
    private EntityPlayer player;
    private State currentState;
    private static Game game;

    private Game(){
        currentState = GameState.getInstance();
        player = new EntityPlayer("Jackson");
        player.addPokemon(new Bulbasaur());
        player.addPokemon(new Ivysaur());
    }

    public static Game getInstance(){
        if(game == null){
            game = new Game();
        }

        return game;
    }

    public EntityPlayer getPlayer() {
        return player;
    }

    public void setPlayer(EntityPlayer player) {
        this.player = player;
    }

    public void setState(State state){
        currentState = state;

        state.onEnterState();
    }

    public void init(){
        while(true)
            currentState.run();
    }
}
