package entity.bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entity.db.CapstoneDB;
import entity.category.Category;
import entity.station.Station;
import utils.Utils;

public class Bike {

    private static Logger LOGGER = Utils.getLogger(Bike.class.getName());

    protected Statement stm;
    protected int id;
    protected String bikeName;
    protected float pin;
    protected int status;
    protected Category category;
    protected Station station;


    public Bike getBikeById(int id) throws SQLException{
        String sql = "SELECT * FROM bike " + "where id=" + id + ";";
        System.out.println("query : " + sql);
        Statement stm = CapstoneDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(sql);
        if(res.next()) {
            System.out.println("Not null");
            Bike b = new Bike();
            b.setId(id);
            b.setBikeName(res.getString("bike_name"));
            b.setPin(res.getFloat("pin"));
            b.setStatus(res.getInt("status"));
            return b;
        }
        return null;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Bike{" +
                ", id=" + id +
                ", bike_name='" + bikeName + '\'' +
                ", pin=" + pin +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public float getPin() {
        return pin;
    }

    public void setPin(float pin) {
        this.pin = pin;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public Category getCategory() {
        return category;
    }

    public Station getStation() {
        return station;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Bike(int id, String bikeName, float pin, int status) {
        this.id = id;
        this.bikeName = bikeName;
        this.pin = pin;
        this.status = status;
    }

    public static void setLOGGER(Logger LOGGER) {
        Bike.LOGGER = LOGGER;
    }

    public Bike() throws SQLException {
        stm = CapstoneDB.getConnection().createStatement();
    }

    public static void main(String[] args) throws SQLException {
        Bike bike = new Bike();
        bike = bike.getBikeById(1);
        System.out.println(bike.bikeName);
    }
}