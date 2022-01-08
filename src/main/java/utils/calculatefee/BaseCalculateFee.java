package utils.calculatefee;

import controller.BaseController;
import entity.category.Category;

public abstract class  BaseCalculateFee {
    Category category;
    public BaseCalculateFee() {
        category = new Category();
    }
    public int calculate(int id) {
        return 0;
    }

}
