package controller;

import entity.payment.CreditCard;

public class PaymentController extends BaseController{
    public boolean checkAvailabelPay(CreditCard card, int amount) {
        return true;
    }
}
