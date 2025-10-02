package com.ferra;

import java.util.*;

public class Faction {
    public String name;
    public int food = 0, metal = 0, energy = 0, research = 0;
    public List<int[]> ownedTiles = new ArrayList<>();

    public Faction(String name) {
        this.name = name;
    }

    public void collectResources(WorldMap map) {
        for (int[] pos : ownedTiles) {
            Tile t = map.getTile(pos[0], pos[1]);
            food += t.type.food;
            metal += t.type.metal;
            energy += t.type.energy;
            research += t.type.research;
        }
    }

    public void claimTile(WorldMap map, int x, int y) {
        Tile t = map.getTile(x, y);
        if (t.owner == null) {
            t.owner = this;
            ownedTiles.add(new int[]{x, y});
            System.out.println(name + " claimed (" + x + "," + y + ") " + t.type);
        }
    }
}
