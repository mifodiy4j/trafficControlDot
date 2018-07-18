package ru.job4j;

/**
 * Класс представляет вариант изменения
 * координаты на плоскости вниз на заданную величину
 * {@code delta}.
 *
 * @author Mikhailov Sergey Mikhailov
 * @since 17.07.18
 */
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
