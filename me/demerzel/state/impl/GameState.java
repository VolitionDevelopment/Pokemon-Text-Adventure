package me.demerzel.state.impl;

import me.demerzel.state.Game;
import me.demerzel.state.State;

/**
 * Created by Demerzel on 2/7/16.
 */
public class GameState implements State{
    private static GameState state;

    private GameState(){

    }

    public static GameState getInstance(){
        if(state == null){
            state = new GameState();
        }

        return state;
    }

    @Override
    public void onEnterState() {
        System.out.println("Entered Game State!");
    }

    @Override
    public void run(){

    }
}
