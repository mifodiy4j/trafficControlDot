package ru.job4j;

/**
 * Класс представляет вариант изменения
 * координаты на плоскости вверх на заданную величину
 * {@code delta}.
 *
 * @author Mikhailov Sergey Mikhailov
 * @since 17.07.18
 */
public class MoveUp extends Move {
    private String direction = "Up";

    public MoveUp(float delta) {
        super(delta);
    }

    @Override
    public String toString() {
        return "Move " + direction + " by " + delta;
    }
}