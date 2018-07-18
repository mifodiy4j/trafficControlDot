package ru.job4j;

/**
 * Класс представляет точку на плоскости X-Y.
 * В конструкторе первый параметр -
 * координата по оси абсцисс,
 * второй параметр -
 * координата по оси ординат.
 *
 * @author Mikhailov Sergey Mikhailov
 * @since 17.07.18
 */
public class Dot {
    private float valueX;
    private float valueY;

    public Dot(float valueX, float valueY) {
        this.valueX = valueX;
        this.valueY = valueY;
    }

    public float getValueX() {
        return valueX;
    }

    public void setValueX(float valueX) {
        this.valueX = valueX;
    }

    public float getValueY() {
        return valueY;
    }

    public void setValueY(float valueY) {
        this.valueY = valueY;
    }

    @Override
    public String toString() {
        return "Dot{" +
                "X:" + valueX +
                ", Y:" + valueY +
                '}';
    }
}