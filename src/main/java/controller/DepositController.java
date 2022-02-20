package controller;

import screen.popup.PopupScreen;
import utils.calculateDepositFee.CalculateDepositFee;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Dat coc, danh gia thong tin the
 * @author longnd
 */
public class DepositController extends BaseController{
    public DepositController() {
    }
    private CalculateDepositFee calDepositFee;
    public DepositController(CalculateDepositFee calFee1) {
        this.calDepositFee = calFee1;
    }
    public int calDepositFee(int fees, int categoryID) {
        return this.calDepositFee.calculateDepositFee(fees,categoryID);
    }

    public boolean validateName(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }
        Pattern p = Pattern.compile("[^A-Za-z0-9\s]");
        Matcher m = p.matcher(s);
        boolean b = m.find();
        return !b;
    }

    public boolean validateCardNumber(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }
        if (s.length() < 3 || s.length() > 12) {
            return false;
        }
        Pattern p = Pattern.compile("[^0-9]");
        Matcher m = p.matcher(s);
        boolean b = m.find();
        return !b;
    }

    public boolean validateExpirationDate(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }
        if (s.length() != 4) {
            return false;
        }
        Pattern p = Pattern.compile("[^0-9]");
        Matcher m = p.matcher(s);
        boolean b = m.find();
        return !b;
    }

    public boolean validateSecurityCode(String s) {
        if (s == null || s.trim().isEmpty()) {
            return false;
        }
        if (s.length() < 8 || s.length() > 20) {
            return false;
        }
        for (Character c: s.toCharArray()){
            if (c == ' ') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DepositController depositController = new DepositController();
        System.out.println(depositController.validateExpirationDate("12345"));
    }
}
