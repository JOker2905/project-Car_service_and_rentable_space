package space;

import exceptions.TooManyThingsException;
import person.Person;
import person.Tenant;
import things.Thing;

import java.util.*;

public class Space {
    protected String id;
    protected double freeSpace;
    protected double maxSpace;
    protected List<Thing>thingList=new ArrayList<>();
    protected Map<Person, List<Thing>> things = new HashMap<>();

    public Space(final double maxSpace) {
        this.freeSpace = maxSpace;
        this.maxSpace=maxSpace;
        generateId();
    }

    public Space(double width, double height, double depth) {
        this.freeSpace = width * height * depth;
        this.maxSpace=width * height * depth;
        generateId();
    }

    private void generateId() {              //wygenerowanie unikatowego id dla pomieszczenia
        final Random random = new Random();
        this.id = "SPC" + System.nanoTime() + random.nextInt(100);
    }

    public void putThing(Person person, Thing thing) throws TooManyThingsException {
        if(freeSpace - thing.getSpace() >= 0) {
            freeSpace -= thing.getSpace();                      //przypisanie wkladanego przedmiotu do osoby
            if(!things.containsKey(person)) {
                things.put(person, new ArrayList<>());
            }
            things.get(person).add(thing);
            thingList.add(thing);
        } else {
            throw new TooManyThingsException("Remove some old items to insert a new item.");
        }
    }

    @Override public boolean equals(final Object o) {
        if(this == o) { return true; }
        if(o == null || getClass() != o.getClass()) { return false; }

        final Space space = (Space) o;

        if(Double.compare(space.freeSpace, freeSpace) != 0) { return false; }
        if(Double.compare(space.maxSpace, maxSpace) != 0) { return false; }
        if(!id.equals(space.id)) { return false; }
        return Objects.equals(things, space.things);
    }

    public void clearThings(Tenant tenant) {
        things.clear();               //wyczyszczenie pomieszczenia
    }

    @Override public int hashCode() {
        int result;
        long temp;                                              //wyliczenie hashcode dla HashMap i HashSet
        result = id.hashCode();
        temp = Double.doubleToLongBits(freeSpace);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxSpace);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (things != null ? things.hashCode() : 0);
        return result;
    }

    public Map<Person, List<Thing>> getThings() {
        return things;                  //mapa pokazujaca przedmioty jakie wlozyla dana osoba
    }
    public List<Thing>getThingList(){
        return thingList;
    }

    public String getId() {
        return id;
    }   //zwroc unikalny numer

    @Override
    public String toString() {
        return getId();
    }


}
