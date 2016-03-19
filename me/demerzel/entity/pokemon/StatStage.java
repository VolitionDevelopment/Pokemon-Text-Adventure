package me.demerzel.entity.pokemon;

/**
 * Created by Jackson on 3/8/16.
 */
public enum StatStage {
    STAGE_NEG6(0.25),
    STAGE_NEG5(0.286),
    STAGE_NEG4(0.333),
    STAGE_NEG3(0.4),
    STAGE_NEG2(0.5),
    STAGE_NEG1(0.666),
    STAGE_0(1.0),
    STAGE_1(1.5),
    STAGE_2(2.0),
    STAGE_3(2.5),
    STAGE_4(3.0),
    STAGE_5(3.5),
    STAGE_6(4.0);

    private double multiplier;

    StatStage(double multiplier){
        this.multiplier = multiplier;
    }

    public double getMultiplier(){
        return multiplier;
    }

    public StatStage increment(){
        if(ordinal() == values().length - 1){
            return this;
        }

        return values()[ordinal() + 1];
    }

    public StatStage decriment(){
        if(ordinal() == 0){
            return this;
        }

        return values()[ordinal() - 1];
    }
}
