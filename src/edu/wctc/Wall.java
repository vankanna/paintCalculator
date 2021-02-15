package edu.wctc;

import java.io.Serial;

public class Wall implements java.io.Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    final double width;
    final double height;

    Wall(double w, double h) {
        this.width = w;
        this.height = h;
    }

    public double getArea() {
        return this.getHeight() * this.getWidth();
    }

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }
}
