package org.lynxlake._03StaticMembers._08ShapesVolume;

class VolumeCalculator {
    static double getTriangularPrismVolume(TriangularPrism o) {
        return o.getBaseSide() * o.getLength() / 2 * o.getHeight();
    }

    static double getCubeVolume(Cube o) {
        return o.getSideLength() * o.getSideLength() * o.getSideLength();
    }

    static double getCylinderVolume(Cylinder o) {
        return Math.PI * o.getRadius() * o.getRadius() * o.getHeight();
    }
}
