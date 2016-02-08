package me.demerzel.state;

/**
 * Created by Demerzel on 2/7/16.
 */
public interface State {
    void onEnterState();

    void run();
}
