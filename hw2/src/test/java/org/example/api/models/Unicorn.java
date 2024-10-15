package org.example.api.models;

public class Unicorn {
    private String name;
    private String tail_color;

    public Unicorn(String name, String tail_color) {
        this.name = name;
        this.tail_color = tail_color;
    }

    public String getName() {
        return name;
    }

    public String getTail_color() {
        return tail_color;
    }


    public String toJson() {
        return "{\"name\": \"" + name + "\", \"tail_color\": \"" + tail_color + "\"}";
    }
}
