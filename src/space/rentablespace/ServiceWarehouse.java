package space.rentablespace;


import person.Tenant;
import things.vehicle.Vehicle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ServiceWarehouse extends RentableSpace {
    protected double spaceForPartsPercent;
    protected double spaceForTiresPercent;
    private List<TenantVehiclePair> waitingList = new ArrayList<>();

    public ServiceWarehouse(double spaceForPartsPercent,
                            double spaceForTiresPercent,
                            final double maxSpace,
                            final BigDecimal fee) {
        super(maxSpace, fee);
        this.spaceForPartsPercent = spaceForPartsPercent;
        this.spaceForTiresPercent = spaceForTiresPercent;
        this.setServiceWarehouse(this);
    }

    public ServiceWarehouse(final double width, final double height, final double depth,
                            final BigDecimal fee,
                            final double spaceForPartsPercent, final double spaceForTiresPercent) {
        super(width, height, depth, fee);
        this.spaceForPartsPercent = spaceForPartsPercent;
        this.spaceForTiresPercent = spaceForTiresPercent;
        setServiceWarehouse(this);
    }

    public void addToWaitingList(final Tenant tenant, final Vehicle vehicle) {
        final  TenantVehiclePair tenantVehiclePair = new TenantVehiclePair(tenant,vehicle);
        waitingList.add(tenantVehiclePair);                  //dodanie samochodu do listy oczekujących
    }

    public List<TenantVehiclePair> getWaitingList() {
        return waitingList;
    }     //zwrocenie listy oczekujacych
}
