package space.rentablespace;

import person.Tenant;
import things.vehicle.Vehicle;

public class TenantVehiclePair {
    public Tenant tenant;
    public Vehicle vehicle;

    public TenantVehiclePair(final Tenant tenant,final Vehicle vehicle){
        this.tenant=tenant;
        this.vehicle=vehicle;
    }
}
