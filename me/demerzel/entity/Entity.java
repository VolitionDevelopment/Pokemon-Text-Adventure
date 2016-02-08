package me.demerzel.entity;

/**
 * Created by Demerzel on 2/7/16.
 */
public abstract class Entity {
    private String name;

    public Entity(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
