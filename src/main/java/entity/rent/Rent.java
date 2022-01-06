package entity.rent;

import entity.bike.Bike;
import entity.user.User;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Rent {
    private static Timestamp endTime;
    private static Timestamp startTime;
    private static Bike bike;
    private static User user;

    public static Timestamp getEndTime() {
        return endTime;
    }

    public static void setEndTime() {
        Rent.endTime = new Timestamp(System.currentTimeMillis());
    }

    public static Timestamp getStartTime() {
        return startTime;
    }

    public static void setStartTime() {
        Rent.startTime = new Timestamp(System.currentTimeMillis());
    }

    public static Bike getBike() {
        return bike;
    }

    public static void setBike(Bike bike) {
        Rent.bike = bike;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Rent.user = user;
    }

    public Rent() {
    }

    public static int thoigiandathue() throws SQLException {
        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        return endTime.getMinutes() - Rent.startTime.getMinutes();
    }
}