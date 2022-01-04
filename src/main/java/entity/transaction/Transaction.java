package entity.transaction;

import entity.bike.Bike;
import entity.user.User;
import entity.rent.Rent;
import java.sql.Timestamp;


public class Transaction {
    private int transactionId;
    private String bikeName;
    private String rentDuration;
    private Timestamp time;
    private float totalPayment;
    private User user;
    private Bike bike;
    private Rent rent;
    public Transaction() {
    }


}