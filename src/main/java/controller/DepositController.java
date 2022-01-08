package controller;

import java.util.HashMap;

public class DepositController extends BaseController{
    private HashMap<Integer, Integer> depositTable;
    public DepositController() {
        this.depositTable = new HashMap<Integer, Integer>();
        this.depositTable.put(2, 400000);
        this.depositTable.put(3, 550000);
        this.depositTable.put(4, 700000);
        this.depositTable.put(5, 700000);
    }

    public int calDepositFee(int categoryId) {
        return this.depositTable.get(categoryId);
    }

}
