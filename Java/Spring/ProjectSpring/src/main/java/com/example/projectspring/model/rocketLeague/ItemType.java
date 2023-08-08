package com.example.projectspring.model.rocketLeague;

public enum
ItemType {
    BOOST("Boost"),
    WHEELS("Wheels"),
    ANTENNA("Antenna"),
    BODY("Body"),
    DECAL("Decal"),
    GOAL_EXPLOSION("Goal Explosion"),
    PAINT_FINISH("Paint Finish"),
    TOPPER("Topper"),
    TRAIL("Trail");

    private final String name;

    ItemType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
