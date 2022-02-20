package utils.calculatefee;

import controller.BaseController;
import entity.category.Category;

import java.sql.SQLException;

/**
 * Tinh phi thue xe
 * @author longnd
 */
public abstract class  BaseCalculateFee {
    Category category;
    public BaseCalculateFee() {
        category = new Category();
    }
    public int calculate(int id) throws SQLException {
        return 0;
    }

}
