package ru.job4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс генерирующий последовательность команд,
 * приводящих нас из начальной точки в конечную.
 * Обе точки принадлежат выпуклой области.
 *
 * @author Mikhailov Sergey Mikhailov
 * @since 17.07.18
 */
public class TrafficControlDot {
    private float startX;
    private float startY;
    private float endX;
    private float endY;
    private float dxmax;
    private float dymax;
    private float dxmin;
    private float dymin;
    private List<Dot> result = new ArrayList<>();
    private List<Move> steps = new ArrayList<>();

    /**
     * Конструктор
     *
     * @param startX - координата по оси абсцисс начальной точки
     * @param startY - координата по оси ординат начальной точки
     * @param endX - - координата по оси абсцисс конечной точки
     * @param endY - координата по оси ординат конечной точки
     * @param dxmax - максимальный размер шага по оси абсцисс
     * @param dymax - максимальный размер шага по оси ординат
     * @param dxmin - минимальный размер шага по оси абсцисс
     * @param dymin - минимальный размер шага по оси ординат
     */
    public TrafficControlDot(float startX, float startY, float endX, float endY, float dxmax, float dymax, float dxmin, float dymin) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.dxmax = dxmax;
        this.dymax = dymax;
        this.dxmin = dxmin;
        this.dymin = dymin;
    }

    /**
     * Метод сохраняет следующий возможный шаг <code>Move</code>
     * в <code>steps</code>.
     * При этом шаг не может быть больше заданной величины
     * <code>dxmax</code> по оси абсцисс
     * <code>dxmax</code> по оси ординат
     * Возможность шага проверяется сначала по оси ординат, а
     * затем по оси ординат.
     *
     * @param dotX координата по оси абсцисс текущей точки <code>Dot</code>
     * @param dotY координата по оси ординат текущей точки <code>Dot</code>
     */
    private void addNextStepsWhenLimitOnTop(float dotX, float dotY) {
        result.add(new Dot(dotX, dotY));
        float deltaY = endY - dotY;
        float deltaX = endX - dotX;
        if (Math.floor(Math.abs(deltaY) / dymax) >= 1) {
            if (deltaY < 0) {
                steps.add(new MoveDown(dymax));
                addNextStepsWhenLimitOnTop(dotX, dotY - dymax);
            } else {
                steps.add(new MoveUp(dymax));
                addNextStepsWhenLimitOnTop(dotX, dotY + dymax);
            }
            return;
        } else if (Math.abs(deltaY) % dymax !=0) {
            if (deltaY < 0) {
                steps.add(new MoveDown(dotY - endY));
            } else {
                steps.add(new MoveUp(endY - dotY));
            }
            addNextStepsWhenLimitOnTop(dotX, endY);
            return;
        }

        if (Math.floor(Math.abs(deltaX) / dxmax) >= 1) {
            if (deltaX < 0) {
                steps.add(new MoveLeft(dxmax));
                addNextStepsWhenLimitOnTop(dotX - dxmax, dotY);
            } else {
                steps.add(new MoveRight(dxmax));
                addNextStepsWhenLimitOnTop(dotX + dxmax, dotY);
            }
            return;
        } else if (Math.abs(deltaX) % dxmax !=0) {
            if (deltaX < 0) {
                steps.add(new MoveLeft(dotX - endX));
            } else {
                steps.add(new MoveRight(endX - dotX));
            }
            addNextStepsWhenLimitOnTop(endX, dotY);
            return;
        }
    }

    private void addNextStepsWhenLimitOnTopAndBelow(float dotX, float dotY) {
        result.add(new Dot(dotX, dotY));
        float deltaY = endY - dotY;
        float deltaX = endX - dotX;
        if (Math.floor(Math.abs(deltaY) / dymax) >= 2) {
            if (deltaY < 0) {
                steps.add(new MoveDown(dymax));
                addNextStepsWhenLimitOnTopAndBelow(dotX, dotY - dymax);
            } else {
                steps.add(new MoveUp(dymax));
                addNextStepsWhenLimitOnTopAndBelow(dotX, dotY + dymax);
            }
            return;
        } else if (Math.abs(deltaY) % dymax !=0 && Math.abs(deltaY) % dymax > dymin) {
                if (deltaY < 0) {
                    steps.add(new MoveDown(dotY - endY));
                } else {
                    steps.add(new MoveUp(endY - dotY));
                }
                addNextStepsWhenLimitOnTopAndBelow(dotX, endY);
                return;
        } else if (Math.abs(deltaY) % dymax !=0 && Math.abs(deltaY) % dymax < dymin) {
            if (deltaY < 0) {
                steps.add(new MoveDown(Math.abs(deltaY) / 2));
                addNextStepsWhenLimitOnTopAndBelow(dotX, dotY - Math.abs(deltaY) / 2);
            } else {
                steps.add(new MoveUp(Math.abs(deltaY) / 2));
                addNextStepsWhenLimitOnTopAndBelow(dotX, dotY + Math.abs(deltaY) / 2);
            }
            return;
        }

        if (Math.floor(Math.abs(deltaX) / dxmax) >= 2) {
            if (deltaX < 0) {
                steps.add(new MoveLeft(dxmax));
                addNextStepsWhenLimitOnTopAndBelow(dotX - dxmax, dotY);
            } else {
                steps.add(new MoveRight(dxmax));
                addNextStepsWhenLimitOnTopAndBelow(dotX + dxmax, dotY);
            }
            return;
        } else if (Math.abs(deltaX) % dxmax !=0 && Math.abs(deltaX) % dxmax > dxmin) {
            if (deltaX < 0) {
                steps.add(new MoveLeft(dotX - endX));
            } else {
                steps.add(new MoveRight(endX - dotX));
            }
            addNextStepsWhenLimitOnTopAndBelow(endX, dotY);
            return;
        } else if (Math.abs(deltaX) % dxmax !=0 && Math.abs(deltaX) % dxmax < dxmin) {
            if (deltaX < 0) {
                steps.add(new MoveLeft(Math.abs(deltaX) / 2));
                addNextStepsWhenLimitOnTopAndBelow(dotX - Math.abs(deltaX) / 2, dotY);
            } else {
                steps.add(new MoveRight(Math.abs(deltaX) / 2));
                addNextStepsWhenLimitOnTopAndBelow(dotX + Math.abs(deltaX) / 2, dotY);
            }
            return;
        }
    }

    /**
     * Метод генерирует шаги от начальноя точки с координатами
     * {@code startX} по оси X, {@code startY} по оси Y
     * до конечной точки с координатами
     * {@code endX} по оси X, {@code endY} по оси Y
     */
    public void doTrafficFromStartToEndWhenLimitOnTop() {
        addNextStepsWhenLimitOnTop(startX, startY);
    }

    /**
     * Метод генерирует шаги от начальноя точки с координатами
     * {@code startX} по оси X, {@code startY} по оси Y
     * до конечной точки с координатами
     * {@code endX} по оси X, {@code endY} по оси Y
     * Величина шага не может быть меньше фиксированной величины
     * {@code dxmin} по оси абсцисс
     * {@code dxmin} по оси ординат
     */
    public void doTrafficFromStartToEndWhenLimitOnTopAndBelow() {
        addNextStepsWhenLimitOnTopAndBelow(startX, startY);
    }

    public List<Dot> getResult() {
        return result;
    }

    public void setResult(List<Dot> result) {
        this.result = result;
    }

    public List<Move> getSteps() {
        return steps;
    }

    public void setSteps(List<Move> steps) {
        this.steps = steps;
    }
}