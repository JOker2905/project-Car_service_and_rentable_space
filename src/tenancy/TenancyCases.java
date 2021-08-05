package tenancy;

import space.rentablespace.RentableSpace;
import time.TimeLapse;

import java.util.ArrayList;
import java.util.List;

public class TenancyCases {
    private List<RentableSpace> tenancies = new ArrayList<>();

    public TenancyCases(TimeLapse timeLapse) {
        timeLapse.setCheckTenancyCasesCallback(() -> {
            for(final RentableSpace tenancy : tenancies) {
                tenancy.getRentEnds().forEach((person, date) -> {
                    if(tenancy.getRentEndsPlus30(person)
                            .before(timeLapse.getCurrentDate())) {
                        person.timePassed(tenancy);
                    }
                });
            }
        });
    }

    public void addTenancy(RentableSpace rentableSpace) {
        tenancies.add(rentableSpace);
    }
}
