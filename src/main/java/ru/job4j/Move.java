package ru.job4j;

/**
 * Класс представляет вариант изменения
 * координаты на плоскости.
 *
 * @author Mikhailov Sergey Mikhailov
 * @since 17.07.18
 */
abstract class Move {
    float delta;
    String direction;

    public Move(float delta) {
        String str = String.format("%.2f", delta);
        str = str.replace(",", ".");
        float f = Float.parseFloat(str);
        this.delta = f;
    }

    @Override
    public String toString() {
        return "Move " + direction + " by " + delta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Move move = (Move) o;

        if (Float.compare(move.delta, delta) != 0) return false;
        return direction != null ? direction.equals(move.direction) : move.direction == null;

    }

    @Override
    public int hashCode() {
        int result = (delta != +0.0f ? Float.floatToIntBits(delta) : 0);
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }
}