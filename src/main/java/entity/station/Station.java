package entity.station;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.bike.Bike;
import entity.db.CapstoneDB;

public class Station{
    private int id;
    private String address;
    private String name;
    private String imagePath;
    private int walkingTime;
    private List<Bike> bikeList;
    public Station() {}
    public Station(int id, String address, String name, String imagePath) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.imagePath = imagePath;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getWalkingTime() {
        return walkingTime;
    }

    public void setWalkingTime(int walkingTime) {
        this.walkingTime = walkingTime;
    }

    public List<Bike> getBikeList() {
        return this.bikeList;
    }

    public void setBikeList(List<Bike> bikeList) {
        this.bikeList = bikeList;
    }
    public Bike addBike(Bike bike) {
        getBikeList().add(bike);

        return bike;
    }
    public List<Bike> getAllBike() throws SQLException {
        ArrayList listB = new ArrayList<>();
        int stationID = this.id;
        String query = "SELECT id FROM bike " + "where station_id=" + id + ";";
        Statement stm = CapstoneDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(query);
        if(res.next()) {
            listB.add(new Bike().getBikeById(Integer.parseInt(res.getString(id))));
            System.out.println("+1");
        }
        return listB;
    }
    public Bike removeBike(Bike bike) {
        getBikeList().remove(bike);

        return bike;
    }
    public  List<Station> getAllStation() throws SQLException{
        String query = "SELECT  * FROM station ;";
        Statement stm = CapstoneDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(query);
        ArrayList stationList = new ArrayList();
        while(res.next()) {
            Station st = new Station(Integer.parseInt(res.getString("id")),res.getString("address"),res.getString("station_name"),res.getString("image_path"));
            stationList.add(st);
        }
        return stationList;
    }

    public static void main(String[] args) throws SQLException {
        Station st = new Station();
        List<Station> listStation = st.getAllStation();
        for (Station station : listStation) {
            System.out.println(station.getName());
        }
    }
}