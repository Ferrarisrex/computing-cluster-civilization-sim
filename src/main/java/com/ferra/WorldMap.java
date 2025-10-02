package com.ferra;

import java.util.Random;

public class WorldMap {
    public int width, height;
    private Tile[][] tiles;
    private Random random = new Random();

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new Tile[height][width];
        generate();
    }

    private void generate() {
        TileType[] types = TileType.values();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                TileType type = types[random.nextInt(types.length)];
                tiles[y][x] = new Tile(type);
            }
        }
    }

    public Tile getTile(int x, int y) {
        return tiles[y][x];
    }
}
