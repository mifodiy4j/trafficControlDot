package ru.job4j;

public class MoveRight extends Move {
    private String direction = "Right";

    public MoveRight(float delta) {
        super(delta);
    }

    @Override
    public String toString() {
        return "Move " + direction + " by " + delta;
    }
}