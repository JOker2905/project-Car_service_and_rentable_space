package things;
public class Thing implements Comparable<Thing>{
    protected double space;

    public Thing(final double space) {
        this.space = space;
    }

    public Thing(double width, double height, double depth) {
        this.space = width * height * depth;
    }

    public double getSpace() {
        return space;
    }

    public void setSpace(final double space) {
        this.space = space;
    }

    @Override
    public int compareTo(Thing o) {
        return (int) (this.getSpace()-o.getSpace());
    }
}
