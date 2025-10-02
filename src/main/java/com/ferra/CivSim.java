package com.ferra;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CivSim extends Application {
    private static final int TILE_SIZE = 48;
    private static final int WIDTH = 10;
    private static final int HEIGHT = 6;

    private WorldMap map;
    private Faction red;
    private Faction blue;

    // Preload biome images
    private Image grassImg = new Image(getClass().getResourceAsStream("grass.png"));
    private Image mountainImg = new Image(getClass().getResourceAsStream("mountain.png"));
    private Image desertImg = new Image(getClass().getResourceAsStream("desert.png"));
    private Image waterImg = new Image(getClass().getResourceAsStream("water.png"));

    @Override
    public void start(Stage stage) {
        map = new WorldMap(WIDTH, HEIGHT);
        red = new Faction("Red");
        blue = new Faction("Blue");

        // Initial claims
        red.claimTile(map, 2, 2);
        blue.claimTile(map, 7, 3);

        GridPane grid = new GridPane();

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                Tile t = map.getTile(x, y);

                // Base biome image
                ImageView tileImg = new ImageView(getTileImage(t.type));
                tileImg.setFitWidth(TILE_SIZE);
                tileImg.setFitHeight(TILE_SIZE);

                // Overlay tint if owned
                Rectangle overlay = new Rectangle(TILE_SIZE, TILE_SIZE);
                overlay.setFill(Color.TRANSPARENT);

                if (t.owner != null) {
                    if (t.owner == red) overlay.setFill(Color.rgb(255, 0, 0, 0.4));
                    if (t.owner == blue) overlay.setFill(Color.rgb(0, 0, 255, 0.4));
                }

                overlay.setStroke(Color.BLACK);

                StackPane stack = new StackPane(tileImg, overlay);
                grid.add(stack, x, y);
            }
        }

        Scene scene = new Scene(grid);
        stage.setTitle("CivSim - Tile Map with Icons & Tints");
        stage.setScene(scene);
        stage.show();
    }

    private Image getTileImage(TileType type) {
        return switch (type) {
            case GRASSLAND -> grassImg;
            case MOUNTAIN -> mountainImg;
            case DESERT -> desertImg;
            case WATER -> waterImg;
        };
    }

    public static void main(String[] args) {
        launch();
    }
}
