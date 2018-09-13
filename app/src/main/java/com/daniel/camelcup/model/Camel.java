package com.daniel.camelcup.model;

public enum Camel {
    WHITE("w", "White"),
    YELLOW("y", "Yellow"),
    GREEN("g", "Green"),
    ORANGE("o", "Orange"),
    BLUE("b", "Blue");

    private final String character;
    private final String name;

    Camel(String character, String name) {
        this.character = character;
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public String getName() {
        return name;
    }
}
