package entity.category;

import entity.bike.Bike;
import entity.db.CapstoneDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Category {

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
    public Category getCategoryById(int id)  throws SQLException{
            String sql = "SELECT * FROM category " + "where id=" + id + ";";
            Statement stm = CapstoneDB.getConnection().createStatement();
            try (ResultSet res = stm.executeQuery(sql)) {
                if (res.next()) {
                    Category c = new Category();
                    c.setId(res.getInt("id"));
                    c.setCostPerHour(res.getFloat("costs_per_hour"));
                    return c;
                }
            }
            return null;
    }
}