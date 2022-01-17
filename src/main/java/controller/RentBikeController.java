package controller;

import entity.rent.Rent;
import utils.calculatefee.BaseCalculateFee;

/**
 * Quan ly thue xe, tinh phi thue
 * @author longnd
 */
public class RentBikeController extends BaseController{
    private BaseCalculateFee calFee;
    public RentBikeController(BaseCalculateFee cal) {
        this.calFee = cal;
    }
    public int calRentalFee(int id) {
        return this.calFee.calculate(id);
    }
}
