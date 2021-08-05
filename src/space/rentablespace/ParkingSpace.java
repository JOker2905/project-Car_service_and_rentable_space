package space.rentablespace;

import java.math.BigDecimal;

public class ParkingSpace extends RentableSpace {
    public ParkingSpace(final double maxSpace, final BigDecimal fee) {
        super(maxSpace, fee);
    }

    public ParkingSpace(final double width, final double height, final double depth, final BigDecimal fee) {
        super(width, height, depth, fee);
    }
}
