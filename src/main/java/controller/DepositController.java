package controller;

import java.util.HashMap;

public class DepositController extends BaseController{
    private HashMap<Integer, Integer> depositTable;
    public DepositController() {
        this.depositTable = new HashMap<Integer, Integer>();
        this.depositTable.put(1, 40000);
        this.depositTable.put(2, 55000);
        this.depositTable.put(3, 70000);
//        this.depositTable.put(4, 700000);
    }

    public int calDepositFee(int categoryId) {
        return this.depositTable.get(categoryId);
    }

    public boolean validateCardHolderName(String cardHolderName) {
        return true;
    }
    public boolean validateCardNumber(String cardNumber) {
        return true;
    }
    public boolean validateIssuingBank(String issuingBank) {
        return true;
    }

    public boolean validateCardInfo(String cardHolderName,String cardNumber, String issuingBank) {
        System.out.println(validateCardHolderName(cardHolderName) && validateCardNumber(cardNumber) && validateIssuingBank(issuingBank));
        return validateCardHolderName(cardHolderName) && validateCardNumber(cardNumber) && validateIssuingBank(issuingBank);
    }

}
