package edu.wctc;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class Room implements java.io.Serializable{

    @Serial
    private static final long serialVersionUID = 1L;

    final List<Wall> wallList = new ArrayList<>();

    Room(double w, double l, double h) {
        Wall wallOne = new Wall(l, h);
        Wall wallTwo = new Wall(l, h);
        Wall wallThree = new Wall(w, h);
        Wall wallFour = new Wall(w, h);

        this.wallList.add(wallOne);
        this.wallList.add(wallTwo);
        this.wallList.add(wallThree);
        this.wallList.add(wallFour);
    }

    public double getArea() {
        double roomArea = 0;
        for (Wall wall : this.wallList) {
            roomArea += wall.getArea();
        }
        return roomArea;
    }

    public String toString() {
        return String.valueOf(this.getArea());
    }



}
