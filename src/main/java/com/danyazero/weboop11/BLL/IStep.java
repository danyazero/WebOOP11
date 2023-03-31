package com.danyazero.weboop11.BLL;

import com.danyazero.weboop11.models.Point;

import java.util.List;

public interface IStep {
    public List<Point> getPointList(double start, double finish, double step);
    public double average(List<Point> points);
    public Point getMaxPoint(List<Point> points);
    public Point getMinPoint(List<Point> points);
    public int stepsCount(double start, double finish, double step);
}
