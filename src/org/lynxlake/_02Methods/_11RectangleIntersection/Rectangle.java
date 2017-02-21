package org.lynxlake._02Methods._11RectangleIntersection;

class Rectangle {
    private String id;
    private int width;
    private int height;
    private int topLeftX;
    private int topLeftY;

    public Rectangle(String id, int width, int height, int topLeftX, int topLeftY) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
    }

    public boolean hasIntersection(Rectangle r) {
        return this.topLeftX < r.getTopLeftX() + r.width && this.topLeftX + width > r.getTopLeftX() && this.topLeftY < r.getTopLeftY() + r.height && this.topLeftY + height > r.getTopLeftY();
    }

    public String getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getTopLeftX() {
        return topLeftX;
    }

    public int getTopLeftY() {
        return topLeftY;
    }
}
