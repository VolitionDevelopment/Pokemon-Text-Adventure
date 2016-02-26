package me.demerzel.entity.human.npc;

import me.demerzel.entity.human.EntityHuman;

import java.util.ArrayList;

/**
 * Created by Demerzel on 2/7/16.
 */
public abstract class EntityNpc extends EntityHuman{
    private String type;
    private ArrayList<String> interactionText;

    public EntityNpc(String name, String type){
        super(name);
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFullName(){
        return type + " " + getName();
    }
}
