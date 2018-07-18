package ru.job4j;

public class MoveLeft extends Move {
    private String direction = "Left";

    public MoveLeft(float delta) {
        super(delta);
    }

    @Override
    public String toString() {
        return "Move " + direction + " by " + delta;
    }
}