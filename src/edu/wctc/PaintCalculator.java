package edu.wctc;

import java.io.Serial;
import java.util.*;

public class PaintCalculator implements java.io.Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    final private List<Room> roomList = new ArrayList<>();

    public void addRoom(double l, double w, double h) {
        Room room = new Room(l, w, h);
        this.roomList.add(room);
    }

    public String toString() {
        if (this.roomList.size() == 0) {
            return "No Rooms";
        } else {
            String output = "";
            for (int i = 0; i < this.roomList.size(); i++) {
                Room room = this.roomList.get(i);
                output += "Room " + (i + 1) + " Total Area: " + room.toString() + "\n";
            }
            return output;
        }
    }
}
