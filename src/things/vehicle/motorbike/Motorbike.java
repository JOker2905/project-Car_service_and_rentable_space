package things.vehicle.motorbike;

import things.vehicle.EngineType;
import things.vehicle.Vehicle;
public class Motorbike extends Vehicle{
    private boolean isSportBike;
    private int numberOfPistons;

    public Motorbike(final double space, final String name, final EngineType engineType, final double engineCapacity) {
        super(space, name, engineType, engineCapacity);
    }

    public boolean isSportBike() {
        return isSportBike;
    }

    public void setSportBike(final boolean sportBike) {
        isSportBike = sportBike;
    }

    public int getNumberOfPistons() {
        return numberOfPistons;
    }

    public void setNumberOfPistons(final int numberOfPistons) {
        this.numberOfPistons = numberOfPistons;
    }
}
