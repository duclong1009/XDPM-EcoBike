package controller;

import entity.station.Station;

import java.sql.SQLException;
import java.util.List;

public class HomeController extends BaseController {
    public List getAllBike() throws SQLException {
        return new Station().getAllBike();
    }

    public List getAllStation() throws  SQLException {
        return new Station().getAllStation();
    }
}
