package entity.station;

import java.util.List;
import entity.bike.Bike;

public class Station{
    private int id;
    private String address;
    private String name;
    private String imagePath;
    private int walkingTime;
    private List<Bike> bikes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getWalkingTime() {
        return walkingTime;
    }

    public void setWalkingTime(int walkingTime) {
        this.walkingTime = walkingTime;
    }

    public List<Bike> getBikes() {
        return this.bikes;
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