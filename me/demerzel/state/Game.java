package me.demerzel.state;

import me.demerzel.entity.human.EntityPlayer;
import me.demerzel.entity.pokemon.impl.Bulbasaur;
import me.demerzel.entity.pokemon.impl.Charmander;
import me.demerzel.entity.pokemon.impl.Ivysaur;
import me.demerzel.state.impl.*;
import me.demerzel.util.Type;
import sun.awt.SunToolkit;

/**
 * Created by Demerzel on 2/7/16.
 */
public class Game {
    private EntityPlayer player;
    private State currentState;
    private static Game game;

    private Game(){
        currentState = CutsceneState.getInstance();
        player = new EntityPlayer("Jackson");
        player.addPokemon(new Charmander());


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
        Type.NORMAL.setResistances(new Type[]{});
        Type.NORMAL.setWeaknesses(new Type[]{Type.FIGHTING});
        Type.NORMAL.setImmune(new Type[]{Type.GHOST});

        Type.FIRE.setResistances(new Type[]{Type.FIRE, Type.GRASS, Type.ICE, Type.BUG, Type.STEEL, Type.FAIRY});
        Type.FIRE.setWeaknesses(new Type[]{Type.WATER, Type.GROUND, Type.ROCK});
        Type.FIRE.setImmune(new Type[]{});

        Type.WATER.setResistances(new Type[]{Type.FIRE, Type.WATER, Type.ICE, Type.STEEL});
        Type.WATER.setWeaknesses(new Type[]{Type.ELECTRIC, Type.GRASS});
        Type.WATER.setImmune(new Type[]{});

        Type.ELECTRIC.setResistances(new Type[]{Type.ELECTRIC, Type.STEEL});
        Type.ELECTRIC.setWeaknesses(new Type[]{Type.GROUND});
        Type.ELECTRIC.setImmune(new Type[]{});

        Type.GRASS.setResistances(new Type[]{Type.WATER, Type.ELECTRIC, Type.GRASS, Type.GROUND});
        Type.GRASS.setWeaknesses(new Type[]{Type.FIRE, Type.ICE, Type.POISON, Type.FLYING, Type.BUG});
        Type.GRASS.setImmune(new Type[]{});

        Type.ICE.setResistances(new Type[]{Type.ICE});
        Type.ICE.setWeaknesses(new Type[]{Type.FIRE, Type.FIGHTING, Type.ROCK, Type.STEEL});
        Type.ICE.setImmune(new Type[]{});

        Type.FIGHTING.setResistances(new Type[]{Type.BUG, Type.ROCK, Type.DARK});
        Type.FIGHTING.setWeaknesses(new Type[]{Type.FLYING, Type.PSYCHIC, Type.FAIRY});
        Type.FIGHTING.setImmune(new Type[]{});

        Type.POISON.setResistances(new Type[]{Type.GRASS, Type.FIGHTING, Type.POISON, Type.BUG, Type.FAIRY});
        Type.POISON.setWeaknesses(new Type[]{Type.GROUND, Type.PSYCHIC});
        Type.POISON.setImmune(new Type[]{});

        Type.GROUND.setResistances(new Type[]{Type.POISON, Type.ROCK});
        Type.GROUND.setWeaknesses(new Type[]{Type.WATER, Type.GRASS, Type.ICE});
        Type.GROUND.setImmune(new Type[]{Type.ELECTRIC});

        Type.FLYING.setResistances(new Type[]{Type.GRASS, Type.FIGHTING, Type.BUG});
        Type.FLYING.setWeaknesses(new Type[]{Type.ELECTRIC, Type.ICE, Type.ROCK});
        Type.FLYING.setImmune(new Type[]{Type.GROUND});

        Type.PSYCHIC.setResistances(new Type[]{Type.FIGHTING, Type.PSYCHIC});
        Type.PSYCHIC.setWeaknesses(new Type[]{Type.BUG, Type.GHOST, Type.DARK});
        Type.PSYCHIC.setImmune(new Type[]{});

        Type.BUG.setResistances(new Type[]{Type.GRASS, Type.FIGHTING, Type.GROUND});
        Type.BUG.setWeaknesses(new Type[]{Type.FIRE, Type.FLYING, Type.ROCK});
        Type.BUG.setImmune(new Type[]{});

        Type.ROCK.setResistances(new Type[]{Type.NORMAL, Type.FIRE, Type.POISON, Type.FLYING});
        Type.ROCK.setWeaknesses(new Type[]{Type.WATER, Type.GRASS, Type.FIGHTING, Type.GROUND, Type.STEEL});
        Type.ROCK.setImmune(new Type[]{});

        Type.GHOST.setResistances(new Type[]{Type.POISON, Type.BUG});
        Type.GHOST.setWeaknesses(new Type[]{Type.GHOST, Type.DARK});
        Type.GHOST.setImmune(new Type[]{Type.NORMAL, Type.FIGHTING});

        Type.DRAGON.setResistances(new Type[]{Type.FIRE, Type.WATER, Type.ELECTRIC, Type.GRASS});
        Type.DRAGON.setWeaknesses(new Type[]{Type.ICE, Type.DRAGON, Type.FAIRY});
        Type.DRAGON.setImmune(new Type[]{});

        Type.DARK.setResistances(new Type[]{Type.GHOST, Type.DARK});
        Type.DARK.setWeaknesses(new Type[]{Type.FIGHTING, Type.BUG, Type.FAIRY});
        Type.DARK.setImmune(new Type[]{Type.PSYCHIC});

        Type.STEEL.setResistances(new Type[]{Type.NORMAL, Type.GRASS, Type.ICE, Type.FLYING, Type.PSYCHIC, Type.BUG, Type.ROCK, Type.DRAGON, Type.STEEL, Type.FAIRY});
        Type.STEEL.setWeaknesses(new Type[]{Type.FIRE, Type.FIGHTING, Type.GROUND});
        Type.STEEL.setImmune(new Type[]{Type.POISON});

        Type.FAIRY.setResistances(new Type[]{Type.FIGHTING, Type.BUG, Type.DARK});
        Type.FAIRY.setResistances(new Type[]{Type.POISON, Type.STEEL});
        Type.FAIRY.setResistances(new Type[]{Type.DRAGON});

        Type.NONE.setResistances(new Type[]{});
        Type.NONE.setWeaknesses(new Type[]{});
        Type.NONE.setImmune(new Type[]{});

        currentState.onEnterState();

        while(true)
            currentState.run();
    }
}
