package controller;

import entity.station.Station;

import java.sql.SQLException;
import java.util.List;

public class StationController extends BaseController{
    Station station;
    public StationController() {
        station = new Station();
    }
    public List getSearchStation(String searchText) throws SQLException {
        return station.findNameStation(searchText);
    }

    public List getAllStation() throws  SQLException {
        return station.getAllStation();
    }
}
