package utils.calculatefee;

import entity.category.Category;
import entity.rent.Rent;

import java.sql.SQLException;

public class CalFee1 extends BaseCalculateFee {


//    public int calculate(int  id) {
//        try {
//            int timeMinute = Rent.thoigiandathue();
//            System.out.println("Category Id" + id);
//            return (int) (category.getCategoryById(id).getCostPerHour() * timeMinute);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
    public int calculate(int id ) throws SQLException {
        int timeMinute = Rent.thoigiandathue();
        if(timeMinute > 10) {
            return 0;
        }
        else {
            if(timeMinute > 30) {
                return 10000;
            }
            else {
                return 10000 + (timeMinute -30)/15 * 3000;
            }
        }
    }
}
