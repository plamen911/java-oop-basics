package org.lynxlake.catLady;

public class Cymric extends Cat {
    private int furLength;
    public Cymric(String name, int furLength) {
        super(name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %d", this.name, this.furLength);
    }
}
