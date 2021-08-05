package things;

public class Box extends Thing {

    protected String name;

    public Box(String name,final double space){
        super(space);
        this.name=name;
    }
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Nazwa:"+getName();
    }



}
