package controller;

import entity.rent.Rent;
import utils.calculatefee.BaseCalculateFee;

public class RentBikeController extends BaseController{
    private BaseCalculateFee calFee;
    public RentBikeController(BaseCalculateFee cal) {
        this.calFee = cal;
    }

    public int calRentalFee() {
        return this.calFee.calculate();
    }
}