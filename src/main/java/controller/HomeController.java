package controller;

import entity.bike.Bike;
import entity.station.Station;

import java.sql.SQLException;
import java.util.List;

public class HomeController extends BaseController {

    public HomeController() {}
    public List getAllBike(int stationID) throws SQLException {
        Bike bike = new Bike();
        return bike.getAllBike(stationID);
    }

    public List getAllStation() throws  SQLException {
        return new Station().getAllStation();
    }
}
