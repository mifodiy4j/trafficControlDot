package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Mikhailov Sergey Mikhailov
 * @since 18.07.18
 */
public class TrafficControlDotTest {

    @Test
    public void whenStepLimitOnTopMoveDownAndRightShouldGenerateStepList() {
        TrafficControlDot traffic = new TrafficControlDot(1, 5.5f, 4.1f, 1, 1, 1, 0.3f, 0.3f);
        traffic.doTrafficFromStartToEndWhenLimitOnTop();
        List<Move> actual = traffic.getSteps();
        List<Move> expected = new ArrayList<>();
        expected.add(new MoveDown(1));
        expected.add(new MoveDown(1));
        expected.add(new MoveDown(1));
        expected.add(new MoveDown(1));
        expected.add(new MoveDown(0.5f));
        expected.add(new MoveRight(1));
        expected.add(new MoveRight(1));
        expected.add(new MoveRight(1));
        expected.add(new MoveRight(0.1f));
        assertThat(actual, is(expected));
    }

    @Test
    public void whenStepLimitOnTopMoveUpAndLeftShouldGenerateStepList() {
        TrafficControlDot traffic = new TrafficControlDot(5.5f, 1, 1, 4.1f, 1, 1, 0.3f, 0.3f);
        traffic.doTrafficFromStartToEndWhenLimitOnTop();
        List<Move> actual = traffic.getSteps();
        List<Move> expected = new ArrayList<>();
        expected.add(new MoveUp(1));
        expected.add(new MoveUp(1));
        expected.add(new MoveUp(1));
        expected.add(new MoveUp(0.1f));
        expected.add(new MoveLeft(1));
        expected.add(new MoveLeft(1));
        expected.add(new MoveLeft(1));
        expected.add(new MoveLeft(1));
        expected.add(new MoveLeft(0.5f));
        assertThat(actual, is(expected));
    }

    @Test
    public void whenStepLimitOnTopAndBelowMoveDownAndRightShouldGenerateStepList() {
        TrafficControlDot traffic = new TrafficControlDot(1, 5.1f, 4.1f, 1, 1, 1, 0.3f, 0.3f);
        traffic.doTrafficFromStartToEndWhenLimitOnTopAndBelow();
        List<Move> actual = traffic.getSteps();
        List<Move> expected = new ArrayList<>();
        expected.add(new MoveDown(1));
        expected.add(new MoveDown(1));
        expected.add(new MoveDown(1));
        expected.add(new MoveDown(0.55f));
        expected.add(new MoveDown(0.55f));
        expected.add(new MoveRight(1));
        expected.add(new MoveRight(1));
        expected.add(new MoveRight(0.55f));
        expected.add(new MoveRight(0.55f));
        assertThat(actual, is(expected));
    }

    @Test
    public void whenStepLimitOnTopAndBelowMoveUpAndLeftShouldGenerateStepList() {
        TrafficControlDot traffic = new TrafficControlDot(5.1f, 1, 1, 4.1f, 1, 1, 0.3f, 0.3f);
        traffic.doTrafficFromStartToEndWhenLimitOnTopAndBelow();
        List<Move> actual = traffic.getSteps();
        List<Move> expected = new ArrayList<>();
        expected.add(new MoveUp(1));
        expected.add(new MoveUp(1));
        expected.add(new MoveUp(0.55f));
        expected.add(new MoveUp(0.55f));
        expected.add(new MoveLeft(1));
        expected.add(new MoveLeft(1));
        expected.add(new MoveLeft(1));
        expected.add(new MoveLeft(0.55f));
        expected.add(new MoveLeft(0.55f));
        assertThat(actual, is(expected));
    }
}