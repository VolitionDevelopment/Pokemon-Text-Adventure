package me.demerzel;


import me.demerzel.state.Game;
import me.demerzel.state.impl.BattleState;
import me.demerzel.state.impl.CutsceneState;

public class Start {
    public static void main(String[] args){
        Game game = Game.getInstance();
        game.setState(CutsceneState.getInstance());
        game.init();


    }
}
