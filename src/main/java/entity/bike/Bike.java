package entity.bike;

import entity.db.CapstoneDB;
import utils.Utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Bike {

    private static Logger LOGGER = Utils.getLogger(Bike.class.getName());
    protected int id;
    protected String bikeName;
    protected int status;
    protected int category_id;
    protected int station_id;
    protected String imagePath;

    public Bike() {}

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Bike(int id, String bikeName, int status, int category_id, int station_id, String imagePath) {
        this.id = id;
        this.bikeName = bikeName;
        this.status = status;
        this.category_id = category_id;
        this.station_id = station_id;
        this.imagePath = imagePath;
    }

    public Bike getBikeById(int id) throws SQLException{
        String sql = "SELECT * FROM bike " + "where id=" + id + ";";
        System.out.println("query : " + sql);
        Statement stm = CapstoneDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(sql);
        if(res.next()) {
            System.out.println("Not null");
            Bike b = new Bike(res.getInt("id"), res.getString("bike_name"), res.getInt("Status"), res.getInt("category_id"), res.getInt("station_id"),res.getString("image_path"));
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
            Bike b = new Bike(res.getInt("id"), res.getString("bike_name"),  res.getInt("Status"), res.getInt("category_id"), res.getInt("station_id"),res.getString("image_path"));
            bikeList.add(b);
        }
        return bikeList;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", bikeName='" + bikeName + '\'' +
                ", status=" + status +
                ", category_id=" + category_id +
                ", station_id=" + station_id +
                ", imagePath='" + imagePath + '\'' +
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

    public List<Bike>  findNameBike(String search,String s_id) throws SQLException {
        String query = "SELECT * FROM bike " + "where bike_name LIKE '%" + search + "%' AND station_id = "+ s_id +";";
        System.out.println(query);
        Statement stm = CapstoneDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(query);
        ArrayList bikeList = new ArrayList();
        while(res.next()) {
            LOGGER.info("Exist bike query!!");
            Bike b = new Bike(res.getInt("id"), res.getString("bike_name"), res.getInt("Status"), res.getInt("category_id"), res.getInt("station_id"),res.getString("image_path"));
            bikeList.add(b);
            System.out.println("Len res " + bikeList.size());
        }
        return bikeList;
    }
    public void updateStatusById(int id) throws SQLException{
        try {
            String query = "update bike set status = ? where id = ?";
            Bike b = new Bike();
            Bike b1 = b.getBikeById(id);
            int stt = 1 - b1.getStatus();
            PreparedStatement preparedStmt = CapstoneDB.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, stt);
            preparedStmt.setInt(2, id);
            preparedStmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateStationIdById(int id, int sttId) throws SQLException{
        try {
            String query = "update bike set station_id = ? where id = ?";
            PreparedStatement preparedStmt = CapstoneDB.getConnection().prepareStatement(query);
            preparedStmt.setInt(1, sttId);
            preparedStmt.setInt(2, id);
            preparedStmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) throws SQLException {
        Bike bike = new Bike();
    }
}