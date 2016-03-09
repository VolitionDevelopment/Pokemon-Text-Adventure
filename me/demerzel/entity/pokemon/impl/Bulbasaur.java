package me.demerzel.entity.pokemon.impl;

import me.demerzel.entity.pokemon.ExperienceGroup;
import me.demerzel.move.impl.*;
import me.demerzel.util.Type;
import me.demerzel.entity.pokemon.EntityPokemon;

/**
 * Created by Demerzel on 2/7/16.
 */
public class Bulbasaur extends EntityPokemon {

    public Bulbasaur() {
        super("Bulbasaur", 45, 49, 49, 65, 65, 45, 64, "", Type.GRASS, Type.POISON, ExperienceGroup.MEDIUM_SLOW);
        addCurrentMove(new Cut());
        addCurrentMove(new CometPunch());
        addCurrentMove(new MegaPunch());

        addMoveToLevelUp(4, new IcePunch());
        setEvolvesTo(new Ivysaur());
        setLevelToEvolve(16);

        setSprite("             `;,;.;,;.;.'\n" +
                "              ..:;:;::;: \n" +
                "        ..--''' '' ' ' '''--.  \n" +
                "      /' .   .'        '.   .`\\\n" +
                "     | /    /            \\   '.|\n" +
                "     | |   :             :    :|\n" +
                "   .'| |   :             :    :|\n" +
                " ,: /\\ \\.._\\ __..===..__/_../ /`.\n" +
                "|'' |  :.|  `'          `'  |.'  ::.\n" +
                "|   |  ''|    :'';          | ,  `''\\\n" +
                "|.:  \\/  | /'-.`'   ':'.-'\\ |  \\,   |\n" +
                "| '  /  /  | / |...   | \\ |  |  |';'|\n" +
                " \\ _ |:.|  |_\\_|`.'   |_/_|  |.:| _ |\n" +
                "/,.,.|' \\__       . .      __/ '|.,.,\\\n" +
                "     | ':`.`----._____.---'.'   |\n" +
                "      \\   `:\"\"\"-------'\"\"' |   |\n" +
                "       ',-,-',             .'-=,=,");
    }
}
