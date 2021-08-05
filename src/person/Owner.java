package person;

import service.Service;
import space.rentablespace.RentableSpace;

import java.util.ArrayList;
import java.util.List;

public class Owner extends Person{
    List<Service> services = new ArrayList<>();
    List<RentableSpace> rentableSpaces = new ArrayList<>();

    public Owner(final String name, final String surname, final String PESEL, final String address,
                 final String birthDate) {
        super(name, surname, PESEL, address, birthDate);
    }

    public List<Service> getServices() {
        return services;
    }               //jakie serwisy do niego naleza

    public void setServices(final List<Service> services) {
        this.services = services;
    }           //ustawienie serwisu

    public List<RentableSpace> getRentableSpaces() {                //jakie miejsca do wynajecia do niego naleza
        return rentableSpaces;
    }

    public void setRentableSpaces(final List<RentableSpace> rentableSpaces) {
        this.rentableSpaces = rentableSpaces;
    }
}                       //ustawienie miejsc do wynajecia
