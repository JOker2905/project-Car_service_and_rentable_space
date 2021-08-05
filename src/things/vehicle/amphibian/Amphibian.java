package things.vehicle.amphibian;

import things.vehicle.Vehicle;
import things.vehicle.EngineType;

public class Amphibian extends Vehicle {
    private double buoyancy;

    public Amphibian(final double space, final String name, final EngineType engineType, final double engineCapacity, final double buoyancy) {
        super(space, name, engineType, engineCapacity);
        this.buoyancy = buoyancy;
    }

    public double getBuoyancy() {
        return buoyancy;
    }

    public void setBuoyancy(final double buoyancy) {
        this.buoyancy = buoyancy;
    }
}
