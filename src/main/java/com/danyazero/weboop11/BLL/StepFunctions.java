package com.danyazero.weboop11.BLL;

import com.danyazero.weboop11.models.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class StepFunctions implements IStep{
    public static final double a = 20.3;

    public List<Point> getPointList(double start, double finish, double step) {
        List<Point> points = new ArrayList<>();
        int n = stepsCount(start, finish, step);

        for (int i=0; i <= n; i++){
            double x = start + i * step;
            double y = f(x);
            points.add(new Point(x ,y));
        }
        return points;
    }

    public int stepsCount(double start, double finish, double step){
        return (int) ((finish - start)/ step);
    }

    public double average(List<Point> points){
        double sum = points.stream().mapToDouble(Point::getY).sum();
        return sum / points.size();
    }

    public Point getMaxPoint(List<Point> points){
        OptionalDouble max = points.stream().mapToDouble(Point::getY).max();
        if (max.isPresent()){
            return points.stream().filter(m -> m.getY() == max.getAsDouble()).findFirst().get();
        }
        return null;
    }

    public Point getMinPoint(List<Point> points){
        OptionalDouble min = points.stream().mapToDouble(Point::getY).min();
        if (min.isPresent()){
            return points.stream().filter(m -> m.getY() == min.getAsDouble()).findFirst().get();
        }
        return null;
    }

    private double f(double x) {
        if (x > 1.2 + 1e-9) return Math.log10(x + 1);
        else {
            double sin = Math.sin(Math.sqrt(a * x));
            return sin * sin;
        }
    }

}
