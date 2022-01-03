package entity.category;

import java.util.List;

public class Category implements Serializable {
    private static final long serialVersionUID = 1L;


    private int id;
    private float costPerHour;
    private int nPedals;
    private int nSeats;
    private String name;

    private List<Bike> bikes;

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(float costPerHour) {
        this.costPerHour = costPerHour;
    }

    public int getnPedals() {
        return nPedals;
    }

    public void setnPedals(int nPedals) {
        this.nPedals = nPedals;
    }

    public int getnSeats() {
        return nSeats;
    }

    public void setnSeats(int nSeats) {
        this.nSeats = nSeats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bike> bikes) {
        this.bikes = bikes;
    }

    public Bike addBike(Bike bike) {
        getBikes().add(bike);

        return bike;
    }

    public Bike removeBike(Bike bike) {
        getBikes().remove(bike);

        return bike;
    }

}