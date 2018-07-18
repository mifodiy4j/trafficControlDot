package ru.job4j;

/**
 * Класс представляет вариант изменения
 * координаты на плоскости вправо на заданную величину
 * {@code delta}.
 *
 * @author Mikhailov Sergey Mikhailov
 * @since 17.07.18
 */
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