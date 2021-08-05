package space.rentablespace;

import person.Person;
import person.Tenant;
import space.Space;

import java.math.BigDecimal;
import java.util.*;


public class RentableSpace extends Space implements Comparable<RentableSpace>{
    protected List<Tenant> tenants=new ArrayList<>();
    private ServiceWarehouse serviceWarehouse;
    protected Map<Tenant, Date> rentStarts = new HashMap<>();
    protected Map<Tenant, Date> rentEnds = new HashMap<>();

    private BigDecimal fee;

    public RentableSpace(final double maxSpace, final BigDecimal fee) {
        super(maxSpace);
        this.fee = fee;
    }

    public RentableSpace(final double width, final double height, final double depth, final BigDecimal fee) {
        super(width, height, depth);
        this.fee = fee;
    }

    public RentableSpace(final double width, final double height, final double depth, final ServiceWarehouse serviceWarehouse, final BigDecimal fee) {
        super(width, height, depth);
        this.serviceWarehouse = serviceWarehouse;
        this.fee = fee;
    }

    public RentableSpace(ServiceWarehouse serviceWarehouse, double maxSpace, final BigDecimal fee) {
        super(maxSpace);
        this.serviceWarehouse = serviceWarehouse;
        this.fee = fee;
        this.freeSpace = maxSpace - serviceWarehouse.maxSpace;
    }

    public Map<Tenant, Date> getRentStarts() {
        return rentStarts;
    }

    public Map<Tenant, Date> getRentEnds() {
        return rentEnds;
    }

    public double getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(final double freeSpace) {
        this.freeSpace = freeSpace;
    }

    public double getMaxSpace() {
        return maxSpace;
    }

    public void setMaxSpace(final double maxSpace) {
        this.maxSpace = maxSpace;
    }

    // autoryzowany do użytku
    public List<Tenant> getTenants() {
        return tenants;
    }
    public void setTenant(Tenant tenant){
        tenants.add(tenant);
    }
    // osoba odpowiedzialna za pobieranie opłat
    public Person getAuthorizedToTakePayments() {
        if(tenants.size() >= 1) {
            return tenants.get(0);
        }
        return null;
    }

    public void setTenants(final List<Tenant> tenants) {
        this.tenants = tenants;
    }

    public ServiceWarehouse getServiceWarehouse() {
        return serviceWarehouse;
    }

    public void setServiceWarehouse(final ServiceWarehouse serviceWarehouse) {
        this.serviceWarehouse = serviceWarehouse;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(final BigDecimal fee) {
        this.fee = fee;
    }

    public void setRentalDates(Tenant tenant, Date start, Date end) {
        rentStarts.put(tenant, start);
        rentEnds.put(tenant, end);
    }

    public Date getRentEndsPlus30(Tenant tenant) {
        final Date endDate = rentEnds.get(tenant);
        return new Date(endDate.getTime() + (30 * 1000 * 60 * 60 * 24));
    }

    public void extendTenancyTime(Tenant tenant) {
        final Date start = rentStarts.get(tenant);
        final Date end = rentEnds.get(tenant);

        final long newEndDate = 2 * end.getTime() - start.getTime();

        rentEnds.put(tenant, new Date(newEndDate));
        tenant.removeTenantAlert(this);
    }


    @Override
    public int compareTo(RentableSpace o) {
        return (int) (this.getMaxSpace()-o.getMaxSpace());
    }

}
