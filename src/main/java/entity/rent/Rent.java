package entity.rent;

import entity.bike.Bike;
import entity.payment.CreditCard;
import entity.user.User;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Rent {
    private static Timestamp endTime;
    private static Timestamp startTime;
    private static Bike bike;
    private static int depositFee;
    private static CreditCard card;
    private static int station_id;

    public static int getStation_id() {
        return station_id;
    }

    public static void setStation_id(int station_id) {
        Rent.station_id = station_id;
    }

    public static CreditCard getCard() {
        return card;
    }

    public static void setCard(CreditCard card) {
        Rent.card = card;
    }

    //    private static User user;
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

    public static int getDepositFee() {
        return depositFee;
    }

    public static void setDepositFee(int depositFee) {
        Rent.depositFee = depositFee;
    }
    public Rent() {
    }

    public static int thoigiandathue() throws SQLException {
        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        return endTime.getMinutes() - Rent.startTime.getMinutes();
    }

    public static void reset() {
        endTime = null;
        startTime = null;
        bike = null;
        depositFee = 0;
        card = null;
    }
}