package me.demerzel.entity.human.npc;

import me.demerzel.entity.human.EntityHuman;

import java.util.ArrayList;

/**
 * Created by Demerzel on 2/7/16.
 */
public abstract class EntityNpc extends EntityHuman{
    private ArrayList<String> interactionText;

    public EntityNpc(String name){
        super(name);
    }

    public ArrayList<String> getInteractionText() {
        return interactionText;
    }

    public void setInteractionText(ArrayList<String> interactionText) {
        this.interactionText = interactionText;
    }

    public void addInteractionText(String text){
        interactionText.add(text);
    }
}
