package person;

public class Person {
    private String name;
    private String surname;
    private String PESEL;
    private String address;
    private String birthDate;

    public Person(final String name, final String surname, final String PESEL, final String address, final String birthDate) {
        this.name = name;
        this.surname = surname;
        this.PESEL = PESEL;
        this.address = address;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(final String PESEL) {
        this.PESEL = PESEL;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(final String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Imie:"+getName()+" Nazwisko:"+getSurname() ;
    }
}
