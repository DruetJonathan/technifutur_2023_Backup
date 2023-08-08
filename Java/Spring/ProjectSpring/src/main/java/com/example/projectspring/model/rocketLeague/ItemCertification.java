package com.example.projectspring.model.rocketLeague;

public enum ItemCertification {
    ACROBAT("Acrobat"),
    AVIATOR("Aviator"),
    BALLISTIC("Ballistic"),
    BICYCLE_GOAL("Bicycle Goal"),
    CLEAR("Clear"),
    CREATOR("Creator"),
    GOALKEEPER("Goalkeeper"),
    JUGGLER("Juggler"),
    PARAGON("Paragon"),
    PLAYMAKER("Playmaker"),
    SCORER("Scorer"),
    SHOW_OFF("Show-Off"),
    SNIPER("Sniper"),
    STRIKER("Striker"),
    SWEET_TOOTH("Sweet Tooth");

    private final String name;

    ItemCertification(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
