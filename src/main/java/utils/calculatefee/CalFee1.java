package utils.calculatefee;

import entity.category.Category;
import entity.rent.Rent;

public class CalFee1 extends BaseCalculateFee {


    public int calculate(int  id) {
        try {
            int timeMinute = Rent.thoigiandathue();
            System.out.println("Category Id" + id);
            return (int) (category.getCategoryById(id).getCostPerHour() * timeMinute);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
