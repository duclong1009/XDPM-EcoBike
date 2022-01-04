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
    protected int id;
    protected String bikeName;
    protected float pin;
    protected int status;
    protected int category_id;
    protected int station_id;

    public Bike() {}

    public Bike(int id, String bike_name, float pin, int status, int category_id , int station_id) {
        this.id = id;
        this.bikeName = bike_name;
        this.pin = pin;
        this.status = status;
        this.category_id =category_id;
        this.station_id = station_id;
    }

    public Bike getBikeById(int id) throws SQLException{
        String sql = "SELECT * FROM bike " + "where id=" + id + ";";
        System.out.println("query : " + sql);
        Statement stm = CapstoneDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(sql);
        if(res.next()) {
            System.out.println("Not null");
            Bike b = new Bike(res.getInt("id"), res.getString("bike_name"), res.getFloat("pin"), res.getInt("Status"), res.getInt("category_id"), res.getInt("station_id"));
            return b;
        }
        return null;
    }

    public List<Bike> getAllBike(int stationID) throws SQLException {
        String query = "SELECT * FROM bike " + "where station_id=" + stationID + ";";
        Statement stm = CapstoneDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(query);
        ArrayList bikeList = new ArrayList();
        while(res.next()) {
            LOGGER.info("Exist bike query!!");
            Bike b = new Bike(res.getInt("id"), res.getString("bike_name"), res.getFloat("pin"), res.getInt("Status"), res.getInt("category_id"), res.getInt("station_id"));
            bikeList.add(b);
        }
        return bikeList;
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
    public int getCategory() {
        return category_id;
    }

    public int getStationID() {
        return station_id;
    }

    public void setCategory(int category) {
        this.category_id = category;
    }

    public void setStation(int station) {
        this.station_id = station;
    }


    public static void setLOGGER(Logger LOGGER) {
        Bike.LOGGER = LOGGER;
    }


    public static void main(String[] args) throws SQLException {
        Bike bike = new Bike();
        bike = bike.getBikeById(1);
        System.out.println(bike.bikeName);
    }
}