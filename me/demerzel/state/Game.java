package me.demerzel.state;

import me.demerzel.state.impl.*;
import sun.awt.SunToolkit;

/**
 * Created by Demerzel on 2/7/16.
 */
public class Game {
    State currentState;

    public Game(){
        currentState = new GameState();
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
