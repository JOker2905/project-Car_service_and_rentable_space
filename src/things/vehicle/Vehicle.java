package things.vehicle;

import things.Thing;

public class Vehicle extends Thing {
    protected String name;
    protected EngineType engineType;
    protected double engineCapacity;

    public Vehicle(final double space, String name,
                   EngineType engineType, double engineCapacity) {
        super(space);
        this.name = name;
        this.engineType = engineType;
        this.engineCapacity = engineCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(final EngineType engineType) {
        this.engineType = engineType;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(final double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }
}