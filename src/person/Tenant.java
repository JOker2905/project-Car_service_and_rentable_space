package person;

import alert.Info;
import alert.TenantAlert;
import exceptions.NeverRentException;
import exceptions.ProblematicTenantException;
import exceptions.TooManyThingsException;
import space.rentablespace.ConsumerWarehouse;
import space.rentablespace.ParkingSpace;
import space.rentablespace.RentableSpace;
import space.rentablespace.ServiceWarehouse;
import things.Thing;
import things.vehicle.Vehicle;

import java.math.BigDecimal;
import java.util.*;
public class Tenant extends Person{
    private final Set<RentableSpace> rented = new HashSet<>();
    private BigDecimal totalRentPrice = BigDecimal.ZERO;
    private Date firstTenancy = null;
    private final Map<RentableSpace, Info> infos = new HashMap<>();

    public Tenant(final String name, final String surname, final String PESEL, final String address, final String birthDate) {
        super(name, surname, PESEL, address, birthDate);
    }


    public void rent(RentableSpace rentableSpace, Date start, Date end) throws ProblematicTenantException {         //wynajecie pomieszczenia
        if(infos.size() >= 3) {
            StringBuilder spaceIds = new StringBuilder();
            for(final RentableSpace space : rented) {
                spaceIds.append(space.getId()).append(" ");
            }

            throw new ProblematicTenantException("Osoba " + getName() + " " + getSurname() + " posiadała już najem " +
                    "pomieszczeń, " + spaceIds.toString() + "- " + rentableSpace.getFee());
        }

        if(totalRentPrice.add(rentableSpace.getFee()).compareTo(new BigDecimal("1250")) < 0) {
            totalRentPrice = totalRentPrice.add(rentableSpace.getFee());
            rented.add(rentableSpace);
            rentableSpace.setRentalDates(this, start, end);
            rentableSpace.setTenant(this);

            if(firstTenancy == null) {
                firstTenancy = start;
            }
        }
    }

    public Set<RentableSpace> getRented() {
        return rented;
    }       //zwrocenie listy wynajetych pomieszczen

    public BigDecimal getTotalRentPrice() {
        return totalRentPrice;
    }    //zwrocenie lacznej kwoty za wynajmy

    public void setTotalRentPrice(final BigDecimal totalRentPrice) {
        this.totalRentPrice = totalRentPrice;
    }

    public Date getFirstTenancy() throws NeverRentException {    //zwrocenie daty pierwszego wynajecia
        if(firstTenancy == null) {
            throw new NeverRentException();
        }
        return firstTenancy;
    }

    public void timePassed(RentableSpace rentableSpace) {         //uplynal czas na zaplacenie za wynajecie
        infos.put(rentableSpace, new TenantAlert(rentableSpace));
        rentableSpace.clearThings(this); // czyścimy przedmioty z powierzchni
    }

    public void payForTenancy(RentableSpace rentableSpace) {        //zaplacenie za wynajem
        rentableSpace.extendTenancyTime(this);
    }

    public void removeTenantAlert(final RentableSpace rentableSpace) {
        infos.remove(rentableSpace);
    }

    public void putThing(RentableSpace rentableSpace, Thing thing) throws TooManyThingsException {   //wlozenie przedmiotu do pomieszczenia
        rentableSpace.putThing(this, thing);
    }

    public void needsMechanicService(ParkingSpace parkingSpace, ServiceWarehouse serviceWarehouse, Vehicle vehicle) throws TooManyThingsException {
        try {
            putThing(serviceWarehouse, vehicle);
        } catch(TooManyThingsException ignored) {
            serviceWarehouse.addToWaitingList(this, vehicle);       //potrzeba naprawy u mechanika
            putThing(parkingSpace, vehicle);
        }
    }

    public void needsSelfService(ConsumerWarehouse consumerWarehouse, Vehicle vehicle) throws TooManyThingsException {
        putThing(consumerWarehouse, vehicle);      //potrzeba samodzielnej naprawy
    }

    public Map<RentableSpace, Info> getInfos(){
        return infos;
    }
}
