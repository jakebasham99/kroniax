package com.alexaut.kroniax.game.level;

import java.util.ArrayList;

import com.alexaut.kroniax.game.Player;
import com.alexaut.kroniax.game.tilemap.TileLayer;
import com.alexaut.kroniax.game.tilemap.TileMap;
import com.badlogic.gdx.math.Vector2;

public class LevelCollisionHandler {

    ArrayList<TileLayer> mCollisionLayers;

    LevelProperties mLevelProperties;

    public LevelCollisionHandler(TileMap map, LevelProperties properties) {
        mCollisionLayers = new ArrayList<TileLayer>();
        mLevelProperties = properties;

        // Check for layers with the collision property
        for (TileLayer layer : map.getTileLayers()) {
            if (layer.getProperties().hasProperty("collision")) {
                mCollisionLayers.add(layer);
            }
        }
    }

    public void collide(Player player) {
        for (TileLayer layer : mCollisionLayers) {
            for (Vector2 point : player.getCollisionPoints()) {
                int x = (int) (point.x / mLevelProperties.tileSize.x);
                int y = (int) ((point.y / mLevelProperties.tileSize.y)) + 1; // +1
                                                                             // cause
                                                                             // tiled
                                                                             // starts
                                                                             // at
                                                                             // 1|1
                y = (int) (mLevelProperties.tileCount.y - y);
                // Check if this tile is not null => collision!
                if (layer.getTile(x, y) != null) {
                    player.setAlive(false);
                    return; // We already found a collision, no need to check
                            // more tiles
                }
            }
        }
    }

}