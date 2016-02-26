package me.demerzel.move;

/**
 * Created by Demerzel on 2/8/16.
 */
public enum CritStage {
    STAGE_0(1/16),
    STAGE_1(1/8),
    STAGE_2(1/2),
    STAGE_3(1);

    CritStage(double chance){}
}
