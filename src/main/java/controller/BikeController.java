package controller;

import entity.bike.Bike;

import java.sql.SQLException;
import java.util.List;

public class BikeController extends BaseController{
    private Bike bike;
    public BikeController() {
        bike = new Bike();
    }
    public List getSearchBike(String searchText, String  s_id) throws SQLException {
        return  bike.findNameBike(searchText,s_id);
    }

    public List getAllBike(int stationID) throws SQLException {
        return bike.getAllBike(stationID);
    }


}
