package me.demerzel;


import me.demerzel.state.Game;
import me.demerzel.state.impl.BattleState;

public class Start {
    public static void main(String[] args){
        Game game = Game.getInstance();
        game.setState(BattleState.getInstance());
        game.init();
    }
}
