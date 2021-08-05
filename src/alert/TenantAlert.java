package alert;


import space.rentablespace.RentableSpace;

public class TenantAlert extends Info{
    private final RentableSpace rentableSpace;

    public TenantAlert(final RentableSpace rentableSpace) {
        this.rentableSpace = rentableSpace;
    }

    public RentableSpace getRentableSpace() {
        return rentableSpace;
    }
}
