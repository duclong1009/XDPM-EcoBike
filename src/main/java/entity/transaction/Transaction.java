package entity.transaction;

import entity.db.CapstoneDB;
import entity.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Transaction {
    private int transactionId;
    private float rentDuration;
    private float totalPayment;
    private String content;
    private User user;


    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Float getRentDuration() {
        return rentDuration;
    }

    public void setRentDuration(Float rentDuration) {
        this.rentDuration = rentDuration;
    }

    public float getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(float totalPayment) {
        this.totalPayment = totalPayment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Transaction(){
    }

    public Transaction getTransactionById(int id) throws SQLException {
        String sql = "SELECT * FROM transaction " + "where transaction_id=" + id + ";";
        Statement stm = CapstoneDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(sql);
        if(res.next()) {
            System.out.println("Not null");
            Transaction tr = new Transaction();
            tr.setTransactionId(res.getInt("transaction_id"));
            tr.setRentDuration(res.getFloat("rented_duration"));
            tr.setTotalPayment(res.getFloat("total_payment"));
            tr.setContent(res.getString("content"));
            User u = new User();
            User u1 = u.getUserById(res.getInt("user_id"));
            tr.setUser(u1);
            return tr;
        }
        return null;
    }
}