package ru.job4j;

/**
 * Класс представляет вариант изменения
 * координаты на плоскости влево на заданную величину
 * {@code delta}.
 *
 * @author Mikhailov Sergey Mikhailov
 * @since 17.07.18
 */
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