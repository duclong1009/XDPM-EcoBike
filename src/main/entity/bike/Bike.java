package entity.bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entity.db.capstoneDB;
import utils.Utils;

public class Bike {

    private static Logger LOGGER = Utils.getLogger(Bike.class.getName());

    protected Statement stm;
    protected int id;
    protected String bikeName;
    protected float pin;
    protected int status; // the real price of product (eg: 450)

    public Bike getBikeById(int id) throws SQLException{
        String sql = "SELECT * FROM bike " + "where id=" + id + ";";
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(sql);
        if(res.next()) {
            return new Bike()
                    .setId(res.getInt("id"))
                    .setBikeName(res.getString("bike"))
                    .setPin(res.getFloat("pin"))
                    .setStatus(res.getInt("status"))
        }
        return null;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Bike{" +
                ", id=" + id +
                ", bikeName='" + bikeName + '\'' +
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
        stm = capstoneDB.getConnection().createStatement();
    }
}