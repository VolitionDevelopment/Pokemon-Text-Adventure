package me.demerzel.state.impl;

import me.demerzel.state.Game;
import me.demerzel.state.State;
import me.demerzel.util.Utilities;

/**
 * Created by Demerzel on 2/7/16.
 */
public class CutsceneState implements State{
    private static CutsceneState state;

    private CutsceneState(){

    }

    public static CutsceneState getInstance(){
        if(state == null){
            state = new CutsceneState();
        }

        return state;
    }

    @Override
    public void onEnterState() {
        System.out.println("                                  ,'\\\n" +
                "    _.----.        ____         ,'  _\\   ___    ___     ____\n" +
                "_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.\n" +
                "\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |\n" +
                " \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |\n" +
                "   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |\n" +
                "    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |\n" +
                "     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |\n" +
                "      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |\n" +
                "       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |\n" +
                "        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |\n" +
                "                                `'                            '-._|");
    }



    @Override
    public void run() {
        System.out.println("=====================================");
        System.out.println("> New Game");
        System.out.println("> Continue");
        System.out.println("> Options");
        System.out.println("> Quit");


        switch (Utilities.getUserInput(">> ").toLowerCase()){
            case "new game":
            case "continue":
                Game.getInstance().setState(BattleState.getInstance());
                break;
            case "quit":
                System.exit(0);
        }

    }
}
