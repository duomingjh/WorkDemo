package com.shw.workdemo.Bean;

public class newContext {
    private String tile;
    private String context;
    private int image;

    public newContext(){

    }
    public newContext(String tile, String context, int image) {
        this.tile = tile;
        this.context = context;
        this.image = image;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
