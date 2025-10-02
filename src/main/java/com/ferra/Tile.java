package com.ferra;

public class Tile {
    public TileType type;
    public Faction owner; // null if unclaimed

    public Tile(TileType type) {
        this.type = type;
        this.owner = null;
    }
}
