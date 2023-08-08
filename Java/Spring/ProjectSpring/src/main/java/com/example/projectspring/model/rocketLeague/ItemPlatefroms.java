package com.example.projectspring.model.rocketLeague;

public enum ItemPlatefroms {
    PC("PC"),
    PLAYSTATION_4("PlayStation 4"),
    XBOX_ONE("Xbox One"),

    NINTENDO_SWITCH("Nintendo Switch");

    private final String name;

    ItemPlatefroms(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
