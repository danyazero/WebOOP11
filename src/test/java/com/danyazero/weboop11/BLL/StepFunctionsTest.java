package com.danyazero.weboop11.BLL;

import com.danyazero.weboop11.models.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StepFunctionsTest {

    IStep bll;
    int start = 0;
    int finish = 5;
    int step = 2;

    List<Point> list = new ArrayList<>(Arrays.asList(
            new Point(0, 0),
            new Point(2.0, 0.477121),
            new Point(4.0, 0.69897)
    ));
    public static double eps = 1e-5;

    @BeforeEach
    void setUp() {
        bll = new StepFunctions();
    }

    @Test
    void getPointListTest() {
        assertEquals(list.get(1).getY(), bll.getPointList(start, finish, step).get(1).getY(), eps);
        assertEquals(list.get(2).getY(), bll.getPointList(start, finish, step).get(2).getY(), eps);
    }

    @Test
    void calcStepsTest(){
        int expected = 2;

        assertEquals(expected, bll.stepsCount(start, finish, step));
    }

    @Test
    void averageTest() {
        double expected = 0.392030;
        assertEquals(expected, bll.average(list), eps);
    }

    @Test
    void getMaxPointTest() {
        double expected = list.get(2).getY();
        assertEquals(expected, bll.getMaxPoint(list).getY());
    }

    @Test
    void getMinPointTest() {
        double expected = list.get(0).getY();
        assertEquals(expected, bll.getMinPoint(list).getY());
    }
}