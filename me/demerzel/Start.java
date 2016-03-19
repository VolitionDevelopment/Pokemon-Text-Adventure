package me.demerzel;


import me.demerzel.state.Game;

public class Start {
    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.init();
    }
}