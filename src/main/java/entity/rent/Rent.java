package entity.rent;

import entity.bike.Bike;
import entity.db.CapstoneDB;
import entity.user.User;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Rent {
    private int id;
    private Timestamp endTime;
    private Timestamp startTime;
    private Bike bike;
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rent() {
    }
    public void insert(int userId, int bikeId) {
        try {
            Statement stm = CapstoneDB.getConnection().createStatement();
            String sql = "insert into `rent` (userId, bikeId, start_time, end_time) values";
            Timestamp thisTime = new Timestamp(System.currentTimeMillis());
            sql = sql + " (" + String.valueOf(userId) + "," + String.valueOf(bikeId) + "," + "?" + "," + "?" + ")";
            PreparedStatement ps = CapstoneDB.getConnection().prepareStatement(sql);
            ps.setTimestamp(1, thisTime);
            ps.setTimestamp(2, thisTime);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(int bikeId) {
        try {
            Statement stm = CapstoneDB.getConnection().createStatement();
            String sql = "delete from rent where bikeId = " + String.valueOf(bikeId);
            stm.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}