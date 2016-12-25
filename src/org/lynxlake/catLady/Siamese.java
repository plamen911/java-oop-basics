package org.lynxlake.catLady;

public class Siamese extends Cat {
    private int earSize;

    public Siamese(String name, int earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("Siamese %s %d", this.name, this.earSize);
    }
}
