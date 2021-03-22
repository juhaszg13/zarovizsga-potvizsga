package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable{
    private String address;
    private int area;
    private int floors;

    public Office(String address, int area, int floors) {
        this.address = address;
        this.area = area;
        this.floors = floors;
    }

    @Override
    public int clean() {
        return floors*area*100;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
