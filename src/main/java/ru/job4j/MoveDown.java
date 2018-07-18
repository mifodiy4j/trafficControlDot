package ru.job4j;

public class MoveDown extends Move {
    private String direction = "Down";

    public MoveDown(float delta) {
        super(delta);
    }

    @Override
    public String toString() {
        return "Move " + direction + " by " + delta;
    }
}
