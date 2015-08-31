package com.alexaut.kroniax.game.tilemap;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TileMap {

    private Properties mProperties;

    private ArrayList<Tileset> mTilesets;
    private ArrayList<TileLayer> mTileLayers;

    public TileMap() {
        mProperties = new Properties();
        mTilesets = new ArrayList<Tileset>();
        mTileLayers = new ArrayList<TileLayer>();
    }

    public Properties getProperties() {
        return mProperties;
    }

    public ArrayList<Tileset> getTilesets() {
        return mTilesets;
    }

    public ArrayList<TileLayer> getTileLayers() {
        return mTileLayers;
    }

    public TextureRegion getTileRegion(int id) {
        if (id == 0)
            return null;

        for (Tileset tileset : mTilesets) {
            if (tileset.getFirstID() <= id) {
                return tileset.getTile(id);
            }
        }
        return null;
    }

    // Convenient functions
    public int getWidth() {
        if (mProperties.hasProperty("width"))
            return mProperties.get("width");
        return 0;
    }

    public int getHeight() {
        if (mProperties.hasProperty("height"))
            return mProperties.get("height");
        return 0;
    }

    public int getTileWidth() {
        if (mProperties.hasProperty("tilewidth"))
            return mProperties.get("tilewidth");
        return 0;
    }

    public int getTileHeight() {
        if (mProperties.hasProperty("tileheight"))
            return mProperties.get("tileheight");
        return 0;
    }

    public void dispose() {
        for (Tileset tileset : mTilesets)
            tileset.dispose();
    }

}