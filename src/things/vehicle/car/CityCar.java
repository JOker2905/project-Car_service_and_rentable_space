package things.vehicle.car;

import things.vehicle.EngineType;

public class CityCar extends Car{
    private boolean isElectric;
    private boolean hasNavigation;

    public CityCar(final double space, final String name, final EngineType engineType, final double engineCapacity, final int numberOfSeats, final boolean hasABS, final boolean isElectric, final boolean hasNavigation) {
        super(space, name, engineType, engineCapacity, numberOfSeats, hasABS);
        this.isElectric = isElectric;
        this.hasNavigation = hasNavigation;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(final boolean electric) {
        isElectric = electric;
    }

    public boolean isHasNavigation() {
        return hasNavigation;
    }

    public void setHasNavigation(final boolean hasNavigation) {
        this.hasNavigation = hasNavigation;
    }
}
