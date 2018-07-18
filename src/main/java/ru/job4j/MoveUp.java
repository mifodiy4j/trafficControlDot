package ru.job4j;

public class MoveUp extends Move {
    private float delta;
    private String direction = "Up";

    public MoveUp(float delta) {
        super(delta);
    }

    @Override
    public String toString() {
        return "Move " + direction + " by " + delta;
    }
}