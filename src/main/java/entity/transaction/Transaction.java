package entity.transaction;

import entity.db.CapstoneDB;
import entity.user.User;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Transaction {
    private int transactionId;
    private float totalPayment;
    private String content;
    private User user;


    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
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
        try {
            String sql = "SELECT * FROM transaction " + "where transaction_id=" + id + ";";
            Statement stm = CapstoneDB.getConnection().createStatement();
            ResultSet res = stm.executeQuery(sql);
            if(res.next()) {
                Transaction tr = new Transaction();
                tr.setTransactionId(res.getInt("transaction_id"));
                tr.setTotalPayment(res.getFloat("total_payment"));
                tr.setContent(res.getString("content"));
                User u = new User();
                User u1 = u.getUserById(res.getInt("user_id"));
                tr.setUser(u1);
                return tr;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public ArrayList<Transaction> getAllTransaction() throws SQLException{
        try {
            String sql = "SELECT * FROM transaction ;";
            Statement stm = CapstoneDB.getConnection().createStatement();
            ArrayList<Transaction> qq = new ArrayList<>();
            ResultSet res = stm.executeQuery(sql);
            if(res.next()){
                Transaction tr = new Transaction();
                tr.setTransactionId(res.getInt("transaction_id"));
                tr.setTotalPayment(res.getFloat("total_payment"));
                tr.setContent(res.getString("content"));
                User u = new User();
                User u1 = u.getUserById(res.getInt("user_id"));
                tr.setUser(u1);
                qq.add(tr);
            }
            return qq;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}