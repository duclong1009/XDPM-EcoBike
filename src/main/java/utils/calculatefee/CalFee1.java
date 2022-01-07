package utils.calculatefee;

import entity.rent.Rent;

public class CalFee1 extends BaseCalculateFee {

    public int calculate() {
        try {
            int timeMinute = Rent.thoigiandathue();
            return 2000 * timeMinute;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
