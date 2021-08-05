package things.vehicle.car;

import things.vehicle.EngineType;
import things.vehicle.Vehicle;

public class Car extends Vehicle {
    protected int numberOfSeats;
    protected boolean hasABS;

    public Car(final double space, final String name, final EngineType engineType, final double engineCapacity,
               int numberOfSeats, boolean hasABS) {
        super(space, name, engineType, engineCapacity);
        this.numberOfSeats = numberOfSeats;
        this.hasABS = hasABS;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(final int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isHasABS() {
        return hasABS;
    }

    public void setHasABS(final boolean hasABS) {
        this.hasABS = hasABS;
    }
}