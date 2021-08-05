package space.service;

import space.Space;

public class CarServiceSpot extends Space {
    public CarServiceSpot(final double freeSpace, final double maxSpace) {
        super(maxSpace);
    }

    public CarServiceSpot(final double width, final double height, final double depth) {
        super(width, height, depth);
    }
}
