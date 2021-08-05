package things.vehicle.car;

import things.vehicle.EngineType;

public class OffRoadCar extends Car{
    private float height;
    private boolean is4x4;

    public OffRoadCar(final double space, final String name, final EngineType engineType, final double engineCapacity, final int numberOfSeats, final boolean hasABS, final float height, final boolean is4x4) {
        super(space, name, engineType, engineCapacity, numberOfSeats, hasABS);
        this.height = height;
        this.is4x4 = is4x4;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(final float height) {
        this.height = height;
    }

    public boolean isIs4x4() {
        return is4x4;
    }

    public void setIs4x4(final boolean is4x4) {
        this.is4x4 = is4x4;
    }
}
