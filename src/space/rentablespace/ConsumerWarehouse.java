package space.rentablespace;

import java.math.BigDecimal;
public class ConsumerWarehouse extends RentableSpace {
    public ConsumerWarehouse(final double maxSpace, final BigDecimal fee) {
        super(maxSpace, fee);
    }

    public ConsumerWarehouse(final ServiceWarehouse serviceWarehouse,
                             final double maxSpace, final BigDecimal fee) {
        super(serviceWarehouse, maxSpace, fee);
    }

    public ConsumerWarehouse(final double width, final double height, final double depth,
                             final ServiceWarehouse serviceWarehouse, final BigDecimal fee) {
        super(width, height, depth, serviceWarehouse, fee);
    }
}
