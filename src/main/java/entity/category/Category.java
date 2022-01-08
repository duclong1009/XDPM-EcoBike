package entity.category;

import entity.db.CapstoneDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Category {

    private int id;
    private float costPerHour;
    private int nPedals;
    private int nSeats;
    private String name;

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

    public Category getCategoryById(int id)  throws SQLException{
            String sql = "SELECT * FROM category " + "where id=" + id + ";";
            Statement stm = CapstoneDB.getConnection().createStatement();
            try (ResultSet res = stm.executeQuery(sql)) {
                if (res.next()) {
                    Category c = new Category();
                    c.setId(res.getInt("id"));
                    c.setCostPerHour(res.getFloat("costs_per_hour"));
                    c.setName(res.getString("name"));
                    c.setnPedals(res.getInt("n_pedals"));
                    c.setnSeats(res.getInt("n_seats"));
                    return c;
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            return null;
    }
}