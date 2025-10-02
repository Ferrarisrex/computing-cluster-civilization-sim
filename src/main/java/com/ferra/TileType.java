package com.ferra;

public enum TileType {
    GRASSLAND(2, 0, 0, 0),
    MOUNTAIN(0, 2, 0, 1),
    DESERT(0, 0, 1, 0),
    WATER(3, 0, 0, 0);

    public final int food;
    public final int metal;
    public final int energy;
    public final int research;

    TileType(int food, int metal, int energy, int research) {
        this.food = food;
        this.metal = metal;
        this.energy = energy;
        this.research = research;
    }
}
